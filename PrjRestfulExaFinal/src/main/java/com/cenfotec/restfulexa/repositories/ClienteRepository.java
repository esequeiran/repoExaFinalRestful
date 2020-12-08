package com.cenfotec.restfulexa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.restfulexa.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	public List<Cliente> findByApellidoUnoContainingIgnoreCase(String apellido);
	public List<Cliente> findByDireccionCobroContainingIgnoreCase(String direccion);

	
}
