package tema3.resueltos.ej3_1_2;

import java.util.Comparator;

public class ComparadorFidelidad implements Comparator<String> {
	private Scores puntuaciones;
	public ComparadorFidelidad( Scores puntuaciones ) {
		this.puntuaciones = puntuaciones;
	}
	@Override
	public int compare(String o1, String o2) {
		int long1 = puntuaciones.getScores(o1).size();
		int long2 = puntuaciones.getScores(o2).size();
//		if (long1>long2) {
//			return -1;
//		} else if (long1<long2) {
//			return +1;
//		} else {
//			return o1.compareTo(o2);
//		}
		int comp = long2-long1;  // -(long1-long2)
		if (comp==0) {
			comp = o1.compareTo(o2);
		}
		// System.out.println( "Comparando " + o1 + " con " + o2 + " y devuelvo " + comp );
		return comp;
	}
}
