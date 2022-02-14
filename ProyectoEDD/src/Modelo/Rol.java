/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author santiago-arg
 */
public class Rol implements Serializable {

    private Long id;
    private String nombreRol;

    /**
     *
     * Getter
     * @return Devuelve el valor de la variable id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * Setter
     * @param id asignado a la variable id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * Getter
     * @return Devuelve el valor de la variable nombreRol
     */
    public String getNombreRol() {
        return nombreRol;
    }

    /**
     *
     * Setter
     * @param nombreRol asignado a la variable nombreRol
     */
    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

}
