package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.CashTransaction;
import com.citi.personalportifoliomanager.entities.Investment;
import com.citi.personalportifoliomanager.entities.InvestmentTransaction;
import com.citi.personalportifoliomanager.repos.InvestmentTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class InvestmentTransactionServiceImpl implements InvestmentTransactionService{

    @Autowired
    private InvestmentTransactionRepository investmentTransactionRepository;

    @Override
    public Collection<InvestmentTransaction> findAllInvestmentTransaction() {
        return investmentTransactionRepository.findAll();
    }

    @Override
    public InvestmentTransaction findInvestmentTransactionById(int id) {
        Optional<InvestmentTransaction> investmentTransaction =  investmentTransactionRepository.findById(id);
        if (investmentTransaction.isPresent()) {
            return investmentTransaction.get();
        }
        else return null;
    }

    @Override
    public Collection<InvestmentTransaction> findInvestmentTransactionByInvestmentId(int investmentId) {
        return investmentTransactionRepository.findInvestmentTransactionByInvestmentId(investmentId);
    }

    @Override
    public InvestmentTransaction saveInvestmentTransaction(InvestmentTransaction investmentTransaction) {
        return investmentTransactionRepository.save(investmentTransaction);
    }
}
