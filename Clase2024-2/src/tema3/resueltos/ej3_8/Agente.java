package tema3.resueltos.ej3_8;

/** Clase de base para el ejercicio 3.8
 */
public class Agente implements Comparable<Agente> {
	private int prov;
	private String loc;
	private String nombre;
	private String dni;
	
	public Agente(int prov, String loc, String nombre, String dni) {
		super();
		this.prov = prov;
		this.loc = loc;
		this.nombre = nombre;
		this.dni = dni;
	}

	public int getProv() {
		return prov;
	}

//	public void setProv(int prov) {
//		this.prov = prov;
//	}

	public String getLoc() {
		return loc;
	}

//	public void setLoc(String loc) {
//		this.loc = loc;
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public int compareTo(Agente o) {
		return this.nombre.compareTo( o.nombre );
	}
	
	@Override
	public String toString() {
		return nombre + "-" + dni;
	}
	
	
}
