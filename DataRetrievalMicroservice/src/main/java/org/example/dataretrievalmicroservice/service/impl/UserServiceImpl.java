package org.example.dataretrievalmicroservice.service.impl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.example.dataretrievalmicroservice.pojo.User;
import org.example.dataretrievalmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public RestTemplate restTemplate;
    private static String USER_BASE_URL = "http://localhost:8080/m1/user";
    @Override
    //@Retry(name = "retryApi", fallbackMethod = "fallbackAfterRetry")
    @CircuitBreaker(name = "retryAPi", fallbackMethod = "fallbackAfterRetry")
    public User getUser() {
        return restTemplate.getForObject(USER_BASE_URL,User.class);
    }
    public User fallbackAfterRetry(Exception ex) {
        System.out.println("--------fallbackAfterRetry-----");
        return new User(0,"Dummy");
    }
}
