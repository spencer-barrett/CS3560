package com.calpizza.hibernate.customer_professor_hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")
public class Professor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String officeNumber;
    private String researchArea;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Professor() {}

    public Professor(String officeNumber, String researchArea) {
        this.officeNumber = officeNumber;
        this.researchArea = researchArea;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getOfficeNumber() { return officeNumber; }

    public void setOfficeNumber(String officeNumber) { this.officeNumber = officeNumber; }

    public String getResearchArea() { return researchArea; }

    public void setResearchArea(String researchArea) { this.researchArea = researchArea; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        return "Professor: " + officeNumber + ", " + researchArea;
    }
}
