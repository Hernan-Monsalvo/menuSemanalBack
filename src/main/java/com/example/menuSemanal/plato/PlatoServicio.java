package com.example.menuSemanal.plato;

import java.util.List;

public interface PlatoServicio {
	
	List<Plato> listar();
	
	List<Plato> listarPorTipo(String tipo);
	
	Plato listarPorId(int id);
	
	Plato listarPorNombre(String nombre_plato);
	
	Plato agregar(Plato plato);
	
	Plato editar(Plato plato);
	
	Plato eliminar(int id);
	

	
	
}
