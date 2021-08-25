package com.citi.personalportifoliomanager.rest;


import com.citi.personalportifoliomanager.entities.CashTransaction;
import com.citi.personalportifoliomanager.entities.InvestmentTransaction;
import com.citi.personalportifoliomanager.service.InvestmentTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/investmenttransactions")
public class InvestmentTransactionController {
    @Autowired
    private InvestmentTransactionService investmentTransactionService;

    @GetMapping
    public Collection<InvestmentTransaction> getInvestmentTransaction(){
        return investmentTransactionService.findAllInvestmentTransaction();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id={id}")
    public InvestmentTransaction getInvestmentTransactionById(@PathVariable("id") int id) {
        return investmentTransactionService.findInvestmentTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/investmentid={id}")
    public Collection<InvestmentTransaction> getInvestmentTransactionByInvestmentId(@PathVariable("id") int InvestmentId) {
        return investmentTransactionService.findInvestmentTransactionByInvestmentId(InvestmentId);
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/saveit")
    public String saveInvestmentTransaction(@RequestBody InvestmentTransaction investmentTransaction){
        investmentTransactionService.saveInvestmentTransaction(investmentTransaction);
        return investmentTransaction.toString();
    }
}
