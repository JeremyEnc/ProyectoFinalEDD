/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Enum.Color;
import Modelo.Enum.TipoPrenda;
import Modelo.Enum.Prenda;
import Modelo.Enum.Talla;
import java.io.Serializable;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Andres
 */
public class Producto implements Serializable {
    Marca marca;
    Long id;
    Double precioVenta;
    Double precioCompra;
    int stock;
    String nombre;
    String codigo;
    Long idProducto;
    TipoPrenda tipoPrenda;
    Talla talla;
    Prenda prenda;
    Color color;
    Double porcentajeDesc;
    boolean estadoDes;
    ImageIcon icon;
    Date fechaCompra;

    /**
     * Retorna la fehca en la que se compro el producto
     * @return La fecha de compra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Establece la fecha en la que se compro el producto
     * @param fechaCompra Nueva fecha de compra
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Constructor del producto con todos los datos
     *
     * @param marca Marca del producto
     * @param precioVenta Precio de venta del producto
     * @param precioCompra Precio de compra del producto
     * @param stock Stock del producto
     * @param nombre Detalles del producto
     * @param codigo Codigo del producto
     * @param idProducto Id del producto
     * @param tipoPrenda Tipo de prenda del producto
     * @param prenda Prenda del producto
     * @param porcentajeDesc Valor en porcentaje del descuento del producto
     * @param estadoDes True o False dependiendo de si existe o no un descuento del producto
     */
    public Producto(Marca marca, Double precioVenta, Double precioCompra, int stock, String nombre, String codigo, Long idProducto, TipoPrenda tipoPrenda, Prenda prenda, Double porcentajeDesc, boolean estadoDes) {
        this.marca = marca;
        this.precioVenta = precioVenta;
        this.precioCompra = precioCompra;
        this.stock = stock;
        this.nombre = nombre;
        this.codigo = codigo;
        this.idProducto = idProducto;
        this.tipoPrenda = tipoPrenda;
        this.prenda = prenda;
        this.porcentajeDesc = porcentajeDesc;
        this.estadoDes = estadoDes;
    }
    /**
     * Constructor vacio del producto
     */
    public Producto() {
    }

    /**
     * Retorna la marca del producto
     * @return La marca del producto
     */
    public Marca getMarca() {
        if (marca == null) {
            marca = new Marca();
        }
        return marca;
    }
    
    /**
     * Retorna la talla del producto
     * @return La talla del producto
     */
    public Talla getTalla() {
        return talla;
    }

    /**
     * Establece la talla del producto
     * @param talla Talla del producto
     */
    public void setTalla(Talla talla) {
        this.talla = talla;
    }

    /**
     * Retorna el color del producto
     * @return El color del producto
     */
    public Color getColor() {
        return color;
    }

    /**
     * Establece el color del producto
     * @param color Nuevo color del producto
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Establece la marca
     * @param marca La marca del producto
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    /**
     * Retorna la id del producto
     * @return La id del producto
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece la id del producto
     * @param id ID del producto
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Retorna el precio de venta del producto
     * @return El precio de venta
     */
    public Double getPrecioVenta() {
        return precioVenta;
    }

    /**
     * Establece el precio de venta del producto
     * @param precioVenta Precio de venta del producto
     */
    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * Retorna el precio de compra del producto
     * @return Precio de venta
     */
    public Double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * Establece el precio de compra del producto
     * @param precioCompra Nuevo precio de compra del producto
     */
    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * Retorna el stock del producto
     * @return Stock del producto
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto
     * @param stock Nuevo stock del producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Retorna el nombre y detalles del producto
     * @return El nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre y detalles del producto
     * @param nombre Nuevo nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna el codigo del producto
     * @return el codigo del producto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el codigo del producto
     * @param codigo Nyevo codigo del producto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna la id del producto
     * @return id del producto
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * Establece la id del producto
     * @param idProducto Nueva id de producto del producto
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    
    /**
     * Retorna el tipo de prenda
     * @return Tipo de prenda
     */
    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }
    
    /**
     * Establece el tipo de prenda
     * @param tipoPrenda Nuevo tipo de prenda  del producto
     */
    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    /**
     * Retorna el nombre de prenda
     * @return Prenda del producto
     */
    public Prenda getPrenda() {
        return prenda;
    }

    /**
     * Estabkece el nombre de prenda
     * @param prenda Nueva prenda del producto
     */
    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    /**
     * Retorna el valor del descuento en porcentaje
     * @return Descuento el procentaje del producto
     */
    public Double getPorcentajeDesc() {
        return porcentajeDesc;
    }

    /**
     * Establecer el valor del descuento en porcentaje
     * @param porcentajeDesc Nuevo porcentaje de descuento del producto
     */
    public void setPorcentajeDesc(Double porcentajeDesc) {
        this.porcentajeDesc = porcentajeDesc;
    }
    
    /**
     * Retorna el estado de descuento (Verdadero o Falso)
     * @return Verdadero o Falso
     */
    public boolean isEstadoDes() {
        return estadoDes;
    }

    /**
     * Establece el estado de descuento (Verdadero o Falso)
     * @param estadoDes Valor True o False
     */
    public void setEstadoDes(boolean estadoDes) {
        this.estadoDes = estadoDes;
    }

    /**
     * Retorna la imagen del producto
     * @return icono  del producto
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Establece la imagen del producto
     * @param icon Nuevo icono del producto
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
