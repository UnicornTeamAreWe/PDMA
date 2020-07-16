package com.PDMA.service;

import com.PDMA.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User checkUser(String username, String password);

    void saveUser(User user);

    Boolean hasUser(String username);

    List<User> getAllUser();

    User getUser(Long userId);

    void setType(Long userId, String type);
}
