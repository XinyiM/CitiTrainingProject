package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.CashTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CashTransactionRepository extends JpaRepository<CashTransaction, Integer>{

    @Query(value="select * from cash_transcation ct where ct.cash_id = :id" ,nativeQuery=true)
    public List<CashTransaction> findCashTransactionByCashId(int id);

}
