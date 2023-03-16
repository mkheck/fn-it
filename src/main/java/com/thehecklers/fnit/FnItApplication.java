package com.thehecklers.fnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class FnItApplication {

	public static void main(String[] args) {
		SpringApplication.run(FnItApplication.class, args);
	}

	@Bean
	public Function<String, String> echo() {
		return s -> s;
	}
}
