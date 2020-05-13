package com.kishore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class HomeController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public static final String TOPIC = "Kafka_Topic";

	@GetMapping("/send/{data}")
	public String stringData(@PathVariable("data") String data) {

		kafkaTemplate.send(TOPIC, data);

		return "Message Send Successfully, Data is: " + data;
	}
	
}