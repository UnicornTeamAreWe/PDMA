package com.PDMA.daoimpl;

import com.PDMA.dao.UserDao;
import com.PDMA.entity.SysUser;
import com.PDMA.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SysUser getUser(Long userId) {
        SysUser user = userRepository.findByUserId(userId);
        return user;
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<SysUser> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(SysUser user) {
        userRepository.save(user);
    }

    @Override
    public Boolean hasUser(String username) {
        return !userRepository.findAllByUsername(username).isEmpty();
    }

    @Override
    public SysUser checkUser(String username, String password) {
        SysUser user = userRepository.checkUser(username, password);
        return user;
    }

    @Override
    public void setType(Long userId, String type) {
        SysUser user = userRepository.findByUserId(userId);
        user.setType(type);
        userRepository.save(user);
        System.out.println(user.getType());
    }
}
