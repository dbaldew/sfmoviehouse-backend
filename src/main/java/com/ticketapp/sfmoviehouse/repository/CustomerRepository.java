package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository <Customer, Long> {
}
