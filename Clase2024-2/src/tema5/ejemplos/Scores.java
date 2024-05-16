package tema5.ejemplos;

import java.util.*;

public class Scores {
	
	public static void main(String[] args) {
		Scores scores = new Scores();
		scores.addScore( "a", 7 );
		scores.addScore( "a", 9 );
		scores.addScore( "a", 3 );
		scores.addScore( "bb", 13 );
		scores.addScore( "bb", 11 );
		scores.addScore( "sss", 25 );
		scores.addScore( "b", 2 );
		System.out.println( scores.mapaPunts );
		System.out.println( scores.getUsuarios() );
		System.out.println( scores.getUsuariosFieles() );
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
	public Set<String> getUsuarios() {
		return mapaPunts.keySet();
	}
	
//	List<String> getUsuariosFieles()
//	devuelve los usuarios ordenados por el número de partidas jugadas
	/** Devuelve los usuarios ordenados por el número de partidas jugadas, de más a menos
	 * @return	Lista de los usuarios ordenados por ese criterio. Si tienen la misma fidelidad, se ordenan por orden alfabético
	 */
	public List<String> getUsuariosFieles() {
		ArrayList<String> l = new ArrayList<>();
		for (String claves : mapaPunts.keySet()) {
			l.add( claves );
		}
		// 1.- Con clase externa
		// l.sort( new ComparadorFidelidad( this ) );  // null alfabético
		// 2.- Con clase interna
		// l.sort( new ComparadorFidelidad() );
		// 3.- Con clase interna anónima
		l.sort( new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						int long1 = getScores(o1).size();
						int long2 = getScores(o2).size();
						int comp = long2-long1;  // -(long1-long2)
						if (comp==0) {
							comp = o1.compareTo(o2);
						}
						return comp;
					}
				}
		);
		return l;
	}

	private class ComparadorFidelidad implements Comparator<String> {
//		private Scores puntuaciones;
//		public ComparadorFidelidad( Scores puntuaciones ) {
//			this.puntuaciones = puntuaciones;
//		}
		@Override
		public int compare(String o1, String o2) {
			int long1 = getScores(o1).size();
			int long2 = getScores(o2).size();
			int comp = long2-long1;  // -(long1-long2)
			if (comp==0) {
				comp = o1.compareTo(o2);
			}
			return comp;
		}
	}

	
}
