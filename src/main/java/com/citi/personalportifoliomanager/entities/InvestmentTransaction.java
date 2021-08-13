package com.citi.personalportifoliomanager.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="investment_transcationcash_transcation")
public class InvestmentTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JoinColumn(name = "investment_id", referencedColumnName = "id")
    @ManyToOne
    private Investment investmentId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Investment getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(Investment investmentId) {
        this.investmentId = investmentId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
