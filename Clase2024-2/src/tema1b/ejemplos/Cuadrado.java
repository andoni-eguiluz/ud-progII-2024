package tema1b.ejemplos;

import java.awt.Color;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

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

    public void dibujar( VentanaGrafica vent ) {
        vent.dibujaRect( xCentro-lado/2, yCentro-lado/2, lado, lado, grosor, color );
    }

    @Override
    public String toString() {
    	return "Cuadrado " + super.toString() + " Lado = " + lado;
    }
    
}
