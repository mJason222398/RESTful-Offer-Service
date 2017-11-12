package com.mbradley.restfulservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/offer")
public class Service {

	private OffersList offersList = new OffersList();

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_XML)
	public Response getOffer(@QueryParam("id") String id) {
		Offer offer = offersList.getOffer(id);

		return Response.status(Status.OK).entity(offer).build();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_XML)
	public Response createOffer(Offer offer) {

		if (!offersList.offerExists(offer.getOfferID())) {
			Validator validator = new Validator(offer);
			String error = validator.validateOffer();
			if (error == null) {
				offersList.addOffer(offer);

				String output = offer.toString();
				return Response.status(Status.OK).entity(output).build();
			} else {
				return Response.status(Status.OK).entity(error).build();
			}
		} else {
			return Response.status(Status.OK).entity("Offer already exists!").build();
		}
	}

	@POST
	@Path("/cancel/{param}")
	public Offer cancelOffer(@PathParam("param") String id) {

		if (offersList.offerExists(id))
			return offersList.cancelOffer(id);
		return null;
	}

}
