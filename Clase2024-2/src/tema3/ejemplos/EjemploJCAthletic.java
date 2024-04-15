package tema3.ejemplos;

import java.util.*;

public class EjemploJCAthletic {

	private static final Object[][] GOLES_COPA = {
		{ "1ªronda", "1/11/23",	"Rubí-Athletic", "1-2", "Adu Ares", 50 },
		{ "1ªronda", "1/11/23",	"Rubí-Athletic", "1-2", "Adu Ares", 56 },
		{ "2ªronda", "7/12/23",	"Cayón-Athletic", "0-3", "Villalibre", 21 },
		{ "2ªronda", "7/12/23",	"Cayón-Athletic", "0-3", "Villalibre", 25 },
		{ "2ªronda", "7/12/23",	"Cayón-Athletic", "0-3", "Nico Williams", 84 },
		{ "dieciseisavos", "7/1/24", "Eibar-Athletic", "0-3", "Villalibre", 16 },
		{ "dieciseisavos", "7/1/24", "Eibar-Athletic", "0-3", "Muniain", 32 },
		{ "dieciseisavos", "7/1/24", "Eibar-Athletic", "0-3", "Villalibre", 39 },
		{ "octavos", "16/1/24",	"Athletic-Alavés", "2-0", "Villalibre", 28 },
		{ "octavos", "16/1/24",	"Athletic-Alavés", "2-0", "Villalibre", 60 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Guruzeta", 0 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Sancet", 48 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Iñaki Williams", 106 },
		{ "cuartos", "24/1/24",	"Athletic-Barcelona", "4-2", "Nico Williams", 120 },
		{ "semifinal", "7/2/24",	"Atlético-Athletic", "0-1", "Berenguer", 24 },
		{ "semifinal", "29/2/24",	"Athletic-Atlético", "3-0", "Iñaki Williams", 12 },
		{ "semifinal", "29/2/24",	"Athletic-Atlético", "3-0", "Nico Williams", 41 },
		{ "semifinal", "29/2/24",	"Athletic-Atlético", "3-0", "Guruzeta", 60 },
		{ "final", "6/4/24",	"Athletic-Mallorca", "1-1 (4-2)", "Sancet", 49 }
	};

	private static ArrayList<String> cargaGoleadores() {
		ArrayList<String> ret = new ArrayList<>();
		for (int i=0; i<GOLES_COPA.length; i++) {
			ret.add( (String) GOLES_COPA[i][4] );
		}
		return ret;
	}

	private static ArrayList<String> goleadores;
	
	public static void main(String[] args) {
		pruebaJCStrings();
	}
	
	private static void pruebaJCStrings() {
		goleadores = cargaGoleadores();
		System.out.println( goleadores );
		
		// Linkedlist
		LinkedList<String> lista2 = new LinkedList<>();
		for (String jugador : goleadores) {
			lista2.add( jugador );
		}
		if (lista2.contains( "Sancet" )) {
			System.out.println( "Sancet está en la lista" );
		}
		System.out.println( lista2 );

		// Sets
		HashSet<String> conjuntoHash = new HashSet<String>();
		for (String jugador : goleadores) {
			conjuntoHash.add( jugador );
		}
		System.out.println( conjuntoHash );
		for (String j : conjuntoHash) {
			System.out.println( "  " + j );
		}
		if (conjuntoHash.contains( "Sancet" )) {
			System.out.println( "Sancet está en el conjunto" );
		}
		
		TreeSet<String> conjuntoTree = new TreeSet<>();
		for (String jugador : goleadores) {
			conjuntoTree.add( jugador );
			System.out.println( "  " + conjuntoTree );
		}
		System.out.println( conjuntoTree );
		if (conjuntoTree.contains( "Sancet" )) {
			System.out.println( "Sancet está en el conjunto" );
		}
		
		// Y cómo es un hash por dentro?
		HashSet<Jugador> conjJugs = new HashSet<>();
		for (String jugador : goleadores) {
			conjJugs.add( new Jugador(jugador) );
			System.out.println( " * " + conjJugs );
		}
		System.out.println( conjJugs );
		
	}
	
}
