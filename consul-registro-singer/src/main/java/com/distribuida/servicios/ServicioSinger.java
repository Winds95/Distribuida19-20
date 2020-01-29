package com.distribuida.servicios;

import java.util.List;

import com.distribuida.dto.Singer;

public interface ServicioSinger {
	
	List<Singer> listar();
	
	Singer buscarPorId(Integer id);	

}
