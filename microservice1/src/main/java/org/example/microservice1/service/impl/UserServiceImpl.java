package org.example.microservice1.service.impl;

import org.example.microservice1.pojo.User;
import org.example.microservice1.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser() {
        return new User(1,"user 1");
    }
}
