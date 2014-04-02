package de.marrrschine;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ServiceConsumer {

	public String consumeServiceGet(String servicename){
		Client client = Client.create();

		WebResource webResource = client
				.resource("http://marrrschine.de:8080/http://marrrschine.de:8080/webapp/rest/hello/test");
		ClientResponse response = webResource.accept("application/json").get(
				ClientResponse.class);

		String output = response.getEntity(String.class);

		return output;
	}
	

}