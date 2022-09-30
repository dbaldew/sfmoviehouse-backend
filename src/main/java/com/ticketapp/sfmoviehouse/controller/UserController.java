package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.dto.request.UserPostRequest;
import com.ticketapp.sfmoviehouse.exception.BadRequestException;
import com.ticketapp.sfmoviehouse.model.User;
import com.ticketapp.sfmoviehouse.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public class UserController {

    @RestController
    @RequestMapping(value = "/users")
    public class Usercontroller{

        private UserService userService;

        @GetMapping(value = "")
        public ResponseEntity<Object> getUsers(){
            return ResponseEntity.ok().body(userService.getUsers());
        }

        @GetMapping(value = "/{username}")
        public ResponseEntity<Object>getUser(@PathVariable("username") String username){
            return ResponseEntity.ok().body(userService.getUser(username));
        }

        @PostMapping(value = "")
        public ResponseEntity<Object> createUser(@RequestBody UserPostRequest userPostRequest) {

            String newUsername = userService.createUser(userPostRequest);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{username}")
                    .buildAndExpand(newUsername).toUri();

            return ResponseEntity.created(location).build();
        }

        @PutMapping(value = "/{username}")
        public ResponseEntity<Object> updateUser(@PathVariable("username") String username, @RequestBody User user){
            userService.updateUser(username, user);
            return ResponseEntity.noContent().build();
        }

        @DeleteMapping(value = "/{username}")
        public ResponseEntity<Object> deleteUser(@PathVariable("username") String username) {
            userService.deleteUser(username);
            return ResponseEntity.noContent().build();
        }

        @GetMapping(value = "/{username}/authorities")
        public ResponseEntity<Object> getUserAuthorities(@PathVariable("username") String username) {
            return ResponseEntity.ok().body(userService.getAuthorities(username));
        }

        @PostMapping(value = "/{username}/authorities")
        public ResponseEntity<Object> addUserAuthority(@PathVariable("username") String username, @RequestBody Map<String, Object> fields) {
            try {
                String authorityName = (String) fields.get("authority");
                userService.addAuthority(username, authorityName);
                return ResponseEntity.noContent().build();
            }
            catch (Exception ex) {
                throw new BadRequestException();
            }
        }

        @DeleteMapping(value = "/{username}/authorities/{authority}")
        public ResponseEntity<Object> deleteUserAuthority(@PathVariable("username") String username, @PathVariable("authority") String authority) {
            userService.removeAuthority(username, authority);
            return ResponseEntity.noContent().build();
        }

        @PatchMapping(value = "/{username}/password")
        public ResponseEntity<Object> setPassword(@PathVariable("username") String username, @RequestBody String password) {
            userService.setPassword(username, password);
            return ResponseEntity.noContent().build();
        }










    }


}
