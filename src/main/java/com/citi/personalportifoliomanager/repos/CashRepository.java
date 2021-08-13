package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CashRepository extends JpaRepository<Cash, Integer> {


    @Query(value="select * from cash c where c.user_id = :id" ,nativeQuery=true)
    public List<Cash> findCashByUserId(int id);
}
