package com.alexeykuznetsov.currency.controller;

import com.alexeykuznetsov.currency.model.Currency;
import com.alexeykuznetsov.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/valutes")
public class CurrencyRESTController {
    @Autowired
    private CurrencyService currencyService;
    @GetMapping("/showAllCurrencies")
    @PreAuthorize("hasRole('USER')")
    public List<Currency> showAllCurrencies() {
        List<Currency> currencyList = currencyService.getAllCurrency();
        return currencyList;
    }

    @GetMapping("/showCurrency/{id}")
    @PreAuthorize("hasRole('USER')")
    public Currency getCurrencyById(@PathVariable String id) {
        Currency currency = currencyService.getCurrencyById(id);
        return currency;
    }
}
