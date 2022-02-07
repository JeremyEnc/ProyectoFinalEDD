/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.ModeloTablas;

import Controlador.EstructurasDinamicas.Lista;
import Modelo.Producto;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ANDRES
 */
public class ModeloTablaProductoCompra extends AbstractTableModel {
    private Lista<Producto> lista = new Lista();
    
    @Override
    public int getRowCount() {
        return lista.length();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Producto dato = lista.getByIndex(i);
        switch(i1){
            case 0: return dato.getId();
            case 1: return dato.getMarca().getNombreMarca();
            case 2: return dato.getNombre();
            case 3: return dato.getTipoPrenda().name();
            case 4: return dato.getColor().name(); 
            case 5: return dato.getPrenda().name();
            case 6: return dato.getTalla().name();
            case 7: return dato.getPrecioVenta();
            case 8 : return dato.getStock();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int i){
        switch(i){
            case 0: return "ID";
            case 1: return "Marca";
            case 2: return "Nombre";
            case 3: return "Tipo Prenda";
            case 4: return "Color";
            case 5: return "Prenda";
            case 6: return "Talla";
            case 7: return "Precio";
            case 8: return "Stock";
            default: return null;
        }
    }
    /**
     * @return the lista
     */
    public Lista<Producto> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Lista lista) {
        this.lista = lista;
    }
}
