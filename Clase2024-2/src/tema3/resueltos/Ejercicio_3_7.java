package tema3.resueltos;

import java.util.ArrayList;
import java.util.Random;

import tema3.resueltos.ej3_7.Movimiento;
import static tema3.resueltos.ej3_7.Movimiento.*;
import tema3.resueltos.ej3_7.Posicion;

public class Ejercicio_3_7 {
	public static void main(String[] args) {
		prueba1();
		pruebaForeach();
		pruebaVarargs();
	}
	
	private static void prueba1() {
		Movimiento mov = Movimiento.NORTE;
		System.out.println( mov );
		mov = mov.rotar( true );
		System.out.println( "+ 1 rotación horaria = " + mov );
		mov = mov.rotar( true );
		mov = mov.rotar( true );
		System.out.println( "+ 2 rotaciones horarias = " + mov );
		mov = mov.rotar( true );
		System.out.println( "+ 1 rotación horaria = " + mov );
		mov = mov.rotar( false );
		System.out.println( "+ 1 rotación antihoraria = " + mov );
		mov = Movimiento.rotar( mov, true );
		System.out.println( "+ 1 rotación horaria = " + mov );
	}

	private static Random random = new Random();
	private static void pruebaForeach() {
		ArrayList<Movimiento> listaMovs = generaListaAleatoria();
		System.out.println( "Movimientos aleatorios: " + listaMovs );
		Movimiento movAQuitar = Movimiento.values()[ random.nextInt(4) ];
		quitarMovimientos( listaMovs, movAQuitar );
		System.out.println( "Quitado movimiento " + movAQuitar + " = " + listaMovs );
	}
	
	private static ArrayList<Movimiento> generaListaAleatoria() {
		ArrayList<Movimiento> listaMovs = new ArrayList<>();
		for (int i=0; i<15; i++) {
			listaMovs.add( Movimiento.values()[ random.nextInt(4) ] );  // Añade movimientos aleatorios
		}
		return listaMovs;
	}
	
	private static void quitarMovimientos( ArrayList<Movimiento> lista, Movimiento movAQuitar ) {
		// Esto daría error por modificación en medio de un recorrido
		//  for (Movimiento mov : lista) {
		//  	if (mov == movAQuitar) {
		//  		lista.remove( mov );
		//  	}
		//  }
		for (int i=0; i<lista.size(); i++) {
			Movimiento mov = lista.get(i);
			if (mov == movAQuitar) {
				lista.remove(i);
				i--;  // Decrementamos el contador porque al borrar la siguiente iteración debe gestionar el mismo índice
			}
		}
	}

	// Esto sí funciona con un foreach - primero recorrer y almacenar, y luego modificar sin un foreach (de la misma lista)
	private static void quitarMovimientos2( ArrayList<Movimiento> lista, Movimiento movAQuitar ) {
		ArrayList<Integer> indicesAQuitar = new ArrayList<>();
		int ind = 0;
		for (Movimiento mov : lista) {
			if (mov == movAQuitar) {
				indicesAQuitar.add( 0, ind );  // Añade al principio para tenerlos en orden inverso
			}
			ind++;
		}
		for (int indAQuitar : indicesAQuitar) {  // Ojo que esto solo funciona si el orden es inverso (al borrar los índices de la derecha cambian)
			lista.remove( indAQuitar );
		}
	}
	
	private static void pruebaVarargs() {
		Posicion pos = new Posicion( 5, 5 );
		mueve( pos, NORTE, ESTE, ESTE, SUR, SUR, SUR, SUR, OESTE );
	}
	
	private static void mueve( Posicion pos, Movimiento... movimientos ) {
		System.out.println( "Moviendo desde " + pos );
		for (Movimiento m : movimientos) {
			pos.mueve( m );
			System.out.println( "  " + m + " --> " + pos );
		}
	}
	
}
