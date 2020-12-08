package com.cenfotec.restfulexa.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cenfotec.restfulexa.domain.Orden;
import com.cenfotec.restfulexa.repositories.OrdenRepository;


@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	OrdenRepository ordenRepo;	
	
	@Override
	public List<Orden> getAllOrdenes() {		
		return ordenRepo.findAll();
	}

	@Override
	public Optional<Orden> getOrden(Long id) {
		
		return ordenRepo.findById(id);
	}

	@Override
	public Orden createOrden(Orden orden) {
		return ordenRepo.save(orden);
	}

	@Override
	public List<Orden> getAllOrdenesByItem(String producto) {
		
		return ordenRepo.findByProductoTipoContainingIgnoreCase(producto);
	}

	@Override
	public Orden updateCantidad(Orden orden) {
		return ordenRepo.save(orden);
	}

	@Override
	public Orden updateTipoItem(Orden orden) {		
		return ordenRepo.save(orden);
	}

	@Override
	public List<Orden> getAllOrdenesCliente(Long id) {
		return ordenRepo.findByClienteId(id);
	}
	

	
}
