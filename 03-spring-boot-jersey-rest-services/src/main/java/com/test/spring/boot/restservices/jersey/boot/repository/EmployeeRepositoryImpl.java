package com.test.spring.boot.restservices.jersey.boot.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.test.spring.boot.restservices.jersey.boot.model.Employee;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {
	private static List<Employee> employeeList;

	static {
		employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee(1, "Jane"));
		employeeList.add(new Employee(2, "Jack"));
		employeeList.add(new Employee(3, "George"));
	}

	public List<Employee> findAll() {
		return employeeList;
	}

	public Employee findById(int id) {
		return getValidatedInternalEmployee(id);
	}

	public void update(Employee employee, int id) {
		Employee emp = getValidatedInternalEmployee(id);
		emp.setId(employee.getId());
		emp.setFirstName(employee.getFirstName());
	}

	public void delete(int id) {
		Employee emp = getValidatedInternalEmployee(id);
		employeeList.remove(emp);
	}

	public void add(Employee employee) {
		Employee emp = getInternalEmployee(employee.getId());
		if (emp != null) {
			throw new RuntimeException("Employee already exists.");
		}
		employeeList.add(employee);
	}

	private Employee getValidatedInternalEmployee(int id) {
		Employee emp = getInternalEmployee(id);
		if (emp == null) {
			throw new RuntimeException("Requested employee not found : " + id);
		}
		return emp;
	}

	private Employee getInternalEmployee(int id) {
		for (Employee emp : employeeList) {
			if (id != 0 && emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}
}
