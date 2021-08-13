package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.entities.CashTransaction;
import com.citi.personalportifoliomanager.entities.User;
import com.citi.personalportifoliomanager.repos.CashTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.*;

@Service
public class CashTransactionServiceImpl implements CashTransactionService{
    @Autowired
    private CashTransactionRepository cashTransactionRepository;

    @Override
    public Collection<CashTransaction> findCashTransactionByCashId(int cashId) {
        return cashTransactionRepository.findCashTransactionByCashId(cashId);
    }

    @Override
    public CashTransaction saveCashTransaction(CashTransaction cashTransaction) {
        System.out.println(cashTransaction.toString());
        return cashTransactionRepository.save(cashTransaction);
    }

    @Override
    public Collection<CashTransaction> findAllCashTransaction() {
        return cashTransactionRepository.findAll();
    }

    @Override
    public CashTransaction findCashTransactionById(int id) {
        Optional<CashTransaction> cashTransaction =  cashTransactionRepository.findById(id);
        if (cashTransaction.isPresent()) {
            return cashTransaction.get();
        }
        else return null;
    }
}
