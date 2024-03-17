package tema1c.ejemplos;

import java.awt.Point;

import utils.ventanas.ventanaBitmap.VentanaGrafica;

public class Imagen extends Figura implements Rotable, Automovible, Clickable {
	
	public final int PUNTOS_POR_CLICK_IMAGEN = 5;
	
    private int anchura;
    private int altura;
    private double rotacion;
    // Automovible
    private int velX;
    private int velY;
    private VentanaGrafica vent;

    public Imagen(int xCentro, int yCentro, int anchura, int altura) {
        super(xCentro, yCentro, 0, null);
        this.anchura = anchura;
        this.altura = altura;
    }
    
    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
    
    public int getVelX() {
		return velX;
	}

	/** Cambia la velocidad horizontal
	 * @param velX	Velocidad nueva en píxeles por segundo
	 */
	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	/** Cambia la velocidad vertical
	 * @param velY	Velocidad nueva en píxeles por segundo
	 */
	public void setVelY(int velY) {
		this.velY = velY;
	}

	/** Cambia la velocidad
	 * @param velX	Velocidad nueva horizontal en píxeles por segundo
	 * @param velY	Velocidad nueva vertical en píxeles por segundo
	 */
	public void setVelocidad(int velX, int velY) {
		setVelX(velX);
		setVelY(velY);
	}
	
	public void dibujar( VentanaGrafica vent ) {
        vent.dibujaImagen( "logo-chatgpt.png", xCentro, yCentro, anchura, altura, 1, rotacion, 1 );
    }

    /** Cambia la rotación 
     * @param incRotacion   Incremento/decremento de rotación (en radianes)
     */
    public void rotar( double incRotacion ) {
        rotacion += incRotacion;
    }

    @Override
    public String toString() {
    	return "Imagen " + super.toString() + " Rot " + rotacion;
    }

    public void setVentana( VentanaGrafica vent ) {
    	this.vent = vent;
    }
    
	@Override
	public void mover(double tiempoMsgs) {
		xCentro += velX * tiempoMsgs/1000.0;
		yCentro += velY * tiempoMsgs/1000.0;
		if (vent!=null) {
			if (xCentro-anchura/2 < 0 || xCentro+anchura/2 > vent.getAnchura()) {
				velX = -velX;
			}
			if (yCentro-altura/2 < 0 || yCentro+altura/2 > vent.getAltura()) {
				velY = -velY;
			}
		}
	}

	@Override
	public boolean estaEnObjeto(Point click) {
		double dist = click.distance( xCentro, yCentro );
		return dist <= Math.min( anchura, altura ) / 2;
	}

	@Override
	public void puntuaClick() {
		Clicker.sumaPuntos( PUNTOS_POR_CLICK_IMAGEN );
	}
	
}
