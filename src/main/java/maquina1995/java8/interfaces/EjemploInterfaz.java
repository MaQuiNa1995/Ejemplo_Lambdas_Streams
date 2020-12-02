package maquina1995.java8.interfaces;

public interface EjemploInterfaz {

    void sumarDoubles(double numero1, double numero2);

    default void sumarEnteros(int numero1, int numero2) {
	int suma = numero1 + numero2;
	System.out.println("Suma de Enteros: " + suma);
    }

}
