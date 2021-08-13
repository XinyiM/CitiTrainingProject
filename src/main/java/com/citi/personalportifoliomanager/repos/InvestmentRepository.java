package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {


    @Query(value="select * from investment i where i.user_id = :id" ,nativeQuery=true)
    public List<Investment> findInvestmentById(int id);
}
