package tema1c.ejemplos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Clicker {
	
	private static int puntos = 0;
	private static final int RESTA_POR_FALLO = -20;
	private static final Font TIPO_LETRA_PUNT = new Font( "Arial", Font.BOLD, 20 );
	
	public static void main(String[] args) {
		VentanaGrafica v = new VentanaGrafica( 800, 600, "Prueba" );
		// v.getJFrame().setLocation( -1800, 50 );  // Solo si se quiere cambiar la posición de la ventana

        // Lista polimórfica
        ArrayList<Figura> listaFiguras = new ArrayList<>();
        listaFiguras.add( new Circulo( 80,90,35,2,Color.GREEN, v ) );
        listaFiguras.add( new Circulo( 420, 350, 90, 5, Color.RED, v ) );

        listaFiguras.add( new Cuadrado( 150, 120, 2, Color.CYAN, 25 ) );
        listaFiguras.add( new Cuadrado( 450, 180, 1, Color.BLACK, 25 ) );
        listaFiguras.add( new Cuadrado( 350, 240, 3, new Color(123, 255, 0), 45 ) );

        Imagen i1 = new Imagen( 300, 280, 30, 30 );
        i1.setVelocidad( 40, 5 );
        i1.setVentana( v );
        listaFiguras.add( i1 );
        Imagen i2 = new Imagen( 120, 340, 30, 30 );
        i2.setVelocidad( -40, 30 );
        i2.setVentana( v );
        listaFiguras.add( i2 );

        listaFiguras.add( new Flecha( 200, 100, 2, Color.BLUE, 50, 0 ) );

        boolean finJuego = false;
		while (!v.estaCerrada() && !finJuego) {
			v.borra();
			// Lógica clicker
			Point click = v.getRatonClicado();
			if (click != null) {
				boolean hayClick = false;
				for (Figura fig : listaFiguras) {
					if (fig instanceof Clickable) {
						Clickable clickable = (Clickable) fig;
						if (clickable.estaEnObjeto(click)) {
							clickable.puntuaClick();
							hayClick = true;
							break;
						}
					}
				}
				if (!hayClick) {
					sumaPuntos( RESTA_POR_FALLO );
				}
			}
			// Movimiento y cambio
			for (Figura fig : listaFiguras) {
				// Animación de color antes de dibujar 
				if (fig instanceof Colorizable) {
					((Colorizable)fig).animaColor();
				}
				// Movimiento autónomo de las figuras que correspondan
				if (fig instanceof Automovible) {
					Automovible auto = (Automovible) fig;
					auto.mover( 40 );
				}
				// fig.mover( 1, 0 );
				// En vez de hacerlo con cada figura, dependiendo de cada caso
//				if (fig instanceof Imagen) {
//					Imagen imagen = (Imagen) fig;
//					imagen.rotar( 0.1 );
//				}
//				if (fig instanceof Cuadrado) {
//					Cuadrado cuadrado = (Cuadrado) fig;
//					cuadrado.rotar( 0.1 );
//				}
				// Mejor hacerlo con interfaces, dependiendo del comportamiento
				if (fig instanceof Rotable) {
					Rotable rotable = (Rotable) fig;
					rotable.rotar(0.1);
				}
				// Rotación y final de juego por flecha
				Point raton = v.getRatonMovido();
				if (fig instanceof Flecha && raton!=null) {
					Flecha flecha = (Flecha) fig;
					flecha.rotaHaciaCursor(raton);
					if (flecha.tocaACursor(raton)) {
						v.dibujaTexto( 150, 380, "Juego terminado!", TIPO_LETRA_PUNT, Color.DARK_GRAY );
						finJuego = true;
					}
				}
				// Dibujar
				fig.dibujar( v );
			}
			v.dibujaTexto( 5, 20, "Puntos: " + puntos, TIPO_LETRA_PUNT, Color.BLACK );
			v.espera( 40 );
		}
	}
	
	/** Incrementa la puntuación del juego
	 * @param puntosASumar	Puntos a sumar o a restar
	 */
	public static void sumaPuntos( int puntosASumar ) {
		puntos += puntosASumar;
	}
	
}
