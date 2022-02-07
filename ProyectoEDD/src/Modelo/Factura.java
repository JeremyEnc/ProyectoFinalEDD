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
 * @author Alba
 */
public class Factura implements Serializable
{
    private Long id;
    private Long id_Persona;
    private String nroFactura;
    private Date fecha;
    private Double valorDescuento;
    private Double subTotal;
    private Double iva;
    private Double total;
    private Lista <DetalleFactura> detallesFactura;

    public Long getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

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

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
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

    public Lista<DetalleFactura> getDetallesFactura() 
    {
        if(detallesFactura == null)
            detallesFactura = new Lista<>();
        return detallesFactura;
    }

    public void setDetallesFactura(Lista<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    
    
}
