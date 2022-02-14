/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Alba
 */
public class DetalleFactura implements Serializable
{
    private Long id; //id del detalle de la factura
    private Long idFactura; //id de la factura a la que pertenece el detalle
    private Long idProdcuto; //id del producto que pertenece al detalle
    private Producto producto; //producto perteneciente al detalle
    private int cantidad; //cantidad de productos del mismo tipo dentro del detalle
    private Double precioUnitario; //precio unitario del producto perteneciente al detalle
    private Double precioTotal; //precio total de todos los productos en el detalle
    
    /**
     * Controlador del detalle factura para inicializarlo con sus atributos correspondientes
     * @param idProdcuto Long ID del producto que pertenecera al detalle
     * @param producto Producto producto perteneciente al detalle
     * @param cantidad Integer cantidad de productos en el detalle
     * @param precioUnitario Double precio unitario del producto
     * @param precioTotal Double precio total del detalle con todos sus calculos
     */
    public DetalleFactura(Long idProdcuto, Producto producto, int cantidad, Double precioUnitario, Double precioTotal) {
        this.idProdcuto = idProdcuto;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }
    
    /**
     * Retorna el producto del detalle
     * @return Producto producto
     */
    public Producto getProducto() {
        return producto;
    }
    /**
     * Permite establecer el producto en el detalle
     * @param producto producto perteneciente al detalle de tipo Producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    /**
     * Retorna el id del detalle
     * @return Long id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Permite establecer el Id del detalle
     * @param id id del detalle de la factura de tipo Long
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Retorna el id de la factura a la que corresponde el detalle
     * @return Long idFactura
     */
    public Long getIdFactura() {
        return idFactura;
    }
    
    /**
     * Permite establecer el Id de la factura a la que corresponde el detalle
     * @param idFactura id de la factura a la que pertenece el detalle de tipo Long
     */
    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }
    
    /**
     * Retorna el id del producto del detalle
     * @return Long id del producto
     */
    public Long getIdProdcuto() {
        return idProdcuto;
    }

    /**
     * Permite establecer el Id del producto del detalle
     * @param idProdcuto id del producto que pertenece al detalle de tipo Long
     */
    public void setIdProdcuto(Long idProdcuto) {
        this.idProdcuto = idProdcuto;
    }
    
    /**
     * Retorna la cantidad de productos del detalle
     * @return Integer cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Permite establecer la cantidad de productos del detalle
     * @param cantidad cantidad de productos del mismo tipo dentro del detalle de tipo Integer
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Retorna el precio unitario del producto del detalle
     * @return Double precio unitario del producto
     */
    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Permite establecer el precio unitario de cada producto del detalle
     * @param precioUnitario precio unitario del producto perteneciente al detalle de tipo Double
     */
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    /**
     * Retorna el precio total del detalle
     * @return Double precio total 
     */
    public Double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Permite establecer el precio total del detalle
     * @param precioTotal precio total de todos los productos en el detalle de tipo Double
     */
    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
}
