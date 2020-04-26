package com.itlize.service;

import org.springframework.http.ResponseEntity;

import com.itlize.entity.User;

public interface UserService {

    ResponseEntity<?> login(String username, String password) throws Exception;

    ResponseEntity<?> createUser(User user) throws Exception;

    ResponseEntity<?> getUserByName(User user) throws Exception;

}