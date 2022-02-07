/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Modelo.ValoresPorDefecto;

/**
 *
 * @author Alba
 */
public class ControladorValoresPorDefecto extends AdaptadorDao<ValoresPorDefecto>
{
    ValoresPorDefecto vpd;

    public ValoresPorDefecto getVpd()
    {
        return vpd;
    }

    public void setVpd(ValoresPorDefecto vpd) {
        this.vpd = vpd;
    }
    
    public ControladorValoresPorDefecto()
    {
        super(ValoresPorDefecto.class);
        vpd = listar().getByIndex(0);
        
        if(vpd == null)
        {
            vpd = new ValoresPorDefecto(0.12, "8989");
            guardar(vpd);
        }
    }

    public void asignarValoresPorDefecto(Double iva, String cod)
    {
        if(vpd == null)
        {
            vpd = new ValoresPorDefecto(0.12, "8989");
            guardar(vpd);
        }
        else
        {
            vpd = new ValoresPorDefecto(iva, cod);
            modificar(vpd, 0);
        }

    }
    
    
    
}
