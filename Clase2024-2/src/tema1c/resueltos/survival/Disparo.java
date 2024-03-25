package tema1c.resueltos.survival;

import java.awt.Color;
import java.util.Random;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Disparo extends ObjetoJuegoConColor {
	private static Random random = new Random();
	
	private double radio = 5;

	public Disparo(double x, double y, Color colorBorde, Color colorFondo, double radio) {
		super(x, y, colorBorde, colorFondo);
		this.setRadio( radio );
	}
	
	/** Crea un disparo nuevo dentro de la ventana, borde rojo, color cyan, radio 7
	 * @param ventana	Ventana de referencia
	 */
	public Disparo( VentanaGrafica ventana ) {
		this( random.nextInt( ventana.getAnchura() ), random.nextInt( ventana.getAltura() ),
				Color.RED, Color.CYAN, 7 );
	}

	public double getRadio() {
		return radio;
	}

	/** Modifica el radio
	 * @param radio	Nuevo radio POSITIVO. Si fuera 0 o negativo, no se modifica.
	 */
	public void setRadio(double radio) {
		if  (radio <= 0) {
			return;
		}
		this.radio = radio;
	}
	
	@Override
	public void dibujar(VentanaGrafica vent) {
		vent.dibujaCirculo( x, y, radio, 1, colorBorde, colorFondo );
	}
	
	

}
