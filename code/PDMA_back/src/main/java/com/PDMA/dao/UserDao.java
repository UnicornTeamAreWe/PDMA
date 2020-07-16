package com.PDMA.dao;

import com.PDMA.entity.User;

import java.util.List;

public interface UserDao {
    User getUser(Long userId);
    List<User> getAllUser();
    void saveUser(User user);
    Boolean hasUser(String username);
    User checkUser(String username, String password);
    void setType(Long userId, String type);
}
