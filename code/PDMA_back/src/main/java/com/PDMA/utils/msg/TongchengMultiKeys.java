package com.PDMA.utils.msg;

import java.io.Serializable;
import java.util.Objects;

public class TongchengMultiKeys implements Serializable {
    private Long userId;
    private String Order_number;

    public TongchengMultiKeys() {
    }

    public TongchengMultiKeys(Long userId, String Order_num) {
        this.userId = userId;
        this.Order_number = Order_num;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrder_number() {
        return Order_number;
    }

    public void setOrder_number(String Order_num) {
        this.Order_number = Order_num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TongchengMultiKeys)) return false;
        TongchengMultiKeys that = (TongchengMultiKeys) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getOrder_number(), that.getOrder_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getOrder_number());
    }
}

