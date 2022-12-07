package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.AuthenticationRequestDTO;
import com.ticketapp.sfmoviehouse.dto.AuthenticationResponseDTO;
import com.ticketapp.sfmoviehouse.service.UserAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authenticate")
public class AuthenticationController {

    UserAuthenticateService userAuthenticateService;

    @Autowired
    public AuthenticationController(UserAuthenticateService userAuthenticateService) {
        this.userAuthenticateService = userAuthenticateService;
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDTO authenticationRequestDTO) throws Exception {

        try {
            AuthenticationResponseDTO authenticationResponseDTO = userAuthenticateService.authenticateUser(authenticationRequestDTO);
            return ResponseEntity.ok(authenticationResponseDTO);
        } catch (UsernameNotFoundException ex) {
            throw new Exception("Password and/or username are incorrect", ex);
        }
    }
}
