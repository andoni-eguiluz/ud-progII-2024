package tema1b.ejemplos;

import java.awt.Color;

public class Figura {
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
	
}
