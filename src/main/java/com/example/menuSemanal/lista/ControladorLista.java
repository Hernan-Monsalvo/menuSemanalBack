package com.example.menuSemanal.lista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.menuSemanal.menu.Menu;
import com.example.menuSemanal.menu.MenuServicio;

@RestController
@RequestMapping({"/lista"})
public class ControladorLista {


	@Autowired
	ListaServicio service;

	@GetMapping(params = {"id"})
	//@RequestMapping(method = RequestMethod.GET, params = {"id"}) //para diferenciar los dos metodos get, se agrega que parametro escucha
	public Lista listarPorId(@RequestParam(value="id") int id){
		return service.listaDeCompra(id);
	}
	
}
