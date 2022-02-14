/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.EstructurasDinamicas.Lista;
import java.io.Serializable;

/**
 *
 * @author santiago-arg
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = 9027769897987898826l;
    private Long id;
    private String nombres;
    private String apellidos;
    private Rol id_Rol;
    private String direccion;
    private String correo;
    private String identificacion;
    private String tipoDeIdentificacion;
    private Cuenta cuenta;
    private Lista<Factura> facturas;

    /**
     *
     * Getter
     *
     * @return Devuelve una lista de tipo facturas
     */
    public Lista<Factura> getFacturas() {
        if (facturas == null) {
            facturas = new Lista<>();
        }
        return facturas;
    }

    /**
     *
     * Setter
     *
     * @param Facturas asignado a la lista Facturas
     */
    public void setFacturas(Lista<Factura> Facturas) {
        this.facturas = Facturas;
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
     *
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
     * @return Devuelve el valor de la variable nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *
     * Setter
     *
     * @param nombres asignado a la variable nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * Setter
     *
     * @param apellidos asignado a la variable apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable id_Rol
     */
    public Rol getId_Rol() {
        if (id_Rol == null) {
            id_Rol = new Rol();
        }
        return id_Rol;
    }

    /**
     *
     * Setter
     *
     * @param id_Rol asignado a la variable id_Rol
     */
    public void setId_Rol(Rol id_Rol) {
        this.id_Rol = id_Rol;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * Setter
     *
     * @param direccion asignado a la variable direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * Setter
     *
     * @param correo asignado a la variable correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     *
     * Setter
     *
     * @param identificacion asignado a la variable identificacion
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable tipoDeIdentificacion
     */
    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    /**
     *
     * Setter
     *
     * @param tipoDeIdentificacion asignado a la variable tipoDeIdentificacion
     */
    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     *
     * Setter
     *
     * @param cuenta asignado a la variable cuenta
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
