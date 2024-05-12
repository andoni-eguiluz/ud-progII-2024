package tema5.ejemplos;

public class ClaseStatic {
    public static int mcd( int num1, int num2 ) {
        int mayor = Math.max( num1, num2 );
        int menor = Math.min( num1, num2 );
        do {
            int restoMayorEntreMenor = mayor % menor;
            if (restoMayorEntreMenor == 0) {
                return menor;
            }
            mayor = menor;
            menor = restoMayorEntreMenor; 
        } while (true);
    } 

    public static void main(String[] args) {
    }
}
