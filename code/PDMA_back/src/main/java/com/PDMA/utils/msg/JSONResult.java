package com.PDMA.utils.msg;

import lombok.Data;

import java.io.Serializable;

@Data
public class JSONResult<T> implements Serializable {
    private Boolean success;
    private Integer errorCode;
    private String errorMsg;
    private T data;

    public JSONResult(Boolean success, Integer errorCode, String errorMsg, T data) {
        this.success = success;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }
}
