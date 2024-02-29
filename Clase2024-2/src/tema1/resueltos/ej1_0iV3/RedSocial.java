package tema1.resueltos.ej1_0iV3;

import java.util.ArrayList;

public class RedSocial {
	private ArrayList<UsuarioRedSocial> usuariosRS;
	private String nombre;
	private String urlPrincipal;
	
	
	/** Crea una red social nueva, SIN USUARIOS
	 * @param nombre	El nombre de esa red social
	 * @param urlPrincipal	Su dirección de internet
	 */
	public RedSocial(String nombre, String urlPrincipal) {
		this.nombre = nombre;
		this.urlPrincipal = urlPrincipal;
		this.usuariosRS = new ArrayList<UsuarioRedSocial>();
	}
	
	public void anyadir( UsuarioRedSocial usuario ) {
		usuariosRS.add( usuario );
	}
	
	/** Visualiza en consola de salida slínea a línea usuario tabulador nº seguidores
	 */
	public void visualizarUsuariosYSeguidores() {
		for (int i=0; i<usuariosRS.size(); i++) {
			if (usuariosRS.get(i) != null) {
				System.out.println( usuariosRS.get(i).toString() );	
			}
		}
	}
	
	/** Ordena los usuarios de la RS por n. seguidores de mayor a menor
	 */
	public void ordenaUsuariosPorSeguidores() {
		for (int pasada=0; pasada<usuariosRS.size()-1; pasada++) {
			for (int comp=0; comp<usuariosRS.size()-1; comp++) {  // TODO mejorar que solo se hagan las comparaciones necesarias
				// boolean hayQueIntercambiar = usuarios[comp].numSeguidores < usuarios[comp+1].numSeguidores;
				boolean hayQueIntercambiar = usuariosRS.get(comp).tieneMenosSeguidoresQue( usuariosRS.get(comp+1) );
				if (hayQueIntercambiar) {
					UsuarioRedSocial auxNombre = usuariosRS.get(comp);
					usuariosRS.set( comp, usuariosRS.get(comp+1) );
					usuariosRS.set( comp+1, auxNombre );
				}
			}
		}
	}
	

	/** Busca un usuario en la red social
	 * @param usuario	Usuario a buscar
	 * @return	Devuelve la posición 0 - n-1 en la que está, -1 si no se encuentra
	 */
	public int buscar( UsuarioRedSocial usuario ) {
		return usuariosRS.indexOf(usuario);
	}
	
}
