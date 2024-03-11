package tema1c.ejemplos;

import java.awt.Color;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Clicker {
	public static void main(String[] args) {
		VentanaGrafica v = new VentanaGrafica( 800, 600, "Prueba" );
		v.getJFrame().setLocation( 2000, 50 );  // Solo si se quiere cambiar la posición de la ventana
		ArrayList<Circulo> listaCirculos = new ArrayList<>();
		Circulo c = new Circulo ( 200, 200, 75, 2, Color.BLUE );
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

        // Lista polimórfica
        ArrayList<Figura> listaFiguras = new ArrayList<>();
        listaFiguras.addAll( listaCirculos );
        listaFiguras.addAll( listaCuadrados );
        listaFiguras.addAll( listaImagenes );

		// Salida a consola
		for (Figura fig : listaFiguras) {
			System.out.println( fig );
		}
		
		while (!v.estaCerrada()) {
			v.borra();
			for (Figura fig : listaFiguras) {
				fig.dibujar( v );
				fig.mover( 1, 0 );
//				if (fig instanceof Imagen) {
//					Imagen imagen = (Imagen) fig;
//					imagen.rotar( 0.1 );
//				}
//				if (fig instanceof Cuadrado) {
//					Cuadrado cuadrado = (Cuadrado) fig;
//					cuadrado.rotar( 0.1 );
//				}
				if (fig instanceof Rotable) {
					Rotable rotable = (Rotable) fig;
					rotable.rotar(0.1);
				}
			}
			v.espera( 40 );
		}
	}
}
