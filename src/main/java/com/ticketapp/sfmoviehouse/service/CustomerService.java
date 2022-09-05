package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.model.Customer;
import com.ticketapp.sfmoviehouse.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> findAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        return customers;
    }

}
