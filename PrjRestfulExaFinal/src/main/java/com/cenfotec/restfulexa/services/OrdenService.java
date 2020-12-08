package com.cenfotec.restfulexa.services;

import java.util.List;
import java.util.Optional;


import com.cenfotec.restfulexa.domain.Orden;


public interface OrdenService {

		public List<Orden> getAllOrdenes();	
		public Optional<Orden> getOrden(Long id);		
		public Orden createOrden(Orden orden);		
		public List<Orden> getAllOrdenesByItem(String producto);
		public Orden updateCantidad(Orden orden);		
		public Orden updateTipoItem(Orden orden);		
		public List<Orden> getAllOrdenesCliente(Long id);
}
