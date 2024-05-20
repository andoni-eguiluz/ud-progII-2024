package varios.testExamenCortoResuelto;

import static org.junit.Assert.*;

import org.junit.Test;

// TAREA 3 

public class DeustoPintxosTest {

	@Test
	public void testCargarLineaCSV() {
		try {
			Producto p = DeustoPintxos.cargarLineaCSV( "Bebida,Radler,2.0,3.5" );
			assertTrue( p instanceof Bebida );
			assertEquals( "Radler", p.getNombre() );
			assertEquals( 2.0, p.getPrecio(), 0.0000001 );
			p = DeustoPintxos.cargarLineaCSV( "Pintxo,Champi,1.5,true" );
			assertTrue( p instanceof Pintxo );
			assertEquals( "Champi", p.getNombre() );
			assertEquals( 1.5, p.getPrecio(), 0.0000001 );
			p = DeustoPintxos.cargarLineaCSV( "Plato,Huevos,7.5,fritos,estrellados,escalfados" );		
			assertTrue( p instanceof Plato );
			assertEquals( "Huevos", p.getNombre() );
			assertEquals( 7.5, p.getPrecio(), 0.0000001 );
		} catch (Exception e) {
			fail( "No lanza ClassNotFound" );
		}
		try {
			DeustoPintxos.cargarLineaCSV( "Otro,a,1.0,b" );		
			fail( "No lanza ClassNotFound" );
		} catch (ClassNotFoundException e) { // ok
		} catch (Exception e) {
			fail( "Excepción incorrecta" );
		}
		try {
			DeustoPintxos.cargarLineaCSV( "Plato,a,1.a0,b,c,d" );		
			fail( "No lanza NumberFormat" );
		} catch (NumberFormatException e) { // ok
		} catch (Exception e) {
			fail( "Excepción incorrecta" );
		}
		try {
			DeustoPintxos.cargarLineaCSV( "Pintxo,a,1.0" );		
			fail( "No lanza IndexOutOfBounds" );
		} catch (IndexOutOfBoundsException e) { // ok
		} catch (Exception e) {
			fail( "Excepción incorrecta" );
		}
	}
	
}
