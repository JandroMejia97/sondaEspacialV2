package sondaEspacial.utils.test;

import sondaEspacial.SondaEspacial;
import sondaEspacial.magnitudes.MagnitudFisica;
import sondaEspacial.unidades.ingles.longitud.Pie;
import sondaEspacial.unidades.ingles.longitud.Pulgada;
import sondaEspacial.unidades.ingles.longitud.Yarda;
import sondaEspacial.unidades.internacional.longitud.Centimetro;
import sondaEspacial.unidades.internacional.longitud.Kilometro;
import sondaEspacial.unidades.internacional.longitud.Metro;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de prueba
 * @author aleja
 */
public class Test {

	public static void main(String[] args) {
		SondaEspacial<Pie> sonda = new SondaEspacial<>();
		List<MagnitudFisica> magnitudes = new ArrayList<>();

		System.out.println("******** SE CREO LA SONDA QUE TRABAJARÁ CON PIES ********");

		// Creando las unidades
		System.out.println("******** CREANDO LAS UNIDADES ********");
		Pie ft1 = new Pie(3);
		Pie ft2 = new Pie(5.5);
		Pie ft3 = new Pie(6.7);
		Yarda yd1 = new Yarda(36);
		Yarda yd2 = new Yarda(49.99);
		Yarda yd3 = new Yarda(10.55);
		Pulgada in1 = new Pulgada(12);
		Pulgada in2 = new Pulgada(23.2);
		Pulgada in3 = new Pulgada(12.6);
		Kilometro km = new Kilometro(1.5);
		Centimetro cm = new Centimetro(20.5);
		Metro m = new Metro(150);

		System.out.println(ft1);
		System.out.println(ft2);
		System.out.println(ft3);
		System.out.println(yd1);
		System.out.println(yd2);
		System.out.println(yd3);
		System.out.println(in1);
		System.out.println(in2);
		System.out.println(in3);
		System.out.println(km);
		System.out.println(cm);
		System.out.println(m);

		// Agregando a la lista
		System.out.println("******** AGREGANDO LAS UNIDADES A LA LISTA ********");
		magnitudes.add(ft1); magnitudes.add(ft2); magnitudes.add(ft3);
		magnitudes.add(yd1); magnitudes.add(yd2); magnitudes.add(yd3);
		magnitudes.add(in1); magnitudes.add(in2); magnitudes.add(in3);
		magnitudes.add(km); magnitudes.add(cm); magnitudes.add(m);

		System.out.println("******** INICIA LA CONVERSION ********");
		for (MagnitudFisica magnitudFisica : magnitudes) {
			System.out.print(magnitudFisica.toString() + " --> ");
			Pie conversion = (Pie) magnitudFisica.convertirInterAIngles();
			System.out.print(conversion + "\n");
			sonda.imprimir(conversion);
		}
	}

}
