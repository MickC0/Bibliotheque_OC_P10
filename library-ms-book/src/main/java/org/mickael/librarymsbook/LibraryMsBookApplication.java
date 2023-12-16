package org.mickael.librarymsbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("org.mickael.librarymsbook")
@EnableDiscoveryClient
public class LibraryMsBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMsBookApplication.class, args);
	}

}
