package com.PDMA.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Alipay")
@JsonIgnoreProperties(value = {"userId","Transaction_number","hibernateLazyInitializer","fieldHandler"})
public class Alipay {
    private Long userId;
    private String Transaction_number;
    private String Merchant_order_number;
    private Date Transaction_creation_time;
    private Date Payment_time;
    private Date Last_modified_time;
    private String Transaction_source;
    private String Type;
    private String Dealing_party;
    private String Commodity_name;
    private String Income_spending;
    private double Amount;
    private double Service_fee;
    private double Refund;
    private String Note;
    private String Funding_state;

    public Alipay() {}

    public Alipay(Long userId,
                  String Transaction_number,
                  String Merchant_order_number,
                  Date Transaction_creation_time,
                  Date Payment_time,
                  Date Last_modified_time,
                  String Transaction_source,
                  String Type,
                  String Dealing_party,
                  String Commodity_name,
                  String Income_spending,
                  double Amount,
                  double Service_fee,
                  double Refund,
                  String Note,
                  String Funding_state) {
        this.userId = userId;
        this.Transaction_number = Transaction_number;
        this.Merchant_order_number = Merchant_order_number;
        this.Transaction_creation_time = Transaction_creation_time;
        this.Payment_time = Payment_time;
        this.Last_modified_time = Last_modified_time;
        this.Transaction_source = Transaction_source;
        this.Type = Type;
        this.Dealing_party = Dealing_party;
        this.Commodity_name = Commodity_name;
        this.Income_spending = Income_spending;
        this.Amount = Amount;
        this.Service_fee = Service_fee;
        this.Refund = Refund;
        this.Note = Note;
        this.Funding_state = Funding_state;
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

    public String getMerchant_order_number() {
        return Merchant_order_number;
    }
    public void setMerchant_order_number(String Merchant_order_number) {
        this.Merchant_order_number = Merchant_order_number;
    }

    public Date getTransaction_creation_time() {
        return Transaction_creation_time;
    }
    public void setTransaction_creation_time(Date Transaction_creation_time) {
        this.Transaction_creation_time = Transaction_creation_time;
    }

    public Date getPayment_time() {
        return Payment_time;
    }
    public void setPayment_time(Date Payment_time) {
        this.Payment_time = Payment_time;
    }

    public Date getLast_modified_time() {
        return Last_modified_time;
    }
    public void setLast_modified_time(Date Last_modified_time) {
        this.Last_modified_time = Last_modified_time;
    }

    public String getTransaction_source() {
        return Transaction_source;
    }
    public void setTransaction_source(String Transaction_source) {
        this.Transaction_source = Transaction_source;
    }

    public double getAmount() {
        return Amount;
    }
    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public double getService_fee() {
        return Service_fee;
    }
    public void setService_fee(double Service_fee) {
        this.Service_fee = Service_fee;
    }

    public double getRefund() {
        return Refund;
    }
    public void setRefund(double Refund) {
        this.Refund = Refund;
    }

    public String getDealing_party() {
        return Dealing_party;
    }
    public void setDealing_party(String Dealing_party) {
        this.Dealing_party = Dealing_party;
    }

    public String getCommodity_name() {
        return Commodity_name;
    }
    public void setCommodity_name(String Commodity_name) {
        this.Commodity_name = Commodity_name;
    }

    public String getIncome_spending() {
        return Income_spending;
    }
    public void setIncome_spending(String Income_spending) {
        this.Income_spending = Income_spending;
    }

    public String getNote() {
        return Note;
    }
    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getFunding_state() {
        return Funding_state;
    }
    public void setFunding_state(String Funding_state) {
        this.Type = Funding_state;
    }

    public String getType() {
        return Type;
    }
    public void setType(String Type) {
        this.Type = Type;
    }
}
