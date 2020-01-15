package com.distribuida.payara.rest;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.distribuida.payara.dto.Album;
import com.distribuida.payara.servicios.ServicioAlbum;

@Path("/albums")
@ApplicationScoped
public class ServicioAlbumRest {

	@Inject
	private ServicioAlbum servicio;
	
	@GET
	@Produces(value=MediaType.APPLICATION_JSON)
	public List<Album> listar( ) {
		List<Album> albums = servicio.listar();
		return albums;
	}
	
	@GET
	@Path("/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Album buscarporId(@PathParam("id") Integer id) {
		Album albums = servicio.buscarPorId(id);
		return albums;
	}
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.TEXT_PLAIN)
	public String saludar() {
		return "hola mundo con payara micro";
	}
		
	
}
