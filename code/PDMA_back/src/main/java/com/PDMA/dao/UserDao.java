package com.PDMA.dao;

import com.PDMA.entity.SysUser;

import java.util.List;

public interface UserDao {
    SysUser getUser(Long userId);
    SysUser getUserByUsername(String username);
    List<SysUser> getAllUser();
    void saveUser(SysUser user);
    Boolean hasUser(String username);
    SysUser checkUser(String username, String password);
    void setType(Long userId, String type);
}
