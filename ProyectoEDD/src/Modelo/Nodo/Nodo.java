/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Nodo;

import java.io.Serializable;

/**
 *
 * @author jere_
 * @param <T>
 */
public class Nodo <T> implements Serializable
{   
    private T dato; //Dato que ira dentro del nodo
    private Nodo nodoNext; //Nodo siguiente

    /**
     * Constructor del nodo en el que ira el dato y el nodo siguiente
     * @param dato
     * @param nodoNext 
     */
    public Nodo(T dato, Nodo nodoNext)
    {
        this.dato = dato;
        this.nodoNext = nodoNext;
    }

    /**
     * Constructor vacio del nodo
     */
    public Nodo()
    {
        this.dato = null;
        this.nodoNext = null;
    }

    /**
     * Retorna el dato que se quiere insertar en el nodo
     * @return dato que se quiere insertar en el nodo
     */
    public T getDato() {
        return dato;
    }

    /**
     * Permite establecer un dato en el nodo 
     * @param dato dato a ingresar en el nodo
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Retorna el nodo siguiente
     * @return nodo siguiente
     */
    public Nodo getNodoNext() {
        return nodoNext;
    }

    /**
     * Permite establecer un nodo siguiente
     * @param nodoNext nodo siguiente a establecer
     */
    public void setNodoNext(Nodo nodoNext) {
        this.nodoNext = nodoNext;
    }
    
    
}
