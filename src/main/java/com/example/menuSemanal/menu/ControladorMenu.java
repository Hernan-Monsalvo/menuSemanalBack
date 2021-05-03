package com.example.menuSemanal.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/menu"})
public class ControladorMenu {

	@Autowired
	MenuServicio service;
	
	
	@GetMapping
	public List<Menu> listar(){
		return service.listar();
	}
	
	
	@GetMapping(params = {"id"})
	//@RequestMapping(method = RequestMethod.GET, params = {"id"}) //para diferenciar los dos metodos get, se agrega que parametro escucha
	public Menu listarPorId(@RequestParam(value="id") int id){
		return service.listarPorId(id);
	}
	
	@PostMapping(params = {"aleatorio"})
	public String[] menuAleatorio(@RequestBody ConfiguracionMenu config) {
		return service.menuAleatorio(config);
	}
	
	@PostMapping
	public Menu agregarMenu(@RequestBody Menu menu) {

		return service.agregar(menu);
	}
	
	@PutMapping
	public Menu editarMenu(@RequestBody Menu menu) {
		
		return service.editar(menu);
	}
	
	@DeleteMapping(params = {"id"})
	public Menu eliminarMenu(@RequestParam(value="id") int id){
		return service.eliminar(id);
	}
	
}
