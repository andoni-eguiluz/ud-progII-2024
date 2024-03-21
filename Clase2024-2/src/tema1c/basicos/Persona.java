package tema1c.basicos;

import java.util.ArrayList;
import java.util.Arrays;

// @SuppressWarnings("rawtypes")
// public class Persona implements Comparable {  // Interfaz raw (Object) sin genericidad
public class Persona implements Comparable<Persona> {  // Interfaz con genericidad, específico de la clase Persona
	
	/** Método de prueba de la clase Persona
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		Persona p1 = new Persona( 11111111, 'c', "Andoni", "Pérez" );
		Persona p2 = new Persona( 22222222, 'd', "María", "González" );
		Persona p3 = new Persona( 33333333, 'e', "luis", "Ruiz" );
		Persona p4 = new Persona( 44444444, 'f', "María", "Arqués" );
		ArrayList<Persona> l = new ArrayList<>();
		l.add( p4 );
		l.add( p3 );
		l.add( p2 );
		l.add( p1 );
		// Otra manera:
		// ArrayList<Persona> l2 = new ArrayList<>( Arrays.asList( p1, p2, p3 ) );
		System.out.println( l );
		l.sort( null );
		System.out.println( l );
		System.out.println( "o".compareTo( "ñ" ));
		// Probemos a ordenar por nombre
		l.sort( new ComparadorNombreYApellidos() );
		System.out.println( l );
	}

	//  Interfaz Comparable - sin genericidad - requiere instanceof y cast
//	@Override
//	public int compareTo(Object o) {
//		// TODO Auto-generated method stub
//		if (o instanceof Persona) 
//			((Persona) o)...
//			...
//	}
	
	// Interfaz Comparable<Persona> - con genericidad - especializado
	@Override
	public int compareTo(Persona o) {
		// objeto this y objeto o --> negativo si this < o, 0 si this==o, + si this > o
		// Orden natural: decidimos dni
		// Manera 1: lo más intuitivo
//		System.out.println( this + " / " + o );
//		if (this.dniNumero < o.dniNumero) {
//			return -1;
//		} else if (this.dniNumero == o.dniNumero) {
//			return 0;
//		} else {
//			return +1;
//		}
		// Manera 2: la más eficiente
		return this.dniNumero - o.dniNumero;
	}
	
	@Override
	public String toString() {
		return "" + dniNumero + dniLetra + ": " + nombre + " " + apellidos;
	}
	
	private int dniNumero;
	private char dniLetra;
	private String nombre;
	private String apellidos;
	public Persona(int dniNumero, char dniLetra, String nombre, String apellidos) {
		super();
		this.dniNumero = dniNumero;
		this.dniLetra = dniLetra;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	public int getDniNumero() {
		return dniNumero;
	}
	public void setDniNumero(int dniNumero) {
		this.dniNumero = dniNumero;
	}
	public char getDniLetra() {
		return dniLetra;
	}
	public void setDniLetra(char dniLetra) {
		this.dniLetra = dniLetra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
}
