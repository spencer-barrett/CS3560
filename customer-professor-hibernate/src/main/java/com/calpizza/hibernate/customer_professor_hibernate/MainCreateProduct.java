package com.calpizza.hibernate.customer_professor_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateProduct {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Product product1 = new Product("Basketball");
            Product product2 = new Product("Soccer Ball");

            session.persist(product1);
            session.persist(product2);

            session.getTransaction().commit();
            System.out.println("Products created and saved to DB.");
        } finally {
            factory.close();
        }
    }
}
