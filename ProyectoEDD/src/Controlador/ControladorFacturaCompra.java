/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DetalleCompra;
import Modelo.FacturaCompra;
import Modelo.Proveedor;

/**
 *
 * @author jere_
 */
public class ControladorFacturaCompra 
{
    FacturaCompra factura;
    Proveedor proveedor;
    
    public FacturaCompra getFactura() {
        return factura;
    }

    public void setFactura(FacturaCompra factura) {
        this.factura = factura;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
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
        double precioIva = factura.getSubTotal() * 0.12;
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
    }
    
    
}
