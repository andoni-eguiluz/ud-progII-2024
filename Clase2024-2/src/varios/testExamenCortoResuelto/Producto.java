package varios.testExamenCortoResuelto;

import java.io.Serializable;
import java.util.Objects;

public abstract class Producto implements Comparable<Producto> 
// TAREA 2
,Serializable
{
	protected String nombre;
	protected double precio;
	// TAREA 2
	private static final long serialVersionUID = 1L;
	
	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return nombre + " (" + precio + "€)";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}

	@Override
	public int compareTo(Producto o) {
		return nombre.compareTo( o.nombre );
	}
}
