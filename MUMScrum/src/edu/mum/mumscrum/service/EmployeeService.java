package edu.mum.mumscrum.service;

import java.util.List;

import edu.mum.mumscrum.datalayer.dao.EmployeeDAO;
import edu.mum.mumscrum.datalayer.model.Employee;

public class EmployeeService {
	EmployeeDAO employeeDAO;

	public EmployeeService() {
		employeeDAO = EmployeeDAO.getInstance();
	}

	public List<Employee> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	public List<Employee> getAllScrumMasters() {
		return employeeDAO.getAllScrumMasters();
	}

	public List<Employee> getAllScrumMastersNotAssignedToRelease() {
		return employeeDAO.getAllScrumMastersNotAssignedToRelease();
	}

	public List<Employee> getAllUserStoryAssignees() {
		return employeeDAO.getAllUserStoryAssignees();
	}

	public Employee getEmployeeById(String id) {
		return employeeDAO.getEmployeeById(id);
	}

	public Employee getEmployeeByUsername(String username) {
		return employeeDAO.getEmployeeByUsername(username);
	}

	public Employee addEmployee(Employee employee) {
		return employeeDAO.addEmployee(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return employeeDAO.updateEmployee(employee);
	}

	public Employee deleteEmployee(Employee employee) {
		return employeeDAO.deleteEmployee(employee);
	}

	public List<Employee> deleteEmployeeById(String id) {
		return employeeDAO.deleteEmployeeById(id);
	}

	public void setEmpIdNull(String id) {
		employeeDAO.setEmpIdNull(id);
	}

}