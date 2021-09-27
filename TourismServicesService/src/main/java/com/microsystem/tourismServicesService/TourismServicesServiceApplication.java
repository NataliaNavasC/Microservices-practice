package com.microsystem.tourismServicesService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TourismServicesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourismServicesServiceApplication.class, args);
	}

}
