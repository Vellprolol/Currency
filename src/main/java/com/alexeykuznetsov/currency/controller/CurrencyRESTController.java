package com.alexeykuznetsov.currency.controller;

import com.alexeykuznetsov.currency.entity.Currency;
import com.alexeykuznetsov.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyRESTController {
    @Autowired
    private CurrencyService currencyService;
    @GetMapping("/showAllCurrencies")
    public List<Currency> showAllCurrencies() {
        List<Currency> currencyList = currencyService.getAllCurrency();
        return currencyList;
    }

    @GetMapping("/showCurrency/{id}")
    public Currency getCurrencyById(@PathVariable String id) {
        Currency currency = currencyService.getCurrencyById(id);
        return currency;
    }
}
