package com.cenfotec.restfulexa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cenfotec.restfulexa.domain.Cliente;
import com.cenfotec.restfulexa.domain.Orden;
import com.cenfotec.restfulexa.domain.Producto;
import com.cenfotec.restfulexa.services.ClienteServiceImpl;
import com.cenfotec.restfulexa.services.OrdenServiceImpl;
import com.cenfotec.restfulexa.services.ProductoServiceImpl;


@RestController
@RequestMapping({"/ordenes"})
public class OrdenController {

	
	@Autowired
	private OrdenServiceImpl ordenService;

	@Autowired
	private ProductoServiceImpl productoService;
	
	@Autowired 
	private ClienteServiceImpl clienteService;

	 @GetMapping
	 public List<Orden> findAll(){
		 return ordenService.getAllOrdenes();
	 }

	 @GetMapping(path = {"/{item}"})
	 public List<Orden> findByItem(@PathVariable String item){
		  return ordenService.getAllOrdenesByItem(item);		  
	 }
	 
	 
	 @PostMapping
	 public ResponseEntity<Orden> create(@RequestBody Orden orden){			 	 	 
		 	Optional<Producto> producto = productoService.get(orden.getIdProducto());
		 	
		 	Optional<Cliente> cliente = clienteService.get(orden.getIdCliente());
		 	
		 	if(producto.isPresent()) {
		 		if(cliente.isPresent()) {
		 			orden.setProducto(producto.get());
		 			orden.setCliente(cliente.get());
		 			
		 			 Orden creada = ordenService.createOrden(orden);
		 			return ResponseEntity.ok().body(creada);	
		 		}		 			 		
		 	}
		 		return ResponseEntity.notFound().build();
		 	
			
		 			 	
		 		 		
	 }

	 @PutMapping(value="/item/{id}")
	 public ResponseEntity<Orden> updateItem(@PathVariable("id") long id, @RequestBody Orden orden){
		 Optional<Producto> producto = productoService.get(orden.getIdProducto());
		
		 if(producto.isPresent()) {
			 Producto pro = producto.get();
			 orden.setProducto(pro);
			 return ordenService.getOrden(id).map(record ->{
				 record.setProducto(orden.getProducto());
				 Orden actualizada = ordenService.updateTipoItem(record);
				 return ResponseEntity.ok().body(actualizada);
			 }).orElse(ResponseEntity.notFound().build());							
		 }else {
			 return ResponseEntity.notFound().build();
			 
		 }
		 
	 }
	 
	 @PutMapping(value="/cantidad/{id}")
	 public ResponseEntity<Orden> updateCantidad(@PathVariable("id") long id, @RequestBody Orden orden){
		 return ordenService.getOrden(id)
				 .map(record -> {
					record.setCantidad(orden.getCantidad());					 					 
					 Orden actualizada = ordenService.updateCantidad(record);
					 return ResponseEntity.ok().body(actualizada);
				 }).orElse(ResponseEntity.notFound().build());
	 }
	 
	
	 
}
