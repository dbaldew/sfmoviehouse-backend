package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.UserDTO;
import com.ticketapp.sfmoviehouse.exception.*;
import com.ticketapp.sfmoviehouse.entity.Authority;
import com.ticketapp.sfmoviehouse.entity.User;
import com.ticketapp.sfmoviehouse.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private String getCurrentUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((UserDetails) authentication.getPrincipal()).getUsername();
    }

    public Collection<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(String username){
        if (!userRepository.existsById(username)) {
            throw new RecordNotFoundException();
        }
        return userRepository.findById(username);
    }

    public String createUser(UserDTO userDTO) {
        try {
            String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());

            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(encryptedPassword);
            user.setEnabled(true);
            user.addAuthority("ROLE_USER");
            for (String s : userDTO.getAuthorities()){
                if(Objects.equals(s, "ROLE_USER")){
                    continue;
                }
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

    public Set<Authority> getAuthorities(String username) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        else {
            User user = userOptional.get();
            return user.getAuthorities();
        }
    }

    public void addAuthority(String username, String authority) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        else {
            User user = userOptional.get();
            user.addAuthority(new Authority(username, authority));
            userRepository.save(user);
        }
    }

    public void removeAuthority(String username, String authority) {
        Optional<User> userOptional = userRepository.findById(username);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException(username);
        }
        else {
            User user = userOptional.get();
            user.removeAuthority(authority);
            userRepository.save(user);
        }
    }

    private boolean isValidPassword(String password) {

        final int MIN_LENGTH = 6;
        boolean validPassword = true;
        if (password.length() < MIN_LENGTH) validPassword = false;
        return validPassword;
    }

    public void setPassword(String username, String password) {
        if (username.equals(getCurrentUserName())) {
            if (isValidPassword(password)) {
                Optional<User> userOptional = userRepository.findById(username);
                if (userOptional.isPresent()) {
                    User user = userOptional.get();
                    user.setPassword(passwordEncoder.encode(password));
                    userRepository.save(user);
                }
                else {
                    throw new UserNotFoundException(username);
                }
            }
            else {
                throw new InvalidPassWordException();
            }
        }
        else {
            throw new NotAuthorizedException();
        }
    }

}
