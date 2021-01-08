package com.hzero.order.service.Impl;

import com.alibaba.excel.EasyExcel;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hzero.order.dto.*;
import com.hzero.order.entity.Header;
import com.hzero.order.entity.Line;
import com.hzero.order.mapper.*;
import com.hzero.order.myconfig.CommonException;
import com.hzero.order.myconfig.ExcelListener;
import com.hzero.order.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private static final String NEW_CONSTANT = "NEW";
    private static final String REJECTED_CONSTANT = "REJECTED";
    private static final String SUBMITTED_CONSTANT = "SUBMITED";
    private static final String APPROVED_CONSTANT = "APPROVED";
    private static final String CLOSED_CONSTANT = "CLOSED";

    @Resource
    OrderMapper orderMapper;
    @Resource
    ExcelExportMapper excelExportMapper;
    @Resource
    HeaderMapper headerMapper;
    @Resource
    LineMapper lineMapper;
    @Resource
    CompanyMapper companyMapper;
    @Resource
    CustomerMapper customerMapper;
    @Resource
    ItemMapper itemMapper;

    @Transactional(readOnly = true)
    @Override
    public PageInfo<Order> selectOrdersByCondition(OrderCondition orderCondition, PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPage(),pageRequest.getSize());
        List<Order> orderList = orderMapper.selectOrdersByCondition(orderCondition);
        return new PageInfo<>(orderList);
    }

    @Override
    public void exportExcel(OrderCondition orderCondition, HttpServletResponse response) {
        List<ExcelExportDto> excelExportDtos = excelExportMapper.excelExport(orderCondition);
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            response.setHeader("content-disposition", "attachment;fileName="+ URLEncoder.encode("订单信息"+ System.currentTimeMillis() + ".xlsx","UTF-8") );
        } catch (IOException e) {
            e.printStackTrace();
        }
        EasyExcel.write(os, ExcelExportDto.class).sheet("订单数据").doWrite(excelExportDtos);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importExcel(MultipartFile multipartFile) throws IOException {
        ExcelListener excelListener = new ExcelListener();
        InputStream inputStream = multipartFile.getInputStream();
        EasyExcel.read(inputStream,ExcelExportDto.class,excelListener).sheet(0).doRead();
        List<ExcelExportDto> data = excelListener.getData();
        Header header = new Header();
        Line line = new Line();
        for (ExcelExportDto importDTO:data) {
            if (headerMapper.selectHeadIdByOrderNumber(importDTO.getOrderNumber()) == null) {
                //订单头导入
                if (headerMapper.getMaxSoLineId() == null){
                    header.setSoHeaderId(1L);
                }else {
                    header.setSoHeaderId(headerMapper.getMaxSoLineId()+1L);
                }
                header.setOrderNumber(importDTO.getOrderNumber());
                // 获取公司id
                header.setCompanyId(companyMapper.getById(importDTO.getCompanyNumber()));
                // 获取客户id
                header.setCustomerId(customerMapper.selectCustomerIdByCustomerNumber(importDTO.getCustomerNumber()));
                header.setOrderDate(importDTO.getOrderDate());
                header.setOrderStatus(importDTO.getOrderStatus());
                headerMapper.insert(header);
            }
            insertLine(importDTO,line);
        }
    }

    @Override
    public Header submitOrder(Long headerId, String orderStatus) {
        Header header = headerMapper.selectById(headerId);
        if (!NEW_CONSTANT.equals(header.getOrderStatus()) && !REJECTED_CONSTANT.equals(header.getOrderStatus())) {
            throw new CommonException("订单状态不正确，无法提交");
        }
        header.setOrderStatus(orderStatus);
        headerMapper.updateById(header);
        return header;
    }

    @Override
    public Header approveOrder(Long headerId, String orderStatus) {
        Header orderHeader = headerMapper.selectById(headerId);
        if (SUBMITTED_CONSTANT.equals(orderHeader.getOrderStatus())) {
            orderHeader.setOrderStatus(orderStatus);
            headerMapper.updateById(orderHeader);
            return orderHeader;
        } else if (NEW_CONSTANT.equals(orderHeader.getOrderStatus()) || REJECTED_CONSTANT.equals(orderHeader.getOrderStatus())) {
            throw new CommonException("订单没有提交，无法审批！");
        } else if (APPROVED_CONSTANT.equals(orderHeader.getOrderStatus())) {
            throw new CommonException("订单已经审批！");
        } else if (CLOSED_CONSTANT.equals(orderHeader.getOrderStatus())) {
            throw new CommonException("订单已经关闭！");
        } else {
            throw new CommonException("订单状态错误！");
        }
    }

    private void insertLine(ExcelExportDto importDTO, Line line) {
//       订单行导入
        if (lineMapper.getMaxSoLineId() == null){
            line.setSoLineId(1L);
        }else {
            line.setSoLineId(lineMapper.getMaxSoLineId()+1L);
        }
        line.setSoHeaderId(headerMapper.selectHeadIdByOrderNumber(importDTO.getOrderNumber()));
        line.setLineNumber(importDTO.getLineNumber());
        line.setItemId(itemMapper.selectItemIdByItemCode(importDTO.getItemCode()));
        line.setDescription(importDTO.getDescription());
        line.setAddition1(importDTO.getAddition1());
        line.setAddition2(importDTO.getAddition2());
        line.setAddition3(importDTO.getAddition3());
        line.setAddition4(importDTO.getAddition4());
        line.setAddition5(importDTO.getAddition5());
        line.setOrderQuantityUom(importDTO.getOrderQuantityUom());
        line.setUnitSellingPrice(importDTO.getUnitSellingPrice());
        line.setOrderQuantity(importDTO.getOrderQuantity());
        lineMapper.insert(line);
    }

}
