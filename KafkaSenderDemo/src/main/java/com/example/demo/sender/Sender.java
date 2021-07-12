package com.example.demo.sender;

import javax.annotation.PostConstruct;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.example.demo.manual.config.KafkaProducerConfig;

@Component
public class Sender extends KafkaProducerConfig {
	
	KafkaTemplate<String, String> kafkatemplate = null;
	
	@PostConstruct
	public void init() throws Exception {
		kafkatemplate = cretaeKafkaTemplate();
	}
	
	public void sendMsg(String msg) throws Exception {
		kafkatemplate.send("topic-test", msg);
	}

}
