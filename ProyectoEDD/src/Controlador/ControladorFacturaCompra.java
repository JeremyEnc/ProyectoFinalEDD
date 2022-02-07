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
    FacturaCompra factura;
    private Double iva;

    public ControladorFacturaCompra(Double iva)
    {
        this.iva = iva;
        this.factura = new FacturaCompra();
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double Iva) {
        this.iva = Iva;
    }
 
    public FacturaCompra getFactura() {
        return factura;
    }

    public void setFactura(FacturaCompra factura) {
        this.factura = factura;
    }

    public void generarNumeroFactura()
    {
        String nroFact = Integer.toString((int)(Math.random()*10000000));
        
        factura.setNroFactura(nroFact);
        
    }
    
    public void calcularSubtotal()
    {
        double subTotal = 0;
        
        for (int i = 0; i < factura.getListaDetalles().length(); i++)
        {
           subTotal+= factura.getListaDetalles().getByIndex(i).getPrecioTotal();
        }
        
        factura.setSubTotal(subTotal);
    }
    
    public void calcularIva()
    {
        Double precioIva = factura.getSubTotal() * iva;
        factura.setIva(precioIva);
    }
    
    public void calcularTotal()
    {
        double precioFinal = factura.getIva() + factura.getSubTotal();
        
        factura.setTotal(precioFinal);
    }
    
    public void agregarDetalleCompra(Long idProducto, Integer cantidad, Double precio )
    {
        long id = factura.getListaDetalles().length() + 1;
        
        
        DetalleCompra detCompra = new DetalleCompra(id, factura.getId(), idProducto, cantidad, precio);
        
        factura.getListaDetalles().add(detCompra);
        
        calcularSubtotal();
        calcularIva();
        calcularTotal();
    }
    
    public void calcularFecha()
    {
        factura.setFecha(new Date());
    }
    
    
}
