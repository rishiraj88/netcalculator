package gsg.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * The single entry point to the net price calculation platform of GSG. It is applicable for VAT.
 * GSG Financial Services GmbH property. Visit us at: https://www.global-savings-group.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
