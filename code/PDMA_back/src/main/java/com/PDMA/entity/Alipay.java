package com.PDMA.entity;

import com.PDMA.utils.msg.AlipayMultiKeys;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Alipay")
@IdClass(AlipayMultiKeys.class)
@JsonIgnoreProperties(value = {"userId","Transaction_number","hibernateLazyInitializer","fieldHandler"})
public class Alipay {
    private Long userId;
    private String Transaction_number;
    private Date Payment_time;
    private String Name;
    private String Commodity_name;
    private double Amount;
    private String Funding_state;
    private String Income_spending;

    public Alipay() {}

    public Alipay(Long userId,
                  String Transaction_number,
                  Date Payment_time,
                  String Commodity_name,
                  double Amount,
                  String Funding_state,
                  String Name,
                  String Income_spending) {
        this.userId = userId;
        this.Transaction_number = Transaction_number;
        this.Payment_time = Payment_time;
        this.Commodity_name = Commodity_name;
        this.Amount = Amount;
        this.Funding_state = Funding_state;
        this.Name = Name;
        this.Income_spending = Income_spending;
    }

    @Id
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name="Transaction_number", insertable = false, updatable = false)
    public String getTransaction_number() {
        return Transaction_number;
    }
    public void setTransaction_number(String Transaction_number) {
        this.Transaction_number = Transaction_number;
    }

    public Date getPayment_time() {
        return Payment_time;
    }
    public void setPayment_time(Date Payment_time) {
        this.Payment_time = Payment_time;
    }

    public double getAmount() {
        return Amount;
    }
    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getIncome_spending() {
        return Income_spending;
    }
    public void setIncome_spending(String Income_spending) {
        this.Income_spending = Income_spending;
    }

    public String getCommodity_name() {
        return Commodity_name;
    }
    public void setCommodity_name(String Commodity_name) {
        this.Commodity_name = Commodity_name;
    }

    public String getFunding_state() {
        return Funding_state;
    }
    public void setFunding_state(String Funding_state) {
        this.Funding_state = Funding_state;
    }

}
