package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.NetWorthHistory;
import com.citi.personalportifoliomanager.repos.NetWorthHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;

@Service
public class NetWorthHistoryServiceImpl implements NetWorthHistoryService{

    @Autowired
    private NetWorthHistoryRepo netWorthHistoryRepo;

    @Override
    public Collection<NetWorthHistory> findAllNetWorthHistory() {
        return netWorthHistoryRepo.findAll();
    }

    @Override
    public Collection<NetWorthHistory> getNetWorthHistoryByUserId(int userId) {
        return netWorthHistoryRepo.getNetWorthHistoryByUserId(userId);
    }

    @Override
    public Collection<NetWorthHistory> getNetWorthHistoryByUserIdAndDate(int userId, Timestamp date){
        return netWorthHistoryRepo.getNetWorthHistoryByUserIdAndDate(userId, date);
    }


}
