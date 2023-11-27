// CustomerRepository.java
package com.yourcompany.registrationapp.repository;

import com.yourcompany.registrationapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByUsername(String username);
}
