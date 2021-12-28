/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Marca;
import Modelo.Producto;
import Modelo.enums.Prenda;
import Modelo.enums.TipoPrenda;

/**
 *
 * @author Usuario
 */
public class ProductoController extends AdaptadorDao<Producto>{
    Producto producto;
    Lista<Producto> productos = new Lista();
    
    public ProductoController(){
        super(Producto.class);
    }
   
    public Producto getProducto() {
        if (producto == null){
            producto = new Producto();
        }
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Lista<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }
    
    
    public boolean crearProducto(Marca marca, Double precioVenta, Double precioCompra, int stock, String nombre, String codigo, Long idProducto, TipoPrenda tipoPrenda, Prenda prenda, int porcentajeDesc, boolean estadoDes){
        try {
            Double desc = Double.valueOf(porcentajeDesc/100);
            producto = new Producto(marca, precioVenta, precioCompra, stock, nombre, codigo, idProducto, tipoPrenda, prenda, desc, estadoDes);
            producto.setId(new Long(listar().length()+1));
            return guardar(producto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public double calcularDescuento(){
        return producto.getPrecioVenta() * producto.getPorcentajeDesc();
    }
    
    public void eliminarProducto(){
        this.producto = null;
        listar();
    }
    
    public Prenda buscarPrenda(int prendaIndex) {
        switch (prendaIndex){
            case 0: return Prenda.Camiseta;
            case 1: return Prenda.Pantalon;
            case 2: return Prenda.Chompa;
            case 3: return Prenda.Blusa;
            case 4: return Prenda.Vestido;
            case 5: return Prenda.Falda;
            default: return null;
        }
    }
    
    public TipoPrenda buscarTipoPrenda(int index) {
        switch (index){
            case 0: return TipoPrenda.Hombre;
            case 1: return TipoPrenda.Mujer;
            case 2: return TipoPrenda.Unisex;
            default: return null;
        }
    }
    
    
}
