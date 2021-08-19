package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.InvestmentHistory;

import java.sql.Timestamp;
import java.util.Collection;

public interface InvestmentHistoryService {
    Collection<InvestmentHistory> findAllInvestmentHistory();

    Collection<InvestmentHistory> getInvestmentHistoryByUserId(int userId);

    Collection<InvestmentHistory> getInvestmentHistoryByUserIdAndDate(int userId, Timestamp date);
}
