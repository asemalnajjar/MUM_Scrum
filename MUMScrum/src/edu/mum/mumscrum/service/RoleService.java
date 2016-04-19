package edu.mum.mumscrum.service;

import java.util.List;

import edu.mum.mumscrum.datalayer.dao.RoleDAO;
import edu.mum.mumscrum.datalayer.model.Role;

public class RoleService {

	private RoleDAO roleDAO;

	public RoleService() {
		roleDAO = RoleDAO.getInstance();
	}

	public List<Role> getAllRoles() {
		return roleDAO.getAllRoles();
	}

}
