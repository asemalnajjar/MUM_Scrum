package edu.mum.mumscrum.controller;

import java.net.HttpURLConnection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;

import edu.mum.mumscrum.databean.AuthenticationDataBean;
import edu.mum.mumscrum.databean.ResponseDataBean;
import edu.mum.mumscrum.service.AuthenticationService;
import edu.mum.mumscrum.utility.MUMScrumUtil;

@Path("/AuthenticationControllerWS")
public class AuthenticationController extends MUMScrumController {

	private AuthenticationService authenticationService;

	public AuthenticationController() {
		authenticationService = new AuthenticationService();
	}

	@POST
	@Path("/authenticate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response authenticate(AuthenticationDataBean authenticationObject) {
		String authCredentials = authenticationService
				.authenticate(authenticationObject);
		responseObject = new ResponseDataBean(authCredentials, authCredentials,
				authenticationObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}
}
