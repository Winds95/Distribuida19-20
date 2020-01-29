package com.distribuida.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.Service;
import com.ecwid.consul.v1.health.HealthServicesRequest;
import com.ecwid.consul.v1.health.model.HealthService;

public class ClienteMain {
	
	public static final String NAME_ALBUM = "consul-album";
	public static final String NAME_SINGER = "consul-singer";

	public static void main(String[] args) {
		
		ConsulClient cliente = new ConsulClient("127.0.0.1");
		Response<Map<String, Service>> ss= cliente.getAgentServices();
		Map<String, Service> servicios = ss.getValue();
		
		List<Service> lista = servicios.values()
				.stream()
				.filter(s -> NAME_ALBUM.equals(s.getService()))
				.collect(Collectors.toList());
		
		if( lista.isEmpty() ) {
			System.err.println( "No existe ningún servicio registrado con el nombre: "
			+ NAME_ALBUM );
			return ;
		}
		
		for (Service s:lista) {
			String url = String.format( "http:// %s:%d/albums/saludo", s.getAddress(),
					s.getPort() );
			System.out.println( s.getId() + "-->" +url);
		}
		
		//listar los servicios validos
		// query for healthy services based on name (returns myapp_01 and myapp_02 if healthy)
		System.out.println("*****************servicios validos*****************8");
		HealthServicesRequest request = HealthServicesRequest.newBuilder()
							.setPassing(true)
							.setQueryParams(QueryParams.DEFAULT)
							.build();
		Response<List<HealthService>> healthyServices = cliente.getHealthServices(NAME_ALBUM, request);
		
		List<HealthService> datos = healthyServices.getValue();
		
		datos.stream().map(s -> s.getService())
		.map( s-> String.format("%s ----> http:// %s:%d/albums/saludo", s.getId(), s.getAddress(), s.getPort()))
		.forEach(System.out::println)
		;
		
//		healthyServices.getValue().forEach(h -> {
//			
//			HealthService.Service s = h.getService();
//			
//			String url = String.format("http:// %s:%d/servicio/hola", s.getAddress(), s.getPort());
//			
//			System.out.println( s.getId() + "-->" +url);
//			
//		});
		
	}

}
