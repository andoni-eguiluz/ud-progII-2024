package tema1c.ejemplos;

/** Comportamiento de objeto que sabe moverse de forma autónoma
 */
public interface Automovible {
    /** Mueve el objeto
     * @param tiempoMsgs    Tiempo transcurrido desde anterior movimiento, en milisegundos
     */
    void mover( double tiempoMsgs );
}
