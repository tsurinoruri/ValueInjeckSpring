package com.example.demo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.demo");
		PlanService service = context.getBean(PlanService.class);
		service.printConfig();
		context.close();
	}
}
