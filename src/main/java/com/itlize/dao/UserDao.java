package com.itlize.dao;

import com.itlize.entity.User;


public interface UserDao {

    void addUser(User user);

    User findUserByUsername(String username);

}
