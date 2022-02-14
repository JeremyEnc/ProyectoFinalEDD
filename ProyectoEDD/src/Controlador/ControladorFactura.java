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
import java.util.Objects;

/**
 *
 * @author Alba
 */
public class ControladorFactura {

    private Persona persona; //persona dueña de la factura
    private Factura factura; //factura actual 
    private DetalleFactura detalleFactura; //detalle perteneciente a la lista de detalles de la factura
    private Double IVA; //valor de IVA que puede ser cambiante
    
    /**
     * Se inicializa el controlador con el valor de IVA que se haya puesto por defecto
     * @param IVA Es Double se refiere al IVA por defecto 
     */
    public ControladorFactura(Double IVA) {
        this.IVA = IVA;
    }

    /**
     * Retorna el detalle de la factura actual en el controlador
     * @return DetalleFactura detalleFactura de la factura
     */
    public DetalleFactura getDetalleFactura() {

        return detalleFactura;
    }
    
    /**
     * Permite establecer un detalle de factura en el controlador
     * @param detalleFactura de tipo DetalleFactura
     */
    public void setDetalleFactura(DetalleFactura detalleFactura) {
        this.detalleFactura = detalleFactura;
    }
    
    /**
     * Devuelve el objeto factura actual en el controlador
     * @return Factura factura actual
     */
    public Factura getFactura() {
        if (factura == null) {
            factura = new Factura();
        }
        return factura;
    }
    
    /**
     * Permite establecer una factura en el controlador
     * @param factura de tipo Factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    /**
     * Devuelve el objeto persona actual en el controlador
     * @return Persona persona del controlador
     */
    public Persona getPersona() {
        return persona;
    }
    
    /**
     * Permite establecer una persona en el controlador
     * @param persona de tipo Persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * Permite cargar un detalle de factura con sus respectivos atributos
     * @param idP Long ID del producto correspondiente al detalle
     * @param p Producto producto que del que va a ser el detalle
     * @param c Integer cantidad de productos en el detalle
     * @param pu Double precio unitario del producto del que va a ser el detalle
     * @param pt Double precio total del detalle con sus respectivos calculos
     */
    public void cargarDetalleFactura(Long idP, Producto p, Integer c, Double pu, Double pt)
    {
        DetalleFactura df = new DetalleFactura(idP, p, c, pt, pt);
        setDetalleFactura(df);
    }

    /**
     * guarda el detalleFactura en la lista de detalles facturas perteneciente a la factura del controlador
     * @return Boolean si se guarda el detalle de manera exitosa
     */
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
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Permite borrar cualquier detalle de la factura a partir del id del producto 
     * y no afecta a la lista de detalles de la factura
     * @param idProducto ID del producto dentro del detalle
     * @return Boolean si se borra el detalle de manera exitosa
     */
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
    
    /**
     * Permite calcular el total sin IVA de la factura actual en el controlador
     * y lo asigna directamente en la factura
     */
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
    
    /**
     * Permite calcular el valor del IVA
     */
    public void calcularIva() 
    {
        Double iva = factura.getSubTotal() * IVA;
        factura.setIva(iva);
    }

    /**
     * Permite calcular el total de la factura actual en el controlador
     */
    public void calcularTotal() {
        Double total = factura.getIva() + factura.getSubTotal();
        factura.setTotal(total);
    }
    
    /**
     * Permite calcular el precio unitario con respecto a si hay o no 
     * valor de descuento en el producto
     * @param detalleFactura de tipo DetalleFactura
     * @return Double precio real del producto con su descuento
     */
    public Double calcularPrecioUnitario(DetalleFactura detalleFactura) {
        ControladorProducto productCtrl = new ControladorProducto();
        productCtrl.setProducto(detalleFactura.getProducto());
        Double precioReal = (detalleFactura.getProducto().getPrecioVenta()) - (productCtrl.calcularDescuento());
        detalleFactura.setPrecioUnitario(precioReal);
        return precioReal;
    }
    /**
     * Permite generar numeros aleatorios para las facturas y se lo asigna a la misma
     */
    public void generar_nroFactura() {
        String nroFactura = String.valueOf((int)(Math.random() * 10000000));
        for (int i = 0; i < persona.getFacturas().length(); i++) {
            if (Objects.equals(persona.getFacturas().getByIndex(i).getNroFactura(), nroFactura)) {
                nroFactura = String.valueOf((int)(Math.random() * 10000000));
                i = 0;
            }
        }
        factura.setNroFactura(nroFactura);
    }
}
