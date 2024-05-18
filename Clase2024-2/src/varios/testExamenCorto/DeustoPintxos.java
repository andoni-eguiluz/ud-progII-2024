package varios.testExamenCorto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DeustoPintxos {
	
	public static Set<Producto> cargarProductosCSV() {
		Set<Producto> productos = new HashSet<Producto>();
		File f = new File("deustopintxos.csv");
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				try {
					productos.add( cargarLineaCSV( linea ) );
				} catch (Exception e) {
					System.out.println( "Error en línea de carga CSV: " + linea );
				}
			}
			sc.close();			
		} catch (FileNotFoundException e) {
			System.err.println("Error al cargar datos: " + e.getMessage());
		}
		return productos;
	}
	
	/** Carga una línea CSV de producto
	 * @param linea	Línea de entrada
	 * @return	Producto creado de acuerdo a esa línea.
	 * @throws ClassNotFoundException	La línea no empieza en uno de los valores de productos conocidos: Bebida,Pintxo,Plato
	 * @throws NumberFormatException	Precio con formato de número double incorrecto
	 * @throws IndexOutOfBoundsException	Insuficientes datos en la línea
	 */
	public static Producto cargarLineaCSV( String linea ) throws ClassNotFoundException, NumberFormatException, IndexOutOfBoundsException {
		Producto nuevo;
		String[] campos = linea.split(",");
		if (campos[0].equals("Bebida")) {
			nuevo = new Bebida(campos[1], Double.parseDouble(campos[2]), Double.parseDouble(campos[3]));
		} else if (campos[0].equals("Pintxo")) {
			nuevo = new Pintxo(campos[1], Double.parseDouble(campos[2]), Boolean.parseBoolean(campos[3]));
		} else if (campos[0].equals("Plato")) {
			ArrayList<String> l = new ArrayList<>();
			for (int i=3; i<campos.length; i++) {
				l.add(campos[i]);
			}
			nuevo = new Plato(campos[1], Double.parseDouble(campos[2]), l);
		} else {
			throw new ClassNotFoundException( "Línea incorrecta: " + linea );
		}
		return nuevo;
	}
	
	public static void generarPedidos(Set<Producto> productos, List<Bar> bares) {
		ArrayList<Producto> lista = new ArrayList<Producto>(productos);
		int c = 10000;
		
		for (Bar bar : bares) {
			// Añadimos 100 pedidos por bar y día
			for (Dia dia: Dia.values()) {
				for (int i = 0; i < 100; i++) {
					Pedido pedido = new Pedido(c, dia);
					
					// Cada pedido tiene 5 productos
					for (int j = 0; j < 5; j++) {
						int alea = (int) (Math.random() * lista.size());
						Producto producto = (Producto) lista.get(alea);
						if (!pedido.getProductos().containsKey(producto)) {
							pedido.getProductos().put(producto, 0);
						}
						pedido.getProductos().replace(producto, pedido.getProductos().get(producto) + 1);
					}
					
					bar.getPedidos().add(pedido);
					c++;					
				}
			}		
			c += 10000;
		}
	}
	
	public static Dia diaMayorRecaudacion(List<Bar> bares) {
		HashMap<Dia, Double> mapa = new HashMap<>();
		
		for (Dia dia : Dia.values()) {
			double totalDia = 0.0;
			for (Bar bar : bares) {
				totalDia += bar.getRecaudacion().get(dia);
			}
			mapa.put(dia, totalDia);
		}
		
		Dia mayorClave = Dia.LUNES;
		double mayorValor = 0.0;
		
		for (Dia dia : mapa.keySet()) {
			double valor = mapa.get(dia);
			if (valor > mayorValor) {
				mayorClave = dia;
				mayorValor = valor;
			}
		}
		
		return mayorClave;
	}
	
	public static void main(String[] args) {
		Set<Producto> productos = new HashSet<Producto>();
		List<Bar> bares = new ArrayList<Bar>();
		
		productos = cargarProductosCSV();
		System.out.println( "Conjunto de productos: " + productos );
		
		// Creamos los 4 bares
		String[] nombres = {"Kupela", "Zaharra", "Sagarra", "Epelde"};
		for (String nombre : nombres) {
			bares.add(new Bar(nombre));
		}
		
		generarPedidos(productos, bares);

		System.out.println(productos);
		System.out.println(bares);
		
//		for (Bar bar : bares) {
//			bar.cobrarPedidos();
//			System.out.println("Recaudacion del bar " + bar.getNombre() + ":" + bar.getRecaudacion());
//		}
//		System.out.println("El dia de mayor recaudacion ha sido el " + diaMayorRecaudacion(bares));
	}

}
