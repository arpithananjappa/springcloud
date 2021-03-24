package com.innominds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}
	@Bean
	@LoadBalanced//here why we use loadbanced means while using resttemplate->(resttemplate.PostForObject("http://localhost:9090/orders",Payment.class )
	              //instead of localhost we used the project application name so we get internal error to avois that we used @LoadBalanced
	              
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
