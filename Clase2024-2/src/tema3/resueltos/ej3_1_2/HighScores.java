package tema3.resueltos.ej3_1_2;

import java.util.*;

public class HighScores {

	/** Método de prueba de la clase
	 * @param args	No utilizado
	 */
	public static void main(String[] args) {
		HighScores hs = new HighScores();
		hs.addHighScore( "a", 8 );
		hs.addHighScore( "j", 5 );
		hs.addHighScore( "x", 7 );
		hs.addHighScore( "j", 2 );
		hs.addHighScore( "x", 15 );
		hs.addUsuario( "b" );
		hs.addHighScore( "b", 20 );
		hs.addUsuario( "x" );
		System.out.println( hs.mapaHS );
		System.out.println( hs.getHighScore( "x" ));
		System.out.println( hs.getHighScore( "m" ));
		System.out.println( hs.getUsuarios() );
		System.out.println( hs.getMejoresUsuarios() );
	}
	
	private Map<String,Integer> mapaHS;
	
//	Constructor de un nuevo gestor de HighScores
	public HighScores() {
		mapaHS = new HashMap<>();
	}	
	
//	void addHighScore( String nick, int score )
	/** Añade una nueva puntuación a un usuario. Si es mayor que las que tuviera se actualiza
	 * y si no mantiene la anterior
	 * @param nick	Usuario (nombre único)
	 * @param score	Nueva puntuación
	 */
	public void addHighScore( String nick, int score ) {
		if (!mapaHS.containsKey(nick)) {
			mapaHS.put( nick, score );  // boxing
		} else {
			if (mapaHS.get(nick) < score) {  // unboxing
				mapaHS.replace( nick, score );
			}
		}
	}
	
//	void addUsuario( String nick )
	/** Añadir un nuevo usuario sin puntuación. Se le asignará la puntuación ficticia -1
	 * Si el usuario ya existía, no se modifica.
	 * @param nick	Nick del nuevo usuario
	 */
	public void addUsuario( String nick ) {
//		if (mapaHS.containsKey(nick)) {
//			// Nada
//		} else {
//			mapaHS.put( nick, -1 );
//		}
		if (!mapaHS.containsKey(nick)) {
			mapaHS.put( nick, -1 );
		}
	}

//	int getHighScore( String nick )  -1 si no existe
	/** Devuelve el high score asociado al usuario.
	 * @param nick	Usuario a consultar
	 * @return	puntuación máxima de ese usuario, -1 si no existe
	 */
	public int getHighScore( String nick ) {
		if (!mapaHS.containsKey(nick)) {
			return -1;
		}
		return mapaHS.get(nick);  // Unboxing  Integer -> getIntValue()
	}
	
//	Set<String> getUsuarios() 
	/** Devuelve los usuarios que hayan sido añadidos al sistema
	 * @return	Conjunto de esos usuarios
	 */
	public Set<String> getUsuarios() {
		return mapaHS.keySet();
	}
	
	/** devuelve los usuarios ordenados por sus high scores
	 * de mejor puntuación a peor puntuación
	 * @return lista de usuarios
	 */
	public List<String> getMejoresUsuarios() {
		ArrayList<String> listaUsuarios = new ArrayList<>();
		for (String usuario : mapaHS.keySet()) {
			listaUsuarios.add( usuario );
		}
		listaUsuarios.sort( new ComparadorPorHighScore( this ) );
		return listaUsuarios;
	}
		
}
