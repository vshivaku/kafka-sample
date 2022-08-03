package com.kafka.sample.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	private KafkaService service;
	@PostMapping(path="send")
	public void sendMessage(String input)
	{
		service.send(input);
	}
	
}	
