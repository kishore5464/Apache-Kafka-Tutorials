package com.kishore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.models.Employee;

@RestController
@RequestMapping("kafka")
public class HomeController {

	@Autowired
	private KafkaTemplate<String, Employee> kafkaTemplate;

	public static final String TOPIC = "Kafka_Json_Topic";

	@GetMapping("/send/{name}")
	public String jsonData(@PathVariable("name") String name) {

		kafkaTemplate.send(TOPIC, new Employee(name, "Virtusa", 12));

		return "Data send successfully Name: " + name;
	}
}
