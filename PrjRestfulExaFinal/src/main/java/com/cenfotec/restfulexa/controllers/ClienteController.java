package com.cenfotec.restfulexa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.restfulexa.domain.Cliente;
import com.cenfotec.restfulexa.domain.Orden;
import com.cenfotec.restfulexa.services.ClienteServiceImpl;
import com.cenfotec.restfulexa.services.OrdenServiceImpl;


@RestController
@RequestMapping({"/clientes"})
public class ClienteController {

	private ClienteServiceImpl clienteService;
	
	@Autowired
	private OrdenServiceImpl ordenService;

	
	 ClienteController(ClienteServiceImpl clienteService) {
		 this.clienteService = clienteService;
	 }

	 @GetMapping
	 public List<Cliente> findAll(){
		 return clienteService.getAll();
	 }

	 @GetMapping(path = {"/{id}"})
	 public ResponseEntity<Cliente> findById(@PathVariable
	 long id){
		  return clienteService.get(id)
		  .map(record ->
		 ResponseEntity.ok().body(record))
		  .orElse(ResponseEntity.notFound().build());
	 }
	 
	 @GetMapping(path = {"/apellido/{apellido}"})
	 public List<Cliente> findByApellido(@PathVariable
	 String apellido){		 		 
		  return clienteService.findByApellido(apellido);
		 
	 }
	 
	 @GetMapping(path = {"/direccion/{direccion}"})
	 public List<Cliente> findByDireccion(@PathVariable
	 String direccion){		 		 
		  return clienteService.findByDireccionCobro(direccion);
		 
	 }
	 
	 @PostMapping
	 public Cliente create(@RequestBody Cliente cliente){
		 return clienteService.save(cliente);
	 }

	 @PutMapping(value="/{id}")
	 public ResponseEntity<Cliente>	update(@PathVariable("id") long id, @RequestBody Cliente cliente){
		 return clienteService.get(id)
				 .map(record -> {
					 record.setNombre(cliente.getNombre());
					 record.setApellidoUno(cliente.getApellidoUno());
					 record.setApellidoDos(cliente.getApellidoDos());
					 record.setDireccionResidencia(cliente.getDireccionResidencia());
					 record.setDireccionCobro(cliente.getDireccionCobro());
					 record.setNumeroTarjeta(cliente.getNumeroTarjeta());
					 record.setVencimiento(cliente.getVencimiento());					 
					 Cliente actualizada = clienteService.save(record);
					 return ResponseEntity.ok().body(actualizada);
				 }).orElse(ResponseEntity.notFound().build());
	 }
	 
	 @DeleteMapping(path ={"/{id}"})
	 public ResponseEntity<?> delete(@PathVariable("id") long id) {
		 List<Orden> ordenes = ordenService.getAllOrdenesCliente(id);
		 System.out.println(ordenes);
		 if(ordenes.size() == 0) {
			 return clienteService.get(id)
					 .map(record -> {
						 clienteService.deleteById(id);
						 return ResponseEntity.ok().build();
					 }).orElse(ResponseEntity.notFound().build());
		 }else {
			 return ResponseEntity.badRequest().build();
		 }
		 
	 }
	 

	
}
