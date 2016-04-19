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
import edu.mum.mumscrum.datalayer.model.Employee;
import edu.mum.mumscrum.service.EmployeeService;
import edu.mum.mumscrum.utility.MUMScrumUtil;

@Path("EmployeeControllerWS")
public class EmployeeController extends MUMScrumController {

	private EmployeeService employeeService;

	public EmployeeController() {
		employeeService = new EmployeeService();
	}

	// @GET here defines, this method will method will process HTTP GET
	// requests.
	// @GET

	// @Path here defines method level path. Identifies the URI path that a
	// resource class method will serve requests for.
	// @Path("/name/{i}")

	// @Produces here defines the media type(s) that the methods
	// of a resource class can produce.
	// @Produces(MediaType.TEXT_XML)

	// @PathParam injects the value of URI parameter that defined in @Path
	// expression, into the method.
	// @PathParam("i")

	@GET
	@Path("/employee")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() {
		List<Employee> employeesList = employeeService.getAllEmployees();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, employeesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/employee/srcummaster")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllScrumMasters() {
		List<Employee> scrumMastersList = employeeService.getAllScrumMasters();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, scrumMastersList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/employee/nonrelease/srcummaster")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllScrumMastersNotAssignedToRelease() {
		List<Employee> scrumMastersList = employeeService
				.getAllScrumMastersNotAssignedToRelease();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, scrumMastersList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/employee/assignee")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUserStoryAssignees() {
		List<Employee> assigneesList = employeeService
				.getAllUserStoryAssignees();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, assigneesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/employee/{id:[0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") String id) {
		Employee employeeResultObject = employeeService.getEmployeeById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, employeeResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/employee/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeByUsername(@PathParam("username") String username) {
		Employee employeeResultObject = employeeService
				.getEmployeeByUsername(username);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, employeeResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@POST
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee employee) {
		Employee employeeResultObject = employeeService.addEmployee(employee);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, employeeResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@PUT
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employee employee) {
		Employee employeeResultObject = employeeService
				.updateEmployee(employee);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, employeeResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/employee/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployeeById(@PathParam("id") String id) {
		/*
		 * Before deleting an employee set emp_id to null for other tables
		 */
		employeeService.setEmpIdNull(id);
		List<Employee> employeesList = employeeService.deleteEmployeeById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, employeesList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/employee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(Employee employee) {

		Employee employeeResultObject = employeeService
				.deleteEmployee(employee);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, employeeResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);

		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

}