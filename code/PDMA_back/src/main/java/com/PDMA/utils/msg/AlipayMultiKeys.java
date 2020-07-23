package com.PDMA.utils.msg;

import java.io.Serializable;
import java.util.Objects;

public class AlipayMultiKeys implements Serializable {
    private Long userId;
    private String Transaction_number;

    public AlipayMultiKeys() {
    }

    public AlipayMultiKeys(Long userId, String Transaction_number) {
        this.userId = userId;
        this.Transaction_number = Transaction_number;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTransaction_number() {
        return Transaction_number;
    }

    public void setTransaction_number(String Transaction_number) {
        this.Transaction_number = Transaction_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlipayMultiKeys)) return false;
        AlipayMultiKeys that = (AlipayMultiKeys) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getTransaction_number(), that.getTransaction_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTransaction_number());
    }
}

