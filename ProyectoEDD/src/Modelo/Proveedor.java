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
    private Long id; //id  o identificador del proveedor
    private String ruc; // ruc o identificacion del proveedor
    private String nombreProveedor;// nombre del Proveedor
    private String apellidoProveedor;// apellido del Proveedor
    private String direccionProveedor;// Direccion del proveedor
    Lista<FacturaCompra> listaFacturasCompras;// Lista de facturas que pertenecen al proveedor

    
    /**
     * Constructor del proveedor
     * @param id identificador del nuevo proveedor
     * @param ruc ruc del nuevo proveedor
     * @param nombreProveedor nombre del nuevo proveedor
     * @param apellidoProveedor apellido del nuevo proveedor
     * @param direccionProveedor direccion del nuevo proveedor
     */
    public Proveedor(Long id, String ruc, String nombreProveedor, String apellidoProveedor, String direccionProveedor) {
        this.id = id;
        this.ruc = ruc;
        this.nombreProveedor = nombreProveedor;
        this.apellidoProveedor = apellidoProveedor;
        this.direccionProveedor = direccionProveedor;
    }
    
    /**
     * Getter para devolver el id del objeto proveedor
     * @return id del proveedor
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Setter para devolver el id del objeto proveedor 
     * @param id el nuevo id que se asignara a proveedor
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Getter para devolver el ruc del proveedor
     * @return ruc del proveedor
     */
    public String getRuc() {
        return ruc;
    }
    
    /**
     * Setter para cambiar el ruc del proveedor
     * @param ruc el nuevo ruc que se va 
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * Getter para obtener el nombre del proveedor
     * @return nombre del proveedor
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }
    
    /**
     * Setter para cambiar el nombre del proveedor
     * @param nombreProveedor el nuevo nombre del proveedor
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    
    /**
     * Getter para obtener el apellido del proveedor
     * @return apellido del proveedor
     */
    public String getApellidoProveedor() {
        return apellidoProveedor;
    }

    /**
     * Setter para cambiar el apellido del proveedor
     * @param apellidoProveedor el nuevo apellido del proveedor
     */
    public void setApellidoProveedor(String apellidoProveedor) {
        this.apellidoProveedor = apellidoProveedor;
    }

    /**
     * Getter para obtener la direccion del proveedor 
     * @return direccion del proveedor
     */
    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    /**
     * Setter para cambiar la direccion del proveedor
     * @param direccionProveedor la nueva direccion del proveedor
     */
    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
    
    
    /**
     *Getter para obtener la lista de facturas pertenecientes al proveedor
     * @return lista de facuras 
     */
    public Lista<FacturaCompra> getListaFacturasCompras()
    {
        if(listaFacturasCompras == null) listaFacturasCompras = new Lista<>();
        return listaFacturasCompras;
    }
    
    /**
     * Setter para cambiar la lista de facturas pertenecientes al proveedor
     * @param listaFacturasCompras la nueva lista de facturas
     */
    public void setListaFacturasCompras(Lista<FacturaCompra> listaFacturasCompras) {
        this.listaFacturasCompras = listaFacturasCompras;
    }
    
    
}
