package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Customer;
import com.ticketapp.sfmoviehouse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity getCustomer() {
        Iterable<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }



}
