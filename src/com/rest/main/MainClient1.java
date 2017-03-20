package com.rest.main;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class MainClient1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("testing"); Client client =
		 * ClientBuilder.newClient();
		 * 
		 * WebTarget target =
		 * client.target("https://www.farbinder.com/api/v1/upload_old");
		 * System.out.println("Request :"
		 * +target.request(MediaType.TEXT_XML).get());
		 */

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);

		WebTarget target = client.target(getBaseURI());

		String response = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(Response.class)
				.toString();

		String plainAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_PLAIN).get(String.class);
		String xmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_XML).get(String.class);
		String htmlAnswer = target.path("rest").path("hello").request().accept(MediaType.TEXT_HTML).get(String.class);

		System.out.println(response);
		System.out.println(plainAnswer);
		System.out.println(xmlAnswer);
		System.out.println(htmlAnswer);

	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri("https://www.farbinder.com/api/v1/upload_old").build();
	}

}
