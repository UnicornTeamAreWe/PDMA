package com.PDMA.service;

import com.PDMA.entity.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    SysUser checkUser(String username, String password);

    void saveUser(SysUser user);

    Boolean hasUser(String username);

    List<SysUser> getAllUser();

    SysUser getUser(Long userId);

    SysUser getUserByUsername(String username);

    void setType(Long userId, String type);

    void init();
}
