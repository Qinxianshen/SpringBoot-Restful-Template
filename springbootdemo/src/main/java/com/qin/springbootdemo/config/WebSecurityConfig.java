package com.qin.springbootdemo.config;


import com.qin.springbootdemo.handle.AuthenticationEntryPointHandler;
import com.qin.springbootdemo.handle.AuthenticationFailureHandler;
import com.qin.springbootdemo.handle.AuthenticationSuccessHandler;
import com.qin.springbootdemo.service.Impl.LoginServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;

/* author:Qinzijing
*  date: 2019/11/8
*  description:网络安全配置 api:user|admin Adminapi: admin Dbapi:dba registered:all login:all
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    LoginServiceImpl loginServiceImpl;

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(loginServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
        * 这里允许所有请求经过
        *
        * */
//        http.authorizeRequests()
//                .anyRequest().permitAll().and().logout().permitAll()
//                .and().csrf().disable();
        //暂时把跨域攻击关了 不然不发POST请求

        http.authorizeRequests()
                .antMatchers("/api/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                .antMatchers("/Adminapi/**").hasRole("ADMIN")
                .antMatchers("/Dbapi/**").hasRole("dba")
                .antMatchers("/registered/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler())
                .failureHandler(new AuthenticationFailureHandler())
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.ACCEPTED))
                .permitAll()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(new AuthenticationEntryPointHandler())
                .and()
                .csrf().disable();
    }
}
