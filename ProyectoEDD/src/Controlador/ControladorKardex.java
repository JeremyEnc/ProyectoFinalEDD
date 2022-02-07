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

    public ControladorKardex() {
        super(Kardex.class);
    }    
    
    public Kardex getKardex() {
        if(kardex == null){
            kardex = new Kardex();
        }
        return kardex;
    }

    public void setKardex(Kardex kardex) {
        this.kardex = kardex;
    }

    public Lista<Kardex> getListaKardex() {
        return listaKardex;
    }

    public void setListaKardex(Lista<Kardex> listaKardex) {
        this.listaKardex = listaKardex;
    }
    
    public boolean guardar(){
        return guardar(kardex);
    }
    
    
}
