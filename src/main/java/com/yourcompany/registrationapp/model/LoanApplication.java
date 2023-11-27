// LoanApplication.java
package com.yourcompany.registrationapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String loanType;
    private double loanAmount;
    private String loanDate;
    private double interestRate;
    private int loanDuration;
    private Long customerId;  // To establish a relationship with the Customer entity

    // Getters and Setters

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
