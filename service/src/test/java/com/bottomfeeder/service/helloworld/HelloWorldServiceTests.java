package com.bottomfeeder.service.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bottomfeeder.service.TestServiceConfiguration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestServiceConfiguration.class)
class HelloWorldServiceTests {

	@Autowired
	HelloWorldService helloWorldService;

	@Test
	void testMessage() {
		String theMessage = helloWorldService.message();
		assertEquals("Hello World Service", theMessage);

	}

}
