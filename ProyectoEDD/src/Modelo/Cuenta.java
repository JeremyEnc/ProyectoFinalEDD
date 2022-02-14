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
public class Cuenta implements Serializable {

    private static final long serialVersionUID = -159426798390312484l;
    private Long id;
    private String nombreUsuario;
    private String clave;
    private Long id_Persona;
    private Boolean estado;

    /**
     * Constructor de cuenta
     *
     * @param id de la cuenta
     * @param nombreUsuario del usurio de la cuenta
     * @param clave clave de la cuenta
     * @param id_Persona de la persona que se relaciona con la cuenta
     * @param estado de la cuenta
     */
    public Cuenta(Long id, String nombreUsuario, String clave, Long id_Persona, Boolean estado) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.id_Persona = id_Persona;
        this.estado = estado;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter
     *
     * @param id asignado a la variable id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     *
     * Setter
     *
     * @param nombreUsuario asignado a la variable nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable clave
     */
    public String getClave() {
        return clave;
    }

    /**
     *
     * Setter
     *
     * @param clave asignado a la variable clave
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable id_Persona
     */
    public Long getId_Persona() {
        return id_Persona;
    }

    /**
     *
     * Setter
     *
     * @param id_Persona asignado a la variable id_Persona
     */
    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     *
     * Setter
     *
     * @param estado asignado a la variable estado
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
