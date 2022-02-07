/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.EstructurasDinamicas.Lista;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.Persona;
import Modelo.Producto;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 * @author Alba
 */
public class ControladorFactura {

    private Persona persona;
    private Factura factura;
    private DetalleFactura detalleFactura;
    private Double IVA;

    public ControladorFactura(Double IVA) {
        this.IVA = IVA;
    }

    
    public DetalleFactura getDetalleFactura() {

        return detalleFactura;
    }

    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Factura getFactura() {
        if (factura == null) {
            factura = new Factura();
        }
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public void cargarDetalleFactura(Long idP, Producto p, Integer c, Double pu, Double pt)
    {
        DetalleFactura df = new DetalleFactura(idP, p, c, pt, pt);
        setDetalleFactura(df);
    }

    public boolean guardarDetalleFactura() {
        if (factura.getId() != null) {
            detalleFactura.setIdFactura(getFactura().getId());
            factura.getDetallesFactura().add(detalleFactura);
            Lista<Factura> aux = persona.getFacturas();
            int pos = -1;
            for (int i = 0; i < aux.length(); i++) {
                if (aux.getByIndex(i).getId().intValue() == getFactura().getId().intValue()) {
                    pos = i;
                    break;
                }
            }
            if (pos >= 0) {
                try {
                    aux.replace(getFactura(), pos);
                    return true;
                } catch (Exception e) {
                    System.out.println("No se ha guardado");
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Boolean borrarDetalle(Long idProducto) {
        if (factura.getId() != null) {
           Lista<DetalleFactura> listaDetalles = factura.getDetallesFactura();
            for (int i = 0; i < listaDetalles.length(); i++) {
                if (listaDetalles.getByIndex(i).getIdProdcuto().intValue() == idProducto.intValue()) {
                    listaDetalles.remove(i);
                    break;
                }
            }
            for (int i = 0; i < listaDetalles.length(); i++) {
                listaDetalles.getByIndex(i).setId(Long.valueOf(i));
            }
            factura.setDetallesFactura(listaDetalles);
            return true;
        }
        return false;
    }

    public void calcularSubTotal() {
        Lista<DetalleFactura> listaDetalles = factura.getDetallesFactura();
        Double precioTotal = 0.0;
        Double precioTotalDescuento = 0.0;
        for (int i = 0; i < listaDetalles.length(); i++) {
            precioTotalDescuento += (listaDetalles.getByIndex(i).getProducto().getPrecioVenta()) - calcularPrecioUnitario(listaDetalles.getByIndex(i));
            precioTotal += calcularPrecioUnitario(listaDetalles.getByIndex(i)) * (listaDetalles.getByIndex(i).getCantidad());
        }
        factura.setSubTotal(precioTotal);
        factura.setValorDescuento(precioTotalDescuento);
    }

    public void calcularIva() 
    {
        Double iva = factura.getSubTotal() * IVA;
        factura.setIva(iva);
    }

    public void calcularTotal() {
        Double total = factura.getIva() + factura.getSubTotal();
        factura.setTotal(total);
    }

    public Double calcularPrecioUnitario(DetalleFactura detalleFactura) {
        ControladorProducto productCtrl = new ControladorProducto();
        productCtrl.setProducto(detalleFactura.getProducto());
        Double precioReal = (detalleFactura.getProducto().getPrecioVenta()) - (productCtrl.calcularDescuento());
        detalleFactura.setPrecioUnitario(precioReal);
        return precioReal;
    }

    public void generar_nroFactura() {
        String nroFactura = String.valueOf((int)(Math.random() * 10000000));
        for (int i = 0; i < persona.getFacturas().length(); i++) {
            if (Objects.equals(persona.getFacturas().getByIndex(i).getNroFactura(), nroFactura)) {
                nroFactura = String.valueOf((int)(Math.random() * 10000000));
                i = 0;
            }
        }
        System.out.println(nroFactura);
        factura.setNroFactura(nroFactura);
    }
}
