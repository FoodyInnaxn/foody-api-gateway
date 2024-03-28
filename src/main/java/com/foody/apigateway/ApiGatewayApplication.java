package com.foody.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//		return builder.routes()
//				.route(r -> r.path("/recipe/**")
//						.filters(f -> f
//							.prefixPath("/api")
//							.addResponseHeader("X-Powered-By","Foody Gateway Service")
//						)
//						.uri("http://localhost:8081")
//				)
//				.route(r -> r.path("/user/**")
//						.filters(f -> f
//								.prefixPath("/api")
//								.addResponseHeader("X-Powered-By","Foody Gateway Service")
//						)
//						.uri("http://localhost:8082")
//				)
//				.build();
//	}

}
