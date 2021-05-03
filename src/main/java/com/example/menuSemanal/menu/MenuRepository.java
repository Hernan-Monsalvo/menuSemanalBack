package com.example.menuSemanal.menu;

import java.util.List;

import org.springframework.data.repository.Repository;

public interface MenuRepository extends Repository<Menu, Integer> {

	List<Menu> findAll();
	
	Menu findById(int id);
	
	Menu save(Menu menu);
	
	void delete(Menu menu);
	
}
