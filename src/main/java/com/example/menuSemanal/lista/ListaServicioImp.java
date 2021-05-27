package com.example.menuSemanal.lista;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.menuSemanal.menu.Menu;
import com.example.menuSemanal.menu.MenuRepository;
import com.example.menuSemanal.plato.Plato;
import com.example.menuSemanal.plato.PlatoRepository;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;


@Service
public class ListaServicioImp implements ListaServicio {

	@Autowired
	private MenuRepository menurepo;

	@Autowired
	private PlatoRepository platorepo;

	@Override
	public Lista listaDeCompra(int id, int diaIni, int diaFin) {
		Menu menu = menurepo.findById(id);
		
		String[] platostotal = menu.getPlatos();
		
		String[] platosmenu = Arrays.copyOfRange(platostotal, diaIni, diaFin);

		java.util.List<Plato> pl = platorepo.findAll();
		java.util.List<String> ingred = new ArrayList<String>();

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

	@Override
	public byte[] pdfLista(Lista lista) {
		
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(baos));

        Document doc = new Document(pdfDoc); 
		doc.getPdfDocument().setDefaultPageSize(PageSize.A4);
		
		java.util.List<String> supermercado = lista.getSupermercado();
		java.util.List<String> carniceria = lista.getCarniceria();
		java.util.List<String> verduleria = lista.getVerduleria();
		
		try {
			PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ITALIC);
			PdfFont fontB = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
		
		List listPDF = new List().setListSymbol("\u2022").setFont(font).setSymbolIndent(5); //u2022: simbolo bullet
		listPDF.setMarginBottom(5);
		
		Paragraph t= new Paragraph("Supermercado"); 
		doc.add(t);
		for (String string : supermercado) {
			listPDF.add(new ListItem(string));
		}
		doc.add(listPDF);
		
		t= new Paragraph("Carniceria"); 
		listPDF = new List().setListSymbol("\u2022").setFont(font).setSymbolIndent(5); //u2022: simbolo bullet
		listPDF.setMarginBottom(5);
		doc.add(t);
		for (String string : carniceria) {
			listPDF.add(new ListItem(string));
		}
		doc.add(listPDF);
		
		t= new Paragraph("Supermercado"); 
		listPDF = new List().setListSymbol("\u2022").setFont(font).setSymbolIndent(5); //u2022: simbolo bullet
		doc.add(t);
		for (String string : verduleria) {
			listPDF.add(new ListItem(string));
		}
		doc.add(listPDF);

        doc.close();
		
        byte[] bites = baos.toByteArray();

		return bites;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			doc.close();
			return null;
		}
		
	}

}
