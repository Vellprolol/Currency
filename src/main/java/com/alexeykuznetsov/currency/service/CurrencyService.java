package com.alexeykuznetsov.currency.service;

import com.alexeykuznetsov.currency.entity.Currency;

import java.util.List;

public interface CurrencyService {
    List<Currency> getAllCurrency();
    Currency getCurrencyById(String id);
}
