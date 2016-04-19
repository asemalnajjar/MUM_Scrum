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
import edu.mum.mumscrum.datalayer.model.Userstory;
import edu.mum.mumscrum.service.UserStoryService;
import edu.mum.mumscrum.utility.MUMScrumUtil;

@Path("UserStoryControllerWS")
public class UserStoryController extends MUMScrumController {

	private UserStoryService userStoryService;

	public UserStoryController() {
		userStoryService = new UserStoryService();
	}

	@GET
	@Path("/userstory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserStorys() {
		List<Userstory> userStoriesList = userStoryService.getAllUserStorys();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoriesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/product/{id}/userstory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserStoriesByProductId(
			@PathParam("id") String productId) {
		List<Userstory> userStoriesList = userStoryService
				.getAllUserStoriesByProductId(productId);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoriesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/sprint/{id}/userstory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserStoriesBySprintId(@PathParam("id") String sprintId) {
		List<Userstory> userStoriesList = userStoryService
				.getAllUserStoriesBySprintId(sprintId);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoriesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/nonsprint/userstory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserStoriesNotAssignedToSprint(
			@PathParam("id") String sprintId) {
		List<Userstory> userStoriesList = userStoryService
				.getAllUserStoriesNotAssignedToSprint();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoriesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/assignee/{id}/userstory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserStoriesByAssigneeId(
			@PathParam("id") String assigneeId) {
		List<Userstory> userStoriesList = userStoryService
				.getAllUserStoriesByAssigneeId(assigneeId);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoriesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/userstory/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserStoryById(@PathParam("id") String id) {
		Userstory userStoryResultObject = userStoryService.getUserStoryById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoryResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@POST
	@Path("/userstory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUserStory(Userstory userstory) {
		Userstory userStoryResultObject = userStoryService
				.addUserStory(userstory);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoryResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@PUT
	@Path("/userstory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUserStory(Userstory userstory) {
		Userstory userStoryResultObject = userStoryService
				.updateUserStory(userstory);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoryResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/userstory/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserStoryById(@PathParam("id") String id) {
		List<Userstory> userStoriesList = userStoryService
				.deleteUserStoryById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoriesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/userstory")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUserStory(Userstory userstory) {
		Userstory userStoryResultObject = userStoryService
				.deleteUserStory(userstory);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, userStoryResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

}
