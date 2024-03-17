package tema1c.ejemplos;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Cuadrado extends Figura implements Rotable, Colorizable {

	private int lado;
	private double rotacion = 0.0;
	private int incColor = +5; // Colorizable
	
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

    public void dibujar( VentanaGrafica vent ) {
        // vent.dibujaRect( xCentro-lado/2, yCentro-lado/2, lado, lado, grosor, color );
        double radio = Math.sqrt( lado * lado / 2.0 );
        vent.dibujaPoligonoRegular( xCentro, yCentro, 4, radio, Math.PI/4 + rotacion, grosor, color );
    }

    @Override
    public String toString() {
    	return "Cuadrado " + super.toString() + " Lado = " + lado;
    }

    @Override
    public void rotar( double incRotacion ) {
        rotacion += incRotacion;
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
    
}
