package com.cenfotec.restfulexa.services;

import java.util.List;
import java.util.Optional;

import com.cenfotec.restfulexa.domain.Cliente;



public interface ClienteService {

	
	public Cliente save(Cliente cliente);
	public Optional<Cliente> get(Long id);
	public List<Cliente> getAll();
	public List<Cliente> findByApellido(String apellido);
	public List<Cliente> findByDireccionCobro(String direccion);
	public void deleteById(Long id);

}
