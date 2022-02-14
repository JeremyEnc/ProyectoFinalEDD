/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Marca;

/**
 *
 * @author ANDRES
 */
public class ControladorMarca extends AdaptadorDao<Marca> {
    Marca marca;
    Lista<Marca> marcas = new Lista();
    
    /**
     * Constructor controlador marca
     */
    public ControladorMarca() {
        super(Marca.class);
        listar();
    }
    /**
     * Retorna la marca actual
     * @return la marca
     */
    public Marca getMarca() {
        if (marca == null) {
            marca = new Marca();
        }
        return marca;
    }
    
    /**
     * Establece la marca
     * @param marca 
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    /**
     * Guarda el objeto marca en el archivo
     * @return True Or False
     */
    public boolean guardar() {
        marcas = listar();
        Long id = new Long(marcas.length());
        return guardar(marca);
    }
    
    /**
     * Retorna la lista de objetos marca
     * @return Lista de marcas
     */
    public Lista<Marca> getMarcas() {
        return marcas;
    }
    
    /**
     * Establecer la lista de marcas
     * @param marcas Lista de marcas
     */
    public void setMarcas(Lista<Marca> marcas) {
        this.marcas = marcas;
    }

}
