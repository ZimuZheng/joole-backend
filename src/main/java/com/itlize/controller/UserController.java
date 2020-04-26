package com.itlize.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.itlize.entity.User;
import com.itlize.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws Exception {
//        userService.login(user.getUsername(),user.getPassword_hash());
        return userService.getUserByName(user);

    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user) throws Exception {

        return userService.createUser(user);

    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout () {
        return ResponseEntity.ok("Logout requested");
    }

}
