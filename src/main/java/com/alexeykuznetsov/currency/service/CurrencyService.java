package com.alexeykuznetsov.currency.service;

import com.alexeykuznetsov.currency.model.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> getAllCurrency();
    Currency getCurrencyById(String id);
}
