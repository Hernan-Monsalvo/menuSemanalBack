package com.example.menuSemanal.plato;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface PlatoRepository extends Repository<Plato, Integer> {

	List<Plato> findAll();
	
	List<Plato> findByTipo(String tipo);
	
	Plato findById(int id);
	
	Plato findByNombre(String nombre);
	
	Plato save(Plato plato);
	
	void delete(Plato plato);
	
}
