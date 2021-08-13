package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.StockWrapper;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class StockService {
    public StockWrapper findStock(final String ticker){
        try{
            return new StockWrapper(YahooFinance.get(ticker));
        }
        catch (IOException e){
            System.out.println("Error");
        }
        return null;

    }

    public BigDecimal findPrice(final StockWrapper stock) throws IOException{
        return stock.getStock().getQuote(true).getPrice();
    }

}
