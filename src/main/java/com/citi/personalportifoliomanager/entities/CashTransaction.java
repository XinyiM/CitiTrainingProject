package com.citi.personalportifoliomanager.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="cash_transcation")
public class CashTransaction implements Serializable {
    //id, cash_id, amount, time, user_id

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @JoinColumn(name = "cash_id", referencedColumnName = "id")
    @ManyToOne
    private Cash cashId;

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

    public Cash getCashId() {
        return cashId;
    }

    public void setCashId(Cash cashId) {
        this.cashId = cashId;
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
