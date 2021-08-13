package com.citi.personalportifoliomanager.entities;

import yahoofinance.Stock;
import java.time.LocalDateTime;

public class StockWrapper {
    private final Stock stock;
    private final LocalDateTime lastAccessed;

    public StockWrapper(final Stock stock) {
        this.stock = stock;
        lastAccessed = LocalDateTime.now();
    }

    public Stock getStock(){
        return stock;
    }
    public LocalDateTime getLastAccessed() {
        return lastAccessed;
    }
}
