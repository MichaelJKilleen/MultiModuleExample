package com.bottomfeeder.service.helloworld;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String message() {
        return "Hello World Service";
    }
}
