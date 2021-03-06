package com.example.demo.manual.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

public abstract class KafkaProducerConfig {

	private ProducerFactory<String, String> producerFactory() throws Exception {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.ACKS_CONFIG, "all");
		configProps.put(ProducerConfig.CLIENT_ID_CONFIG, "demo-producer");
		configProps.put(ProducerConfig.DELIVERY_TIMEOUT_MS_CONFIG, 120000);
		configProps.put(ProducerConfig.LINGER_MS_CONFIG, 60000);
		configProps.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 30000);
		configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 33554432); // default 16384
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	protected KafkaTemplate<String, String> cretaeKafkaTemplate() throws Exception {
		return new KafkaTemplate<>(producerFactory());
	}
}
