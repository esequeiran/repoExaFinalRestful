package com.cenfotec.restfulexa.services;

import java.util.List;
import java.util.Optional;

import com.cenfotec.restfulexa.domain.Producto;


public interface ProductoService {

	
	public Producto save(Producto producto);
	public Optional<Producto> get(Long id);
	public List<Producto> getAll();
	public void deleteProducto(Long id);
}
