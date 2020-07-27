package com.PDMA.utils.msg;

import com.PDMA.entity.SysUser;

public class Message {
    private Integer status;
    private String message;
    private SysUser user;

    public Message(){}

    public Message(Integer status, String message, SysUser user) {
        this.status = status;
        this.message = message;
        this.user = user;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
