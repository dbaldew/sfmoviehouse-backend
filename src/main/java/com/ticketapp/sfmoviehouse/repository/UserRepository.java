package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
