package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.InvestmentHistory;
import com.citi.personalportifoliomanager.entities.NetWorthHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Collection;

public interface InvestmentHistoryRepo extends JpaRepository<InvestmentHistory, Integer> {
    

    @Query(value="select * from investment_history n where n.user_id = :id" ,nativeQuery=true)
    Collection<InvestmentHistory> getInvestmentHistoryByUserId(int id);

    @Query(value="select * from investment_history n where n.user_id = :id and n.date >= :date" ,nativeQuery=true)
    Collection<InvestmentHistory> getInvestmentHistoryByUserIdAndDate(int id, Timestamp date);
}
