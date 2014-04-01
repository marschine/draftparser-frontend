package de.marrrschine;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ServiceConsumer {
	Client client = ClientBuilder.newClient();
	WebTarget target = client.target("http://marrrschine.de:8080").path("webapp/rest/");
}
