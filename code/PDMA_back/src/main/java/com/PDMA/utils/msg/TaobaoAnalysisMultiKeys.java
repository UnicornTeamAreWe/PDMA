package com.PDMA.utils.msg;

import java.io.Serializable;
import java.util.Objects;

public class TaobaoAnalysisMultiKeys implements Serializable {
    private Long userId;
    private Long Year;
    private Long Month;

    public TaobaoAnalysisMultiKeys() {
    }

    public TaobaoAnalysisMultiKeys(Long userId, Long Year, Long Month) {
        this.userId = userId;
        this.Year = Year;
        this.Month = Month;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getYear() {
        return Year;
    }

    public void setYear(Long Year) {
        this.Year = Year;
    }

    public Long getMonth() {
        return Month;
    }

    public void setMonth(Long Month) {
        this.Month = Month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaobaoAnalysisMultiKeys)) return false;
        TaobaoAnalysisMultiKeys that = (TaobaoAnalysisMultiKeys) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getMonth(), that.getMonth()) &&
                Objects.equals(getYear(), that.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getMonth(), getYear());
    }
}

