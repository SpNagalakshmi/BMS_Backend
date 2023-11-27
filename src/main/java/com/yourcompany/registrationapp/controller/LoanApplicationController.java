// LoanApplicationController.java
package com.yourcompany.registrationapp.controller;

import com.yourcompany.registrationapp.model.Customer;
import com.yourcompany.registrationapp.model.LoanApplication;
import com.yourcompany.registrationapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoanApplicationController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/applyLoan")
    public String showLoanApplicationForm(Model model) {
        model.addAttribute("loanApplication", new LoanApplication());
        return "applyLoan";
    }

    @PostMapping("/applyLoan")
    public String processLoanApplication(@ModelAttribute("loanApplication") LoanApplication loanApplication, Model model) {
        // Assuming the customer is already logged in; you may need to implement user authentication
        Long customerId = 1L; // Replace with the actual customer ID
        customerService.applyLoan(customerId, loanApplication);
        return "redirect:/home";
    }
}
