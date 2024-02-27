package tema1.resueltos.ej1_0iV2;

import java.util.ArrayList;

public class Ejercicio1_0iConObjetos {

	public static void main(String[] args) {
		System.out.println( UsuarioRedSocial.getNumUsuarioRS() );
		// UsuarioRedSocial[] usuariosRS = new UsuarioRedSocial[4];
		// usuariosRS[0] = new UsuarioRedSocial( "@sams", 1300 );
		// usuariosRS[1] = new UsuarioRedSocial( "@JeffBezos", 61000 );
		// usuariosRS[2] = new UsuarioRedSocial( "@BillGates", 62000 );
		// usuariosRS[3] = new UsuarioRedSocial( "@elonmusk", 128900 );
		// Rehacer con arraylists:
		ArrayList<UsuarioRedSocial> usuariosRS = new ArrayList<>();
		usuariosRS.add( new UsuarioRedSocial( "@sams", 1300 ) );
		usuariosRS.add( new UsuarioRedSocial( "@JeffBezos", 61000 ) );
		usuariosRS.add( new UsuarioRedSocial( "@BillGates", 62000 ) );
		usuariosRS.add( new UsuarioRedSocial( "@elonmusk", 128900 ) );
		visualizarUsuariosYSeguidores( usuariosRS );
		ordenaUsuariosPorSeguidores( usuariosRS );
		visualizarUsuariosYSeguidores( usuariosRS );
		System.out.println( UsuarioRedSocial.getNumUsuarioRS() );

		// Añadir usuarios
		usuariosRS.add( new UsuarioRedSocial( "Andoni" ) );
		ordenaUsuariosPorSeguidores( usuariosRS );
		visualizarUsuariosYSeguidores( usuariosRS );
		// Buscar usuario
		UsuarioRedSocial usuarioABuscar = new UsuarioRedSocial( "@BillGates", 62000 );
		System.err.println( "Está bill gates? " + usuariosRS.contains( usuarioABuscar ) );
		System.out.println( "En qué posición? " + usuariosRS.indexOf( usuarioABuscar ) );
	}

	private static void bajaSeguidores( int numBaja, UsuarioRedSocial[] usuarios ) {
		for (int i=0; i<usuarios.length; i++) {
			usuarios[i].setNumMilesSeguidores( usuarios[i].getNumMilesSeguidores() + numBaja );
		}
	}
	
	// Visualiza línea a línea usuario tabulador nº seguidores
	private static void visualizarUsuariosYSeguidores( ArrayList<UsuarioRedSocial> usuarios ) {
		for (int i=0; i<usuarios.size(); i++) {
			if (usuarios.get(i) != null) {
				System.out.println( usuarios.get(i).toString() );	
			}
		}
	}
	
	private static void ordenaUsuariosPorSeguidores( ArrayList<UsuarioRedSocial> usuarios ) {
		for (int pasada=0; pasada<usuarios.size()-1; pasada++) {
			for (int comp=0; comp<usuarios.size()-1; comp++) {  // TODO mejorar que solo se hagan las comparaciones necesarias
				// boolean hayQueIntercambiar = usuarios[comp].numSeguidores < usuarios[comp+1].numSeguidores;
				boolean hayQueIntercambiar = usuarios.get(comp).tieneMenosSeguidoresQue( usuarios.get(comp+1) );
				if (hayQueIntercambiar) {
					UsuarioRedSocial auxNombre = usuarios.get(comp);
					usuarios.set( comp, usuarios.get(comp+1) );
					usuarios.set( comp+1, auxNombre );
				}
			}
		}
	}
	
}
