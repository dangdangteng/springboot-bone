package com.dinglicom.cloud.eurake.config;

/***
 * @creation purpose : security 权限验证
 * @data : 16:44,2019-07-23
 * @author : 『Ezreal』
 * @Character description : 最帅的那个就是我
 ***/
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        super.configure(http);
    }
}