package com.qin.springbootdemo.handle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qin.springbootdemo.domain.User;
import com.qin.springbootdemo.domain.UserResult;
import org.springframework.security.core.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/* author:Qinzijing
*  date: 2019/11/9
*  description:登陆正确时返回的控制器
*/
public class AuthenticationSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        /*
         * 登陆成功返回json数据
         * */
        Object principal = authentication.getPrincipal();
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        httpServletResponse.setStatus(200);
        Map<String,Object> map = new HashMap<>();
        UserResult userResult = new UserResult();
        if(principal instanceof User){
            userResult.setUserId(((User) principal).getUserId());
            userResult.setEnabled(((User) principal).isEnabled());
            userResult.setLocked(((User) principal).getLocked());
            userResult.setRoleId(((User) principal).getRoles().get(0).getRoleId());
            userResult.setRoleName(((User) principal).getRoles().get(0).getNameZh());
        }
        map.put("status",200);
        map.put("data",userResult);
        map.put("msg","登录成功");
        ObjectMapper om = new ObjectMapper();
        out.write(om.writeValueAsString(map));
        out.flush();
        out.close();
    }
}
