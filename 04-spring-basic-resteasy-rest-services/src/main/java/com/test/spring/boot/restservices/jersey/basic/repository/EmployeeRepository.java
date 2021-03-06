package com.test.spring.boot.restservices.jersey.basic.repository;

import java.util.List;

import com.test.spring.boot.restservices.jersey.basic.model.Employee;

public interface EmployeeRepository {

	public List<Employee> findAll();

	public Employee findById(int id);

	public void update(Employee employee, int id);

	public void delete(int id);

	public void add(Employee employee);
}