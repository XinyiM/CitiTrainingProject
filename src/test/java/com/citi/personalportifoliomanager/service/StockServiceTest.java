package com.citi.personalportifoliomanager.service;

import com.citi.personalportifoliomanager.entities.StockWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.math.BigDecimal;

@SpringBootTest
class StockServiceTest {
    @Autowired
    private StockService stockService;

    @Test
    void invoke() throws IOException {
        final StockWrapper stock = stockService.finsStock("GOOG");
        System.out.println(stock.getStock());
        final BigDecimal price = stockService.findPrice(stock);
        System.out.println(price);
    }

}