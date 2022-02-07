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
 * @author Usuario
 */
public class ControladorMarca extends AdaptadorDao<Marca> {

    Marca marca;
    Lista<Marca> marcas = new Lista();

    public ControladorMarca() {
        super(Marca.class);
        listar();
    }

    public Marca getMarca() {
        if (marca == null) {
            marca = new Marca();
        }
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public boolean guardar() {
        marcas = listar();
        Long id = new Long(marcas.length());
        return guardar(marca);
    }

    public Lista<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(Lista<Marca> marcas) {
        this.marcas = marcas;
    }

}
