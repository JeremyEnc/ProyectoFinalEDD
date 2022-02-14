/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Enum.Prenda;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ANDRES
 */
public class Kardex implements Serializable{
    //0 = compra; 1 = venta
    private Long tipoId;
    private Date fecha;
    private String detalle;
    private Double valorUnitario;
    private int cantidad;
    private double total;
    private int cantidadTotal;
    private double totalFinal;
    private Prenda prenda;
    private static final long serialVersionUID = 8056012889477739846l;
    /**
     * Retorna la prenda del kardex
     * @return La prenda
     */
    public Prenda getPrenda() {
        return prenda;
    }
    
    /**
     * Establece la prenda del kardex
     * @param prenda Nueva prenda
     */
    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }
    
    /**
     * Retorna el tipo de id del kardex (Siendo 0 una compra, y 1 una venta)
     * @return El tipo de id del kardex
     */
    public Long getTipoId() {
        return tipoId;
    }

    /**
     * Establece el tipo de id del kardex (Siendo 0 una compra, y 1 una venta)
     * @param tipoId Tipo de id del kardex
     */
    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    /**
     * Retorna la fecha en la que se realizo la compra o la venta
     * @return La fecha de compra o de la venta
     */
    public Date getFecha() {
        return fecha;
    }
    
    /**
     * Establece la fecha en la que se realizo la compra o la venta
     * @param fecha Nueva fecha de compra o venta
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna los detalles del producto comprado o vendido
     * @return Los detalles del producto
     */
    public String getDetalle() {
        return detalle;
    }
    
    /**
     * Establece los detalles del producto comprado o vendido
     * @param detalle Nuevo detalle de kardex
     */
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    /**
     * Retorna el valor unitario del producto
     * @return El valor unitario
     */
    public Double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Establece el valor unitario del producto
     * @param valorUnitario  Valor unitario del producto
     */
    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    
    /**
     * Retorna la cantidad del producto
     * @return la cantidad del producto
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Establece la cantidad adquirida o vendida del producto
     * @param cantidad La cantidad del producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    /**
     * Retorna el precio total de la compra o venta
     * @return Valor total
     */
    public double getTotal() {
        return total;
    }
    
    /**
     * Establece el precio total de la compra o venta
     * @param total Precio total
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    /**
     * Retorna la cantidad total comprada o vendida del producto
     * @return La cantidad total
     */
    public int getCantidadTotal() {
        return cantidadTotal;
    }
    
    /**
     * Establecer la cantidad total comprada o vendida del producto
     * @param cantidadTotal Cantidad total del producto
     */
    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    /**
     * Retorna el valor total final comprado o vendido del producto
     * @return Valor final
     */
    public double getTotalFinal() {
        return totalFinal;
    }

    /**
     * Establece el valor total final comprado o vendido del producto
     * @param totalFinal Valor final 
     */
    public void setTotalFinal(double totalFinal) {
        this.totalFinal = totalFinal;
    }
}
