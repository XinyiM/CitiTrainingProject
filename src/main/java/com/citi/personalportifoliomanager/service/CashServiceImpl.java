package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.entities.User;
import com.citi.personalportifoliomanager.repos.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.*;

@Service
public class CashServiceImpl implements CashService{
    @Autowired
    private CashRepository cashRepository;


    @Override
    public Collection<Cash> findCashAccountByUserId(int userId) {
        return cashRepository.findCashByUserId(userId);
    }

    @Override
    public Collection<Cash> findAllCashAccount() {
        return cashRepository.findAll();
    }

    @Override
    public Cash findCashAccountById(int id) {
        Optional<Cash> cash =  cashRepository.findById(id);
        if (cash.isPresent()) {
            return cash.get();
        }
        else return null;
    }

}