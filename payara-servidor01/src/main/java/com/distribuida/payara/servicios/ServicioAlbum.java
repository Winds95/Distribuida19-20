package com.distribuida.payara.servicios;

import java.util.List;

import com.distribuida.payara.dto.Album;

public interface ServicioAlbum {
	
	List<Album> listar();
	
	Album buscarPorId(Integer id);	

}
