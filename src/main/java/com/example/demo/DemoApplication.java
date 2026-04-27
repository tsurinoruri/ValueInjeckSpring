package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.demo");

		TaskExecutor executor = context.getBean(TaskExecutor.class);
		executor.work();
		context.close();
	}
}
