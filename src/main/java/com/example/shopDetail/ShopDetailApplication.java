package com.example.shopDetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShopDetailApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopDetailApplication.class, args);
	}

}
