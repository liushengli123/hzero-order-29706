package com.hzero.order.service;


import com.hzero.order.entity.Header;
import com.hzero.order.mapper.HeaderMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

//实现定时任务执行，查询所有已提交的订单将状态改为close
@Component
public class JobService{

    @Resource
    HeaderMapper headerMapper;

    @Scheduled(cron = "* * 3 * * ?")
    public void execute() {
        String orderStatus ="APPROVED";
        List<Header> headers = headerMapper.selectHeaderByOrderStatus(orderStatus);
        for (Header header : headers) {
            header.setOrderStatus("CLOSED");
            headerMapper.updateById(header);
            System.out.println("-------------------执行任务----------------");
        }
    }
}
