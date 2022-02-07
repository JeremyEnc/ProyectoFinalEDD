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

    public Lista<Factura> getFacturas() {
        if (facturas == null) {
            facturas = new Lista<>();
        }
        return facturas;
    }

    public void setFacturas(Lista<Factura> Facturas) {
        this.facturas = Facturas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Rol getId_Rol() {
        if (id_Rol == null) {
            id_Rol = new Rol();
        }
        return id_Rol;
    }

    public void setId_Rol(Rol id_Rol) {
        this.id_Rol = id_Rol;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoDeIdentificacion() {
        return tipoDeIdentificacion;
    }

    public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
        this.tipoDeIdentificacion = tipoDeIdentificacion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
