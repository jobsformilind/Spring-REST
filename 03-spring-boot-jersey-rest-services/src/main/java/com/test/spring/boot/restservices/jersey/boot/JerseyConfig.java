package com.test.spring.boot.restservices.jersey.boot;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.test.spring.boot.restservices.jersey.boot.repository.EmployeeRepository;
import com.test.spring.boot.restservices.jersey.boot.repository.EmployeeRepositoryImpl;
import com.test.spring.boot.restservices.jersey.boot.rest.EmployeeRestService;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(EmployeeRepository.class);
		register(EmployeeRepositoryImpl.class);
		register(EmployeeRestService.class);
		packages("com.test.spring.boot.restservices.jersey.boot");
	}

}