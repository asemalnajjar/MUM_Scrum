package edu.mum.mumscrum.utility;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import edu.mum.mumscrum.databean.ResponseDataBean;

public class MUMScrumUtil {
	public static <T> JsonObject prepareJsonObjectResponse(
			ResponseDataBean responseObject) {
		Gson gsonObject = new Gson();
		JsonElement status = gsonObject.toJsonTree(responseObject.getStatus());
		JsonElement message = gsonObject
				.toJsonTree(responseObject.getMessage());
		JsonElement data = gsonObject.toJsonTree(responseObject.getData());

		JsonObject jsonObject = new JsonObject();
		jsonObject.add("status", status);
		jsonObject.add("message", message);
		jsonObject.add("data", data);
		return jsonObject;
	}

}
