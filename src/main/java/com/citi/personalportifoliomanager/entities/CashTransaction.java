package com.citi.personalportifoliomanager.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="cash_transcation")
public class CashTransaction implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JoinColumn(name = "cash_id", referencedColumnName = "id")
    private int cashId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Timestamp time;

    @Override
    public String toString() {
        return "CashTransaction{" +
                "id=" + id +
                ", cashId=" + cashId +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCashId() {
        return cashId;
    }

    public void setCashId(int cashId) {
        this.cashId = cashId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


}
