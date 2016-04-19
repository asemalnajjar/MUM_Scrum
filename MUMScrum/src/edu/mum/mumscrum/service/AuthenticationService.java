package edu.mum.mumscrum.service;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import edu.mum.mumscrum.common.ConfigurationConstants.AuthenticationStandard;
import edu.mum.mumscrum.common.ConfigurationConstants.CharacterEncoding;
import edu.mum.mumscrum.common.ConfigurationConstants.ErrorMessage;
import edu.mum.mumscrum.common.ConfigurationConstants.RoleTypeHomeRoute;
import edu.mum.mumscrum.databean.AuthenticationDataBean;
import edu.mum.mumscrum.datalayer.model.Employee;

public class AuthenticationService {
	private EmployeeService employeeService;

	public AuthenticationService() {
		employeeService = new EmployeeService();
	}

	public String authenticate(AuthenticationDataBean authenticationObject) {
		if (authenticationObject.getEmployee().getUsername() == null
				|| authenticationObject.getEmployee().getPassword() == null) {
			return ErrorMessage.USERNAME_OR_PASSWORD_VALUE_IS_REQUIRED;
		}

		Employee employee = employeeService
				.getEmployeeByUsername(authenticationObject.getEmployee()
						.getUsername());

		if (employee != null) {
			if (!employee.getPassword().equals(
					authenticationObject.getEmployee().getPassword())) {
				return ErrorMessage.INVALID_USERNAME_OR_PASSWORD;
			}
			authenticationObject.setEmployee(employee);
			String homeRoute = getAuthObjHomeRoute(employee);
			// if (homeRoute == null) {
			// return ErrorMessage.AUTHENTICATION_FAILED;
			// }
			authenticationObject.setHomeRoute(homeRoute);
		} else {
			return ErrorMessage.INVALID_USERNAME_OR_PASSWORD;
		}

		return ErrorMessage.SUCCESS;
	}

	private String getAuthObjHomeRoute(Employee employee) {
		String roleDesc = employee.getRole().getRoleDesc();
		if (RoleTypeHomeRoute.PRODUCT_OWNER.getName().equals(roleDesc)) {
			return RoleTypeHomeRoute.PRODUCT_OWNER.getHomeRoute();
		}
		if (RoleTypeHomeRoute.SCRUM_MASTER.getName().equals(roleDesc)) {
			return RoleTypeHomeRoute.SCRUM_MASTER.getHomeRoute();
		}
		if (RoleTypeHomeRoute.DEVELOPER.getName().equals(roleDesc)) {
			return RoleTypeHomeRoute.DEVELOPER.getHomeRoute();
		}
		if (RoleTypeHomeRoute.TESTER.getName().equals(roleDesc)) {
			return RoleTypeHomeRoute.TESTER.getHomeRoute();
		}
		if (RoleTypeHomeRoute.HR_ADMIN.getName().equals(roleDesc)) {
			return RoleTypeHomeRoute.HR_ADMIN.getHomeRoute();
		}
		return null;
	}

	public boolean authenticate(String authCredentials) {
		boolean authenticationStatus = false;
		if (null == authCredentials) {
			return authenticationStatus;
		}
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst(
				AuthenticationStandard.BASIC + " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes,
					CharacterEncoding.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (usernameAndPassword.endsWith(":")
				|| usernameAndPassword.startsWith(":")) {
			return authenticationStatus;
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		Employee employee = employeeService.getEmployeeByUsername(username);

		if (employee != null) {
			authenticationStatus = employee.getPassword().equals(password);
		}

		return authenticationStatus;
	}

}
