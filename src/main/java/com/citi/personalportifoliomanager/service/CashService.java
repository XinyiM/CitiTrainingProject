package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.entities.User;

import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;

public interface CashService {
    Collection<Cash> findCashAccountByUserId(int userId);

    Collection<Cash> findAllCashAccount();

    Cash findCashAccountById(int id);

    HashMap<Time, Float> getCashChangesByUserIdAndTime(int id, Time time);
}
