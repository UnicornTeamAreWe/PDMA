package com.PDMA.support;

import com.PDMA.entity.SysUser;
import com.PDMA.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("username:" + username);
        SysUser user = userService.getUserByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException(String.format("User with the username %s doesn't exist", username));
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(user.getType());

        System.out.println("pwd:"+user.getPassword());
        BCryptPasswordEncoder ecd = new BCryptPasswordEncoder();
        System.out.println(ecd.encode("12345"));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
