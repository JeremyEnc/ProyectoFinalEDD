/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.ModeloTablas;

import Controlador.EstructurasDinamicas.Lista;
import Modelo.Kardex;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ANDRES
 */
public class ModeloTablaKardex extends AbstractTableModel {
    Lista<Kardex> productosLista = new Lista<>();

   /**
    * Retorna la lista de objetos kardex
    * @return Lista de tipo kardex
    */
    public Lista<Kardex> getProductosLista() {
        return productosLista;
    }

    /**
     * Aux = 0 => Compra
     * Aux = 1 => Venta
     * @param productosLista 
     */
    public void setProductosLista(Lista<Kardex> productosLista) {   
        this.productosLista = productosLista;
    }
    
    /**
     * Constructor vacio de Modelo Tabla Kardex
     */
    public ModeloTablaKardex() {
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public int getRowCount() {
        return productosLista.length();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Fecha";
            case 1:
                return "Detalle";
            case 2:
                return "Valor Unitario";
            case 3:
                return "Cantidad";
            case 4:
                return "Total";
            case 5:
                return "Valor Unitario";
            case 6:
                return "Cantidad";
            case 7:
                return "Total";
            case 8:
                return "Cantidad Total";
            case 9:
                return "TOTAL";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        Kardex p = productosLista.getByIndex(arg0);
        if (p != null && p.getTipoId().intValue() == 0) {
            switch (arg1) {
                case 0:
                    return p.getFecha().getDate()+"/"+((p.getFecha().getMonth())+1)+"/"+(p.getFecha().getYear()+1900);
                case 1:
                    return p.getDetalle();
                case 2:
                    return p.getValorUnitario();
                case 3:
                    return p.getCantidad();
                case 4:
                    return p.getTotal();
                case 5:
                    return "";
                case 6:
                    return "";
                case 7:
                    return "";
                case 8:
                    return p.getCantidadTotal();
                case 9:
                    return p.getTotalFinal();
                default:
                    return null;
            }
        } else if (p != null && p.getTipoId().intValue() == 1) {
            switch (arg1) {
                case 0:
                    return p.getFecha().getDate()+"/"+((p.getFecha().getMonth())+1)+"/"+(p.getFecha().getYear()+1900);
                case 1:
                    return p.getDetalle();
                case 2:
                    return "";
                case 3:
                    return "";
                case 4:
                    return "";
                case 5:
                    return p.getValorUnitario();
                case 6:
                    return p.getCantidad();
                case 7:
                    return p.getTotal();
                case 8:
                    return p.getCantidadTotal();
                case 9:
                    return p.getTotalFinal();
                default:
                    return null;
            }
        }
        return null;
    }
}
