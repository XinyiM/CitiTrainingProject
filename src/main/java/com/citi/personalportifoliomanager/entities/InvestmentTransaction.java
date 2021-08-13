package com.citi.personalportifoliomanager.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="cash_transcation")
public class CashTransaction {
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

    // bidirectional
    @JoinColumn (name="user_id", referencedColumnName="id", nullable = false)
    @ManyToOne
    private User user;
}
