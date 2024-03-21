package tema1c.basicos;

public class EjemploInterfaces {

}

interface Fregable {
	void fregar();  // por defecto es public y es abstract
}

interface Rompible {
	boolean estaRoto();
}

interface Lavavajilleable extends Fregable {
	// void fregar();
	void meterEnLavavajillas();
}