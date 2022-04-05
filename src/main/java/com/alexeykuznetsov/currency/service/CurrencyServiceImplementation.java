package com.alexeykuznetsov.currency.service;

import com.alexeykuznetsov.currency.DAO.CurrencyDAO;
import com.alexeykuznetsov.currency.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CurrencyServiceImplementation implements CurrencyService {
    @Autowired
    private CurrencyDAO currencyDAO;
    @Transactional
    @Override
    public List<Currency> getAllCurrency() {
        return currencyDAO.getAllCurrency();
    }

    @Transactional
    @Override
    public Currency getCurrencyById(String id) {
        return currencyDAO.getCurrencyById(id);
    }

}
