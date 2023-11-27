// Customer.java
package com.yourcompany.registrationapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String address;
    private String state;
    private String country;
    private String email;
    private String pan;
    private String contactNo;
    private String dob;
    private String accountType;
    // New fields for loan details
    private String loanType;
    private double loanAmount;
    private String loanDate;
    private double interestRate;
    private int loanDuration;

    // Getters and Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
