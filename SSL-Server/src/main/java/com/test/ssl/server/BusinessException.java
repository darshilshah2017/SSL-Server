package com.test.ssl.server;

public class BusinessException extends RuntimeException {

    public BusinessException(){}

    public BusinessException(String errorMsg){
        super(errorMsg);
    }
}
