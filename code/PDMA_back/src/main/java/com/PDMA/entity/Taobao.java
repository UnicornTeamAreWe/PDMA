package com.PDMA.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Taobao")
@JsonIgnoreProperties(value = {"userId","Transaction_time","hibernateLazyInitializer","fieldHandler"})
public class Taobao {
    private Long userId;
    private Date Transaction_time;
    private String Shop_name;
    private String Commodity;
    private String Detail;
    private double Price;
    private String State;

    public Taobao() {}

    public Taobao(Long userId, Date Transaction_time, String Shop_name, String Commodity, String Detail, double Price, String State) {
        this.userId = userId;
        this.Transaction_time = Transaction_time;
        this.Shop_name = Shop_name;
        this.Commodity = Commodity;
        this.Detail = Detail;
        this.Price = Price;
        this.State = State;
    }

    @Id
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getTransaction_time() {
        return Transaction_time;
    }
    public void setTransaction_time(Date transaction_time) {
        this.Transaction_time = transaction_time;
    }

    public String getShop_name() {
        return Shop_name;
    }
    public void setShop_name(String Shop_name) {
        this.Shop_name = Shop_name;
    }

    public String getDetail() {
        return Detail;
    }
    public void setDetail(String Detail) {
        this.Detail = Detail;
    }


    public double getPrice() {
        return Price;
    }
    public void setPrice(double Price) {
        this.Price = Price;
    }


    public String getState() {
        return State;
    }
    public void setState(String State) {
        this.State = State;
    }
}
