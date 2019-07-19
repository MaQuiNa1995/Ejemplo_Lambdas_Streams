package es.maquina.java8.interfaces;

public class Ejemplo implements EjemploInterfaz {

    @Override
    public void sumarDoubles(double numero1, double numero2) {
	double suma = numero1 + numero2;
	System.out.println("Suma de Doubles: " + suma);
    }

}
