package com.calpizza.hibernate.customer_professor_hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class MainCreateOrder {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
        	 session.beginTransaction();
            Product product1 = new Product("Board Game");
            Product product2 = new Product("Puzzle");
            
            session.persist(product1);
            session.persist(product2);    

            Order order = new Order();
            order.setCustomerName("Alice");
            order.setDate(new Date());

            order.getProducts().add(product1);
            order.getProducts().add(product2);

            product1.getOrders().add(order);
            product2.getOrders().add(order);

            session.beginTransaction();
            session.persist(order);
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}