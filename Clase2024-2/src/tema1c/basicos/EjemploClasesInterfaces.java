package tema1c.basicos;

import java.util.ArrayList;

public class EjemploClasesInterfaces {
	public static void main(String[] args) {
		Fregable[] arrayFreg;
		ArrayList<Fregable> listaFreg = new ArrayList<>();
		Fregable freg;
		// NO new Fregable();
		listaFreg.add( new Tenedor() );
		listaFreg.add( new Vaso() );
		listaFreg.add( new CopaChampan() );
		// listaFreg.add( "" );
		for (Fregable f : listaFreg) {
			f.fregar();
			if (f instanceof Vaso) {
				// lo que sea
			}
		}
	}
}

class Tenedor implements Fregable {
	@Override
	public void fregar() {
		System.out.println( "3 pasadas de estropajo" );
	}
}

abstract class Cristaleria implements Fregable, Rompible {
	
}

class Vaso extends Cristaleria implements Lavavajilleable {  // implements Fregable, Rompible
	@Override
	public void fregar() {
		System.out.println( "pasar estropajo con los deditos" );
	}
	@Override
	public boolean estaRoto() {
		return false;  // TODO implementar lógica de rotura
	}
	@Override
	public void meterEnLavavajillas() {
		System.out.println( "bla bla bla" );
	}
}

class CopaChampan extends Cristaleria implements Fregable, Rompible {
	@Override
	public void fregar() {
		System.out.println( "pasar estropajo con cuidadín" );
	}
	@Override
	public boolean estaRoto() {
		return true;  // TODO implementar lógica de rotura
	}
}
