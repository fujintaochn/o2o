package com.hu.o2o.dto;


import lombok.Data;

@Data
public class Result<T> {
    private boolean success;
    private T data;
    private String errorMsg;
    private int errorCode;

    public Result() {
    }
    //操作成功时的构造器
    public Result(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public Result(boolean success, int errorCode, String errorMsg) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
