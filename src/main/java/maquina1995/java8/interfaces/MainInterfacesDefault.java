package maquina1995.java8.interfaces;

public class MainInterfacesDefault {

    public static void main(String... args) {

	// Se hace un new del objeto para no estar con tonterías de statics
	Ejemplo ejemplo = new Ejemplo();

	// Metodo normal de una interfaz
	ejemplo.sumarDoubles(2D, 3D);

	// Llamada al metodo default
	ejemplo.sumarEnteros(5, 5);

    }
}
