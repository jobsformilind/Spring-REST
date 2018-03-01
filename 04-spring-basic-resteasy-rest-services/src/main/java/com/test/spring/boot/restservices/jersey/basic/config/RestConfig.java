package com.test.spring.boot.restservices.jersey.basic.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.test.spring.boot.restservices.jersey.basic.exception.ExceptionResponse;
import com.test.spring.boot.restservices.jersey.basic.exception.GenericExceptionMapper;
import com.test.spring.boot.restservices.jersey.basic.rest.EmployeeRestService;

@ApplicationPath("/resources")
public class RestConfig extends Application {
	public Set<Class<?>> getClasses() {
		List<Class<? extends Object>> classesList = Arrays.asList(EmployeeRestService.class, ExceptionResponse.class,
				GenericExceptionMapper.class);
		return new HashSet<Class<?>>(classesList);
	}
}