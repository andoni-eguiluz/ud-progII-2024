package tema1c.resueltos.survival;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class JuegoSurvival {
	private static Random random = new Random();
	/** Tamaño de la ventana, anchura, en píxeles (800)
	 */
	public static final int ANCHO_VENTANA = 800;  // ancho en píxeles
	/** Tamaño de la ventana, altura, en píxeles (600)
	 */
	public static final int ALTO_VENTANA = 600;
	
	private VentanaGrafica ventana;
	private ArrayList<ObjetoJuego> listaObjetos;
	
	public JuegoSurvival() {
		ventana = new VentanaGrafica( ANCHO_VENTANA, ALTO_VENTANA, "Juego survival" );
		listaObjetos = new ArrayList<>();
	}
	
	public void init() {
//		listaObjetos.add( new Disparo( random.nextInt(ANCHO_VENTANA), random.nextInt(ALTO_VENTANA), 
//				Color.BLACK, Color.CYAN, 7 ) );
//		listaObjetos.add( new Disparo( random.nextInt(ANCHO_VENTANA), random.nextInt(ALTO_VENTANA), 
//				Color.BLACK, Color.CYAN, 7 ) );
		for (int i=0; i<5; i++) {
			listaObjetos.add( new Disparo( ventana ) );
		}
	}
	
	public void jugar() {
		int conteo = 0;
		while (!ventana.estaCerrada()) {
			// 1. Proceso inputs
			
			// 2. Lógica de juego
			
			// 3. Proceso de output
			for (ObjetoJuego oj : listaObjetos) {
				oj.dibujar(ventana);
			}
			conteo++;
			System.out.println( conteo );
			ventana.espera( 40 );
		}
	}
	
}
