package org.mickael.libraryauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LibraryAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAuthServerApplication.class, args);
	}

}
