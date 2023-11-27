// CustomerServiceImpl.java
package com.yourcompany.registrationapp.service;

import com.yourcompany.registrationapp.model.Customer;
import com.yourcompany.registrationapp.model.LoanApplication;
import com.yourcompany.registrationapp.repository.CustomerRepository;
import com.yourcompany.registrationapp.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public void applyLoan(Long customerId, LoanApplication loanApplication) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer != null) {
            loanApplication.setCustomerId(customerId);
            loanApplicationRepository.save(loanApplication);
        }
    }

    @Override
    public void updateAccountDetails(Customer customer) {
        customerRepository.save(customer);
    }
}
