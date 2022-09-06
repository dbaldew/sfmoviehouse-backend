package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.exception.RecordNotFoundException;
import com.ticketapp.sfmoviehouse.model.Customer;
import com.ticketapp.sfmoviehouse.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Customer> findById(Long id) {
        try {
            Optional<Customer> customer = customerRepository.findById(id);
            return customer;
        } catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException();
        }

    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        try {
            customerRepository.deleteById(id);
        } catch (IndexOutOfBoundsException ex) {
            throw new RecordNotFoundException();
        }

    }
}
