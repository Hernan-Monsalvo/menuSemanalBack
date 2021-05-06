package com.example.menuSemanal.lista;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.menuSemanal.menu.Menu;
import com.example.menuSemanal.menu.MenuRepository;
import com.example.menuSemanal.plato.Plato;
import com.example.menuSemanal.plato.PlatoRepository;

@Service
public class ListaServicioImp implements ListaServicio {

	@Autowired
	private MenuRepository menurepo;

	@Autowired
	private PlatoRepository platorepo;

	@Override
	public Lista listaDeCompra(int id) {
		Menu menu = menurepo.findById(id);
		String[] platosmenu = menu.getPlatos();

		List<Plato> pl = platorepo.findAll();
		List<String> ingred = new ArrayList<String>();

		Plato[] allplatos = new Plato[pl.size()];
		pl.toArray(allplatos);

		for (String platom : platosmenu) {
			if (platom != null) {
				for (Plato plato : allplatos) {

					if (platom.equals(plato.getNombre())) {

						if(plato.getIngredientes() != null && !plato.getIngredientes().isBlank())
						
						ingred.add(plato.getIngredientes());

					}
				}
			}

		}
		
		String[] ingredientes = new String[ingred.size()];
		ingred.toArray(ingredientes);

		return new Lista(ingredientes);
	}

}
