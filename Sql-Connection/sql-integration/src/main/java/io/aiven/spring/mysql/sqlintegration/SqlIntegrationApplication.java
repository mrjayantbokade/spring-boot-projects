package io.aiven.spring.mysql.sqlintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqlIntegrationApplication {

	public static void main(String[] args) {

		SpringApplication.run(SqlIntegrationApplication.class, args);
		System.out.println(">>>>>>>>>>>>>>>>");
		System.out.println("running on port localhost:8080/project");

	}

}
