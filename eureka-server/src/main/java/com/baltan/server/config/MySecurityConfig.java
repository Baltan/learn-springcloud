package com.baltan.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-01-30 14:43
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         * Spring Cloud 2.0 以上的Security默认启用了csrf检验，
         * 要在eurekaServer端配置security的csrf检验为false，
         * 否则服务提供者无法注册进eureka注册中心
         *
         * 参考：https://segmentfault.com/a/1190000015319949
         */
        http.csrf().disable();
        super.configure(http);
    }
}
