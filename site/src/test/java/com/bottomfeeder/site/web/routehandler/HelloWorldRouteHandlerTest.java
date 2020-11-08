package com.bottomfeeder.site.web.routehandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bottomfeeder.service.helloworld.HelloWorldService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = HelloWorldRouteHandler.class)
public class HelloWorldRouteHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HelloWorldService helloWorldService;

    @BeforeEach
    public void setup() {
        // We would need this line if we would not use the MockitoExtension
        MockitoAnnotations.initMocks(this);
        Mockito.when(helloWorldService.message()).thenReturn("Test Hello World");
    }

    @Test
    public void test1() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/helloworld").accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String response = result.getResponse().getContentAsString();
        assertEquals("Test Hello World", result.getResponse().getContentAsString(), "Response is incorrect");

    }

}
