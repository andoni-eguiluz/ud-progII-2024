package tema4.resueltos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PruebaPelis {

	public static void main(String[] args) {
		ArrayList<Peli> l = new ArrayList<>();
		l.add( new Peli( "Oppenheimer", 2023 ) );
		l.add( new Peli( "Barbie", 2023 ) );
		l.add( new Peli( "Todo a la vez en todas partes", 2022 ) );
		l.add( new Peli( "CODA", 2021 ) );
		System.out.println( l );
		guardarListaObjetos( l, "pelis.dat" );
		System.out.println( l );
		ArrayList<Peli> l2 = cargarListaObjetos( "pelis.dat" );
		System.out.println( l2 );
	}
	
	private static void guardarListaObjetos( ArrayList<Peli> l, String nombre ) {  // escribir en fichero
		try {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( nombre ) );
			oos.writeObject( l );
			oos.close();
		} catch (Exception e) {
			// System.out.println( "Error en fichero" );
			e.printStackTrace();
		}
	}
	
	private static ArrayList<Peli> cargarListaObjetos( String nombre ) {   // leer de fichero
		return null;
	}
	
}
