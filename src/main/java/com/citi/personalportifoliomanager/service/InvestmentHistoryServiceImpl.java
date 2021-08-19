package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.InvestmentHistory;
import com.citi.personalportifoliomanager.repos.InvestmentHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Collection;

@Service
public class InvestmentHistoryServiceImpl implements InvestmentHistoryService {

    @Autowired
    private InvestmentHistoryRepo InvestmentHistoryRepo;

    @Override
    public Collection<InvestmentHistory> findAllInvestmentHistory() {
        return InvestmentHistoryRepo.findAll();
    }

    @Override
    public Collection<InvestmentHistory> getInvestmentHistoryByUserId(int userId) {
        return InvestmentHistoryRepo.getInvestmentHistoryByUserId(userId);
    }

    @Override
    public Collection<InvestmentHistory> getInvestmentHistoryByUserIdAndDate(int userId, Timestamp date){
        return InvestmentHistoryRepo.getInvestmentHistoryByUserIdAndDate(userId, date);
    }


}
