package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {


    @Query(value="select * from investment i where i.user_id = :id" ,nativeQuery=true)
    List<Investment> findInvestmentById(int id);

    @Query(value="select * from investment i where i.user_id = :id and i.portfolio = :portfolio" ,nativeQuery=true)
    Collection<Investment> getInvestmentPortfolioByUserId(int id, String portfolio);
}
