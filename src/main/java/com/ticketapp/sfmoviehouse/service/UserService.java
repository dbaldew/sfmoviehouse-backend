package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {

    private UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }





    public Object getUsers() {
    }
}
