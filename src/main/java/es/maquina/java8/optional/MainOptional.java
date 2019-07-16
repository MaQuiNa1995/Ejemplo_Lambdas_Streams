package es.maquina.java8.optional;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * 
 * @author cmunozas
 * @see <a href="https://www.baeldung.com/java-optional">Ejemplo Optional</a>
 */
public class MainOptional {

    private static final Logger LOGGER = Logger.getLogger(MainOptional.class.getName());

    private static final String CADENA = "Cadena del Optional C(*_*c)";
    private static final String VALOR_POR_DEFECTO = "Valor Por Defecto";

    public static void main(String... args) {
	ejemploCreacionOptional();
	ejemploCondicionalesOptional();
	ejemploValorPorDefectoSiNulo();
    }

    private static void crearSaltoLinea() {
	System.out.println("\n");
    }

    /**
     * Creacion de un objeto Optional
     */
    private static void ejemploCreacionOptional() {

	// Optional<T> los optional pueden crearse con cualquier objeto
	Optional<String> opcional = Optional.empty();
	// Si haces el get de un optional vacío obtienes un Null Pointer
	LOGGER.info("¿ Tiene valor el Optional ? \n" + opcional.isPresent());

	LOGGER.info("Se añade valor");
	// En este caso como se ha definido que el optional tuviera una String le
	// montamos como tal
	// IMPORTANTE si se le hace un Opional.of de un null salta el Null Pointer
	opcional = Optional.of(CADENA);
	LOGGER.info("Valor del opcional: " + opcional.get());

	LOGGER.info("Se le indica al optional que el parametro que se le pasa puede ser null (en este caso es null) ");
	// Para nulos habría que usar el ofNullable(T);
	opcional = Optional.ofNullable(null);
	// Si haces el get de un optional vacío obtienes un Null Pointer
	LOGGER.info("¿ Tiene valor el Optional ? " + opcional.isPresent());

	LOGGER.info("Se da un nuevo valor al optional a traves del ofNullable");
	// Para nulos habría que usar el ofNullable(T);
	opcional = Optional.ofNullable(CADENA);

	// Si haces el get de un optional vacío obtienes un Null Pointer
	LOGGER.info("¿ Tiene valor el Optional ? \n" + opcional.isPresent() + " " + opcional.get());

    }

    /**
     * Metodo para comprobar que el optional tiene valor
     */
    private static void ejemploCondicionalesOptional() {
	crearSaltoLinea();

	// En vez de comprobar con un if si un valor es nulo se puede recurrir al metodo
	// ifPresent que ejecuta el lambda si tiene valor presente
	final Optional<String> opcional = Optional.ofNullable(CADENA);
	opcional.ifPresent(name -> LOGGER.info("El optional tiene: " + opcional.get()));

	// En este caso no imprime nada porque el valor es nulo/vacio
	final Optional<String> opcional2 = Optional.empty();
	opcional2.ifPresent(name -> LOGGER.info("El optional tiene: " + opcional2.get()));

	// Aqui tampoco porque el valor es nulo
	final Optional<String> opcional3 = Optional.ofNullable(null);
	opcional3.ifPresent(name -> LOGGER.info("El optional tiene: " + opcional2.get()));

    }

    /**
     * Metodo para comprobar el funcionamiento del seteo de un valor por defecto en
     * caso de que el optional sea nulo/vacio
     */
    private static void ejemploValorPorDefectoSiNulo() {
	crearSaltoLinea();

	// Iniciamos el Optional con una cadena
	Optional<String> opcional = Optional.ofNullable(CADENA);
	Optional<String> opcionalNulo = Optional.ofNullable(null);

	String cadena = opcional.orElse(VALOR_POR_DEFECTO);
	LOGGER.info("Ahora tenemos el valor de la variable CADENA: " + cadena + " ya que no está vacío");

	cadena = opcionalNulo.orElse(VALOR_POR_DEFECTO);
	LOGGER.info("En cambio ahora al estar nulo obtenemos el valor por defecto " + cadena);

    }

}
