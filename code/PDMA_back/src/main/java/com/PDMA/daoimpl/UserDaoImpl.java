package com.PDMA.daoimpl;

import com.PDMA.dao.UserDao;
import com.PDMA.entity.User;
import com.PDMA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Long userId){
        User user = userRepository.findByUserId(userId);
        return user;
    }

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user){
        userRepository.save(user);
    }

    @Override
    public Boolean hasUser(String username){
        return !userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public User checkUser(String username, String password){
        User user = userRepository.checkUser(username,password);
        if(user==null)
            return null;
        return user;
    }

    @Override
    public void setType(Long userId, String type){
        User user = userRepository.findByUserId(userId);
        user.setType(type);
        userRepository.save(user);
        System.out.println(user.getType());
    }
}
