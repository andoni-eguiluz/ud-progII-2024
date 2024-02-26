package tema1.basicos;

/** Ejemplo para entender el funcionamiento del método finalize
 */
public class EntendiendoFinalize {
    public static void main(String[] args) {
        // Creamos 6 objetos que se pierden de la misma...
        t();
        t();
        t();
        t();
        t();
        t();
        System.out.println( "fin" );
        // Si acabáramos aquí, nadie los destruiría
        // Pero si llamamos al recolector de basura y esperamos un pelín...
        // ¿Qué pasa?
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }

    private static void t() {
        B b = new B();
    }

    private static class B {
        private static int cont = 0;
        private int num;
        public B() {
            cont++;
            num = cont;
            System.out.println( "Nuevo b: " + num );
        }

        // Método al que llama Java cuando un método desaparece de memoria
        // Normalmente no hay que definirlo, solo si la desaparición de 
        // ese objeto debe afectar en algún otro lugar
        @Override
        protected void finalize() throws Throwable {
            System.out.println( "Quitando objeto b: " + num );
            super.finalize();
        }
    }
}
