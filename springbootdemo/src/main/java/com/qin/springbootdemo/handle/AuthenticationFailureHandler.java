package com.qin.springbootdemo.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/* author:Qinzijing
*  date: 2019/11/9
*  description:登陆失败时候返回的控制器
*/
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        /*
         * 登陆失败返回json
         * */
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setStatus(401);
        Map<String,Object> map = new HashMap<>();
        map.put("status",401);
        if (e instanceof LockedException){
            map.put("map","账户被锁定，登陆失败");
        }else if (e instanceof BadCredentialsException){
            map.put("msg","用户名或者密码输入错误，登陆失败");
        }else if(e instanceof DisabledException){
            map.put("msg","账户被禁用，登陆失败");
        }else if(e instanceof AccountExpiredException){
            map.put("msg","账户已过期，登陆失败");
        }else if(e instanceof CredentialsExpiredException){
            map.put("msg","密码已过期，登陆失败");
        }else {
            map.put("msg","登陆失败");
        }
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
    }
}
