package com.test.spring.boot.restservices.jersey.boot.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.spring.boot.restservices.jersey.boot.model.Employee;
import com.test.spring.boot.restservices.jersey.boot.repository.EmployeeRepository;

@Component
@Path("/api/employees")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class EmployeeRestService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@GET
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@GET
	@Path("/{id}")
	public Employee findById(@PathParam("id") int id) {
		return employeeRepository.findById(id);
	}

	@PUT
	@Path("/{id}")
	public Response update(Employee employee, @PathParam("id") int id) {
		employeeRepository.update(employee, id);
		ResponseBuilder responseBuilder = Response.status(Response.Status.OK.getStatusCode());
		return responseBuilder.build();
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		employeeRepository.delete(id);
		ResponseBuilder responseBuilder = Response.status(Response.Status.OK.getStatusCode());
		return responseBuilder.build();
	}

	@POST
	public Response add(Employee employee, @Context UriInfo uriInfo) {
		employeeRepository.add(new Employee(employee.getId(), employee.getFirstName()));
		ResponseBuilder responseBuilder = Response.status(Response.Status.CREATED.getStatusCode());
		responseBuilder.header("Location", String.format("%s/%s", uriInfo.getAbsolutePath(), employee.getId()));
		return responseBuilder.build();
	}
}
