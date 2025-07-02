package com.calpizza.hibernate.customer_professor_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Professor.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, 1);
            if (customer != null) {
                session.remove(customer); 
            }
            session.getTransaction().commit();
        }
    }
}
