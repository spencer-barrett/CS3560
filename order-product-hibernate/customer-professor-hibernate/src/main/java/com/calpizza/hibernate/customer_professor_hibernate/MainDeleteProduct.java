package com.calpizza.hibernate.customer_professor_hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainDeleteProduct {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            int productIdToDelete = 1; 

            session.beginTransaction();

            Product product = session.get(Product.class, productIdToDelete);
            if (product != null) {
                session.remove(product);
                System.out.println("Deleted product: " + product.getName());
            } else {
                System.out.println("Product not found with ID: " + productIdToDelete);
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}