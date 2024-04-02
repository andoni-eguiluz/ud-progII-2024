package tema1c.resueltos.survival;

public interface Clickable {
	/** Informa si un punto está o no dentro de un objeto
	 * @param x	Horizontal del punto a comprobar
	 * @param y	Vertical del punto a comprobar
	 * @return	true si el punto (x,y) indicado está dentro, false en caso contrario
	 */
	boolean puntoDentro( double x, double y );
	
	/** Modifica el estado de selección del objeto
	 * @param sel	true si está seleccionado, false en caso contrario
	 */
	void setSeleccionado (boolean sel);
}
