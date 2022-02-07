/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.ModeloTablas;

import Controlador.ControladorFactura;
import Controlador.ControladorValoresPorDefecto;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.DetalleFactura;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alba
 */
public class ModeloTablaFactura extends AbstractTableModel{
    private Lista<DetalleFactura> lista = new Lista();
    private ControladorValoresPorDefecto ctrLVPD = new ControladorValoresPorDefecto();
    private ControladorFactura ctrlFactura = new ControladorFactura(ctrLVPD.getVpd().getIVA());

    public Lista<DetalleFactura> getLista() {
        return lista;
    }

    public void setLista(Lista<DetalleFactura> lista) {
        this.lista = lista;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return lista.length();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nro";
            case 1:
                return "Nombre";
            case 2:
                return "Cantidad";
            case 3:
                return "Porcentaje de Descuento";    
            case 4:
                return "Precio Unitario";
            case 5:
                return "Precio Total";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        DetalleFactura a = lista.getByIndex(arg0);
        if (a != null) {
            switch (arg1) {
                case 0:
                    return (arg0 + 1);
                case 1:
                    return a.getProducto().getNombre();
                case 2:
                    return a.getCantidad();
                case 3:
                    return a.getProducto().getPorcentajeDesc();
                case 4:
                    return ctrlFactura.calcularPrecioUnitario(a);
                case 5:
                    return a.getPrecioTotal();
                default:
                    return null;
            }
        }else{
            return null;
        }
    }
}
