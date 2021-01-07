package com.hzero.order.myconfig;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.util.Date;


//对自动填充数据的处理
@Component
public class MyHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("creationDate",new Date(),metaObject);
        this.setFieldValByName("orderDate",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("lastUpdateDate",new Date(),metaObject);
    }
}

