/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina1995.java8.interfaces.funcionales;

/**
 * Interfaz funcional usada para hacer operaciones con dos numeros de tipo java
 */
@FunctionalInterface
public interface CalculadoraIF {
    public void operar(int primero, int segundo);
}