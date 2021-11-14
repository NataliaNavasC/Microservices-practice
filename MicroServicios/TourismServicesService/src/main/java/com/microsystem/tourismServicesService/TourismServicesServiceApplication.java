package com.microsystem.tourismServicesService;

import com.microsystem.tourismServicesService.Utils.CustomProperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(CustomProperty.class)
public class TourismServicesServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TourismServicesServiceApplication.class, args);
	}

}
