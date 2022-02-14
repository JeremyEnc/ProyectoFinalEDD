/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.EstructurasDinamicas.Lista;

/**
 *
 * @author jere_
 * @param <T> es la clase que se guardara en archivos
 */
public interface InterfazDao <T>
{
    /**
     * Metodo para guardar el objeto de tipo T en archivos
     * @param dato el objeto que se va a guardar
     * @return Verdadero si se guardo sin ningun problema, falso si hubo algun problema
     */
    public boolean guardar(T dato);
    /**
     * Metodo para modificar algun elemento que se haya guardaro en el sistema
     * @param dato El nuevo objeto que va a remplazar al anterior
     * @param pos La posicion que va a remplazar
     * @return  Verdadero si se guardo sin ningun problema, falso si hubo algun problema
     */
    public boolean modificar(T dato, int pos);
    /**
     * Metodo para listar los objetos que se encuentren guardaros en el archivo
     * @return la lista de objetos guardados en el archivo
     */
    public Lista<T> listar();
    
    
}
