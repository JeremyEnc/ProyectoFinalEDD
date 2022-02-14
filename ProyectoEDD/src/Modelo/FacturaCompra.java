/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.EstructurasDinamicas.Lista;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jere_
 */
public class FacturaCompra implements Serializable
{
    private Long id;// id del objeto factura compra
    private String nroFactura;// numero de la factura
    private Date fecha;// fecha en la que se realizo la factura
    private Double subTotal;// subtotal de las compras de la factura
    private Double iva;// iva que se aplicara al subtotal de la factura
    private Double total;// total entre el subtotal y el iva
    private Lista<DetalleCompra> listaDetalles;// lista de los detalles compra de cada producto

    /**
     * Getter para obtener el id del objeto factura
     * @return id del objeto factura
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Setter para cambiar el id 
     * @param id el nuevo id del objeto factura
     */
    public void setId(Long id) {
        this.id = id;
    }
        
    
    /**
     * Getter para obtener el nro de la factura
     * @return el numero de la factura
     */
    public String getNroFactura() {
        return nroFactura;
    }

    /**
     * Setter para cambiar el numero de la factura
     * @param nroFactura el numero de la factura
     */
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    /**
     * Getter para obtener la fecha en que se realizo la factura
     * @return la fecha en que se realizo la factura
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Setter para cambiar la fecha en que se realizo la factura
     * @param fecha la nueva fecha de la factura
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Getter para obtener el subtotal de la factura
     * @return el subtotal de la factura
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * Setter para cambiar el subtotal de la factura
     * @param subTotal el nuevo subtotal de la factura
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Getter para obtener el I.V.A. de la factura
     * @return el I.V.A. de la factura
     */
    public Double getIva() {
        return iva;
    }

    /**
     * Setter para cambiar el I.V.A. de la factura
     * @param iva el nuevo valor de I.V.A de la factura
     */
    public void setIva(Double iva) {
        this.iva = iva;
    }
    
    /**
     * Getter para obtener el total de la factura
     * @return el total de la factura
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Setter para cambiar el total de la factura
     * @param total el nuevo total de la factura
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Getter para obtener la lista de DetallesCompra de la factura
     * @return lista de DetallesCompra de la factura
     */
    public Lista<DetalleCompra> getListaDetalles() 
    {
        if(listaDetalles == null)
        {
            listaDetalles = new Lista<>();
        }
        return listaDetalles;
    }
    
    /**
     * Setter para cambiar la lista de DetallesCompra de la factura
     * @param listaDetalles la nueva lista de DetallesCompra de la factura
     */
    public void setListaDetalles(Lista<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
    
    
}

