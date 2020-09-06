package com.PDMA.entity;


import com.PDMA.utils.msg.TongchengMultiKeys;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tongcheng")
@IdClass(TongchengMultiKeys.class)
@JsonIgnoreProperties(value = {"userId","hibernateLazyInitializer","fieldHandler"})
public class Tongcheng {
    private Long userId;
    private Date Time;
    private String Platform;
    private String Title;
    private double Price;
    private String Order_number;
    private String State;

    public Tongcheng() {}

    public Tongcheng(Long userId, Date Time,
            String Platform,
             String Title,
            double Price,
             String Order_number,
            String State) {
        this.userId = userId;
        this.Time = Time;
        this.Platform = Platform;
        this.Price = Price;
        this.Title = Title;
        this.State = State;
        this.Order_number = Order_number;
    }

    @Id
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name="Order_number", insertable = false, updatable = false)
    public String getOrder_number() {
        return Order_number;
    }
    public void setOrder_number(String Order_num) {
        this.Order_number = Order_num;
    }

    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getState() {
        return State;
    }
    public void setState(String State) {
        this.State = State;
    }

    public String getPlatform() {
        return Platform;
    }
    public void setPlatform(String Platform) {
        this.Platform = Platform;
    }

    public Double getPrice() {
        return Price;
    }
    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public Date getTime() {
        return Time;
    }
    public void setTime(Date Time) {
        this.Time = Time;
    }

}
