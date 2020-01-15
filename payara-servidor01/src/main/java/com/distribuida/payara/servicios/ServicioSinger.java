package com.distribuida.payara.servicios;

import java.util.List;

import com.distribuida.payara.dto.Singer;

public interface ServicioSinger {
	
	List<Singer> listar();
	
	Singer buscarPorId(Integer id);	

}
