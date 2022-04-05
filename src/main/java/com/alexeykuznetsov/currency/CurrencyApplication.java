package com.alexeykuznetsov.currency;

import com.alexeykuznetsov.currency.model.Currency;
import com.alexeykuznetsov.currency.model.Role;
import com.alexeykuznetsov.currency.model.UserRoleEnum;
import com.alexeykuznetsov.currency.model.Valutes;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.util.List;

import static com.alexeykuznetsov.currency.XMLparser.XMLToObject.XMLtoObject;

@SpringBootApplication
public class CurrencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyApplication.class, args);
        CurrencyApplication application = new CurrencyApplication();
        application.fillBase();
        application.addRoles();
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

    void addRoles() {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Role.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Role> roles = session.createQuery("from Role", Role.class).getResultList();
        if (roles.isEmpty()) {
            Role user = new Role();
            user.setName(UserRoleEnum.ROLE_USER);
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
        session.close();
   }

}
