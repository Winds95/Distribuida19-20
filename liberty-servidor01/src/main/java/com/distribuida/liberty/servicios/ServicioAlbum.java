package com.distribuida.liberty.servicios;

import java.util.List;

import com.distribuida.liberty.dto.Album;

public interface ServicioAlbum {
	
	List<Album> listar();
	
	Album buscarPorId(Integer id);	

}
