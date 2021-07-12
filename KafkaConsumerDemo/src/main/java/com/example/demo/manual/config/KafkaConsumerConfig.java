package com.example.demo.manual.config;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public abstract class KafkaConsumerConfig {
	
	protected KafkaConsumer<String, String> consumerFactory() throws Exception {
		Properties config = new Properties();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // earliest or latest
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "demo");
		config.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 20);
		config.put(ConsumerConfig.ALLOW_AUTO_CREATE_TOPICS_CONFIG, false);
		config.put(ConsumerConfig.CLIENT_ID_CONFIG, "demo-consumer");
		return new KafkaConsumer<>(config);
	}
}
