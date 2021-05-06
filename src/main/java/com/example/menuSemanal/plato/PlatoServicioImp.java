package com.example.menuSemanal.plato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoServicioImp implements PlatoServicio {

	@Autowired
	private PlatoRepository repositorio;
	
	@Override
	public List<Plato> listar() {
		return repositorio.findAll();
	}
	

	@Override
	public List<Plato> listarPorTipo(String tipo) {
		return repositorio.findByTipo(tipo);
	}

	@Override
	public Plato listarPorId(int id) {
		return repositorio.findById(id);
	}
	
	@Override
	public Plato listarPorNombre(String nombre) {
		
		return repositorio.findByNombre(nombre);
	}

	@Override
	public Plato agregar(Plato plato) {
		return repositorio.save(plato);
	}

	@Override
	public Plato editar(Plato plato) {
		return repositorio.save(plato);
	}

	@Override
	public Plato eliminar(int id) {
		// TODO Auto-generated method stub
		Plato plato = listarPorId(id);
		
		if(plato != null) {
		repositorio.delete(plato);
		}
		return plato;
	}




}
