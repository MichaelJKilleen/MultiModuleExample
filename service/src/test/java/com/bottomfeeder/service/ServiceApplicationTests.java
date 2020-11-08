package com.bottomfeeder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = TestServiceConfiguration.class)
class ServiceApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("", "");
	}

}
