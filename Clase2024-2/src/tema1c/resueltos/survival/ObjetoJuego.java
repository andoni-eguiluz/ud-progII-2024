package tema1c.resueltos.survival;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public abstract class ObjetoJuego {  // extends Object
	protected double x;
	protected double y;

	public ObjetoJuego(double x, double y) {
		// super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	/** Dibuja el objeto 
	 * @param vent	Ventana en la que dibujarlo
	 */
	public abstract void dibujar( VentanaGrafica vent );
	
	/** Mueve el objeto
	 * @param x	Nueva coordenada x (horizontal)
	 * @param y	Nueva coordenada y (vertical)
	 */
	public void moverA ( double x, double y ) {
		this.x = x;
		this.y = y;
	}
		
	/** Devuelve la distancia entre centros del objeto this y otro objeto
	 * @param o2	Segundo objeto
	 * @return	Distancia en píxeles
	 */
	public double distanciaA( ObjetoJuego o2 ) {
		double difX = this.x - o2.x;
		double difY = this.y - o2.y;
		return Math.sqrt( difX*difX + difY*difY );   // Math.pow( b, e )
	}
	
	/** Determina si el centro del objeto está en la ventana
	 * @param vent	Ventana en la que comprobar
	 * @return	true si el centro está en la ventana visible, false en caso contrario
	 */
	public boolean estaDentroDeVentana( VentanaGrafica vent ) {
		return x >= 0 && x < vent.getAnchura() && y >= 0 && y < vent.getAltura();
	}
	
	
}
