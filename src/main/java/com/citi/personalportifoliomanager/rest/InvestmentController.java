package com.citi.personalportifoliomanager.rest;

import com.citi.personalportifoliomanager.entities.Investment;
import com.citi.personalportifoliomanager.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/invest")
public class InvestmentController {
    @Autowired
    private InvestmentService investmentService;

    @GetMapping
    public Collection<Investment> getInvestment(){
        return investmentService.findAllInvestmentAccount();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/id={id}")
    public Investment getInvestmentById(@PathVariable("id") int id) {
        return investmentService.findInvestmentAccountById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/userid={id}")
    public Collection<Investment> getInvestmentByUserId(@PathVariable("id") int userId){
        return investmentService.findInvestmentAccountByUserId(userId);
    }
}
