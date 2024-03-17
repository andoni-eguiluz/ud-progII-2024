package tema1c.ejemplos;

import java.awt.Color;
import java.awt.Point;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Flecha extends Figura implements Automovible, Rotable, Colorizable {
	private static int LARGO_FLECHA = 10;
	
	private double modulo;
	private double argumento;
	private int incColor = +5;
	
	public Flecha(int xCentro, int yCentro, int grosor, Color color, double modulo, double argumento) {
		super(xCentro, yCentro, grosor, color);
		this.modulo = modulo;
		this.argumento = argumento;
	}
	
	public double getModulo() {
		return modulo;
	}

	public void setModulo(double modulo) {
		this.modulo = modulo;
	}

	public double getArgumento() {
		return argumento;
	}

	public void setArgumento(double argumento) {
		this.argumento = argumento;
	}

	@Override
	public void dibujar(VentanaGrafica v) {
		v.dibujaFlecha( xCentro, yCentro, argumento, modulo, LARGO_FLECHA, grosor, color );
	}

	@Override
	public void animaColor() {
		int nuevoRojo = color.getRed() + incColor;
		if (nuevoRojo > 255 || nuevoRojo < 0) {
			incColor = -incColor;
			nuevoRojo += incColor;
		}
		color = new Color( nuevoRojo, color.getGreen(), color.getBlue() );
	}

	@Override
	public void rotar(double rotacion) {
		argumento += rotacion;
	}

	@Override
	public void mover(double tiempoMsgs) {
		double aMover = modulo * tiempoMsgs / 1000.0;
		xCentro += aMover * Math.cos(argumento);
		yCentro += aMover * Math.sin(argumento);
	}

    /** Hace que la flecha gire hacia el cursor de ratón, orientándose exactamente en su dirección
     * @param raton    Punto donde está el ratón en la ventana
     */
    public void rotaHaciaCursor( Point raton ) {
    	double xDireccion = raton.x - xCentro;
    	double yDireccion = raton.y - yCentro;
    	argumento = Math.atan2( yDireccion, xDireccion );
    }
    
    /** Detecta si la flecha está tocando al cursor de ratón
     * @param raton    Punto donde está el ratón en la ventana
     * @return    true si la punta de la flecha está muy cerca (menos de dos píxeles de distancia) de ese punto, false en caso contrario
     */
    public boolean tocaACursor( Point raton ) {
    	double distX = raton.x - xCentro - modulo/2 * Math.cos(argumento);
    	double distY = raton.y - yCentro - modulo/2 * Math.sin(argumento);
    	return Math.sqrt( distX*distX + distY*distY ) < 2;
    }
	
}
