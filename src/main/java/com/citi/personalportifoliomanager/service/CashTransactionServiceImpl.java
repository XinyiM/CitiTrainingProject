package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.entities.CashTransaction;
import com.citi.personalportifoliomanager.repos.CashRepository;
import com.citi.personalportifoliomanager.repos.CashTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CashTransactionServiceImpl implements CashTransactionService{
    @Autowired
    private CashTransactionRepository cashTransactionRepository;

    @Autowired
    private CashRepository cashRepository;

    @Override
    public Collection<CashTransaction> findCashTransactionByCashId(int cashId) {
        return cashTransactionRepository.findCashTransactionByCashId(cashId);
    }

    @Override
    public CashTransaction saveCashTransaction(CashTransaction cashTransaction) {
        System.out.println(cashTransaction.toString());
        int cashId = cashTransaction.getCashId();
        Cash cash = cashRepository.getById(cashId);
        cash.setAmount(cash.getAmount() + cashTransaction.getAmount());
        cashRepository.save(cash);
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
