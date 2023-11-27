package com.yourcompany.registrationapp.service;

import com.yourcompany.registrationapp.model.Customer;
import com.yourcompany.registrationapp.model.LoanApplication; // Add this import statement

public interface CustomerService {
    void saveCustomer(Customer customer);

    Customer findByUsername(String username);

    void applyLoan(Long customerId, LoanApplication loanApplication);

    void updateAccountDetails(Customer customer);
}
