package tema3.resueltos.ej3_8;

import java.util.*;

/** Clase contenedora para el ejercicio 3.8
 * @author andoni.eguiluz @ ingenieria.deusto.es
 *
 */
public class GestorAgentes {
	
	// Estructura de datos
	private HashMap<Integer,TreeMap<String,TreeSet<Agente>>> mapaAgentes;
	
	/** Crea un gestor de agentes comerciales
	 */
	public GestorAgentes() {
		mapaAgentes = new HashMap<>();
	}
	
    /** Añade datos de un agente al gestor
	 * @param datosAgente	Datos del agente en formato
           "pp#localidad#agente#dni" donde pp es el código numérico de la provincia
            (entero de 1 a 52, según el código postal
	 	Si el dato es incorrecto, no se añade nada.
	 */
    public void anyadirAgente( String datosAgente ) {
        StringTokenizer st = new StringTokenizer( datosAgente, "#" );
        int prov = Integer.parseInt( st.nextToken() );
        String loc = st.nextToken();
        String nombreAgente = st.nextToken();
        String dni = st.nextToken();
        Agente agente = new Agente( prov, loc, nombreAgente, dni );
        if (!mapaAgentes.containsKey(prov)) {
            mapaAgentes.put( prov, new TreeMap<>() );
        }
        // Se puede hacer así...
        TreeMap<String,TreeSet<Agente>> mapa2 = mapaAgentes.get( prov );
        if (!mapa2.containsKey(loc)) {
            mapa2.put( loc, new TreeSet<>() );
        }
        TreeSet<Agente> conjAgentes = mapa2.get( loc );
        conjAgentes.add( agente );
        // O así:
        // if (!mapaAgentes.get(prov).containsKey(loc)) {
        //     mapaAgentes.get(prov).put( loc, new TreeSet<>() );
        // }
        // mapaAgentes.get(prov).get(loc).add( agente );
    }

    /** Devuelve la colección de códigos de provincias donde hay agentes, sin orden
	 * @return	Colección de códigos enteros
	 */
	// public HashSet<Integer> getProvincias() {
    //     return (HashSet<Integer>) mapaAgentes.keySet();
    // }
	public Collection<Integer> getProvincias() {
        return mapaAgentes.keySet();
    }

    /** Devuelve el conjunto de ciudades de una provincia en orden alfabético 
	 * @param provincia	Código de provincia (de 1 a 52)
	 * @return	Conjunto de ciudades de esa provincia, vacío si no hay 
            ninguna ciudad en esa provincia
	 */
	public Set<String> getCiudades( int provincia ) {
        if (mapaAgentes.containsKey(provincia)) {
        // if (mapaAgentes.get(provincia)!=null) {
            return mapaAgentes.get(provincia).keySet();
        } else {
            return new TreeSet<>();
        }
    }

    /** Devuelve la colección de agentes de una provincia y ciudad, en orden
	 * @param provincia	Código de provincia
	 * @param ciudad	Nombre de ciudad
	 * @return	Colección de agentes de esa ciudad y provincia, en orden alfabético
            de nombre de agente. Vacío si no hay agentes en esa ciudad/prov
	 */
	public Collection<Agente> getAgentes( int provincia, String ciudad ) {
        if (!mapaAgentes.containsKey(provincia)) {
            return new TreeSet<>();
        }
        if (!mapaAgentes.get(provincia).containsKey(ciudad)) {
            return new TreeSet<>();
        }
        return mapaAgentes.get(provincia).get(ciudad);
    }

    /** Saca a consola la lista de agentes agrupada por provincia y ordenada por ciudad
     en el formato:
	 * pp:	Ciudad-1:  agente 1, agente 2, agente 3...
	 * 		Ciudad-2:  agente 1, agente 2...
	 * 		...
	 * pp:	Ciudad-1:  agente 1, agente 2...
	 */
	public void informeAgentes() {
        for (int prov : mapaAgentes.keySet()) {
            // TreeMap<String,TreeSet<Agente>> mapa2 = mapaAgentes.get(prov);
            System.out.print( prov + ":\t" );
            boolean primeraCiudad = true;
            for (String ciudad : mapaAgentes.get(prov).keySet()) {
                if (primeraCiudad) {
                    primeraCiudad = false;
                } else {
                    System.out.print( "\t" );
                }
                System.out.print( ciudad + ": " );
                for (Agente agente : mapaAgentes.get(prov).get(ciudad)) {
                    System.out.println( agente );
                }
            }
        }
    }
	
}
