/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author jere_
 */
public class DetalleCompra implements Serializable
{
    private Long id;// id del objeto detalle compra
    private Long idFactura;//id de la factura a la que pertenece el detalle compra                            
    private Long idProducto;//id del producto que pertenece a este detalle compra
    private Integer cantidad;// cantidad del producto que se va a comprar
    private Double precioUnitario;// precio unitario del producto
    private Double precioTotal;//Precio total resultado del precio unitario por la cantidad
    
    /**
     * Constructor de la clase DetalleCompra
     * @param id id del nuevo objeto detalle compra
     * @param idFactura id de la factura a la que pertenece el nuevo detalle compra 
     * @param idProducto id del producto que pertenece a este nuevo detalle compra
     * @param cantidad cantidad del producto que se va a comprar
     * @param precioUnitario precio unitario del producto
     */
    public DetalleCompra(Long id, Long idFactura, Long idProducto, Integer cantidad, Double precioUnitario)
    {
        this.id = id;
        this.idFactura = idFactura;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioUnitario * cantidad;
    }

    /**
     * Getter para obtener el id del objeto DetalleCompra
     * @return el id del objeto DetalleCompra
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter para cambiar el id del objeto DetalleCompra
     * @param id el nuevo id del objeto DetalleCompra
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter para obtener el id de la factura a la que pertenece el detalle Compra
     * @return el id de la factura a la que pertenece el detalle compra
     */
    public Long getIdFactura() {
        return idFactura;
    }

    /**
     * Setter para cambiar el id de la factura a la que pertenece el detalle Compra
     * @param idFactura el nuevo id de la factura a la que pertenece el detalle Compra
     */
    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    /**
     * Getter para obtener el id del producto que pertence al detalle compra
     * @return el id del producto que pertence al detalle compra
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * Setter para cambiar el id del producto que pertence al detalle compra
     * @param idProducto el nuevo id del producto que pertence al detalle compra
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Getter para obtener la cantidad del producto que se va a comprar
     * @return la cantidad del producto que se va a comprar
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Setter para cambiar la cantidad del producto que se va a comprar
     * @param cantidad la nueva cantidad del producto que se va a comprar
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Getter para obtener el precio unitario del producto que pertenece al detalle factura
     * @return el precio unitario del producto que pertenece al detalle factura
     */
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Setter para cambiar el precio unitario del producto que pertenece al detalle factura
     * @param precioUnitario el nuevo precio unitario del producto que pertenece al detalle factura
     */
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Getter para obtner el precioTotal del detalle factura
     * @return el precioTotal del detalle factura
     */
    public Double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Setter para cambiar el precioTotal del detalle factura
     * @param precioTotal el nuevo precioTotal del detalle factura
     */
    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    
}

