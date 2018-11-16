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
     * Constante de tipo int que indica el tiempo de espera del hilo
     */
    private static final int TIEMPO_ESPERA_HILO = 2000;

    /**
     * Metodo usado para la ejecucion del programa puedes comentar los metodos para
     * ejecutar los que te interesen
     * 
     * @param args
     *            las distintas @see java.lang.String que pueden pasarse al programa
     */
    public static void main(String[] args) {

	ejecutarEjemploHiloLambda();
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
	// Creamos los objetos de la interfaz y rellenamos los metodos
	ICalculadora sumadorNumeros = (primero, segundo) -> LOGGER
		.info("La suma es: " + String.valueOf(primero + segundo));
	ICalculadora restarNumeros = (primero, segundo) -> LOGGER
		.info("La resta es: " + String.valueOf(primero - segundo));
	ICalculadora multiplicarNumeros = (primero, segundo) -> LOGGER
		.info("La multiplicacion es: " + String.valueOf(primero * segundo));
	ICalculadora dividirNumeros = (primero, segundo) -> LOGGER
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
     * Ejecuta un hilo creado a partir de un lambda que solo imprime trazas de log
     * indicando los pasos que hace se pone el primero en el main para que mientras
     * esta ejecutando este se hagan las otras operaciones del main por lo tanto
     * este metodo dejara traza en el principio y el final del metodo ya que la
     * ejecucion de los demas metodos que contiene el main no excede el tiempo de
     * espera usado en este caso @see es.maquina.lambdas.interfaces.MainLambda#main
     */
    private static void ejecutarEjemploHiloLambda() {

	/**
	 * Creacion de un objeto Runnable (Generico de los hilos) en el que definimos la
	 * funcionalidad Impresion de trazas al iniciar el hilo y al acabar una espera
	 * de @see es.maquina.lambdas.interfaces.MainLambdas#TIEMPO_ESPERA_HILO
	 */
	Runnable hilo = (() -> {
	    try {

		LOGGER.info("Se empieza la ejecucion del hilo: " + Thread.currentThread().getName());
		Thread.sleep(TIEMPO_ESPERA_HILO);
		LOGGER.info(Thread.currentThread().getName() + " se desperto despues de " + TIEMPO_ESPERA_HILO / 1000
			+ " Segundos de hibernacion");
	    } catch (InterruptedException exception) {
		LOGGER.warning(exception.getMessage());
	    }
	});

	new Thread(hilo, "Hilo Dormilon de 2 Seg").start();

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
