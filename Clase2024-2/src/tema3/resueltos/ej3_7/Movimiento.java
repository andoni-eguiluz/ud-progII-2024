package tema3.resueltos.ej3_7;

public enum Movimiento {
	NORTE, ESTE, SUR, OESTE;
	
	/** Rota un movimiento
	 * @param movimiento	Movimiento origen
	 * @param horario	Sentido de la dirección de rotación (true = horaria, false = antihoraria)
	 * @return	movimiento con la rotación aplicada
	 */
	public static Movimiento rotar( Movimiento movimiento, boolean horario ) {
		return movimiento.rotar( horario );
	}
	
	/** Rota un movimiento
	 * @param horario	Sentido de la dirección de rotación (true = horaria, false = antihoraria)
	 * @return	movimiento con la rotación aplicada
	 */
	public Movimiento rotar( boolean horario ) {
		int incremento = horario ? +1 : -1;
		int indice = (this.ordinal() + incremento + 4) % 4;  // Calcula movimiento en positivo y convierte siempre a módulo 4 = rango 0 a 3
		return values()[indice];
	}
	
	public Movimiento inverso() {
		int indice = (this.ordinal() + 2) % 4;
		return values()[indice];
	}
	
	
	// Paso 9 - cambio de filas y columnas
	private int[] cambioF = { -1, 0, +1, 0 };
	/** Calcula el cambio de filas que significa hacer este movimiento
	 * @return	0, -1 o +1 dependiendo del cambio vertical de fila que implique este movimiento
	 */
	public int cambioFilas() {
		return cambioF[ ordinal() ];
	}
	
	private int[] cambioC = { 0, +1, 0, -1 };
	/** Calcula el cambio de columnas que significa hacer este movimiento
	 * @return	0, -1 o +1 dependiendo del cambio horizontal de columna que implique este movimiento
	 */
	public int cambioColumnas() {
		return cambioC[ ordinal() ];
	}
	

}
