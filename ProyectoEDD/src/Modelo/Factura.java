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
public class Factura implements Serializable {

    private Long id; //id de la factura
    private Long id_Persona; //id de la persona dueña de la factura
    private String nroFactura; //nro de la factura (aleatorio)
    private Date fecha; //fecha de creacion de la factura
    private Double valorDescuento; //valor de descuento en la factura
    private Double subTotal; //sub total de la factura (precio total sin IVA)
    private Double iva; //iva de la factura
    private Double total; //precio total en la factura (subtotal + iva)
    private Lista<DetalleFactura> detallesFactura; //lista de detalles en la factura (un producto en cada detalle)

    /**
     * Retorna el id de la persona dueña de la factura
     *
     * @return id de la persona Long
     */
    public Long getId_Persona() {
        return id_Persona;
    }

    /**
     * Permite establecer un id de la persona dueña de la factura
     *
     * @param id_Persona id de la persona dueña de la factura de tipo Long
     */
    public void setId_Persona(Long id_Persona) {
        this.id_Persona = id_Persona;
    }

    /**
     * Retorna el id de la factura
     *
     * @return Long id factura
     */
    public Long getId() {
        return id;
    }

    /**
     * Permite establecer un id a la factura
     *
     * @param id Long id de la factura
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retorna el nro de la factura
     *
     * @return String numero de la factura
     */
    public String getNroFactura() {
        return nroFactura;
    }

    /**
     * Permite establecer el nro de la factura
     *
     * @param nroFactura de tipo String
     */
    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    /**
     * Retorna la fecha en la que se hizo la factura
     *
     * @return Date fecha factura
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Permite estblecer una fecha a la factura
     *
     * @param fecha fecha de creacion de la factura de tipo Date
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna el valor de descuento en la factura
     *
     * @return Double valor de descuento
     */
    public Double getValorDescuento() {
        return valorDescuento;
    }

    /**
     * Permite establecer un valor de descuento en la factura
     *
     * @param valorDescuento valor de descuento en la factura de tipo Double
     */
    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    /**
     * Retorna el sub total de la factura (total sin iva)
     *
     * @return Double sub total
     */
    public Double getSubTotal() {
        return subTotal;
    }

    /**
     * Permite establecer el sub total de la factura (total sin iva)
     *
     * @param subTotal de tipo Double
     */
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Retorna el iva de la factura
     *
     * @return Double iva
     */
    public Double getIva() {
        return iva;
    }

    /**
     * Permite establecer un valor de iva en la factura
     *
     * @param iva de tipo Double
     */
    public void setIva(Double iva) {
        this.iva = iva;
    }

    /**
     * Retorna el valor total de la factura
     *
     * @return Double valor total
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Permite establecer un valor total en la factura (subtotal + iva)
     *
     * @param total precio total en la factura (subtotal + iva) de tipo Double
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Retorna la lista de detalles de la factura, si es nula la crea
     *
     * @return DetalleFactura lista de detalles
     */
    public Lista<DetalleFactura> getDetallesFactura() {
        if (detallesFactura == null) {
            detallesFactura = new Lista<>();
        }
        return detallesFactura;
    }

    /**
     * Permite establecer una lista de detalles en la factura
     *
     * @param detallesFactura lista de detalles en la factura (un producto en cada detalle) de tipo DetalleFactura
     */
    public void setDetallesFactura(Lista<DetalleFactura> detallesFactura) {
        this.detallesFactura = detallesFactura;
    }
}
