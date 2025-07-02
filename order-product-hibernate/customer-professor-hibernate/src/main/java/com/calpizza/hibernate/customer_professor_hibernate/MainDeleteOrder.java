package com.calpizza.hibernate.customer_professor_hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteOrder {

    public static void main(String[] args) {
        int orderId = 1; 
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            Order order = session.get(Order.class, orderId);

            if (order != null) {
                
                order.getProducts().clear();
                
                session.remove(order);
                System.out.println("Deleted order with ID: " + orderId);
            } else {
                System.out.println("Order with ID " + orderId + " not found.");
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}