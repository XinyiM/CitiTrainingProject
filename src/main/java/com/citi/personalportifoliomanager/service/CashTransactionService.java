package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.CashTransaction;

import java.util.Collection;

public interface CashTransactionService {
    Collection<CashTransaction> findAllCashTransaction();

    CashTransaction findCashTransactionById(int id);

    Collection<CashTransaction> findCashTransactionByCashId(int cashId);

    CashTransaction saveCashTransaction(CashTransaction cashTransaction);
}
