package com.citi.personalportifoliomanager.rest;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.service.CashTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/cashtransactiones")
public class CashTransactionController {
    @Autowired
    private CashTransactionService cashTransactionService;

    @GetMapping
    public Collection<Cash> getCashTransaction(){
        return cashTransactionService.findAllCashTransactionAccount();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id={id}")
    public Cash getCashTransactionById(@PathVariable("id") int id) {
        return cashTransactionService.findCashTransactionById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cashid={id}")
    public Collection<Cash> getCashTransactionByCashId(@PathVariable("id") int cashId){
        return cashTransactionService.findCashTransactionByCashId(cashId);
    }
}
