package edu.mum.mumscrum.datalayer.dao;

import java.util.List;

import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

import edu.mum.mumscrum.common.ConfigurationConstants.RoleTypeHomeRoute;
import edu.mum.mumscrum.common.ConfigurationConstants.SortingType;
import edu.mum.mumscrum.datalayer.model.Employee;

public class EmployeeDAO {
	private static EmployeeDAO employeeDAO;
	private MUMScrumDAO mumScrumDAO;

	private EmployeeDAO() {
		mumScrumDAO = MUMScrumDAO.getInstance();
	}

	public static EmployeeDAO getInstance() {
		if (employeeDAO == null) {
			return new EmployeeDAO();
		}
		return employeeDAO;
	}

	public List<Employee> getAllEmployees() {
		return mumScrumDAO.getAllObjectsByExpression(Employee.class,
				new ExpressionBuilder(), SortingType.ASCENDING, "id");
	}

	public List<Employee> getAllScrumMasters() {
		Expression expression = new ExpressionBuilder().get("role")
				.get("roleId").equal(RoleTypeHomeRoute.SCRUM_MASTER.getId());
		return mumScrumDAO.getAllObjectsByExpression(Employee.class,
				expression, SortingType.ASCENDING, "firstName");
	}

	public List<Employee> getAllUserStoryAssignees() {
		Expression expression = new ExpressionBuilder().get("role")
				.get("roleId").equal(RoleTypeHomeRoute.DEVELOPER.getId());
		expression = expression.or(new ExpressionBuilder().get("role")
				.get("roleId").equal(RoleTypeHomeRoute.TESTER.getId()));
		return mumScrumDAO.getAllObjectsByExpression(Employee.class,
				expression, SortingType.ASCENDING, "firstName");
	}

	public List<Employee> getAllScrumMastersNotAssignedToRelease() {
		return null;
	}

	public Employee getEmployeeById(String id) {
		Expression expression = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.getObjectByExpression(Employee.class, expression);
	}

	public Employee getEmployeeByUsername(String username) {
		Expression expression = new ExpressionBuilder().get("username").equal(
				username);
		return mumScrumDAO.getObjectByExpression(Employee.class, expression);
	}

	public Employee addEmployee(Employee employee) {
		return mumScrumDAO.addObject(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return mumScrumDAO.updateObject(employee);
	}

	public Employee deleteEmployee(Employee employee) {
		return mumScrumDAO.deleteObject(employee);
	}

	public List<Employee> deleteEmployeeById(String id) {
		Expression expression = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.deleteAllObjectsBasedOnExpression(Employee.class,
				expression);
	}

	public void setEmpIdNull(String id) {
		String up1 = " update Product   set emp_id = null where emp_id = " + id;
		String up2 = " update Release   set emp_id = null where emp_id = " + id;
		String up3 = " update UserStory set emp_id = null where emp_id = " + id;
		String up4 = " update SPRINT    set emp_id = null where emp_id = " + id;
		mumScrumDAO.executeNonSelectingSQLCall(up1);
		mumScrumDAO.executeNonSelectingSQLCall(up2);
		mumScrumDAO.executeNonSelectingSQLCall(up3);
		mumScrumDAO.executeNonSelectingSQLCall(up4);
	}

}