package com.distribuida.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@ApplicationScoped
public class PingRest {
	
	@GET
	@Path(value = "/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public String ping() {
		
		System.out.println("ping");
		
		return "ok";
	}
	
}