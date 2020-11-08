package com.bottomfeeder.site.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bottomfeeder.service.helloworld.HelloWorldService;
import com.bottomfeeder.site.web.controller.HelloWorldController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(value = HelloWorldController.class)
class HelloWorldControllerTests {

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

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/helloworld/test")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String response = result.getResponse().getContentAsString();
		assertEquals("[\"Test Hello World : test\"]", result.getResponse().getContentAsString(),
				"Response is incorrect");

	}

}
