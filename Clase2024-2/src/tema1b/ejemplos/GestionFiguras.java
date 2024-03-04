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
		// c.dibujar(v);
		for (int i=0; i<200; i++) {
			v.borra();
			for (Circulo circulo : listaCirculos) {
				circulo.dibujar(v);
				circulo.mover( 1, 0 );
			}
			v.espera( 40 );
		}
	}
}
