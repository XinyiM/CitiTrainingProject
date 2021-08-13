package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.InvestmentTransaction;

import java.util.Collection;

public interface InvestmentTransactionService {
    Collection<InvestmentTransaction> findAllInvestmentTransaction();

    InvestmentTransaction findInvestmentTransactionById(int id);

    Collection<InvestmentTransaction> findInvestmentTransactionByInvestmentId(int InvestmentId);

    InvestmentTransaction saveInvestmentTransaction(InvestmentTransaction investmentTransaction);
}
