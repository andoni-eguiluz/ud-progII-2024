package tema5.ejemplos;

import static org.junit.Assert.*;

import org.junit.Test;

public class FraccionTest {

	@Test
	public void testFraccion() {
		Fraccion f = new Fraccion( 1, 2 );
		// System.out.println( "Numerador = " + f.num );
		assertEquals( 1, f.num );
		assertEquals( 2, f.den );
		f = new Fraccion( -1, 5 );
		assertEquals( -1, f.num );
		assertEquals( 5, f.den );
		f = new Fraccion( 0, 4 );
		assertEquals( 0, f.num );
		assertEquals( 4, f.den );
		f = new Fraccion( 3, 6 );
		assertEquals( 3, f.num );
		assertEquals( 6, f.den );
	}
	
	@Test
	public void testFraccionExcepcion() {
		try {
			new Fraccion( 5, 0 );
			fail( "No se está generando una ArithmeticE por den 0" );
		} catch (ArithmeticException e) {
			// ok
		}
	}
	
	
	@Test
	public void testSuma() {
		Fraccion f1 = new Fraccion( 1, 2 );
		Fraccion f2 = new Fraccion( 2, 5 );
		Fraccion f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(9,10), f3 );

		f1 = new Fraccion( 1, 4 );
		f2 = new Fraccion( 1, 4 );
		f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(1,2), f3 );
		
		f1 = new Fraccion( 1, 2 );
		f2 = new Fraccion( -1, 2 );
		f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(0,2), f3 );
		
		f1 = new Fraccion( 3, 8 );
		f2 = new Fraccion( 0, 2 );
		f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(3,8), f3 );

		f1 = new Fraccion( 0, 2 );
		f2 = new Fraccion( 3, 8 );
		f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(3,8), f3 );
		
		f1 = new Fraccion( -1, 2 );
		f2 = new Fraccion( -1, 3 );
		f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(-5,6), f3 );

		f1 = new Fraccion( 1, -2 );
		f2 = new Fraccion( 1, -3 );
		f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(-5,6), f3 );
		
		f1 = new Fraccion( -1, -2 );
		f2 = new Fraccion( -1, -3 );
		f3 = Fraccion.suma( f1, f2 );
		assertEquals( new Fraccion(5,6), f3 );
	}
	
	@Test
	public void testSumaException() {
		try {
			Fraccion res = Fraccion.suma( null, new Fraccion(1,2));
			fail();
		} catch (NullPointerException e) {
			// assert salta algo? no hace falta
		}
	}

	public void testDivideException() {
		try {
			Fraccion.divide( new Fraccion(1,2), new Fraccion(0,5));
			fail( "División f positiva por fracción 0" );
		} catch (ArithmeticException e) {
		}
		try {
			Fraccion.divide( new Fraccion(-1,2), new Fraccion(0,5));
			fail( "División f negativa por fracción 0" );
		} catch (ArithmeticException e) {
		}
		
		for (int i=1; i<=100; i++) {
			try {
				Fraccion.divide( new Fraccion(0,i), new Fraccion(0,5));
				fail( "División fracción 0 por fracción 0" );
			} catch (ArithmeticException e) {
			}
		}
	}
	
}
