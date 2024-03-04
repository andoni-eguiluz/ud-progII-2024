package tema1b.ejemplos;

import java.awt.Color;

public class Cuadrado extends Figura {

	private int lado;
	
	public Cuadrado(int xCentro, int yCentro, int grosor, Color color, int lado) {
		super(xCentro, yCentro, grosor, color);
		this.lado = lado;
	}

	public int getLado() {
		return lado;
	}

	public void setLado(int lado) {
		this.lado = lado;
	}
	
}
