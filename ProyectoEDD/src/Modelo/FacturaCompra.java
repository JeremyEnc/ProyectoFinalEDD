/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.EstructurasDinamicas.Lista;
import java.util.Date;

/**
 *
 * @author jere_
 */
public class FacturaCompra
{
    private Long id;
    private String nroFactura;
    private Date fecha;
    private Double subTotal;
    private Double iva;
    private Double total;
    private Lista<DetalleCompra> listaDetalles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Lista<DetalleCompra> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(Lista<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
    
    
}

