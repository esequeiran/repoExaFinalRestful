package com.cenfotec.restfulexa.services;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.restfulexa.domain.Cliente;
import com.cenfotec.restfulexa.repositories.ClienteRepository;



@Service
public class ClienteServiceImpl implements ClienteService{
	
	
	@Autowired
	ClienteRepository clienteRepo;
	

		@Override
		public Cliente save(Cliente cliente) {
			return this.clienteRepo.save(cliente);
			
		}

		@Override
		public Optional<Cliente> get(Long id) {
			return 	this.clienteRepo.findById(id);
		}

		@Override
		public List<Cliente> getAll() {
			return this.clienteRepo.findAll();
		}

		@Override
		public List<Cliente> findByApellido(String apellido) {
			return this.clienteRepo.findByApellidoUnoContainingIgnoreCase(apellido);
		}

		@Override
		public List<Cliente> findByDireccionCobro(String direccion) {
			return this.clienteRepo.findByDireccionCobroContainingIgnoreCase(direccion);
		}

		@Override
		public void deleteById(Long id) {
			clienteRepo.deleteById(id);
			
		}
		
}
