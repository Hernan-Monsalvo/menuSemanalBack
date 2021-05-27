package com.example.menuSemanal.lista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.menuSemanal.menu.Menu;
import com.example.menuSemanal.menu.MenuServicio;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/lista"})
public class ControladorLista {


	@Autowired
	ListaServicio service;

	@GetMapping(params = {"id"})
	public Lista listarPorId(@RequestParam(value="id") int id, @RequestParam(value="diaIni") int diaIni,@RequestParam(value="diaFin") int diaFin){
		
		return service.listaDeCompra(id, diaIni, diaFin);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_PDF_VALUE)
	public byte[] pdfLista(@RequestBody Lista lista){
		
		return service.pdfLista(lista);
		
		
	}
	
}
