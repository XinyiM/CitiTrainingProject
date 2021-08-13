package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Cash;

import java.util.Collection;

public interface CashTransactionService {
    Collection<Cash> findAllCashTransactionAccount();

    Cash findCashTransactionById(int id);

    Collection<Cash> findCashTransactionByCashId(int cashId);
}
