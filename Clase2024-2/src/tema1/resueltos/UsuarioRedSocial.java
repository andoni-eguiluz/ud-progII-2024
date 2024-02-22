package tema1.resueltos;

public class UsuarioRedSocial {
	public String nombre;
	public int numSeguidores;
	
//	public UsuarioRedSocial() {
//		
//	}
	
	public UsuarioRedSocial( String nombre, int numSeguidores ) {
		this.nombre = nombre;
		this.numSeguidores = numSeguidores;
	}
	
	public UsuarioRedSocial( String nombre ) {
		this.nombre = nombre;
		this.numSeguidores = 0; // Da igual que no ponerlo
	}
	
//	public UsuarioRedSocial( String url ) {
//		
//	}
	
	public boolean estaMalOrdenadoCon( UsuarioRedSocial usuario ) {
		return numSeguidores < usuario.numSeguidores;
	}
	
}
