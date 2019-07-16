/*
 * Copyright 2017 cmunoz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package es.maquina.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Clase enfocada a mostrar ejemplos de manejo de Streams
 * <p>
 * IMPORTANTE Regla de sonar: squid:S3959 (No se debe usar el mismo stream mas
 * de 1 vez)
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html">Javadoc
 *      Clase Collector</a>
 * 
 * @autor MaQuiNa1995
 * @date 22-jun-2017
 */
public class MainStream {

    private static final Logger LOGGER = Logger.getLogger(MainStream.class.getName());

    public static void main(String... args) {

	streamPalabrasEjemplo();
	streamNumerosEjemplo();
	streamClaseCombate();
    }

    /**
     * Método para uso de Streams con Strings
     *
     * @see java.lang.String#contains(CharSequence) es sensible a mayusculas
     */
    private static void streamPalabrasEjemplo() {

	// ------- Filtro por contains --------

	LOGGER.info("Filtro de palabras por las que tengan i");
	generarPalabras().stream()
		// 'Filtramos' la lista por los valores que tengan la letra i
		.filter(s -> s.contains("i"))
		// Por cada elemento imprimimos el valor en pantalla
		.forEach(System.out::println);

	crearSaltoLinea();

	// ------- ordenamiento y referencia a metodos -------
	LOGGER.info("Ordenamiento y referencias a metodos (en este caso al upperCase) ");
	generarPalabras().stream()
		// Pasamos el Stream a mapa y mayúsculas se usan los dobles doble punto para
		// hacer referencia al metodo de la clase String (Se hace asi en los lambdas)
		.map(String::toUpperCase)
		// tambien se puede hacerlo como normalmente lo haríamos
		// llamando al metodo del objeto:.map(e -> e.toUpperCase())

		// Le ordenamos
		// - String -> Abecedario
		// - Numeros -> Mayor a Menor
		.sorted()
		// Imprimimos en pantalla de cada elemento
		.forEach(System.out::println);

    }

    /**
     * Método para el uso de Streams con Números
     */
    private static void streamNumerosEjemplo() {
	crearSaltoLinea();

	LOGGER.info("Limitacion de objetos del stream");
	// ---- Limitacion de objetos ------
	generarDiezNumeros()
		// Indicamos que es un Stream
		.stream()
		// cogemos solo los 5 primeros
		.limit(5)
		// Imprimimos en pantalla cada elemento
		.forEach(System.out::println);
    }

    /**
     * Método para el uso de Streams con Números
     */
    private static void streamClaseCombate() {

	crearSaltoLinea();

	// ---------- Reduciendo listas para solo coger X atributo ----------

	LOGGER.info("Reduciendo listas de objetos a solo 1 atributo");
	List<String> listaNombreClase = generarClaseCombate()
		// Indicamos que es un Stream
		.stream()
		// De cada elemento cogemos el NombreClase
		.map(n -> n.getNombreClase())
		// Lo pasamos a una lista
		.collect(Collectors.toList());

	// Lo imprimimos en pantalla
	listaNombreClase.forEach(e -> System.out.println(e));

	crearSaltoLinea();

	// ---------- Filtro de atributos de objeto por condicion ----------
	LOGGER.info("Filtro por condición en numeros vidaBase mayor de 600");
	List<ClaseCombate> listaVidaBaseAlta = generarClaseCombate()
		// Indicamos que es un Stream
		.stream()
		// Cogemos los elementos que tengan mas de 600 de vidaBase
		.filter(n -> n.getVidaBase() > 600)
		// Lo pasamos a una lista
		.collect(Collectors.toList());

	// Lo imprimimos en pantalla
	listaVidaBaseAlta.forEach(System.out::println);

	crearSaltoLinea();

	// ----- Operacion de media en X atributo de una lista de objetos -----

	LOGGER.info("Media de atributos en este caso de la vida base");
	Double vidaMediaClases = generarClaseCombate()
		// Indicamos que es un Stream
		.stream()
		// Cogemos la vida de todos los elementos y hacemos una media
		.collect(Collectors.averagingInt(n -> n.getVidaBase()));

	LOGGER.info("La media es:" + vidaMediaClases);

	crearSaltoLinea();

	// ---- Concatenacion de atributos ----
	LOGGER.info("concatenacion de atributos por 1 caracter (en este caso ,)");
	String armasConcatenadas = generarClaseCombate()
		// Indicamos que es un Stream
		.stream()
		// cogemos el atributo que queramos
		.map(ClaseCombate::getTipoArma)
		// Los concatenamos por comas
		.collect(Collectors.joining(", "));

	LOGGER.info("concatenacion de armas: " + armasConcatenadas);

    }

    /**
     * Método que genera 8 palabras
     *
     * @return Lista de ocho palabras
     */
    private static List<String> generarPalabras() {
	return Arrays.asList("Valefor", "Ifrit", "Ixion", "Shiva", "Bahamut", "Yogimbo", "Anima", "Hermanas Magus");

    }

    /**
     * Método que genera una lista de 10 números
     *
     * @return Lista de 10 números
     */
    private static List<Integer> generarDiezNumeros() {
	List<Integer> numerosRandom = new ArrayList<>();

	for (int i = 0; i < 10; i++) {
	    numerosRandom.add(i);
	}

	return numerosRandom;
    }

    private static List<ClaseCombate> generarClaseCombate() {

	ClaseCombate objeto1 = new ClaseCombate();
	objeto1.setNombreClase("Espadachin");
	objeto1.setTipoArma("Espada");
	objeto1.setVidaBase(1000);

	ClaseCombate objeto2 = new ClaseCombate();
	objeto2.setNombreClase("Mago");
	objeto2.setTipoArma("Varita");
	objeto2.setVidaBase(450);

	ClaseCombate objeto3 = new ClaseCombate();
	objeto3.setNombreClase("Arquero");
	objeto3.setTipoArma("Arco");
	objeto3.setVidaBase(550);

	ClaseCombate objeto4 = new ClaseCombate();
	objeto4.setNombreClase("Artista Marcial");
	objeto4.setTipoArma("Puño De Combate");
	objeto4.setVidaBase(700);

	List<ClaseCombate> listaObjetoEjemplo = new ArrayList<>();

	listaObjetoEjemplo.add(objeto1);
	listaObjetoEjemplo.add(objeto2);
	listaObjetoEjemplo.add(objeto3);
	listaObjetoEjemplo.add(objeto4);

	return listaObjetoEjemplo;
    }

    private static void crearSaltoLinea() {
	System.out.println("\n");
    }

}
