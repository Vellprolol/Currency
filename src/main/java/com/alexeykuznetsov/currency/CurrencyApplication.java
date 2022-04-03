package com.alexeykuznetsov.currency;

import com.alexeykuznetsov.currency.DAO.CurrencyDAOImplementation;
import com.alexeykuznetsov.currency.entity.Currency;
import com.alexeykuznetsov.currency.entity.Valutes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.alexeykuznetsov.currency.XMLparser.XMLToObject.XMLtoObject;

@SpringBootApplication
public class CurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
        CurrencyApplication application = new CurrencyApplication();
        application.fillBase();
    }

    void fillBase() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Currency.class).buildSessionFactory();
        Valutes valutes = XMLtoObject();
        List<Currency> currencyList = valutes.getCurrencyList();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        for (Currency currency : currencyList) {
            session.saveOrUpdate(currency);
        }
        session.getTransaction().commit();
        session.close();
    }

}
