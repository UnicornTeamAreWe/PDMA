package com.PDMA.support;

import com.PDMA.utils.msg.JSONResult;
import com.PDMA.utils.msg.JwtTokenUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String token = JwtTokenUtil.createToken(userDetails.getUsername(), userDetails.getAuthorities().toString());

        JSONResult<User> result = new JSONResult(Boolean.TRUE, 100, "登陆成功", userDetails);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.setHeader("token", JwtTokenUtil.TOKEN_PREFIX + token);
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
