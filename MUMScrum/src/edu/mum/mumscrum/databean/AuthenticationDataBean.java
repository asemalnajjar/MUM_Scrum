package edu.mum.mumscrum.databean;

import edu.mum.mumscrum.datalayer.model.Employee;

public class AuthenticationDataBean {

	private Employee employee;
	private String homeRoute;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getHomeRoute() {
		return homeRoute;
	}

	public void setHomeRoute(String homeRoute) {
		this.homeRoute = homeRoute;
	}
}
