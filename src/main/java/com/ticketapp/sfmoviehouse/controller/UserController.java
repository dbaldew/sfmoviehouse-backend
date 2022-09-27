package com.ticketapp.sfmoviehouse.controller;

import com.ticketapp.sfmoviehouse.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class UserController {

    @RestController
    @RequestMapping(value = "/users")
    public class Usercontroller{

        private UserService userService;

        public ResponseEntity<Object> getUsers(){
            return ResponseEntity.ok().body(userService.getUsers());
        }


    }


}
