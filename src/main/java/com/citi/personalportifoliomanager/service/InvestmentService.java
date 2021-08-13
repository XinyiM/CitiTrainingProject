package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Investment;

import java.util.Collection;

public interface InvestmentService {
    Collection<Investment> findInvestmentAccountByUserId(int userId);

    Collection<Investment> findAllInvestmentAccount();

    Investment findInvestmentAccountById(int id);
}
