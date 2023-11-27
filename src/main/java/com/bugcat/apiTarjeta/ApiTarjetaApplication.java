package com.bugcat.apiTarjeta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiTarjetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTarjetaApplication.class, args);
	}

}
