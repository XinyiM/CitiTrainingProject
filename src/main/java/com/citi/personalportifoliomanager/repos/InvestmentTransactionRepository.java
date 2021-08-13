package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.InvestmentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestmentTransactionRepository extends JpaRepository<InvestmentTransaction, Integer> {

    @Query(value="select * from investment_transcation it where it.investment_id = :id" ,nativeQuery=true)
    List<InvestmentTransaction> findInvestmentTransactionByInvestmentId(int id);
}
