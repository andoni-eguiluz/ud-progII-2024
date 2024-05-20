package varios.testExamenCortoResuelto;

public class Pintxo extends Producto 
// TAREA 1
implements Concursable {
	protected boolean caliente;

	public Pintxo(String nombre, double precio, boolean caliente) {
		super(nombre, precio);
		this.caliente = caliente;
	}

	public boolean isCaliente() {
		return caliente;
	}

	public void setCaliente(boolean caliente) {
		this.caliente = caliente;
	}
	
	// TAREA 1
	@Override
	public boolean enConcurso() {
		return precio >= 2;
	}
}
