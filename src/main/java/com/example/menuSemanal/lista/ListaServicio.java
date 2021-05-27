package com.example.menuSemanal.lista;

public interface ListaServicio {
	
	Lista listaDeCompra(int id, int diaIni, int diaFin);

	byte[] pdfLista(Lista lista);

}
