package com.PDMA.entity;


import com.PDMA.utils.msg.TaobaoAnalysisMultiKeys;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Taobao_Analysis")
@IdClass(TaobaoAnalysisMultiKeys.class)
@JsonIgnoreProperties(value = {"userId","hibernateLazyInitializer","fieldHandler"})
public class Taobao_Analysis{
    private Long userId;
    private Long Year;
    private Long Month;
    private double Amount;
    private Long Order_number;

    public Taobao_Analysis() {}

    public Taobao_Analysis(Long userId, Long Year, Long Month, double Amount, Long Order_number) {
        this.userId = userId;
        this.Year = Year;
        this.Month = Month;
        this.Amount = Amount;
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
    @Column(name="Year", insertable = false, updatable = false)
    public Long getYear() {
        return Year;
    }
    public void setYear(Long Year) {
        this.Year = Year;
    }

    @Id
    @Column(name="Month", insertable = false, updatable = false)
    public Long getMonth() {
        return Month;
    }
    public void setMonth(Long Month) {
        this.Month = Month;
    }

    public Double getAmount() {
        return Amount;
    }
    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public Long getOrder_number() {
        return Order_number;
    }
    public void setOrder_number(Long Order_number) {
        this.Order_number = Order_number;
    }
}
