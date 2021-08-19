package com.citi.personalportifoliomanager.repos;

import com.citi.personalportifoliomanager.entities.NetWorthHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.Collection;

public interface NetWorthHistoryRepo extends JpaRepository<NetWorthHistory, Integer> {

//    @Query(value="select * from netnet_worth_history n where c.user_id = :id" ,nativeQuery=true)
//    Collection<NetWorthHistory> getNetWorthHistoryByDate(Timestamp date);

    @Query(value="select * from net_worth_history n where n.user_id = :id" ,nativeQuery=true)
    Collection<NetWorthHistory> getNetWorthHistoryByUserId(int id);

    @Query(value="select * from net_worth_history n where n.user_id = :id and n.date >= :date" ,nativeQuery=true)
    Collection<NetWorthHistory> getNetWorthHistoryByUserIdAndDate(int id, Timestamp date);
}
