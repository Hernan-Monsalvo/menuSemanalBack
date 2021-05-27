package com.example.menuSemanal.menu;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.menuSemanal.plato.Plato;
import com.example.menuSemanal.plato.PlatoRepository;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.BorderCollapsePropertyValue;
import com.itextpdf.layout.property.BorderRadius;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

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

		List<Plato> veg = repositorioplato.findByTipo("veg");
		List<Plato> car = repositorioplato.findByTipo("car");
		List<Plato> del = repositorioplato.findByTipo("del");
		
		String[] configuracion = config.getConfiguracion();
		String[] menuAleatorio = new String[14];
		
		for (int i = 0; i < 14; i++) {
			menuAleatorio[i] = "no";
		}


		
		for (int i = 0; i < 14; i++) {
			
			if(configuracion[i].equals("veg")) {

			menuAleatorio[i] = platoAleatorio(configuracion[i], veg);
			}
			if(configuracion[i].equals("car")) {

			menuAleatorio[i] = platoAleatorio(configuracion[i], car);
			}
			if(configuracion[i].equals("del")) {

			menuAleatorio[i] = platoAleatorio(configuracion[i], del);
			}
			
			if(hayRepetido(menuAleatorio, i)) {
				i--;
			}
		}

		return menuAleatorio;
	}

	public Boolean hayRepetido(String[] menu, int j) {
		
		for (int i = 0; i <= j; i++) {
			
			for (int n = 0; n < j; n++) {
				if(!menu[j].equals("no") && menu[j].equals(menu[n])) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String platoAleatorio(String cfg, List<Plato> lista) {
		String plato = "no";

		Random rdn = new Random();

		if (cfg != null) {
				int indexRandom = rdn.nextInt(lista.size());
				Plato platoRandom = lista.get(indexRandom);
				plato = platoRandom.getNombre();
				System.out.println(platoRandom.getNombre());
		}
		return plato;
	}

	@Override
	public byte[] pdfPorId(int id) {
		Menu menu = listarPorId(id);
		String[] platos = menu.getPlatos();
		String text = "This is the text of my pdf";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PdfDocument pdfDoc = new PdfDocument(new PdfWriter(baos));

		Document doc = new Document(pdfDoc);
		doc.getPdfDocument().setDefaultPageSize(PageSize.A4.rotate());

		Table titulo = new Table(4);

		this.procesarTabla(titulo, menu.getNombre(), true);
		this.procesarTabla(titulo, menu.getMes(), true);
		this.procesarTabla(titulo, menu.getSemana(), true);

		titulo.setWidth(500);
		titulo.setMarginTop(20);
		doc.add(titulo);

		// tabla
		Table table = new Table(8);
		table.setMarginTop(20);
		table.setWidth(750);

		table.setBorderCollapse(BorderCollapsePropertyValue.SEPARATE); // falta libreria

		// Sets horizontal spacing between all the table's cells. See css's
		// border-spacing for more information.
		table.setHorizontalBorderSpacing(5); // falta libreria

		this.procesarTabla(table, "", true);
		this.procesarTabla(table, "SABADO", true);
		this.procesarTabla(table, "DOMINGO", true);
		this.procesarTabla(table, "LUNES", true);
		this.procesarTabla(table, "MARTES", true);
		this.procesarTabla(table, "MIERCOLES", true);
		this.procesarTabla(table, "JUEVES", true);
		this.procesarTabla(table, "VIERNES", true);

		this.procesarTabla(table, "ALMUERZO", false);
		this.procesarTabla(table, platos[0], false);
		this.procesarTabla(table, platos[2], false);
		this.procesarTabla(table, platos[4], false);
		this.procesarTabla(table, platos[6], false);
		this.procesarTabla(table, platos[8], false);
		this.procesarTabla(table, platos[10], false);
		this.procesarTabla(table, platos[12], false);

		this.procesarTabla(table, "CENA", false);
		this.procesarTabla(table, platos[1], false);
		this.procesarTabla(table, platos[3], false);
		this.procesarTabla(table, platos[5], false);
		this.procesarTabla(table, platos[7], false);
		this.procesarTabla(table, platos[9], false);
		this.procesarTabla(table, platos[11], false);
		this.procesarTabla(table, platos[13], false);

		doc.add(table);

		doc.close();

		byte[] bites = baos.toByteArray();

		return bites;

	}

	public void procesarTabla(Table table, String linea, boolean isHeader) {

		try {
			PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
			PdfFont fontB = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

			if (isHeader) {
				Cell cell = new Cell().add(new Paragraph(linea).setFont(fontB));
				cell.setFontSize(18);
				cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
				cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
				cell.setBorderTopRightRadius(new BorderRadius(5));
				cell.setBorderTopLeftRadius(new BorderRadius(5));

				table.addCell(cell);
			} else {
				Cell cell = new Cell().setFontSize(18);
				cell.setVerticalAlignment(VerticalAlignment.MIDDLE);
				cell.setHorizontalAlignment(HorizontalAlignment.CENTER);
				table.addCell(cell.add(new Paragraph(linea).setFont(font)));
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
