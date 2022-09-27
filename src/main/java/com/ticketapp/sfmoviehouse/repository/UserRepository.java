package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, String> {
}
