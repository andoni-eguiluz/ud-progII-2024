package tema1.resueltos;

/** Resolución de algunos apartados del ejercicio 1.0.
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class Ejercicio1_0 {

	public static void main(String[] args) {
		ejercicio1_0_b();
		System.out.println();
		ejercicioTablaMultiplicar();  // 1.0.c
		System.out.println();
		ejercicio1_0_d();
	}
	
	private static void ejercicio1_0_b() {
		// [Métodos sobrecargados] Define un método que calcule el máximo común divisor de dos números 
		// y pruébalo desde un main. 
		// Define otro método con el mismo nombre que calcule el máximo común divisor de tres números, 
		// y pruébalo también desde el main.
		System.out.println( "MCD 70, 28 = " + mcd(70, 28) );
		System.out.println( "MCD 70, 28, 140 = " + mcd(70, 28, 140) );
	}
	
	private static int mcd( int num1, int num2 ) {
		int mcd = 1;
		for (int i=2; i<Math.min(num1, num2); i++) {
			if (num1 % i == 0 && num2 % i == 0) {
				mcd = i;
			}
		}
		return mcd;
		// TODO algoritmo mejorable... ¿no?  O:-)
	}

	private static int mcd( int num1, int num2, int num3 ) {
		int mcd = 1;
		for (int i=2; i<Math.min(Math.min(num1, num2), num3); i++) {
			if (num1 % i == 0 && num2 % i == 0 && num3 % i == 0) {
				mcd = i;
			}
		}
		return mcd;
	}

	// Ejercicio 1.0.c
	private static void ejercicioTablaMultiplicar() {
		cabecera();
		for (int i=0; i<10; i++) {
			System.out.print( "Tabla de " + i ); 
			for (int j=0; j<10; j++) {
				String espacios = " ";
				if (i*j<10) espacios = "  ";
				System.out.print( espacios + i*j ); 
			}
			System.out.println();
		}
	}
		// Saca a consola la cabecera de la tabla de multiplicar
		private static void cabecera() {
			System.out.print( "          " );
			for (int j=0; j<10; j++) {
				System.out.print( "  " + j ); 
			}
			System.out.println();
			System.out.println( "           -----------------------------" );
		}

	// Ejercicio 1.0.d
	// Define un método primo que informe si un número entero (recibido como parámetro) 
	// es primo o no. Utiliza ese método desde el main para visualizar en consola 
	// todos los números primos entre 1 y 100.
	private static void ejercicio1_0_d() {
		System.out.println( "Lista de números primos:" );
		for (int i=1; i<=100; i++) {
			if (primo(i)) {
				System.out.println( i );
			}
		}
	}
	private static boolean primo( int num ) {
		boolean esPrimo = true;
		for (int divisor=2; divisor<num; divisor++) {  // Un número es primo si no es divisible por ninguno de 2 al num-1
			if (num % divisor == 0) {
				esPrimo = false;
				break;
			}
		}
		return esPrimo;
	}
	
	

}
