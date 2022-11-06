package com.ticketapp.sfmoviehouse.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class AuthenticationRequestDTO {
    @NotEmpty
    private String username;
    @NotEmpty
    @Size(min=6, message = "password should have at least 6 characters")
    private String password;

    public AuthenticationRequestDTO(){}
    public AuthenticationRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

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
}
