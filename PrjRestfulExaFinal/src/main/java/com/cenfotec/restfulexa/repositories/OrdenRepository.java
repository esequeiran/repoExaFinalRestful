package com.cenfotec.restfulexa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.restfulexa.domain.Orden;


public interface OrdenRepository extends JpaRepository<Orden, Long>{

	public List<Orden> findByProductoTipoContainingIgnoreCase(String tipo);
	public List<Orden> findByClienteId(Long id);
}
