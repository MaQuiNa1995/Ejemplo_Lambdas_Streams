/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.maquina.java8.interfaces.funcionales;

/**
 * Interfaz funcional usada para hacer operaciones con dos numeros de tipo java
 */
@FunctionalInterface
public interface ICalculadora {
    public void operar(int primero, int segundo);
}