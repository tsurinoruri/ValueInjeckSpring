package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.example.demo");

		EmailService emailService = context.getBean(EmailService.class);
		UserService userService = context.getBean(UserService.class);

		System.out.println("=== Тестирование с корректными аргументами ===");
		try {
			emailService.send("user@example.com", "Hello World!");
			userService.updateName(123L, "John Doe");
			userService.updateEmail(123L, "john@example.com");
			System.out.println("✓ Все вызовы успешны\n");
		} catch (IllegalArgumentException e) {
			System.out.println("✗ Ошибка: " + e.getMessage() + "\n");
		}

		System.out.println("=== Тестирование с null аргументами ===");

		// Тест 1: null в emailService.send
		try {
			System.out.println("Вызов emailService.send(null, \"text\"):");
			emailService.send(null, "Hello World!");
		} catch (IllegalArgumentException e) {
			System.out.println("  ✗ Перехвачено исключение: " + e.getMessage() + "\n");
		}

		// Тест 2: null в userService.updateName
		try {
			System.out.println("Вызов userService.updateName(123L, null):");
			userService.updateName(123L, null);
		} catch (IllegalArgumentException e) {
			System.out.println("  ✗ Перехвачено исключение: " + e.getMessage() + "\n");
		}

		// Тест 3: null в userService.updateEmail
		try {
			System.out.println("Вызов userService.updateEmail(null, \"email@test.com\"):");
			userService.updateEmail(null, "john@example.com");
		} catch (IllegalArgumentException e) {
			System.out.println("  ✗ Перехвачено исключение: " + e.getMessage() + "\n");
		}

		// Тест 4: метод без аннотации не должен проверяться
		System.out.println("=== Тестирование метода без аннотации ===");
		try {
			System.out.println("Вызов emailService.sendWithoutCheck(null, null):");
			emailService.sendWithoutCheck(null, null);
			System.out.println("  ✓ Метод выполнился без проверки (нет исключения)\n");
		} catch (Exception e) {
			System.out.println("  ✗ Неожиданное исключение: " + e.getMessage() + "\n");
		}
		context.close();
	}
}
