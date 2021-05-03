package com.example.menuSemanal.menu;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.menuSemanal.plato.Plato;
import com.example.menuSemanal.plato.PlatoRepository;

@Service
public class MenuServicioImp implements MenuServicio {

	@Autowired
	private MenuRepository repositorio;

	@Autowired
	private PlatoRepository repositorioplato;

	@Override
	public List<Menu> listar() {
		return repositorio.findAll();
	}

	@Override
	public Menu listarPorId(int id) {
		return repositorio.findById(id);
	}

	@Override
	public Menu agregar(Menu menu) {
		return repositorio.save(menu);
	}

	@Override
	public Menu editar(Menu menu) {
		return repositorio.save(menu);
	}

	@Override
	public Menu eliminar(int id) {
		// TODO Auto-generated method stub
		Menu menu = listarPorId(id);

		if (menu != null) {
			repositorio.delete(menu);
		}
		return menu;
	}

	@Override
	public String[] menuAleatorio(ConfiguracionMenu config) {

		String[] configuracion = config.getConfiguracion();
		String[] menuAleatorio = new String[14];

		List<Plato> veg = repositorioplato.findByTipo("veg");
		List<Plato> car = repositorioplato.findByTipo("car");
		List<Plato> del = repositorioplato.findByTipo("del");
		int i = 0;
		Random rdn = new Random();

		for (String cfg : configuracion) {

			if(cfg != null) {
			if (cfg.equals("veg")) {

				int indexRandom = rdn.nextInt(veg.size());
				Plato platoRandom = veg.get(indexRandom);
				menuAleatorio[i] = platoRandom.getNombre_plato();
				System.out.println(platoRandom.getNombre_plato());
			}
			if (cfg.equals("car")) {
				int indexRandom = rdn.nextInt(car.size());
				Plato platoRandom = car.get(indexRandom);
				menuAleatorio[i] = platoRandom.getNombre_plato();
				System.out.println(platoRandom.getNombre_plato());
			}
			if (cfg.equals("del")) {
				int indexRandom = rdn.nextInt(del.size());
				Plato platoRandom = del.get(indexRandom);
				menuAleatorio[i] = platoRandom.getNombre_plato();
				System.out.println(platoRandom.getNombre_plato());

			}
			}
			i++;
		}

		return menuAleatorio;
	}

}
