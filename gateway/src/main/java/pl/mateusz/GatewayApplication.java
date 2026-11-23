package pl.mateusz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder,
                                     @Value("${company.service.url}") String companyUrl,
                                     @Value("${food.service.url}") String foodUrl) {
		return builder.routes()
				.route("companies", r -> r
						.path("/api/companies", "/api/companies/{id}")
						.uri(companyUrl))
				.route("foods", r -> r
						.path("/api/foods", "/api/foods/**",
								"/api/companies/{id}/foods", "/api/companies/{id}/foods/**")
						.uri(foodUrl))
				.build();
	}
}
