package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Album;

public interface ServicioAlbum {
	
	List<Album> listar();
	
	Album buscarPorId(Integer id);	

}
