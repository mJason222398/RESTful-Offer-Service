package com.mbradley.restfulservice.jerseyclient;

import java.util.Date;

import javax.ws.rs.core.MediaType;

import com.mbradley.restfulservice.Offer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class JerseyClient {
	
	public static void main(String[] args) {
		
		createOffer();
		getOffer();
	}
	
	public static void createOffer()
	{
		try
		{
			Offer offer = new Offer("ID3434", "Half price golf balls", "GBP", 12.99, new Date(), new Date());
			Client client = Client.create();
			WebResource webResource = client.resource("http://localhost:8080/RESTful/restfulservice/offer/create");
			ClientResponse response = webResource.accept("application/xml").post(ClientResponse.class, offer);
			
			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			
			String output = response.getEntity(String.class);
			System.out.println("Server response : \n");
			System.out.println(output);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getOffer()
	{
		try
		{
			String id = "ID3434";
			
			ClientConfig cc = new DefaultClientConfig();
			Client client;
			cc.getClasses().add(Offer.class);
			client = Client.create(cc);
			
			WebResource webResource = client.resource("http://localhost:8080/RESTful/restfulservice/offer/get");
			ClientResponse response = webResource.queryParam("id", id).accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
			
			if (response.getStatus() != 200)
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			
			Offer output = response.getEntity(Offer.class);
			System.out.println("Server response : \n");
			System.out.println(output);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
