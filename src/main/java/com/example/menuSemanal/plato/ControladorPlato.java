package com.example.menuSemanal.plato;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/plato"})
public class ControladorPlato {

	@Autowired
	PlatoServicio service;
	
	
	@GetMapping
	public List<Plato> listar(){
		return service.listar();
	}
	
	@GetMapping(params = {"tipo"})
	public List<Plato> listarPorTipo(@RequestParam(value="tipo") String tipo){
		return service.listarPorTipo(tipo);
	}
	
	@GetMapping(params = {"id"})
	//@RequestMapping(method = RequestMethod.GET, params = {"id"}) //para diferenciar los dos metodos get, se agrega que parametro escucha
	public Plato listarPorId(@RequestParam(value="id") int id){
		return service.listarPorId(id);
	}
	
	@PostMapping
	public Plato agregarPlato(@RequestBody Plato plato) {

		return service.agregar(plato);
	}
	
	@PutMapping
	public Plato editarPlato(@RequestBody Plato plato) {
		
		return service.editar(plato);
	}
	
	@DeleteMapping(params = {"id"})
	public Plato eliminarPlato(@RequestParam(value="id") int id){
		return service.eliminar(id);
	}
	
}
