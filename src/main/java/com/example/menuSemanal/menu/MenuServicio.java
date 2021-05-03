package com.example.menuSemanal.menu;

import java.util.List;

public interface MenuServicio {
	
	List<Menu> listar();
	
	Menu listarPorId(int id);
	
	Menu agregar(Menu menu);
	
	Menu editar(Menu menu);
	
	Menu eliminar(int id);
	
	String[] menuAleatorio(ConfiguracionMenu config);
	
	
}
