package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.AuthenticationRequestDTO;
import com.ticketapp.sfmoviehouse.dto.AuthenticationResponseDTO;
import com.ticketapp.sfmoviehouse.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticateService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwtUtl;
    public AuthenticationResponseDTO authenticateUser(AuthenticationRequestDTO authenticationRequestDTO) {

        String username = authenticationRequestDTO.getUsername();
        String password = authenticationRequestDTO.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
            final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            final String jwt = jwtUtl.generateToken(userDetails);

            return new AuthenticationResponseDTO(jwt);
        }
        catch (BadCredentialsException ex) {
            throw new UsernameNotFoundException("Incorrect username or password");
        }
    }
}
