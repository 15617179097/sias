package com.nice.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName WebConfig 跨域
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/22
 * @Version V1.0
 **/
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

/*    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }*/
}
