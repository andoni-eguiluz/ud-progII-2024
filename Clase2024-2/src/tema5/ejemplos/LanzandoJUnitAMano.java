package tema5.ejemplos;

import org.junit.runner.*;
import org.junit.runner.notification.Failure;

/** Ejemplo de cómo se puede lanzar JUnit desde un main normal (en lugar de que lo haga el IDE)
 * @author andoni.eguiluz at ingenieria.deusto.es
 */
public class LanzandoJUnitAMano {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(
			ClaseStaticTest.class 
		);
		for (Failure failure:result.getFailures()) {
			System.out.println( "Fallo: " + failure.toString() );
			System.out.println( "   Detalles: " + failure.getTrace() );
		}
		if (result.wasSuccessful()){
			System.out.println("Tests ok! ");
		}  
	}

}
