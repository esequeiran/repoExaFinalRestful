package com.cenfotec.restfulexa.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cenfotec.restfulexa.domain.Producto;

import com.cenfotec.restfulexa.services.ProductoServiceImpl;

@RestController
@RequestMapping({"/productos"})
public class ProductoController {

	private ProductoServiceImpl productoService;
	
	ProductoController(ProductoServiceImpl productoService) {
		 this.productoService = productoService;
	 }

	 @GetMapping
	 public List<Producto> findAll(){
		 return productoService.getAll();
	 }

	 @GetMapping(path = {"/{id}"})
	 public ResponseEntity<Producto> findById(@PathVariable
	 long id){
		  return productoService.get(id)
		  .map(record ->
		 ResponseEntity.ok().body(record))
		  .orElse(ResponseEntity.notFound().build());
	 }
	 
	 @PostMapping
	 public Producto create(@RequestBody Producto producto){
		 return productoService.save(producto);
	 }
}
