package edu.mum.mumscrum.controller;

import java.net.HttpURLConnection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonObject;

import edu.mum.mumscrum.common.ConfigurationConstants.ErrorMessage;
import edu.mum.mumscrum.databean.ResponseDataBean;
import edu.mum.mumscrum.datalayer.model.Sprint;
import edu.mum.mumscrum.service.SprintService;
import edu.mum.mumscrum.utility.MUMScrumUtil;

@Path("SprintControllerWS")
public class SprintController extends MUMScrumController {

	private SprintService sprintservice;
	private ResponseDataBean responseObject;

	public SprintController() {
		sprintservice = new SprintService();
	}

	@GET
	@Path("/sprint")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSprints() {
		List<Sprint> sprintlist = sprintservice.getAllSprints();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, sprintlist);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/sprint/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSprintById(@PathParam("id") String id) {
		Sprint sprint = sprintservice.getSprintById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, sprint);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@POST
	@Path("/sprint")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addSprint(Sprint sprint) {
		Sprint spr = sprintservice.addSprint(sprint);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, spr);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@PUT
	@Path("/sprint")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSprint(Sprint sprint) {
		Sprint spr = sprintservice.updateSprint(sprint);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, spr);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/sprint")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSprint(Sprint sprint) {
		Sprint spr = sprintservice.deleteSprint(sprint);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, spr);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/sprint/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteSprintById(@PathParam("id") String id) {
		sprintservice.setSprintIdNull(id);
		List<Sprint> spr = sprintservice.deleteSprintById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, spr);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}
}// SprintController
