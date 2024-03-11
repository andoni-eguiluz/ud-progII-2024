package tema1c.ejemplos;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public abstract class Figura {
	protected int xCentro;
	protected int yCentro;
	protected int grosor;
	protected Color color;
	
	public Figura(int xCentro, int yCentro, int grosor, Color color) {
		super();
		this.xCentro = xCentro;
		this.yCentro = yCentro;
		this.grosor = grosor;
		this.color = color;
	}
	
	public int getxCentro() {
		return xCentro;
	}
	public void setxCentro(int xCentro) {
		this.xCentro = xCentro;
	}
	public int getyCentro() {
		return yCentro;
	}
	public void setyCentro(int yCentro) {
		this.yCentro = yCentro;
	}
	public int getGrosor() {
		return grosor;
	}
	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	/** Mueve una figura
	 * @param incX	Cambio de la cood. x (puede ser negativo)
	 * @param incY  Cambio de la coor. y (puede ser negativo)
	 */
	public void mover( int incX, int incY ) {
		xCentro += incX;
		yCentro += incY;
	}
	
	public abstract void dibujar( VentanaGrafica v );

	@Override
    public String toString() {
    	return "(" + xCentro + "," + yCentro + ")";
    }	
}
