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

    public Cuenta(Long id, String nombreUsuario, String clave, Long id_Persona, Boolean estado) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.id_Persona = id_Persona;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Long getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
