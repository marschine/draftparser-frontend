package de.marrrschine;

import org.json.simple.JSONArray;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ServiceConsumer {

	public JSONArray consumeServiceGet(){
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://marrrschine.de:8080/http://marrrschine.de:8080/webapp/rest/hello/live");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		String output = response.getEntity(String.class);
		
		JSONArray jsonObjects = (JSONArray) response.getEntity(JSONArray.class);

		return jsonObjects;
	}
}