package tema1.resueltos.ej1_0iV3;

import javax.swing.JOptionPane;

public class Ejercicio1_0iConObjetos {

	private static RedSocial x;
	private static RedSocial instagram;
	
	public static void main(String[] args) {
		System.out.println( UsuarioRedSocial.getNumUsuarioRS() );
		x = new RedSocial( "x", "x.com" );
		x.anyadir( new UsuarioRedSocial( "@sams", 1300 ) );
		x.anyadir( new UsuarioRedSocial( "@JeffBezos", 61000 ) );
		x.anyadir( new UsuarioRedSocial( "@BillGates", 62000 ) );
		x.anyadir( new UsuarioRedSocial( "@elonmusk", 128900 ) );
		x.visualizarUsuariosYSeguidores();
		x.ordenaUsuariosPorSeguidores();
		x.visualizarUsuariosYSeguidores();
		System.out.println( UsuarioRedSocial.getNumUsuarioRS() );

		// Añadir usuarios
		x.anyadir( new UsuarioRedSocial( "Andoni" ) );
		x.ordenaUsuariosPorSeguidores();
		x.visualizarUsuariosYSeguidores();
		// Buscar usuario
		UsuarioRedSocial usuarioABuscar = new UsuarioRedSocial( "@BillGates", 62000 );
//		System.err.println( "Está bill gates? " + usuariosRS.contains( usuarioABuscar ) );
		System.out.println( "En qué posición? " + x.buscar( usuarioABuscar ) );
		
		// Trabajo con instagram
		instagram = new RedSocial( "instagram", "instagram.com" );
		instagram.anyadir( new UsuarioRedSocial( "sama", 6 ) );
		instagram.anyadir( new UsuarioRedSocial( "thisisbillgates", 9000 ) );
		
		instagram.visualizarUsuariosYSeguidores();
		
		// Interacción
		interaccion();
	}
	
	private static void interaccion() {
		// x.visualizarUsuariosYSeguidores();
		Object resp = JOptionPane.showInputDialog( null, "Selecciona red social", "Inicio",
				JOptionPane.QUESTION_MESSAGE, null, 
				new Object[] { "X", "Instagram" }, "X" );
		System.out.println( resp );
		if ("X".equals(resp)) {
			// x
			// System.out.println( "en x" );
			menu( x );
		} else if ("Instagram".equals(resp)) {
			// instagram
			menu( instagram );
		} else {
			// acabar
			JOptionPane.showMessageDialog( null, "Fin de programa" );
		}
	}
	
	private static void menu( RedSocial rs ) {
		boolean acabar = false;
		do {
			Object resp = JOptionPane.showInputDialog( null, "Elige opción", "¿Qué quieres hacer?", JOptionPane.QUESTION_MESSAGE, null,
					new Object[] { "Añadir", "Buscar", "Borrar", "Ver" }, "Añadir" );
			if ("Añadir".equals(resp)) {
				anyadir( rs );
			} else if ("Buscar".equals(resp)) {
				buscar( rs );
			} else if ("Borrar".equals(resp)) {
				borrar( rs );
			} else if ("Ver".equals(resp)) {
				ver( rs );
			} else {
				acabar = true;
			}
		} while (!acabar);
	}
	
	private static void anyadir( RedSocial rs ) {
		String resp = JOptionPane.showInputDialog( null, "Introduce nombre nuevo usuario:" );
		String resp2 = JOptionPane.showInputDialog( null, "Introduce nº de seguidores de nuevo usuario (en miles):" );
		int seguidores = Integer.parseInt( resp2 );
		rs.anyadir( new UsuarioRedSocial( resp, seguidores ) );
		System.out.println( "Añadido nuevo usuario: " + rs );
	}

	private static void buscar( RedSocial rs ) {
		String resp = JOptionPane.showInputDialog( null, "Introduce nombre usuario a buscar:" );
		JOptionPane.showMessageDialog( null, "El usuario " + resp 
				+ (rs.buscar( new UsuarioRedSocial(resp) )!=-1 ? " SÍ " : " NO ")
				+ "está en la red social" );
	}

	private static void borrar( RedSocial rs ) {
		String resp = JOptionPane.showInputDialog( null, "Introduce nombre usuario a borrar:" );
		rs.borrar( new UsuarioRedSocial( resp ) );
		System.out.println( "El usuario " + resp + " ha sido borrado (si existía)." );
	}
	
	private static void ver( RedSocial rs ) {
		String visu = "";
		for (int i=0; i<rs.tamanyo(); i++) {
			UsuarioRedSocial u = rs.get(i);
			visu += u.toString() + "\n";
		}
		JOptionPane.showMessageDialog( null, visu );
	}
	
}
