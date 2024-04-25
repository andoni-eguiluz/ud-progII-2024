package tema3.resueltos.ej3_1_2;

import java.util.*;

public class Scores {
	
	public static void main(String[] args) {
		Scores scores = new Scores();
		scores.addScore( "a", 7 );
		scores.addScore( "a", 9 );
		scores.addScore( "a", 3 );
		System.out.println( scores.mapaPunts );
	}

	private HashMap<String,ArrayList<Integer>> mapaPunts;
//	Constructor de un nuevo gestor de Scores
	public Scores() {
		mapaPunts = new HashMap<>();
	}
	
//	void addUsuario( String nick )
	public void addUsuario( String nick ) {
		if (mapaPunts.containsKey(nick)) {
			// Nada
		} else {
			mapaPunts.put( nick, new ArrayList<>() );
		}
	}
	
//	void addScore( String nick, int score )
	public void addScore( String nick, int score ) {
//		if (!mapaPunts.containsKey(nick)) {
//			mapaPunts.put( nick, new ArrayList<>() );
//			mapaPunts.get(nick).add( score );
//		} else {
//			mapaPunts.get(nick).add( score );
//		}
		if (!mapaPunts.containsKey(nick)) {
			mapaPunts.put( nick, new ArrayList<>() );
		}
		mapaPunts.get(nick).add( score );
	}
	
//	List<Integer> getScores( String nick ) 
//	 null si no existe
	/** Devuelve las puntuaciones almacenadas para un usuario
	 * @param nick	Usuario a consultar
	 * @return	Lista de sus puntuaciones, null si el usuario no existe
	 */
	public List<Integer> getScores( String nick ) {
		return mapaPunts.get(nick);
	}
	
	
//	Set<String> getUsuarios() 
//	Devuelve el conjunto de usuarios registrados con puntuaciones
//	List<String> getUsuariosFieles()
//	devuelve los usuarios ordenados por el número de partidas jugadas

}
