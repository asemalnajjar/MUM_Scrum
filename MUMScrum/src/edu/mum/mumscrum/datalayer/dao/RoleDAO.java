package edu.mum.mumscrum.datalayer.dao;

import java.util.List;

import org.eclipse.persistence.expressions.ExpressionBuilder;

import edu.mum.mumscrum.common.ConfigurationConstants.SortingType;
import edu.mum.mumscrum.datalayer.model.Role;

public class RoleDAO {

	private static RoleDAO roleDAO;
	private MUMScrumDAO mumScrumDAO;

	public RoleDAO() {
		mumScrumDAO = MUMScrumDAO.getInstance();
	}

	public static RoleDAO getInstance() {
		if (roleDAO == null) {
			return new RoleDAO();
		}
		return roleDAO;
	}

	public List<Role> getAllRoles() {
		return mumScrumDAO.getAllObjectsByExpression(Role.class,
				new ExpressionBuilder(), SortingType.ASCENDING, "roleDesc");
	}

}
