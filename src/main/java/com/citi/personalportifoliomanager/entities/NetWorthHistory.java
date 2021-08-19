package com.citi.personalportifoliomanager.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="net_worth_history")
public class NetWorthHistory implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "net_worth")
    private float netWorth;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp date;

    @JoinColumn (name="user_id", referencedColumnName="id", nullable = false)
    private int userId;

    @Override
    public String toString() {
        return "NetWorthHistory{" +
                "id=" + id +
                ", netWorth=" + netWorth +
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
        return netWorth;
    }

    public void setNetWorth(float netWorth) {
        this.netWorth = netWorth;
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
