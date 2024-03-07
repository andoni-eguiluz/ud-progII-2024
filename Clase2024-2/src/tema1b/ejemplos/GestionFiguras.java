package tema1b.ejemplos;

import java.awt.Color;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class GestionFiguras {
	public static void main(String[] args) {
		VentanaGrafica v = new VentanaGrafica( 800, 600, "Prueba" );
		// v.dibujaCirculo( 100, 100, 50, 2, Color.GREEN );
		ArrayList<Circulo> listaCirculos = new ArrayList<>();
		Circulo c = new Circulo ( 200, 200, 75, 2, Color.BLUE );
		// v.dibujaCirculo( c.getxCentro(), c.getyCentro(), c.getRadio(), c.getGrosor(), c.getColor() );
		listaCirculos.add( c );
		listaCirculos.add( new Circulo( 500, 350, 120, 5, Color.GREEN ) );
		listaCirculos.add( new Circulo( 400, 200, 80, 5, Color.RED ) );
		
        ArrayList<Cuadrado> listaCuadrados = new ArrayList<>();
        listaCuadrados.add( new Cuadrado( 150, 120, 2, Color.CYAN, 25 ) );
        listaCuadrados.add( new Cuadrado( 450, 180, 1, Color.BLACK, 25 ) );
        listaCuadrados.add( new Cuadrado( 350, 240, 3, new Color(123, 255, 0), 45 ) );

        ArrayList<Imagen> listaImagenes = new ArrayList<>();
        listaImagenes.add( new Imagen( 300, 280, 30, 30 ) );
        listaImagenes.add( new Imagen( 120, 340, 30, 30 ) );

		// c.dibujar(v);
		for (int i=0; i<200; i++) {
			v.borra();
			for (Circulo circulo : listaCirculos) {
				circulo.dibujar(v);
				circulo.mover( 1, 0 );
			}
			for (Cuadrado cuadrado : listaCuadrados) {
				cuadrado.dibujar(v);
				cuadrado.mover( 1, 0 );
			}
			for (Imagen imagen : listaImagenes) {
				imagen.dibujar(v);
				imagen.mover( 1, 0 );
			}
			v.espera( 40 );
		}
	}
}
