package com.example.ordersystem;

import com.example.ordersystem.model.Product;
import com.example.ordersystem.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OrderSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSystemApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(ProductRepository productRepository) {
		return args -> {
			productRepository.saveAll(List.of(
					new Product(null, "Laptop", 1200.0),
					new Product(null, "Smartphone", 800.0),
					new Product(null, "Headphones", 150.0),
					new Product(null, "Mouse", 25.0)
			));
			System.out.println("Sample products initialized.");
		};
	}
}
