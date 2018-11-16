package es.maquina.lambdas.interfaces;

import java.util.logging.Logger;

/**
 * Main usado para la visualizacion de ejemplos sobre lambdas
 * 
 * @author MaQui1995
 *
 */
public class MainLambdas {

    /**
     * Log generico de java
     */
    private static final Logger LOGGER = Logger.getLogger(MainLambdas.class.getName());

    /**
     * Metodo usado para la ejecucion del programa puedes comentar los metodos para
     * ejecutar los que te interesen
     * 
     * @param args
     *            las distintas @see java.lang.String que pueden pasarse al programa
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
     * @see es.maquina.lambdas.interfaces.IValidadorCadena
     * 
     */
    private static void ejecutarEjemploCadenas() {
	IValidadorCadena validadorCadenas = (nombre, patron) -> nombre.matches(patron);

	String palabraValidar = "MaQuiNa";
	String patronValidar = "[A-Z][a-zA-Z]*";
	LOGGER.info("La cadena: " + palabraValidar + " cumple el patron " + patronValidar + ": "
		+ validadorCadenas.validar(palabraValidar, patronValidar));
    }

    /**
     * 
     * Ejecuta el ejemplo en el que se muestra el uso de una interfaz funcional
     * definida en una clase externa
     * 
     * PD: es statico para poder usarno en el main
     * 
     * @see es.maquina.lambdas.interfaces.IValidadorCadena
     */
    private static void ejecutarEjemploCalculadora() {
	// Creamos un objeto de la interfaz
	ICalculadora sumadorNumeros = (primero, segundo) -> LOGGER
		.info("La suma es: " + String.valueOf(primero + segundo));
	ICalculadora restarNumeros = (primero, segundo) -> LOGGER
		.info("La resta es: " + String.valueOf(primero - segundo));
	ICalculadora multiplicarNumeros = (primero, segundo) -> LOGGER
		.info("La multiplicacion es: " + String.valueOf(primero * segundo));
	ICalculadora dividirNumeros = (primero, segundo) -> LOGGER
		.info("La division es: " + String.valueOf(primero / segundo));

	int numero1 = 10;
	int numero2 = 5;
	sumadorNumeros.operar(numero1, numero2);
	restarNumeros.operar(numero1, numero2);
	multiplicarNumeros.operar(numero1, numero2);
	dividirNumeros.operar(numero1, numero2);
    }

    /**
     * Interfaz funcional usada para validar cadenas
     */
    @FunctionalInterface
    private interface IValidadorCadena {
	/**
	 * Unico metodo de la interfaz en el que se reciben dos @see java.lang.String
	 * 
	 * @param cadena
	 *            String a validar
	 * @param patron
	 *            String a usar como patron
	 * @return booleano que ofrece informacion sobre si el parametro "cadena" cumple
	 *         el "patron" pasados al metodo
	 */
	public boolean validar(String cadena, String patron);
    }

}
