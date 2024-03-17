package tema1c.ejemplos;

import java.awt.Point;

/** Comportamiento de poder hacer click en el objeto
 */
public interface Clickable {
    /** Informa si un punto corresponde al espacio visual del objeto
     * @param click    Punto de click
     * @return    true si el punto de click es interior al objeto, false en caso contrario
     */
    boolean estaEnObjeto( Point click );
    /** Modifica la puntuación del juego al hacerse un click
     */
    void puntuaClick();
}
