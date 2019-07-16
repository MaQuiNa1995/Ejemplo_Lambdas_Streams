package es.maquina.java8.fechas;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.logging.Logger;

public class MainFechas {

    private static final Logger LOGGER = Logger.getLogger(MainFechas.class.getName());

    public static void main(String[] args) {
	ejemplosLocalDate();

    }

    /**
     * Método para ver ejemplos de uso de {@link java.time.LocalDate}
     * <P>
     * Se usa para representar una fecha en formato ISO (yyyy-MM-dd) sin la hora
     * <p>
     * Útil para almacenar cumpleaños por ejemplo
     * 
     */
    private static void ejemplosLocalDate() {

	// Instanciamos el objeto LocalDate y con .now() cogemos la fecha actual
	LocalDate hoy = LocalDate.now();

	LOGGER.info("La fecha de hoy sin hora: " + hoy);
	crearSaltoLinea();

	// Para pasar de unos valores a un LocalDate:
	// LocalDate.of(Año, Mes, Día)
	// LocalDate.of(1970, 02, 20)
	LOGGER.info("La fecha de hace 1 año fue " + LocalDate.of(hoy.getYear() - 1, 02, 20));
	crearSaltoLinea();

	// O tambien puedes pasarlo en formato String yyyy-mm-dd con el metodo .parse
	LOGGER.info("Pasamos de una string: 1970-01-31 a un objeto LocalDate: " + LocalDate.parse("1970-01-31"));
	crearSaltoLinea();

	// Para sumar y restar días meses o años podemos usar:
	LocalDate ayer = LocalDate.now().minus(1, ChronoUnit.DAYS);
	LocalDate mannana = LocalDate.now().plus(1, ChronoUnit.DAYS);
	LOGGER.info("Ayer fue:" + ayer + " y mañana será: " + mannana);
	crearSaltoLinea();

	// Para sacar el día el mes o el año de un objeto LocalDate:
	LOGGER.info("Hoy es día:" + hoy.getDayOfMonth() + " Estamos en el mes numero" + hoy.getMonthValue()
		+ " de nombre: " + hoy.getMonth() + " En el año: " + hoy.getYear());
	crearSaltoLinea();

	// Para ver si una fecha es anterior a otra
	boolean isAnterior = ayer.isBefore(mannana);
	LOGGER.info("¿ AYER es anterior a MAÑANA ? " + isAnterior);
	isAnterior = mannana.isBefore(ayer);
	LOGGER.info("¿ MAÑANA es anterior a AYER ? " + isAnterior);
	// IMPORTANTE si 2 fechas son iguales da false (que es lógico por otra parte)
	isAnterior = mannana.isBefore(mannana);
	LOGGER.info("¿ MAÑANA es anterior a MAÑANA ? " + isAnterior);
	crearSaltoLinea();

	// Coger el primer día del mes
	LocalDate primerDiaMes = LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth());

    }

    private static void crearSaltoLinea() {
	System.out.println("\n");
    }

}
