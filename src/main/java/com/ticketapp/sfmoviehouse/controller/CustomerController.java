package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.model.Customer;
import com.ticketapp.sfmoviehouse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object>getCustomers() {
        return ResponseEntity.ok().body(customerService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object>getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok().body(customerService.findById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object>addCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return ResponseEntity.ok("added customer");
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Object>deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
        return ResponseEntity.ok("removed customer");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
        return ResponseEntity.ok("updated customer");
    }
}
