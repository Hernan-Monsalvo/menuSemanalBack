package com.example.menuSemanal.lista;


import java.util.ArrayList;
import java.util.List;

public class Lista {

	private List<String> supermercado;
	private List<String> carniceria;
	private List<String> verduleria;

	public Lista() {  }
	
	public Lista(String[] ingredientes) {

		supermercado = new ArrayList<String>();
		carniceria = new ArrayList<String>();
		verduleria = new ArrayList<String>();

		crearLista(ingredientes);

		verduleria = sumaCantidades(verduleria);
		carniceria = sumaCantidades(carniceria);
		supermercado = sumaCantidades(supermercado);
		
		

	}

	private void crearLista(String[] ingredientes) {
		for (String ing : ingredientes) {

			String[] eaching = ing.split("-");

			for (String tmp : eaching) {

				char t = tmp.charAt(0);

				tmp = tmp.substring(1);

				// System.out.println("T: "+t);

				if (t == "C".charAt(0)) {
					supermercado.add(tmp);
					// System.out.println("tmp: " + tmp);
				}
				if (t == "V".charAt(0)) {
					verduleria.add(tmp);
					// System.out.println("tmp: " + tmp);
				}
				if (t == "X".charAt(0)) {
					carniceria.add(tmp);
					// System.out.println("tmp: " + tmp);
				}
			}

		}
	}

	private List<String> sumaCantidades(List<String> lista) {

		List<String> listatmpcant = new ArrayList<String>();
		String[][] arraytmp = new String[lista.size()][3];
		int i = 0;
		for (String ing : lista) { // para cada item de la lista por ej: Papa(0.5_kg)

			String arr[] = ing.split("\\("); // separo por el ( ---> me queda: Papa / 0.5_kg) doble barra antes del (
												// para evitar que lo tome literal
			String ingr = arr[0];
			String arr2[] = arr[1].split("_"); // separo por el _ ---> me queda: 0.5 / kg)
			String cant = arr2[0];
			String unidad = arr2[1].substring(0, arr2[1].length() - 1); // quito el ) ---> me queda: kg

			// lleno el array [0] = Papa / [1] = 0.5 / [2] = kg
			arraytmp[i][0] = ingr;
			arraytmp[i][1] = cant;
			arraytmp[i][2] = unidad;

			//System.out.println(i + arraytmp[i][0] + arraytmp[i][1] + arraytmp[i][2]);
			i++;
		}

		// comparo por ingredientes repetido
		int j = 0;
		for (String[] ing : arraytmp) {

			for (String[] ing2 : arraytmp) {

				if (ing[0] != ing2[0]) {
					if (ing[0].equals(ing2[0])) {
						//System.out.println("Son iguales" + ing[0]);
						double cant1 = Double.parseDouble(ing[1]);
						double cant2 = Double.parseDouble(ing2[1]);
						double total = cant1 + cant2;
						// ing2 = null;
						ing[1] = Double.toString(total);
						ing2[0] = "";
						ing2[1] = "";
						ing2[2] = "";

						//System.out.println("el total de " + ing[0] + " es " + total + ing[2]);

					}
				}
			}

		}
		for (String[] ing : arraytmp) {
			if (ing[0] != "") {
				listatmpcant.add(ing[0]+"("+ing[1]+"_"+ing[2]+")");
			}
			
		}
		/*
		System.out.println("Lista: ");
		for (String strings : lista) {
			System.out.println(strings);
		}*/
		
		return listatmpcant;

	}

	public List<String> getSupermercado() {
		return supermercado;
	}

	public void setSupermercado(List<String> supermercado) {
		this.supermercado = supermercado;
	}

	public List<String> getCarniceria() {
		return carniceria;
	}

	public void setCarniceria(List<String> carniceria) {
		this.carniceria = carniceria;
	}

	public List<String> getVerduleria() {
		return verduleria;
	}

	public void setVerduleria(List<String> verduleria) {
		this.verduleria = verduleria;
	}

	@Override
	public String toString() {
		return "Lista [supermercado=" + supermercado + ", carniceria=" + carniceria + ", verduleria=" + verduleria
				+ "]";
	}

}
