package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.entities.User;
import com.citi.personalportifoliomanager.repos.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

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

    @Override
    public HashMap<Time, Float> getCashChangesByUserIdAndTime(int id, Time time) {
        // TODO add a implementation method to get Cash changes Time Float key value pairs - hashmap
        return null;
    }

}