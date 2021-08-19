package com.citi.personalportifoliomanager.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="investment_history")
public class InvestmentHistory implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "investment")
    private float investment;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp date;

    @JoinColumn (name="user_id", referencedColumnName="id", nullable = false)
    private int userId;

    @Override
    public String toString() {
        return "NetWorthHistory{" +
                "id=" + id +
                ", netWorth=" + investment +
                ", date=" + date +
                ", userId=" + userId +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNetWorth() {
        return investment;
    }

    public void setNetWorth(float netWorth) {
        this.investment = netWorth;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
