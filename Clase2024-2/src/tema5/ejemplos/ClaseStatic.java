package tema5.ejemplos;

public class ClaseStatic {
    public static int mcd( int num1, int num2 ) {
        do {
            int mayor = Math.abs( Math.max( num1, num2 ) );
            int menor = Math.abs( Math.min( num1, num2 ) );
            int restoMayorEntreMenor = mayor % menor;
            if (restoMayorEntreMenor == 0) {
                return menor;
            }
            num1 = menor;
            num2 = restoMayorEntreMenor; 
        } while (true);
    } 

    public static void main(String[] args) {
    }
}
