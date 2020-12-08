package com.cenfotec.restfulexa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cenfotec.restfulexa.domain.Producto;
import com.cenfotec.restfulexa.repositories.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoRepository productoRepo;
	

		@Override
		public Producto save(Producto producto) {
			return this.productoRepo.save(producto);
		}

		@Override
		public Optional<Producto> get(Long id) {
			return 	this.productoRepo.findById(id);
		}

		@Override
		public List<Producto> getAll() {
			return this.productoRepo.findAll();
		}

		@Override
		public void deleteProducto(Long id) {
		
		}
			
	
}
