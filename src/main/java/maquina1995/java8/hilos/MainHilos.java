package maquina1995.java8.hilos;

import java.util.logging.Logger;

public class MainHilos {

    private static final Logger LOGGER = Logger.getLogger(MainHilos.class.getName());

    /**
     * Constante de tipo int que indica el tiempo de espera del hilo
     */
    private static final int TIEMPO_ESPERA_HILO = 2000;

    public static void main(String... args) {
	ejecutarEjemploHilo();
    }

    /**
     * Ejecuta un hilo creado a partir de un lambda que solo imprime trazas de log
     * indicando los pasos que hace se pone el primero en el main para que mientras
     * esta ejecutando este se hagan las otras operaciones del main por lo tanto
     * este metodo dejara traza en el principio y el final del metodo ya que la
     * ejecucion de los demas metodos que contiene el main no excede el tiempo de
     * espera usado en este caso @see es.maquina.lambdas.interfaces.MainLambda#main
     */
    private static void ejecutarEjemploHilo() {

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
		Thread.currentThread().interrupt();
	    }
	});

	new Thread(hilo, "Hilo Dormilon de 2 Seg").start();

    }

}
