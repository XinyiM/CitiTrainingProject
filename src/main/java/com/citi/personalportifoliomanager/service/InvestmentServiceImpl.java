package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Investment;
import com.citi.personalportifoliomanager.repos.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class InvestmentServiceImpl implements InvestmentService {


    @Autowired
    private InvestmentRepository InvestmentRepository;


    @Override
    public Collection<Investment> findInvestmentAccountByUserId(int userId) {
        return InvestmentRepository.findInvestmentById(userId);
    }


    @Override
    public Collection<Investment> findAllInvestmentAccount() {
        return InvestmentRepository.findAll();
    }


    @Override
    public Investment findInvestmentAccountById(int id) {
        Optional<Investment> Investment =  InvestmentRepository.findById(id);
        if (Investment.isPresent()) {
            return Investment.get();
        }
        else return null;
    }

}