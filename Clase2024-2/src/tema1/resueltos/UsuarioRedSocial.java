package tema1.resueltos;

public class UsuarioRedSocial {
	
// STATIC
	
	private static int numUsuariosTotales = 0;
	
	public static int getNumUsuariosTotales() {
//		System.out.println( this.nombre );  no se puede!
		return numUsuariosTotales;
	}

	
	
	
// NO STATIC	
	
	private String nombre;
	private int numMilesSeguidores;
	
//	public UsuarioRedSocial() {
//		
//	}
	
	/** Crea un nuevo usuario
	 * @param nombre	Nombre de ese usuario
	 * @param numMilesSeguidores	Número de seguidores (en miles)
	 */
	public UsuarioRedSocial( String nombre, int numMilesSeguidores ) {
		this.nombre = nombre;
		this.numMilesSeguidores = numMilesSeguidores;
		UsuarioRedSocial.numUsuariosTotales++;
	}
	
	/** Crea un nuevo usuario con 0 seguidores
	 * @param nombre	Nombre del nuevo usuario
	 */
	public UsuarioRedSocial( String nombre ) {
		this.nombre = nombre;
		this.numMilesSeguidores = 0; // Da igual que no ponerlo
		numUsuariosTotales++;
	}
	
	// No se podría: sobrecarga no permite misma signatura
//	public UsuarioRedSocial( String url ) {
//		
//	}
	
	/** Compara el usuario this con otro e informa de su diferencia en seguidores
	 * @param usuario	Segundo usuario
	 * @return	true si this tiene menos seguidores que usuario, false en caso contrario
	 */
	public boolean estaMalOrdenadoCon( UsuarioRedSocial usuario ) {
		return numMilesSeguidores < usuario.numMilesSeguidores;
	}
	
	public String toString() {
		// return this.nombre + "\t" + this.numMilesSeguidores;
		return nombre + "\t" + numMilesSeguidores;
	}

	public String getNombre() {
		return this.nombre;
	}
	
//	public void setNombre( String nombre ) {
//		this.nombre = nombre;
//	}
	
	public int getNumMilesSeguidores() {
		return numMilesSeguidores;
	}
	
	public void setNumMilesSeguidores( int numMilesSeguidores ) {
		this.numMilesSeguidores = numMilesSeguidores;
		if (this.numMilesSeguidores < 0) {
			this.numMilesSeguidores = 0;
			System.out.println( "Error: intento de poner seguidores negativos");
		}
	}
	
	
}
