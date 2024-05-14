package tema5.ejemplos;

import static org.junit.Assert.*;
import org.junit.Test;

public class ClaseStaticTest {

	@Test
	public void testMcd() {
    	// System.out.println( ClaseStatic.mcd( 15, 25 ) );
    	// System.out.println( ClaseStatic.mcd( 18, 24 ) );
    	// System.out.println( ClaseStatic.mcd( 17, 23 ) );
		assertEquals( 5, ClaseStatic.mcd( 35, 5 ) );
		assertEquals( 5, ClaseStatic.mcd( 5, 35 ) );
		assertEquals( 5, ClaseStatic.mcd( 25, 15 ) );
		assertEquals( 5, ClaseStatic.mcd( 15, 25 ) );
		assertEquals( 10, ClaseStatic.mcd( 30, 50 ) );
		assertEquals( 20, ClaseStatic.mcd( 60, 100 ) );
		assertEquals( 6, ClaseStatic.mcd( 18, 24 ) );
		assertEquals( 1, ClaseStatic.mcd( 17, 23 ) );
		assertEquals( 1, ClaseStatic.mcd( 1, 1 ) );
		assertEquals( 1, ClaseStatic.mcd( 7, 1 ) );
		assertEquals( 1, ClaseStatic.mcd( 1, 7 ) );
		assertEquals( 6, ClaseStatic.mcd( 18, -24 ) );
		assertEquals( 6, ClaseStatic.mcd( -18, 24 ) );
		assertEquals( 6, ClaseStatic.mcd( -18, -24 ) );
		assertEquals( 1, ClaseStatic.mcd( -7, 1 ) );
		assertEquals( 7, ClaseStatic.mcd( 7, 0 ) );
		assertEquals( 7, ClaseStatic.mcd( 0, 7 ) );
		assertEquals( 1, ClaseStatic.mcd( 0, 1 ) );
		assertEquals( 28, ClaseStatic.mcd( 0, -28 ) );
		assertEquals( 1, ClaseStatic.mcd( 0, 0 ) );
	}
	
	@Test
	public void test2() {
    	System.out.println( ClaseStatic.mcd( 17, 23 ) );
    }

}
