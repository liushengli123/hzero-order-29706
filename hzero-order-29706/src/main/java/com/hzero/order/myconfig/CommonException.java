package com.hzero.order.myconfig;

//  实现自定义异常处理
public class CommonException extends RuntimeException{
    private String message;
    public CommonException(String message){
        super(message);
    }
}
