package com.citi.personalportifoliomanager.rest;

import com.citi.personalportifoliomanager.entities.InvestmentHistory;
import com.citi.personalportifoliomanager.service.InvestmentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Collection;

@RestController
@RequestMapping("/investmenthistory")
@CrossOrigin
public class InvestHistoryController {
    @Autowired
    private InvestmentHistoryService InvestmentHistoryService;

    @GetMapping
    public Collection<InvestmentHistory> getInvestmentHistory(){
        return InvestmentHistoryService.findAllInvestmentHistory();
    }

    @GetMapping(value = "/userid={id}")
    public Collection<InvestmentHistory> getInvestmentHistoryById(@PathVariable int id){
        return InvestmentHistoryService.getInvestmentHistoryByUserId(id);
    }

    // sample request url: http://localhost:8080/investmenthistory/id=1/date=2021-07-18
    @GetMapping(value = "/id={id}/date={date}")
    public Collection<InvestmentHistory> getInvestmentHistoryByIdAndDate(@PathVariable("id") int id, @PathVariable("date") String date){
        date += " 00:00:00";
        Timestamp datetime = Timestamp.valueOf(date);
        return InvestmentHistoryService.getInvestmentHistoryByUserIdAndDate(id, datetime);
    }


}