package com.kishore.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.kishore.models.Employee;

@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String, Employee> producerFactory() {

		Map<String, Object> configs = new HashMap<>();

		// This 127.0.0.1 is localhost and 9092 port is our consumer running port which
		// we able to see in terminal
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");

		// Our Map key type is String so we assign value as StringSerializer from Kafka
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		// Our Map value type is JSON so we assign value as JsonSerializer from Kafka
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(configs);

	}

	@Bean
	public KafkaTemplate<String, Employee> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
