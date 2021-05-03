package com.example.menuSemanal.menu;

import javax.persistence.Column;

public class ConfiguracionMenu {
	

	private String sabado_almuerzo;

	private String sabado_cena;

	private String domingo_almuerzo;

	private String domingo_cena;
	
	private String lunes_almuerzo;
	
	private String lunes_cena;
	
	private String martes_almuerzo;
	
	private String martes_cena;
	
	private String miercoles_almuerzo;
	
	private String miercoles_cena;
	
	private String jueves_almuerzo;
	
	private String jueves_cena;
	
	private String viernes_almuerzo;
	
	private String viernes_cena;
	
	public ConfiguracionMenu() {}

	public String[] getConfiguracion() {
		
		String[] configuracion = new String[14];
		
		configuracion[0] = sabado_almuerzo;
		configuracion[1] = sabado_cena;
		configuracion[2] = domingo_almuerzo;
		configuracion[3] = domingo_cena;
		configuracion[4] = lunes_almuerzo;
		configuracion[5] = lunes_cena;
		configuracion[6] = martes_almuerzo;
		configuracion[7] = martes_cena;
		configuracion[8] = miercoles_almuerzo;
		configuracion[9] = miercoles_cena;
		configuracion[10] = jueves_almuerzo;
		configuracion[11] = jueves_cena;
		configuracion[12] = viernes_almuerzo;
		configuracion[13] = viernes_cena;	
		
		
		return configuracion;
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
