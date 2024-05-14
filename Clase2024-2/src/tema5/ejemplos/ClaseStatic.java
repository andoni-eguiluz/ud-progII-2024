package tema5.ejemplos;

public class ClaseStatic {
	
    /** Calcula y devuelve el máximo común divisor de dos números
     * Si los números son negativos, se consideran como si fueran positivos.
     * Si algún número es cero, el MCD es el otro número en positivo.
     * Si los dos números son cero, el MCD se considera +1.
     * @param num1	Primer número
     * @param num2	Segundo número
     * @return	Devuelve el mayor entero positivo que divide exactamente a ambos
     */
    public static int mcd( int num1, int num2 ) {
        int mayor = Math.abs( Math.max( num1, num2 ) );
        int menor = Math.abs( Math.min( num1, num2 ) );
        if (menor==0) {
        	if (mayor==0) {
        		return 1;
        	}
        	return mayor;
        }
        do {
            int restoMayorEntreMenor = mayor % menor;
            if (restoMayorEntreMenor == 0) {
                return menor;
            }
            mayor = menor;
            menor = restoMayorEntreMenor; 
        } while (true);
    } 

    /** Método de prueba
     * @param args
     */
    public static void main(String[] args) {
    	System.out.println( ClaseStatic.mcd( 15, 25 ) );
    	System.out.println( ClaseStatic.mcd( 18, 24 ) );
    	System.out.println( ClaseStatic.mcd( 17, 23 ) );
    }
    
}
