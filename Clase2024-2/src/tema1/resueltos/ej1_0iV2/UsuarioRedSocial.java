package tema1.resueltos.ej1_0iV2;

public class UsuarioRedSocial {

    // STATIC
    private static int numUsuariosRS = 0;
    public static int getNumUsuarioRS() {
        return numUsuariosRS;
    }

    // ----------------------------
    // NO STATIC

    private String nombre = "";
    private int numMilesSeguidores = 0; // da igual = 0 que nada
    // Más atributos?
    // private int numSeguidos - pu get - pu set
    // private String email - pu get - pu set
    // private String dni - pu get - no set - habría que añadirlo en algún constructor 
    // ingresosMensuales (suponer 2€*num seguidores)
    //   pu getIngresosMensuales() sin atributo
    // numUsuariosRS??

    /** Crea un nuevo usuario
     * @param nombre    Nombre de ese usuario
     * @param numMilesSeguidores Número de seguidores, en miles
     */
    public UsuarioRedSocial( String nombre, int numMilesSeguidores ) {
        this.nombre = nombre;
        this.setNumMilesSeguidores( numMilesSeguidores );
        UsuarioRedSocial.numUsuariosRS++;
    }

    /** Crea un nuevo usuario de red social con 0 seguidores
     * @param nombre    Nombre del nuevo usuario
     */
    public UsuarioRedSocial( String nombre ) {
        this.nombre = nombre;
        this.setNumMilesSeguidores( 0 );
        UsuarioRedSocial.numUsuariosRS++;
    }

    /** Compara los seguidores de este usuario y otro
     * @param u2    Segundo usuario que comparar
     * @return  true si this tiene menos seguidores que u2, false en caso contrario
     */
    public boolean tieneMenosSeguidoresQue( UsuarioRedSocial u2 ) {
        return this.numMilesSeguidores < u2.numMilesSeguidores;
    }

    /** Convierte a string el usuario, con su nombre, tabulador y sus seguidores
     * @return  String formateado
     */
    public String toString() {
        return this.nombre + "\t" + this.numMilesSeguidores;
    }

    public String getNombre() {
        return this.nombre;
    }

    // Si nombre es inmutable, nos vale con no publicar set
    // /** Modifica el nombre del usuario
    //  * @param nombre    Nuevo nombre
    //  */
    // public void setNombre( String nombre ) {
    //     this.nombre = nombre;
    // }

    public int getNumMilesSeguidores() {
        return numMilesSeguidores;
    }

    public void setNumMilesSeguidores( int numMilesSeguidores ) {
        this.numMilesSeguidores = numMilesSeguidores;
        if (this.numMilesSeguidores < 0) {
            this.numMilesSeguidores = 0;
            System.out.println( "Error en cambio de usuario: seguidores negativos" );
        }
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        UsuarioRedSocial usuario2 = (UsuarioRedSocial) obj; ///!!!!OJO
        return this.nombre.equals( usuario2.nombre );
    }

}
