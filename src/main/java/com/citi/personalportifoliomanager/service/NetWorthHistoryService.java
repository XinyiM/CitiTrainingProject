package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.NetWorthHistory;

import java.sql.Timestamp;
import java.util.Collection;

public interface NetWorthHistoryService {
    Collection<NetWorthHistory> findAllNetWorthHistory();

    Collection<NetWorthHistory> getNetWorthHistoryByUserId(int userId);

    Collection<NetWorthHistory> getNetWorthHistoryByUserIdAndDate(int userId, Timestamp date);
}
