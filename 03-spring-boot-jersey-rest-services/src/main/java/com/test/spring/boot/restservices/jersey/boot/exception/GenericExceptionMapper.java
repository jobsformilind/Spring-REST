package com.test.spring.boot.restservices.jersey.boot.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {
	public Response toResponse(Exception ex) {
		ExceptionResponse response = new ExceptionResponse(ex.getMessage());
		ResponseBuilder responseBuilder = Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
		responseBuilder.entity(response);
		return responseBuilder.build();
	}
}