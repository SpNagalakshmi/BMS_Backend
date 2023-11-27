// LoanApplicationRepository.java
package com.yourcompany.registrationapp.repository;

import com.yourcompany.registrationapp.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}
