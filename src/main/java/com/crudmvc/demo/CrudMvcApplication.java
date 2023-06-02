package com.crudmvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.crudmvc.demo"
})
public class CrudMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudMvcApplication.class, args);
	}

}
