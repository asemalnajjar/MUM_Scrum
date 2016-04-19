package edu.mum.mumscrum.controller;

import java.net.HttpURLConnection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;

import edu.mum.mumscrum.common.ConfigurationConstants.ErrorMessage;
import edu.mum.mumscrum.databean.ResponseDataBean;
import edu.mum.mumscrum.datalayer.model.Role;
import edu.mum.mumscrum.service.RoleService;
import edu.mum.mumscrum.utility.MUMScrumUtil;

@Path("RoleControllerWS")
public class RoleController extends MUMScrumController {
	private RoleService roleService;
	private ResponseDataBean responseObject;

	public RoleController() {
		roleService = new RoleService();
	}

	@GET
	@Path("/role")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRoles() {
		List<Role> rolesList = roleService.getAllRoles();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, rolesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}
}
