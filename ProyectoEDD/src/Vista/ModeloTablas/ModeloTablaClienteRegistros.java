/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.ModeloTablas;

import Controlador.ControladorFactura;
import Controlador.ControladorPersona;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.DetalleFactura;
import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alba
 */
public class ModeloTablaClienteRegistros extends AbstractTableModel
{
    Lista<Persona> personasLista = new Lista<>();

    public ModeloTablaClienteRegistros(Lista<Persona> personasLista)
    {
        this.personasLista = personasLista;
    }


    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public int getRowCount() {
        return personasLista.length();
    }

    @Override
    public String getColumnName(int column) 
    {
        switch (column)
        {
            case 0:
                return "Nro";
            case 1:
                return "Cliente";
            case 2:
                return "Rol";
            case 3:
                return "Identificación";    
            case 4:
                return "Ultima Compra";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int arg0, int arg1) 
    {
        Persona p = personasLista.getByIndex(arg0);
        if (p != null) {
            switch (arg1) {
                case 0:
                    return (arg0 + 1);
                case 1:
                    return p.getNombres() + " " + p.getApellidos();
                case 2:
                    return p.getId_Rol().getNombreRol();
                case 3:
                    return p.getIdentificacion();
                case 4:
                    return p.getFacturas().getByIndex(p.getFacturas().length() - 1).getFecha();
                default:
                    return null;
            }
        }else{
            return null;
        }
    }
}
