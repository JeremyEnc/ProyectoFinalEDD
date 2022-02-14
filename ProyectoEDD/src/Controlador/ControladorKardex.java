/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Kardex;

/**
 *
 * @author ANDRES
 */
public class ControladorKardex extends AdaptadorDao<Kardex>{
    Kardex kardex;
    Lista<Kardex>  listaKardex = new Lista<>();
    
    /**
     * Constructor de Controlador Kardex
     */
    public ControladorKardex() {
        super(Kardex.class);
    }    
    
    /**
     * Retorna el objeto kardex actual
     * @return Objeto Kardex
     */
    public Kardex getKardex() {
        if(kardex == null){
            kardex = new Kardex();
        }
        return kardex;
    }
    
    /**
     * Establece el objeto kardex
     * @param kardex Objeto Kardex
     */
    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }
    
    /**
     * Retortna la lista de los kardex
     * @return Lista de kardex
     */
    public Lista<Kardex> getListaKardex() {
        return listaKardex;
    }
    
    /**
     * Establece la lista de kardexs
     * @param listaKardex Lista de Kardex
     */
    public void setListaKardex(Lista<Kardex> listaKardex) {
        this.listaKardex = listaKardex;
    }
    
    /**
     * Permite guardar el objeto kardex en archivo
     * @return True o False
     */
    public boolean guardar(){
        return guardar(kardex);
    }
    
    
}
