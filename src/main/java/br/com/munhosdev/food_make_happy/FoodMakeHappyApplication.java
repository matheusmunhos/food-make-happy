package br.com.munhosdev.food_make_happy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FoodMakeHappyApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodMakeHappyApplication.class, args);
	}

}
