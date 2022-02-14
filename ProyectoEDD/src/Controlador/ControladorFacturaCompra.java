/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleCompra;
import Modelo.FacturaCompra;
import java.util.Date;

/**
 *
 * @author jere_
 */
public class ControladorFacturaCompra 
{
    FacturaCompra factura;//Objeto de la clase factura que se utiliza como auxiliar
    private Double iva;//Valor del iva

    /**
     * Constructor de la clase ControladorFacturaCompra 
     * @param iva es el valor que se aplicara como I.V.A a la factura
     */
    public ControladorFacturaCompra(Double iva)
    {
        this.iva = iva;
        this.factura = new FacturaCompra();
    }

    /**
     * Getter para obtener el I.V.A. de las facturas
     * @return el I.V.A. de las facturas
     */
    public Double getIva() {
        return iva;
    }

    /**
     * Setter para cambiar el I.V.A. de las facturas
     * @param Iva el nuevo  I.V.A. de las facturas
     */
    public void setIva(Double Iva) {
        this.iva = Iva;
    }
 
    /**
     * Getter para obtener el atributo factura del objeto
     * @return el atributo factura del objeto
     */
    public FacturaCompra getFactura() {
        return factura;
    }

    /**
     * Setter para cambiar el atributo factura del objeto
     * @param factura el nuevo atributo factura del objeto
     */
    public void setFactura(FacturaCompra factura) {
        this.factura = factura;
    }

    /**
     * Metodo para generar el numero de factura de la factura
     */
    public void generarNumeroFactura()
    {
        String nroFact = Integer.toString((int)(Math.random()*10000000));
        
        factura.setNroFactura(nroFact);
        
    }
    
    /**
     * Metodo para calcular el subtotal de la factura
     */
    public void calcularSubtotal()
    {
        double subTotal = 0;
        
        for (int i = 0; i < factura.getListaDetalles().length(); i++)
        {
           subTotal+= factura.getListaDetalles().getByIndex(i).getPrecioTotal();
        }
        
        factura.setSubTotal(subTotal);
    }
    
    /**
     * Metodo para calcular el iva de la factura
     */
    public void calcularIva()
    {
        Double precioIva = factura.getSubTotal() * iva;
        factura.setIva(precioIva);
    }
    
    /**
     * Metodo para calcular el total de la factura
     */
    public void calcularTotal()
    {
        double precioFinal = factura.getIva() + factura.getSubTotal();
        
        factura.setTotal(precioFinal);
    }
    
    /**
     * Metodo para agregar un nuevo detalle compra a la factura
     * @param idProducto id del producto que pertenece al nuevo detalle compra
     * @param cantidad cantidad del producto que pertenece al nuevo detalle compra
     * @param precio precio del producto que pertenece al nuevo detalle compra
     */
    public void agregarDetalleCompra(Long idProducto, Integer cantidad, Double precio )
    {
        long id = factura.getListaDetalles().length() + 1;
        
        
        DetalleCompra detCompra = new DetalleCompra(id, factura.getId(), idProducto, cantidad, precio);
        
        factura.getListaDetalles().add(detCompra);
        
        calcularSubtotal();
        calcularIva();
        calcularTotal();
    }
    
    /**
     * Metodo para obtener la fecha en la que se realizo la factura
     */
    public void calcularFecha()
    {
        factura.setFecha(new Date());
    }
    
    
}
