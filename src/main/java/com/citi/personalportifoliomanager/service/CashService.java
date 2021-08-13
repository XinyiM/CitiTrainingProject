package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.entities.User;

import java.util.Collection;

public interface CashService {
    Collection<Cash> findCashAccountByUserId(int userId);

    Collection<Cash> findAllCashAccount();

    Cash findCashAccountById(int id);
}
