package com.kafka.sample.demo;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

	@Autowired
    StreamBridge streamBridge;
	
	public void send(String input){
        streamBridge.send("output-out-0", MessageBuilder.withPayload(input)
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)).build());
    }
	
}
