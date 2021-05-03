package com.example.menuSemanal.plato;

import javax.persistence.*;

@Entity
@Table(name = "platos")
public class Plato {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nombre_plato;
	
	@Column
	private String ingredientes;

	@Column
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_plato() {
		return nombre_plato;
	}

	public void setNombre_plato(String nombre_plato) {
		this.nombre_plato = nombre_plato;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
