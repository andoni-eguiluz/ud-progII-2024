package tema1c.ejemplos;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Circulo extends Figura implements Colorizable, Automovible, Clickable {

	private static final int RADIO_SENSIBLE = 15;
	private static final int PUNTOS_CLICK = 10;
	
// No se definen! Se heredan
//	private int xCentro;
//	private int yCentro;
//	private int grosor;
//	private Color color;
	private int radio;
	private int incColor = +5; // Colorizable
	private VentanaGrafica vent;

	private static Random random = new Random();
	
	public Circulo(int xCentro, int yCentro, int radio, int grosor, Color color) {
		super( xCentro, yCentro, grosor, color );
//		this.xCentro = xCentro;
//		this.yCentro = yCentro;
		this.setRadio( radio );
//		this.grosor = grosor;
//		this.color = color;
	}
	
	public Circulo(int xCentro, int yCentro, int radio, int grosor, Color color, VentanaGrafica vent) {
		this( xCentro, yCentro, radio, grosor, color );
		// super( xCentro, yCentro, grosor, color );
		// this.setRadio( radio );
		this.setVent( vent );
	}
	
	public VentanaGrafica getVent() {
		return vent;
	}

	public void setVent(VentanaGrafica vent) {
		this.vent = vent;
	}

	//	public int getxCentro() {
//		return xCentro;
//	}
//
//	public void setxCentro(int xCentro) {
//		this.xCentro = xCentro;
//	}
//
//	public int getyCentro() {
//		return yCentro;
//	}
//
//	public void setyCentro(int yCentro) {
//		this.yCentro = yCentro;
//	}
//
	public int getRadio() {
		return radio;
	}

	
	/** Cambia el radio del círculo
	 * @param radio	Nuevo radio, si es 0 o negativo se ajusta a 10
	 */
	public void setRadio(int radio) {
		if (radio<=0) {
			this.radio = 10;
			return;
		}
		this.radio = radio;
	}

//	public int getGrosor() {
//		return grosor;
//	}
//
//	public void setGrosor(int grosor) {
//		this.grosor = grosor;
//	}
//
//	public Color getColor() {
//		return color;
//	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}
//
	/** Dibuja el círculo en una ventana
	 * @param v	Ventana en la que dibujar
	 */
	public void dibujar (VentanaGrafica v) {
		v.dibujaCirculo( getxCentro(), getyCentro(), getRadio(), getGrosor(), getColor() );
		v.dibujaCirculo( getxCentro(), getyCentro(), RADIO_SENSIBLE, 1, Color.MAGENTA );
	}
	
	@Override
    public String toString() {
    	// return "Cuadrado (" + xCentro + "," + yCentro + ") Radio = " + radio;
    	return "Círculo " + super.toString() + " Radio = " + radio;
    }
	
	// Colorizable
	public void animaColor() {
		int nuevoRojo = color.getRed() + incColor;
		if (nuevoRojo > 255 || nuevoRojo < 0) {
			incColor = -incColor;
			nuevoRojo += incColor;
		}
		color = new Color( nuevoRojo, color.getGreen(), color.getBlue() );
	}

	@Override
	public void mover( double tiempoMsgs ) {
		xCentro += random.nextInt( 11 ) - 5;
		yCentro += random.nextInt( 11 ) - 5;
		// Evitar que se salga
		if (xCentro-radio<0) {
			xCentro = radio;
		} else if (xCentro+radio>vent.getAnchura()) {
			xCentro = vent.getAnchura()-radio;
		}
		if (yCentro-radio<0) {
			yCentro = radio;
		} else if (yCentro+radio>vent.getAltura()) {
			yCentro = vent.getAltura()-radio;
		}
	}

	@Override
	public boolean estaEnObjeto(Point click) {
		double dist = click.distance( xCentro, yCentro );
		return dist < RADIO_SENSIBLE;
	}

	@Override
	public void puntuaClick() {
		Clicker.sumaPuntos( PUNTOS_CLICK );
	}
	
}
