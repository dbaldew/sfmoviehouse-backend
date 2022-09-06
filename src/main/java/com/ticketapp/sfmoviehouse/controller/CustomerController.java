package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Customer;
import com.ticketapp.sfmoviehouse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/customers")
    public ResponseEntity getCustomers() {
        Iterable<Customer> customers = customerService.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity addCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return ResponseEntity.ok("added customer");
    }

     @PutMapping(value = "/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
         Optional<Customer> customerToUpdate = customerService.findById(id);
         customerService.save(customer);
        return ResponseEntity.ok("updated customer");
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.ok("removed customer");
    }

}
