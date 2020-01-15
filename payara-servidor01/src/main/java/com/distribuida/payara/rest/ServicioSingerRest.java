package com.distribuida.payara.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.payara.dto.Singer;
import com.distribuida.payara.servicios.ServicioSinger;

@Path("/singers")
@ApplicationScoped
public class ServicioSingerRest {

	@Inject
	private ServicioSinger servicio;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public List<Singer> listar( ) {
		List<Singer> singers = servicio.listar();
		return singers;
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Singer buscarporId(@PathParam("id") Integer id) {
		Singer singers = servicio.buscarPorId(id);
		return singers;
	}
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.TEXT_PLAIN)
	public String saludar() {
		return "hola mundo con payara micro";
	}
		
	
}
