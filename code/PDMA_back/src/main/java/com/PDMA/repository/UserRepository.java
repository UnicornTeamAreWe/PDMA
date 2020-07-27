package com.PDMA.repository;

import com.PDMA.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<SysUser, String> {
    @Query(value = "from SysUser where username = :username and password = :password")
    SysUser checkUser(@Param("username") String username, @Param("password") String password);

    List<SysUser> findAllByUsername(String username);

    SysUser findByUsername(String username);

    SysUser findByUserId(Long userId);
}
