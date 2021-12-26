/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.enums.Prenda;
import Modelo.enums.TipoPrenda;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class Producto  implements Serializable{
    Marca marca;
    Long id;
    Double precioVenta;
    Double precioCompra;
    int stock;
    String nombre;
    String codigo;
    Long idProducto;
    TipoPrenda tipoPrenda;
    //Talla talla;
    Prenda prenda;
    //Color color;
    Double porcentajeDesc;
    boolean estadoDes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public TipoPrenda getTipoPrenda() {
        return tipoPrenda;
    }

    public void setTipoPrenda(TipoPrenda tipoPrenda) {
        this.tipoPrenda = tipoPrenda;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Double getPorcentajeDesc() {
        return porcentajeDesc;
    }

    public void setPorcentajeDesc(Double porcentajeDesc) {
        this.porcentajeDesc = porcentajeDesc;
    }

    public boolean isEstadoDes() {
        return estadoDes;
    }

    public void setEstadoDes(boolean estadoDes) {
        this.estadoDes = estadoDes;
    }
    
    
}
