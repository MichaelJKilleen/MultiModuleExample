package com.bottomfeeder.service;

import com.bottomfeeder.service.helloworld.HelloWorldService;
import com.bottomfeeder.service.helloworld.HelloWorldServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.bottomfeeder.*" })
public class TestServiceConfiguration {

    @Bean
    public HelloWorldService helloWorldService() {
        return new HelloWorldServiceImpl();
    }

}
