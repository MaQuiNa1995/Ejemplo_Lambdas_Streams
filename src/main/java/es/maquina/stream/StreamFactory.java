/*
 * Copyright 2017 cmunoz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.maquina.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * @autor cmunoz
 * @version 1.0
 */
public class StreamFactory {

    private static final Logger LOG = Logger.getLogger(StreamFactory.class.getName());

    /**
     * Método para el uso de Streams con Números
     */
    public void streamsNumeros() {

	LOG.info("Generamos 10 Números");
	generarDiezNumeros().stream() // Indicamos que es un Stream
		.forEach(System.out::println);

	LOG.info("Generamos 10 Números y Los Límitamos a 5");
	generarDiezNumeros().stream() // Indicamos que es un Stream
		.limit(5) // cogemos solo los 5 primeros
		.forEach(System.out::println); // Imprimimos en pantalla cada elemento
    }

    /**
     * Método que genera una lista de 10 números
     *
     * @return Lista de 10 números
     */
    private List<Integer> generarDiezNumeros() {
	List<Integer> numerosRandom = new ArrayList<>();

	for (int i = 1; i < 11; i++) {
	    numerosRandom.add(i);
	}

	return numerosRandom;
    }

    /**
     * Método para uso de Streams con Strings
     *
     * @see java.lang.String#contains(CharSequence) es sensible a mayusculas
     */
    public void streamsPalabras() {
	LOG.info("Generamos Palabras e Imprimimos Las Que Tengan 'i'");
	generarPalabras().stream() // Indicamos que es un Stream
		.filter(s -> s.contains("i")) // 'Filtramos' cada palabra
		.forEach(System.out::println); // Imprimimos en pantalla

	LOG.info("Generamos Palabras Las Metemos a Un Mapa y Las Ordenamos");
	generarPalabras().stream() // Indicamos que es un Stream
		.map(String::toUpperCase) // Pasamos el Stream a mapa y mayúsculas
		.sorted() // Le ordenamos 'Naturalmente'
			  // String -> Abecedario
			  // Numeros -> Mayor a Menor
		.forEach(System.out::println); // Imprimimos en pantalla cada elemento

    }

    /**
     * Método que genera 8 palabras
     *
     * @return Lista de ocho palabras
     */
    private List<String> generarPalabras() {
	List<String> nombresInvocaciones = Arrays.asList("Valefor", "Ifrit", "Ixion", "Shiva", "Bahamut", "Yogimbo",
		"Anima", "Hermanas Magus");

	return nombresInvocaciones;
    }

}
