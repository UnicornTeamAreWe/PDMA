package com.PDMA.utils.msg;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TaobaoMultiKeys implements Serializable {
    private Long userId;
    private Date Transaction_time;

    public TaobaoMultiKeys() {
    }

    public TaobaoMultiKeys(Long userId, Date Transaction_time) {
        this.userId = userId;
        this.Transaction_time = Transaction_time;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTransaction_time() {
        return Transaction_time;
    }

    public void setTransaction_time(Date Transaction_time) {
        this.Transaction_time = Transaction_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaobaoMultiKeys)) return false;
        TaobaoMultiKeys that = (TaobaoMultiKeys) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getTransaction_time(), that.getTransaction_time());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getTransaction_time());
    }
}

