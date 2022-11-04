package com.ticketapp.sfmoviehouse.dto;

import java.util.Set;

public class UserPostRequest {
        private String username;
        private String password;
        private Set<String> authorities;

    public UserPostRequest(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }
}

