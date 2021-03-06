/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Producto;
import Modelo.Enum.Prenda;
import Modelo.Enum.Talla;
import Modelo.Enum.TipoPrenda;
import Modelo.Enum.Color;

/**
 *
 * @author ANDRES
 */
    public class ControladorProducto extends AdaptadorDao<Producto> {

    Producto producto;
    Lista<Producto> productos = new Lista();

    /**
     * Constructor vacio de controlador de producto
     */
    public ControladorProducto() {
        super(Producto.class);
    }
    
    /**
     * Retorna el producto actual
     * @return el producto
     */
    public Producto getProducto() {
        if (producto == null) {
            producto = new Producto();
        }
        return producto;
    }
    
    /**
     * Establece el producto
     * @param producto Nuevo producto
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Retorna la lista de productos
     * @return la lista de productos
     */
    public Lista<Producto> getProductos() {
        return productos;
    }
    
    /**
     * Permite establecer la lista de productos
     * @param productos Nueva lista de productos
     */
    public void setProductos(Lista<Producto> productos) {
        this.productos = productos;
    }
    
    /**
     * Guarda el producto actual
     * @return True or False
     */
    public boolean guardar() {
        try {
            Double desc = Double.valueOf(producto.getPorcentajeDesc() / 100);
            producto.setPorcentajeDesc(desc);
            producto.setId(new Long(listar().length() + 1));
            return guardar(producto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Calcula el descuento
     * @return Descuento en dolares
     */
    public double calcularDescuento() {
        return producto.getPrecioVenta() * producto.getPorcentajeDesc();
    }

    /**
     * Elimina el producto seleccionado
     */    
    public void eliminarProducto() {
        setProductos(listar());
        productos.remove(producto.getIdProducto().intValue());
        guardarNuevaLista(productos);
    }
    
    /**
     * Permite buscar la prenda mediante el indice del enum
     * @param prendaIndex
     * @return La prenda
     */
    public Prenda buscarPrenda(int prendaIndex) {
        switch (prendaIndex) {
            case 0:
                return Prenda.Camiseta;
            case 1:
                return Prenda.Pantalon;
            case 2:
                return Prenda.Chompa;
            case 3:
                return Prenda.Blusa;
            case 4:
                return Prenda.Vestido;
            case 5:
                return Prenda.Falda;
            default:
                return null;
        }
    }
    
    /**
     * Permite buscar el tipo de prenda mediante el indicedel enum
     * @param index
     * @return El tipo de prenda
     */
    public TipoPrenda buscarTipoPrenda(int index) {
        switch (index) {
            case 0:
                return TipoPrenda.Hombre;
            case 1:
                return TipoPrenda.Mujer;
            case 2:
                return TipoPrenda.Unisex;
            default:
                return null;
        }
    }
    
    /**
     * Permite buscar la talla por el indice del enum
     * @param index
     * @return La talla
     */
    public Talla buscarTalla(int index) {
        switch (index) {
            case 0:
                return Talla.XS;
            case 1:
                return Talla.S;
            case 2:
                return Talla.M;
            case 3:
                return Talla.L;
            case 4:
                return Talla.XL;
            default:
                return null;
        }
    }
    
    /**
     * Busca el color mediante el indice del color
     * @param index
     * @return El color
     */
    public Color buscarColor(int index) {
        switch (index) {
            case 0:
                return Color.ROJO;
            case 1:
                return Color.AZUL;
            case 2:
                return Color.NEGRO;
            case 3:
                return Color.BLANCO;
            case 4:
                return Color.CAFE;
            case 5:
                return Color.AMARILLO;
            case 6:
                return Color.GRIS;
            case 7:
                return Color.VERDE;
            default:
                return null;
        }
    }
    
    /**
     * Imprime el producto mediante el indice
     * @param i
     * @return Valores de producto en consola
     */
    public Lista<Producto> generarTipo(int i){
        Lista<Producto> lista = new Lista<>();
        productos = listar();
        System.out.println("Tamanio "+productos.length());
        for (int j = 0; j < productos.length(); j++) {
            System.out.println("Producto "+1 +" : "+productos.getByIndex(j).getNombre());
            if(productos.getByIndex(j).getPrenda().equals(buscarPrenda(i))){
                System.out.println("1 "+buscarPrenda(i).name());
                lista.add(productos.getByIndex(j));
            }
        }
        return lista;
    }

}
