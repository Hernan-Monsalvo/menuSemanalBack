package com.example.menuSemanal.menu;

import javax.persistence.*;

@Entity
@Table(name = "menu_semanal")
public class Menu {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String mes;
	
	@Column
	private String semana;
	
	@Column
	private String sabado_almuerzo;
	
	@Column
	private String sabado_cena;
	
	@Column
	private String domingo_almuerzo;
	
	@Column
	private String domingo_cena;
	
	@Column
	private String lunes_almuerzo;
	
	@Column
	private String lunes_cena;
	
	@Column
	private String martes_almuerzo;
	
	@Column
	private String martes_cena;
	
	@Column
	private String miercoles_almuerzo;
	
	@Column
	private String miercoles_cena;
	
	@Column
	private String jueves_almuerzo;
	
	@Column
	private String jueves_cena;
	
	@Column
	private String viernes_almuerzo;
	
	@Column
	private String viernes_cena;
	
	
	public String[] getPlatos() {
		
		String[] platos = new String[14];
		
		platos[0] = sabado_almuerzo;
		platos[1] = sabado_cena;
		platos[2] = domingo_almuerzo;
		platos[3] = domingo_cena;
		platos[4] = lunes_almuerzo;
		platos[5] = lunes_cena;
		platos[6] = martes_almuerzo;
		platos[7] = martes_cena;
		platos[8] = miercoles_almuerzo;
		platos[9] = miercoles_cena;
		platos[10] = jueves_almuerzo;
		platos[11] = jueves_cena;
		platos[12] = viernes_almuerzo;
		platos[13] = viernes_cena;		
		
		return platos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getSabado_almuerzo() {
		return sabado_almuerzo;
	}

	public void setSabado_almuerzo(String sabado_almuerzo) {
		this.sabado_almuerzo = sabado_almuerzo;
	}

	public String getSabado_cena() {
		return sabado_cena;
	}

	public void setSabado_cena(String sabado_cena) {
		this.sabado_cena = sabado_cena;
	}

	public String getDomingo_almuerzo() {
		return domingo_almuerzo;
	}

	public void setDomingo_almuerzo(String domingo_almuerzo) {
		this.domingo_almuerzo = domingo_almuerzo;
	}

	public String getDomingo_cena() {
		return domingo_cena;
	}

	public void setDomingo_cena(String domingo_cena) {
		this.domingo_cena = domingo_cena;
	}

	public String getLunes_almuerzo() {
		return lunes_almuerzo;
	}

	public void setLunes_almuerzo(String lunes_almuerzo) {
		this.lunes_almuerzo = lunes_almuerzo;
	}

	public String getLunes_cena() {
		return lunes_cena;
	}

	public void setLunes_cena(String lunes_cena) {
		this.lunes_cena = lunes_cena;
	}

	public String getMartes_almuerzo() {
		return martes_almuerzo;
	}

	public void setMartes_almuerzo(String martes_almuerzo) {
		this.martes_almuerzo = martes_almuerzo;
	}

	public String getMartes_cena() {
		return martes_cena;
	}

	public void setMartes_cena(String martes_cena) {
		this.martes_cena = martes_cena;
	}

	public String getMiercoles_almuerzo() {
		return miercoles_almuerzo;
	}

	public void setMiercoles_almuerzo(String miercoles_almuerzo) {
		this.miercoles_almuerzo = miercoles_almuerzo;
	}

	public String getMiercoles_cena() {
		return miercoles_cena;
	}

	public void setMiercoles_cena(String miercoles_cena) {
		this.miercoles_cena = miercoles_cena;
	}

	public String getJueves_almuerzo() {
		return jueves_almuerzo;
	}

	public void setJueves_almuerzo(String jueves_almuerzo) {
		this.jueves_almuerzo = jueves_almuerzo;
	}

	public String getJueves_cena() {
		return jueves_cena;
	}

	public void setJueves_cena(String jueves_cena) {
		this.jueves_cena = jueves_cena;
	}

	public String getViernes_almuerzo() {
		return viernes_almuerzo;
	}

	public void setViernes_almuerzo(String viernes_almuerzo) {
		this.viernes_almuerzo = viernes_almuerzo;
	}

	public String getViernes_cena() {
		return viernes_cena;
	}

	public void setViernes_cena(String viernes_cena) {
		this.viernes_cena = viernes_cena;
	}

	
	
}
