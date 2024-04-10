package tema3.resueltos.ej3_7;

public class Posicion {
	private int fila;
	private int columna;
	
	public Posicion(int fila, int columna) {
		super();
		this.fila = fila;
		this.columna = columna;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	@Override
	public String toString() {
		return "[" + fila + "," + columna + "]";
	}

	public void mueve( Movimiento mov ) {
		// Opción 1 - con alternativas
//		if (mov==Movimiento.NORTE) {
//			fila--;
//		} else if (mov==Movimiento.SUR) {
//			fila++;
//		} else if (mov==Movimiento.ESTE) {
//			columna++;
//		} else {
//			columna--;
//		}
		// Opción 2 - con métodos en el enum
			fila += mov.cambioFilas();
			columna += mov.cambioColumnas();
	}
	
}
