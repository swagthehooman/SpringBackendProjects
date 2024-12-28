package com.swagnik.recipeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RecipeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeapiApplication.class, args);
	}

}
