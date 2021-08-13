package com.citi.personalportifoliomanager.entities;

import org.springframework.core.serializer.Serializer;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="net_worth")
    private float netWorth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(float netWorth) {
        this.netWorth = netWorth;
    }
}
