package com.PDMA.entity;

import com.PDMA.utils.msg.SoftwareMultiKeys;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "software")
@IdClass(SoftwareMultiKeys.class)
@JsonIgnoreProperties(value = {"userId","SoftwareName","hibernateLazyInitializer","fieldHandler"})
public class Software {
    private Long userId;
    private String SoftwareName;
    private String username;
    private String password;

    public Software() {}

    public Software(Long userId, String SoftwareName, String username, String password) {
        this.userId = userId;
        this.SoftwareName = SoftwareName;
        this.username = username;
        this.password = password;
    }

    @Id
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name="SoftwareName", insertable = false, updatable = false)
    public String getSoftwareName() {
        return SoftwareName;
    }
    public void setSoftwareName(String SoftwareName) {
        this.SoftwareName = SoftwareName;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



}
