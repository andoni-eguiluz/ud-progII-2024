package tema1c.interfacesAvanzados;

public interface B extends InterfazConDefault {
	@Override
	default int comportamiento2() {
		return -3;
	}
}
