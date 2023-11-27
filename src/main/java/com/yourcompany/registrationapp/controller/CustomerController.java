// CustomerController.java
package com.yourcompany.registrationapp.controller;

import com.yourcompany.registrationapp.model.Customer;
import com.yourcompany.registrationapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute("customer") Customer customer, Model model) {
        Customer existingCustomer = customerService.findByUsername(customer.getUsername());
        if (existingCustomer != null && existingCustomer.getPassword().equals(customer.getPassword())) {
            // Login successful
            return "redirect:/home";
        } else {
            // Login failed
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        // Implement logout logic here (invalidate session, etc.)
        return "redirect:/login";
    }

    @GetMapping("/updateProfile")
    public String showUpdateProfileForm(Model model) {
        // Assuming the customer is already logged in; you may need to implement user authentication
        String username = "testUser"; // Replace with the actual username
        Customer customer = customerService.findByUsername(username);
        model.addAttribute("customer", customer);
        return "updateProfile";
    }

    @PostMapping("/updateProfile")
    public String processUpdateProfile(@ModelAttribute("customer") Customer customer) {
        customerService.updateAccountDetails(customer);
        return "redirect:/home";
    }
}
