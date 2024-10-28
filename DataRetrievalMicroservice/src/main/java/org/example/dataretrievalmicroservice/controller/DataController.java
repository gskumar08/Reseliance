package org.example.dataretrievalmicroservice.controller;

import org.example.dataretrievalmicroservice.pojo.User;
import org.example.dataretrievalmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getUser(){
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }
}
