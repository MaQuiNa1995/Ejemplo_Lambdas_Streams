/*
 * Copyright 2017 cmunoz.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package maquina1995.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Clase enfocada a mostrar ejemplos de manejo de Streams
 * <p>
 * IMPORTANTE Regla de sonar: squid:S3959 (No se debe usar el mismo stream mas de 1 vez)
 * 
 * @see <a href= "https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html">Javadoc Clase Collector</a>
 * 
 * @autor MaQuiNa1995
 * @date 22-jun-2017
 */
public class MainStream
{

	private static final Logger LOGGER = Logger.getLogger ( MainStream.class.getName ( ) );

	public static void main ( String... args )
	{

		streamStrings ( );
		streamNumerosEjemplo ( );
		streamClaseCombate ( );
		objetosProgramacionFuncional ( );
	}

	/**
	 * 	
	
	 */
	private static void objetosProgramacionFuncional ( )
	{
		// Function -> Maps
		Function < String, String > toUppercaseFunction = String::toUpperCase;
		BiFunction < String, String, String > joinFunction = ( first, second ) -> String.join ( "_", first, second );

		UnaryOperator < String > toUppercaseFunction2 = e -> e.toUpperCase ( );

		UnaryOperator < String > toInteger = e -> String.valueOf ( e );

		BinaryOperator < String > joinFunction2 = ( first, second ) -> String.join ( "_", first, second );

		IntFunction < Integer > multiplyIntegerFunction = e -> e * 2;
		DoubleFunction < Integer > multiplyDoubleFunction;

		// Predicates -> Filters
		Predicate < String > isJarFile = e -> e.endsWith ( ".jar" );
		Predicate < String > isPomFile = e -> e.equals ( "pom.xml" );

		Predicate < String > isJarOrXmlFile = isJarFile.or ( isPomFile );
		Predicate < String > notJarOrXmlFile = isJarFile.and ( isPomFile )
				.negate ( );

		BiPredicate < String, String > isJarOrXmlFile2 = ( first, second ) -> first.endsWith ( ".jar" ) || second.endsWith ( ".xml" );
		BiPredicate < String, String > areEquals = ( first, second ) -> first.equals ( second );

		// Consumer -> ForEach
		Consumer < String > escupirPorPantalla = System.out::println;
		Consumer < String > escupirPorPantalla2 = e -> System.out.println ( e );

		BiConsumer < String, String > escupirJuntau = ( first, second ) -> System.out.println ( String.join ( ",", first, second ) );

		// Supplier -> Proveedor de objetos
		Supplier < List < String > > stringSupplier = ( ) -> generarPalabras ( );

		Supplier < Integer > randomSupplier = ( ) -> new Random ( ).nextInt ( );
	}

	Function < Integer, Integer > function ( Supplier < Integer > generadorIntegers )
	{
		return entrada -> entrada * generadorIntegers.get ( );
	}

//		generarDiezNumeros ( ).stream ( ).map ( e -> )

//		Current Interface , Preferred Interface
//		Function<Integer, R> IntFunction<R> 
//		Function<Long, R> LongFunction<R> 
//		Function<Double, R> DoubleFunction<R> 
//		Function<Double,Integer>  DoubleToIntFunction  
//		Function<Double,Long>  DoubleToLongFunction  
//		Function<Long,Double>  LongToDoubleFunction  
//		Function<Long,Integer>  LongToIntFunction 
//		Function<R,Integer>  ToIntFunction<R> 
//		Function<R,Long>  ToLongFunction<R> 
//		Function<R,Double>  ToDoubleFunction<R> 
//		Function<T,T>  UnaryOperator<T>  
//		BiFunction<T,T,T>  BinaryOperator<T>  
//		Consumer<Integer> IntConsumer 
//		Consumer<Double> DoubleConsumer 
//		Consumer<Long> LongConsumer 
//		BiConsumer<T,Integer>  ObjIntConsumer<T> 
//		BiConsumer<T,Long>  ObjLongConsumer<T> 
//		BiConsumer<T,Double>  ObjDoubleConsumer<T> 
//		Predicate<Integer> IntPredicate 
//		Predicate<Double> DoublePredicate 
//		Predicate<Long> LongPredicate 
//		Supplier<Integer> IntSupplier 
//		Supplier<Double> DoubleSupplier 
//		Supplier<Long> LongSupplier 
//		Supplier<Boolean>  BooleanSupplier 
//		UnaryOperator<Integer> IntUnaryOperator 
//		UnaryOperator<Double> DoubleUnaryOperator 
//		UnaryOperator<Long> LongUnaryOperator 
//		BinaryOperator<Integer>  IntBinaryOperator 
//		BinaryOperator<Long>  LongBinaryOperator 
//		BinaryOperator<Double>  DoubleBinaryOperator 
//		Function<T, Boolean>  Predicate<T> 
//		BiFunction<T,U,Boolean>  BiPredicate<T,U> 

//	}

	/**
	 * Método para uso de Streams con Strings
	 * 
	 * @see{@link java.util.Collections#frequency}
	 * @see java.lang.String#contains(CharSequence) es sensible a mayusculas
	 */
	private static void streamStrings ( )
	{
		// ------- Filtro por contains --------
		LOGGER.info ( "Filtro de palabras por las que tengan i" );
		generarPalabras ( ).stream ( )
				// 'Filtramos' la lista por los valores que tengan la letra i
				.filter ( s -> s.contains ( "i" ) )
				// Por cada elemento imprimimos el valor en pantalla
				.forEach ( System.out::println );

		crearSaltoLinea ( );

		// ------- ordenamiento y referencia a metodos -------
		LOGGER.info ( "Ordenamiento y referencias a metodos (en este caso al upperCase) " );
		generarPalabras ( ).stream ( )
				// Pasamos el Stream a mapa y mayúsculas se usan los dobles doble punto para
				// hacer referencia al metodo de la clase String (Se hace asi en los lambdas)
				.map ( String::toUpperCase )
				// tambien se puede hacerlo como normalmente lo haríamos
				// llamando al metodo del objeto:.map(e -> e.toUpperCase())

				// Le ordenamos
				// - String -> Abecedario
				// - Numeros -> Mayor a Menor
				.sorted ( )
				// Imprimimos en pantalla de cada elemento
				.forEach ( System.out::println );

		LOGGER.info ( "Ejemplo de uso de frequency para contar coincidencias en una lista" );
		// Podemos usar el metodo {@link Collections#frequency} para contar las
		// coincidencias de X objeto en este caso una String
		System.out.println ( Collections.frequency ( generarPalabras ( ), "Yogimbo" ) );

	}

	/**
	 * Método para el uso de Streams con Números
	 */
	private static void streamNumerosEjemplo ( )
	{
		crearSaltoLinea ( );

		LOGGER.info ( "Limitacion de objetos del stream" );
		// ---- Limitacion de objetos ------
		generarDiezNumeros ( )
				// Indicamos que es un Stream
				.stream ( )
				// cogemos solo del 4 al 7 primeros
				.skip ( 3 )
				.limit ( 3 )
				// Imprimimos en pantalla cada elemento
				.forEach ( System.out::println );
	}

	/**
	 * Método para el uso de Streams con Números
	 */
	private static void streamClaseCombate ( )
	{

		crearSaltoLinea ( );

		// ---------- Reduciendo listas para solo coger X atributo ----------

		LOGGER.info ( "Reduciendo listas de objetos a solo 1 atributo" );
		generarClaseCombate ( )
				// Indicamos que es un Stream
				.stream ( )
				// De cada elemento cogemos el NombreClase
				.map ( ClaseCombate::getNombreClase )
				// Lo imprimimos en pantalla
				.forEach ( System.out::println );

		crearSaltoLinea ( );

		// ---------- Filtro de atributos de objeto por condicion ----------
		LOGGER.info ( "Filtro por condición en numeros vidaBase mayor de 600" );
		generarClaseCombate ( )
				// Indicamos que es un Stream
				.stream ( )
				// Cogemos los elementos que tengan mas de 600 de vidaBase
				.filter ( n -> n.getVidaBase ( ) > 600 )
				// Lo imprimimos en pantalla
				.forEach ( System.out::println );

		crearSaltoLinea ( );

		// ----- Operacion de media en X atributo de una lista de objetos -----

		LOGGER.info ( "Media de atributos en este caso de la vida base" );
		Double vidaMediaClases = generarClaseCombate ( )
				// Indicamos que es un Stream
				.stream ( )
				// Cogemos la vida de todos los elementos y hacemos una media
				.collect ( Collectors.averagingInt ( ClaseCombate::getVidaBase ) );

		LOGGER.info ( "La media es:" + vidaMediaClases );

		crearSaltoLinea ( );

		// ---- Concatenacion de atributos ----
		LOGGER.info ( "concatenacion de atributos por 1 caracter (en este caso ,)" );
		String armasConcatenadas = generarClaseCombate ( )
				// Indicamos que es un Stream
				.stream ( )
				// cogemos el atributo que queramos
				.map ( ClaseCombate::getTipoArma )
				// Los concatenamos por comas
				.collect ( Collectors.joining ( "," ) );

		LOGGER.info ( "concatenacion de armas: " + armasConcatenadas );

	}

	/**
	 * Método que genera 8 palabras
	 *
	 * @return Lista de ocho palabras
	 */
	private static List < String > generarPalabras ( )
	{
		return Arrays.asList ( "Valefor", "Ifrit", "Ixion", "Shiva", "Bahamut", "Yogimbo", "Anima", "Hermanas Magus" );

	}

	/**
	 * Método que genera una lista de 10 números
	 *
	 * @return Lista de 10 números
	 */
	private static List < Integer > generarDiezNumeros ( )
	{
		return IntStream.range ( 1, 10 )
				.boxed ( )
				.collect ( Collectors.toList ( ) );

	}

	private static List < ClaseCombate > generarClaseCombate ( )
	{

		List < ClaseCombate > listaObjetoEjemplo = new ArrayList <> ( );

		ClaseCombate objeto = new ClaseCombate ( );
		objeto.setNombreClase ( "Espadachin" );
		objeto.setTipoArma ( "Espada" );
		objeto.setVidaBase ( 1000 );
		listaObjetoEjemplo.add ( objeto );

		objeto = new ClaseCombate ( );
		objeto.setNombreClase ( "Mago" );
		objeto.setTipoArma ( "Varita" );
		objeto.setVidaBase ( 450 );
		listaObjetoEjemplo.add ( objeto );

		objeto = new ClaseCombate ( );
		objeto.setNombreClase ( "Arquero" );
		objeto.setTipoArma ( "Arco" );
		objeto.setVidaBase ( 550 );
		listaObjetoEjemplo.add ( objeto );

		objeto = new ClaseCombate ( );
		objeto.setNombreClase ( "Artista Marcial" );
		objeto.setTipoArma ( "Puño De Combate" );
		objeto.setVidaBase ( 700 );
		listaObjetoEjemplo.add ( objeto );

		return listaObjetoEjemplo;
	}

	private static void crearSaltoLinea ( )
	{
		System.out.println ( "\n" );
	}

}
