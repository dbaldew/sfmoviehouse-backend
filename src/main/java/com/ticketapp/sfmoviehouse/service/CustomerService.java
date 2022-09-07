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
        if (!customerRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        return customerRepository.findById(id);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RecordNotFoundException();
        }
        customerRepository.deleteById(id);
    }

    public void updateCustomer(Long id, Customer updatedCustomer) {
        if(!customerRepository.existsById(id)){
            throw new RecordNotFoundException();
        }
        Customer customer = customerRepository.findById(id).get();
        customer.setName(updatedCustomer.getName());
        customerRepository.save(customer);
    }
}

