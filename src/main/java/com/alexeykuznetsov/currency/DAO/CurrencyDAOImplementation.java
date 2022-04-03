package com.alexeykuznetsov.currency.DAO;

import com.alexeykuznetsov.currency.entity.Currency;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class CurrencyDAOImplementation implements CurrencyDAO {
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Currency> getAllCurrency() {
        Session session = entityManager.unwrap(Session.class);
        List<Currency> currencyList = session.createQuery("from Currency", Currency.class).getResultList();
        return currencyList;
    }

    @Override
    public Currency getCurrencyById(String id) {
        Session session = entityManager.unwrap(Session.class);
        Currency currency = session.get(Currency.class, id);
        return currency;
    }
}
