package com.alexeykuznetsov.currency.DAO;

import com.alexeykuznetsov.currency.model.Currency;

import java.util.List;

public interface CurrencyDAO {
    List<Currency> getAllCurrency();

    Currency getCurrencyById(String id);
}
