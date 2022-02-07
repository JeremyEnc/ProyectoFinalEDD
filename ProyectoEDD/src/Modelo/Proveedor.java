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
 * @author jere_
 */
public class Proveedor implements Serializable
{
    private Long id;
    private String ruc;
    private String nombreProveedor;
    private String apellidoProveedor;
    private String direccionProveedor;
    Lista<FacturaCompra> listaFacturasCompras;

    public Proveedor(Long id, String ruc, String nombreProveedor, String apellidoProveedor, String direccionProveedor) {
        this.id = id;
        this.ruc = ruc;
        this.nombreProveedor = nombreProveedor;
        this.apellidoProveedor = apellidoProveedor;
        this.direccionProveedor = direccionProveedor;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getApellidoProveedor() {
        return apellidoProveedor;
    }

    public void setApellidoProveedor(String apellidoProveedor) {
        this.apellidoProveedor = apellidoProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public Lista<FacturaCompra> getListaFacturasCompras()
    {
        if(listaFacturasCompras == null) listaFacturasCompras = new Lista<>();
        return listaFacturasCompras;
    }

    public void setListaFacturasCompras(Lista<FacturaCompra> listaFacturasCompras) {
        this.listaFacturasCompras = listaFacturasCompras;
    }
    
    
}
