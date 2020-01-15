package com.distribuida.liberty.servicios;

import java.util.List;

import com.distribuida.liberty.dto.Singer;

public interface ServicioSinger {
	
	List<Singer> listar();
	
	Singer buscarPorId(Integer id);	

}
