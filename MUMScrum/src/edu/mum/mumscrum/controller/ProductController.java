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
import edu.mum.mumscrum.datalayer.model.Product;
import edu.mum.mumscrum.service.ProductService;
import edu.mum.mumscrum.utility.MUMScrumUtil;

@Path("ProductControllerWS")
public class ProductController extends MUMScrumController {

	private ProductService productService;

	public ProductController() {
		productService = new ProductService();
	}

	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProducts() {
		List<Product> productsList = productService.getAllProducts();
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, productsList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductById(@PathParam("id") String id) {
		Product productResultObject = productService.getProductById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, productResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {

		Product productResultObject = productService.addProduct(product);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, productResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@PUT
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateProduct(Product product) {
		Product productResultObject = productService.updateProduct(product);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, productResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProductById(@PathParam("id") String id) {

		productService.deleteAllChild(id);
		/*
		 * On delete for a Product cascade delete for PROGRESS_RECORD, US,
		 * Sprint, Release by prd_id
		 */

		List<Product> productsList = productService.deleteProductById(id);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, productsList);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

	@DELETE
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(Product product) {
		Product productResultObject = productService.deleteProduct(product);
		responseObject = new ResponseDataBean(ErrorMessage.SUCCESS,
				ErrorMessage.SUCCESS, productResultObject);
		JsonObject result = MUMScrumUtil
				.prepareJsonObjectResponse(responseObject);
		return Response.status(HttpURLConnection.HTTP_OK)
				.entity(result.toString()).build();
	}

}
