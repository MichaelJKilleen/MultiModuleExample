package com.bottomfeeder.site.web.routehandler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

@Component
public class TestRouteHandler {
    public ServerResponse execute(ServerRequest request) {
        return ServerResponse.ok().body("Test 123");
    }

}