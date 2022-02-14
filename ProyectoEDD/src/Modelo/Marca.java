/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;


/**
 *
 * @author ANDRES
 */
public class Marca  implements Serializable{
    Long id;
    String nombreMarca;
    String paisOrigen;
    
    /**
     * Retorna la id de la marca
     * @return Id de marca
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la id de la Marca
     * @param id Id de la marca
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el nombre de la marca
     * @return Nombre de la marca
     */
    public String getNombreMarca() {
        return nombreMarca;
    }
    
    /**
     * Establece el nobmre de la marca
     * @param nombreMarca Nombre de la marca
     */
    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
    
    /**
     * Retorna el pais de origen de la marca
     * @return Pais de origen
     */
    public String getPaisOrigen() {
        return paisOrigen;
    }
    
    /**
     * Establece el pais de origen de la marca
     * @param paisOrigen Paise de origen de la marca
     */
    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    
}
