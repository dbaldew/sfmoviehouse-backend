package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.request.UserPostRequest;
import com.ticketapp.sfmoviehouse.exception.BadRequestException;
import com.ticketapp.sfmoviehouse.exception.UserNotFoundException;
import com.ticketapp.sfmoviehouse.model.User;
import com.ticketapp.sfmoviehouse.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.Optional;

public class UserService {

    private UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username){
        return userRepository.findById(username);
    }

    public String createUser(UserPostRequest userPostRequest) {
        try {
            String encryptedPassword = passwordEncoder.encode(userPostRequest.getPassword());

            User user = new User();
            user.setUsername(userPostRequest.getUsername());
            user.setPassword(encryptedPassword);
            user.setEnabled(true);
            user.addAuthority("ROLE_USER");
            for (String s : userPostRequest.getAuthorities()) {
                if (!s.startsWith("ROLE_")) {
                    s = "ROLE_" + s;
                }
                user.addAuthority(s);
            }

            User newUser = userRepository.save(user);
            return newUser.getUsername();
        }
        catch (Exception ex) {
            throw new BadRequestException("Cannot create user.");
        }
    }

    public void updateUser(String username, User newUser) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        else {
            User user = userOptional.get();
            user.setPassword(passwordEncoder.encode(newUser.getPassword()));
            user.setEnabled(newUser.isEnabled());
            userRepository.save(user);
        }
    }

    public void deleteUser(String username) {
        if (userRepository.existsById(username)) {
            userRepository.deleteById(username);
        }
        else {
            throw new UserNotFoundException(username);
        }
    }






}
