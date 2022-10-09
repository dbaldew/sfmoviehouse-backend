package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.request.AuthenticationRequest;
import com.ticketapp.sfmoviehouse.dto.response.AuthenticationResponse;
import com.ticketapp.sfmoviehouse.service.UserAuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class AuthenticationController {

    UserAuthenticateService userAuthenticateService;

    @Autowired
    public AuthenticationController (UserAuthenticateService userAuthenticateService){
        this.userAuthenticateService = userAuthenticateService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {

        AuthenticationResponse authenticationResponse = userAuthenticateService.authenticateUser(authenticationRequest);

        return ResponseEntity.ok(authenticationResponse);
    }

}
