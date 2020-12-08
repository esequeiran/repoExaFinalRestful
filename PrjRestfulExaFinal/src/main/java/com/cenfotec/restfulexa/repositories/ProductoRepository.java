package com.cenfotec.restfulexa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cenfotec.restfulexa.domain.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
