package tema1.resueltos;

public class Ejercicio1_0iConObjetos {
	//	Crea dos arrays, uno con los nombres de 4 o 5 usuarios de cualquier red social que uses,
	//	y otro con sus seguidores. Realiza un programa que muestre por consola esos usuarios 
	//  primero sin ordenar y luego ordenados por número de seguidores 
	//	(de mayor a menor).

	public static void main(String[] args) {
//		String[] usuarios = { "@sama", "@BillGates", "@JeffBezos", "@elonmusk" };
//		int[] seguidores = { 2700, 64300, 63000, 173300 };
		UsuarioRedSocial[] usuariosRS = new UsuarioRedSocial[4];
//		usuariosRS[0] = new UsuarioRedSocial();
//		usuariosRS[0].nombre = "@sama";
//		usuariosRS[0].numSeguidores = 2700;
//		usuariosRS[1] = new UsuarioRedSocial();
//		usuariosRS[1].nombre = "@BillGates";
//		usuariosRS[1].numSeguidores = 64300;
//		usuariosRS[2] = new UsuarioRedSocial();
//		usuariosRS[2].nombre = "@JeffBezos";
//		usuariosRS[2].numSeguidores = 63000;
//		usuariosRS[3] = new UsuarioRedSocial();
//		usuariosRS[3].nombre = "@elonmusk";
//		usuariosRS[3].numSeguidores = 173300;
		usuariosRS[0] = new UsuarioRedSocial( "@sama", 2700 );
		usuariosRS[1] = new UsuarioRedSocial( "@BillGates", 64300 );
		usuariosRS[2] = new UsuarioRedSocial( "@JeffBezos", 63000 );
		usuariosRS[3] = new UsuarioRedSocial( "@elonmusk", 173300 );
		visualizarUsuariosYSeguidores( usuariosRS );
		ordenaUsuariosPorSeguidores( usuariosRS );
		visualizarUsuariosYSeguidores( usuariosRS );
	}
	
	// Visualiza línea a línea usuario tabulador nº seguidores
	private static void visualizarUsuariosYSeguidores(UsuarioRedSocial[] usuarios) {
		for (int i=0; i<usuarios.length; i++) {
			// System.out.println( i );
			if (usuarios[i] != null) {
				System.out.println( usuarios[i].nombre + "\t" + usuarios[i].numSeguidores );
			}
		}
	}
	
	private static void ordenaUsuariosPorSeguidores(UsuarioRedSocial[] usuarios ) {
		for (int pasada=0; pasada<usuarios.length-1; pasada++) {
			for (int comp=0; comp<usuarios.length-1; comp++) {  // TODO mejorar que solo se hagan las comparaciones necesarias
				// boolean hayQueIntercambiar = usuarios[comp].numSeguidores < usuarios[comp+1].numSeguidores;
				boolean hayQueIntercambiar = usuarios[comp].estaMalOrdenadoCon( usuarios[comp+1] );
				if (hayQueIntercambiar) {
//					int aux = seguidores[comp];
//					seguidores[comp] = seguidores[comp+1];
//					seguidores[comp+1] = aux;
					UsuarioRedSocial auxNombre = usuarios[comp];
					usuarios[comp] = usuarios[comp+1];
					usuarios[comp+1] = auxNombre;
				}
			}
		}
	}
	
}
