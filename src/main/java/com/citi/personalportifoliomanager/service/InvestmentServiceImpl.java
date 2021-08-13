package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Investment;
import com.citi.personalportifoliomanager.entities.InvestmentTransaction;
import com.citi.personalportifoliomanager.repos.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService {


    @Autowired
    private InvestmentRepository investmentRepository;


    @Override
    public Collection<Investment> findInvestmentAccountByUserId(int userId) {
        return investmentRepository.findInvestmentById(userId);
    }


    @Override
    public Collection<Investment> findAllInvestmentAccount() {
        return investmentRepository.findAll();
    }


    @Override
    public Investment findInvestmentAccountById(int id) {
        Optional<Investment> Investment =  investmentRepository.findById(id);
        if (Investment.isPresent()) {
            return Investment.get();
        }
        else return null;
    }

}