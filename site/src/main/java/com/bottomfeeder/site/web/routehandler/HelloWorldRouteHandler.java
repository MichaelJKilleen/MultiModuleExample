package com.bottomfeeder.site.web.routehandler;

import static org.springframework.web.servlet.function.RouterFunctions.route;

import com.bottomfeeder.service.helloworld.HelloWorldService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class HelloWorldRouteHandler {

    private HelloWorldService helloWorldService;

    public HelloWorldRouteHandler(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public ServerResponse home(ServerRequest request) {
        return ServerResponse.ok().body(helloWorldService.message());
    }

    @Bean
    RouterFunction<ServerResponse> helloWorldRoutes(HelloWorldRouteHandler helloWorldRouteHandler) {
        return route().path("/helloworld", builder -> builder.GET("/", helloWorldRouteHandler::home)).build();
    }
}
