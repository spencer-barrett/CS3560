package com.calpizza.hibernate.customer_professor_hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Professor.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            Customer customer = new Customer("Janice", "123 Main St");
            Professor professor = new Professor("Room 13", "OOD & Programming");

            // bidirectional link
            customer.setProfessor(professor);
            professor.setCustomer(customer);

            session.beginTransaction();
            session.persist(customer); // cascades to professor
            session.getTransaction().commit();
        }
    }
}