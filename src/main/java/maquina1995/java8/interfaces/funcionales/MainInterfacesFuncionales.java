package maquina1995.java8.interfaces.funcionales;

import java.util.logging.Logger;

/**
 * Main usado para la visualizacion de ejemplos sobre lambdas
 * 
 * @author MaQui1995
 *
 */
public class MainInterfacesFuncionales {

    /**
     * Log generico de java
     */
    private static final Logger LOGGER = Logger.getLogger(MainInterfacesFuncionales.class.getName());

    /**
     * Metodo usado para la ejecucion del programa puedes comentar los metodos para
     * ejecutar los que te interesen
     * 
     * @param args las distintas @see java.lang.String que pueden pasarse al
     *             programa
     */
    public static void main(String[] args) {

	ejecutarEjemploCalculadora();
	ejecutarEjemploCadenas();

    }

    /**
     * 
     * Ejecuta el ejemplo en el que se muestra el uso de una interfaz funcional
     * definida en la misma clase
     * 
     * PD: es statico para poder usarno en el main
     * 
     * @see maquina1995.java8.interfaces.funcionales.MainInterfacesFuncionales.IValidadorCadena#validar
     * 
     */
    private static void ejecutarEjemploCadenas() {

	IValidadorCadena validadorCadenas = (nombre, patron) -> nombre.matches(patron);

	String palabraValidar = "MaQuiNa";
	String patronValidar = "[A-Z][a-zA-Z]*";
	LOGGER.info("La cadena: " + palabraValidar + " cumple el patron " + patronValidar + ": "
		+ validadorCadenas.validarCadenaByPatron(palabraValidar, patronValidar));
    }

    /**
     * 
     * Ejecuta el ejemplo en el que se muestra el uso de una interfaz funcional
     * definida en una clase externa
     * 
     * PD: es statico para poder usarno en el main
     * 
     * @see maquina1995.java8.interfaces.funcionales.MainInterfacesFuncionales.IValidadorCadena#validar
     */
    private static void ejecutarEjemploCalculadora() {
	// Creamos los objetos de la interfaz y rellenamos los metodos
	CalculadoraIF sumadorNumeros = (primero, segundo) -> LOGGER
		.info("La suma es: " + String.valueOf(primero + segundo));
	CalculadoraIF restarNumeros = (primero, segundo) -> LOGGER
		.info("La resta es: " + String.valueOf(primero - segundo));
	CalculadoraIF multiplicarNumeros = (primero, segundo) -> LOGGER
		.info("La multiplicacion es: " + String.valueOf(primero * segundo));
	CalculadoraIF dividirNumeros = (primero, segundo) -> LOGGER
		.info("La division es: " + String.valueOf(primero / segundo));

	// usamos variables de numeros predefinidas para mayor comodidad
	int numero1 = 10;
	int numero2 = 5;

	/**
	 * Llamamos a los objetos definidos arriba para invocar a la implementacion
	 * propia de cada uno
	 * 
	 */
	sumadorNumeros.operar(numero1, numero2);
	restarNumeros.operar(numero1, numero2);
	multiplicarNumeros.operar(numero1, numero2);
	dividirNumeros.operar(numero1, numero2);
    }

    /**
     * Interfaz funcional usada para validar cadenas
     */
    @FunctionalInterface
    public interface IValidadorCadena {
	/**
	 * Unico metodo de la interfaz en el que se reciben dos @see java.lang.String
	 * 
	 * @param cadena String a validar
	 * @param patron String a usar como patron
	 * @return booleano que ofrece informacion sobre si el parametro "cadena" cumple
	 *         el "patron" pasados al metodo
	 */
	public boolean validarCadenaByPatron(String cadena, String patron);
    }

}
