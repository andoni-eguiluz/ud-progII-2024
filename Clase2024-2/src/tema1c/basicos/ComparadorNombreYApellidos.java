package tema1c.basicos;

import java.util.Comparator;

public class ComparadorNombreYApellidos implements Comparator<Persona> {

	@Override
	public int compare(Persona o1, Persona o2) {
		// String nom = o1.getNombre();
		// String may = nom.toUpperCase();
		System.out.println( o1 + " / " + o2 );
		int ret = o1.getNombre().toUpperCase().compareTo( o2.getNombre().toUpperCase() );
		if (ret == 0) {
			return o1.getApellidos().toUpperCase().compareTo( o2.getApellidos().toUpperCase() );
		} else {
			return ret;
		}
	}

}
