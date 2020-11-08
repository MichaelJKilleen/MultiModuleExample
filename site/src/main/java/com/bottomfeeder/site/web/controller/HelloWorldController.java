package com.bottomfeeder.site.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.bottomfeeder.service.helloworld.HelloWorldService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private HelloWorldService helloWorldService;

    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping("/helloworld/{name}")
    public List<String> retrieveCoursesForStudent(@PathVariable String name) {
        List<String> names = new ArrayList<>();
        names.add(helloWorldService.message() + " : " + name);
        return names;
    }

}
