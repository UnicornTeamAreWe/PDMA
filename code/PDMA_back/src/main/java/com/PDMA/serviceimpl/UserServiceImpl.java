package com.PDMA.serviceimpl;

import com.PDMA.dao.UserDao;
import com.PDMA.entity.SysUser;
import com.PDMA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public SysUser checkUser(String username, String password) {
        return userDao.checkUser(username, password);
    }

    @Override
    public void saveUser(SysUser user) {
        userDao.saveUser(user);
    }

    @Override
    public Boolean hasUser(String username) {
        return userDao.hasUser(username);
    }

    @Override
    public List<SysUser> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public SysUser getUser(Long userId) {
        return userDao.getUser(userId);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public void setType(Long userId, String type) {
        userDao.setType(userId, type);
    }

    @Override
    public void init() {

    }


}
