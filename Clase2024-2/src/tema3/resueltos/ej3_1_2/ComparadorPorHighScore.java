package tema3.resueltos.ej3_1_2;

import java.util.Comparator;

public class ComparadorPorHighScore implements Comparator<String> {
	private HighScores hs;
	public ComparadorPorHighScore( HighScores hs ) {
		this.hs = hs;
	}
	/** Compara dos nicks devolviendo negativo si o1 tiene mejor puntuación que o2, 
	 * positivo en caso contrario, 0 si tienen la misma puntuación
	 */
	@Override
	public int compare(String o1, String o2) {
		// System.out.println( "Compara " + o1 + " con " + o2 + " devuelvo " + (hs.getHighScore(o1) - hs.getHighScore(o2)) );
		return - (hs.getHighScore(o1) - hs.getHighScore(o2));
	}
}
