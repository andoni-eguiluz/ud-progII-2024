package tema1c.ejemplos;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Circulo extends Figura {

// No se definen! Se heredan
//	private int xCentro;
//	private int yCentro;
//	private int grosor;
//	private Color color;
	private int radio;
	
	public Circulo(int xCentro, int yCentro, int radio, int grosor, Color color) {
		super( xCentro, yCentro, grosor, color );
//		this.xCentro = xCentro;
//		this.yCentro = yCentro;
		this.setRadio( radio );
//		this.grosor = grosor;
//		this.color = color;
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
	}
	
	@Override
    public String toString() {
    	// return "Cuadrado (" + xCentro + "," + yCentro + ") Radio = " + radio;
    	return "Círculo " + super.toString() + " Radio = " + radio;
    }
	
	
}
