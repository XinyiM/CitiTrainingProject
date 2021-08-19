package com.citi.personalportifoliomanager.rest;

import com.citi.personalportifoliomanager.entities.NetWorthHistory;
import com.citi.personalportifoliomanager.service.NetWorthHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;

@RestController
@RequestMapping("/networthhistory")
@CrossOrigin
public class NetWorthController {
    @Autowired
    private NetWorthHistoryService netWorthHistoryService;

    @GetMapping
    public Collection<NetWorthHistory> getNetWorthHistory(){
        return netWorthHistoryService.findAllNetWorthHistory();
    }

    @GetMapping(value = "/userid={id}")
    public Collection<NetWorthHistory> getNetWorthHistoryById(@PathVariable int id){
        return netWorthHistoryService.getNetWorthHistoryByUserId(id);
    }

    // sample request url: http://localhost:8080/networthhistory/id=2/date=2021-08-18
    @GetMapping(value = "/id={id}/date={date}")
    public Collection<NetWorthHistory> getNetWorthHistoryByIdAndDate(@PathVariable("id") int id, @PathVariable("date") String date){
        date += " 00:00:00";
        Timestamp datetime = Timestamp.valueOf(date);
        return netWorthHistoryService.getNetWorthHistoryByUserIdAndDate(id, datetime);
    }


}