package com.citi.personalportifoliomanager.rest;

import com.citi.personalportifoliomanager.entities.Cash;
import com.citi.personalportifoliomanager.service.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/cashes")
public class CashController {
    @Autowired
    private CashService cashService;

    @GetMapping
    public Collection<Cash> getCashes(){
        return cashService.findAllCashAccount();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id={id}")
    public Cash getCashById(@PathVariable("id") int id) {
        return cashService.findCashAccountById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userid={id}")
    public Collection<Cash> getCashesByUserId(@PathVariable("id") int userId){
        return cashService.findCashAccountByUserId(userId);
    }
}
