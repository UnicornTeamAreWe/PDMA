package com.PDMA.utils.msg;

import java.io.Serializable;
import java.util.Objects;

public class SoftwareMultiKeys implements Serializable {
    private Long userId;
    private String SoftwareName;

    public SoftwareMultiKeys() {
    }

    public SoftwareMultiKeys(Long userId, String SoftwareName) {
        this.userId = userId;
        this.SoftwareName = SoftwareName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSoftwareName() {
        return SoftwareName;
    }

    public void setSoftwareName(String SoftwareName) {
        this.SoftwareName = SoftwareName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SoftwareMultiKeys)) return false;
        SoftwareMultiKeys that = (SoftwareMultiKeys) o;
        return Objects.equals(getUserId(), that.getUserId()) &&
                Objects.equals(getSoftwareName(), that.getSoftwareName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getSoftwareName());
    }
}

