/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.ModeloTablas;

import Controlador.ControladorProveedor;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Proveedor;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alba
 */
public class ModeloTablaProveedoresRegistro extends AbstractTableModel
{
    private Lista<Proveedor> listaProveedores;

    public ModeloTablaProveedoresRegistro(Lista<Proveedor> listaProveedores)
    {
        this.listaProveedores = listaProveedores;
    }


    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return listaProveedores.length();
    }

    @Override
    public String getColumnName(int column) 
    {
        switch (column)
        {
            case 0:
                return "Nro";
            case 1:
                return "Nombres";
            case 2:
                return "R.U.C";
            case 3:
                return "Dirección";    
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) 
    {
        Proveedor p = listaProveedores.getByIndex(arg0);
        if (p != null) {
            switch (arg1) {
                case 0:
                    return (arg0 + 1);
                case 1:
                    return p.getNombreProveedor()+ " " + p.getApellidoProveedor();
                case 2:
                    return p.getRuc();
                case 3:
                    return p.getDireccionProveedor();
                default:
                    return null;
            }
        }else{
            return null;
        }
    }
}
