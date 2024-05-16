package tema5.ejemplos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ScoresTest {

	@Test
	public void testGetUsuariosFieles() {
		Scores scores = new Scores();
		scores.addScore( "a", 7 );
		scores.addScore( "a", 9 );
		scores.addScore( "a", 3 );
		scores.addScore( "bb", 13 );
		scores.addScore( "bb", 11 );
		scores.addScore( "sss", 25 );
		scores.addScore( "b", 2 );
		List<String> l = scores.getUsuariosFieles();		
		// Pruebas poquito a poco...
		assertEquals( 4, l.size() );
		assertEquals( "a", l.get(0) );
		assertEquals( "bb", l.get(1) );
		assertEquals( "b", l.get(2) );
		assertEquals( "sss", l.get(3) );
		// ...o de un solo paso:
		assertEquals( new ArrayList<>( Arrays.asList( "a", "bb", "b", "sss" ) )
				,l);
		
		
		
		scores.addScore( "sss", 10 );
		l = scores.getUsuariosFieles();		
		assertEquals( new ArrayList<>( Arrays.asList( "a", "bb", "sss", "b" ) )
				,l);
	}

}
