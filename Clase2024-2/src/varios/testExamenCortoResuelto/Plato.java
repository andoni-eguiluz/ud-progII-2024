package varios.testExamenCortoResuelto;

import java.util.ArrayList;
import java.util.List;

public class Plato extends Producto 
// TAREA 1
implements Concursable {
	protected ArrayList<String> opciones;

	public Plato(String nombre, double precio, List<String> opciones) {
		super(nombre, precio);
		this.opciones = new ArrayList<>( opciones ); 
	}

	public List<String> getOpciones() {
		return opciones;
	}
	
	@Override
	public String toString() {
		return super.toString() + " " + opciones;
	}
	
	// TAREA 1
	@Override
	public boolean enConcurso() {
		return opciones.size() >= 4;
	}

}
