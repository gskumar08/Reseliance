package org.example.microservice1.controller;

import org.example.microservice1.pojo.User;
import org.example.microservice1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/m1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getUser(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }
}
