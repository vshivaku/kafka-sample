package com.kafka.sample.demo;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@Bean
    Consumer<Message<String>> input() {
        return str -> {
           //log.info("Consumed payload : {}", str);
            RetryTemplate retryTemplate = new RetryTemplate();
            FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
            backOffPolicy.setBackOffPeriod(600000);

            retryTemplate.setBackOffPolicy(backOffPolicy);
            retryTemplate.execute(context -> {
                try {
                    //service call
                }
                catch (Exception e) {
                    throw new IllegalStateException("test");
                }
                return null;
            });
        };
    }
	
}
