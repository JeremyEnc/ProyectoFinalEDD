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
public class ControladorValoresPorDefecto extends AdaptadorDao<ValoresPorDefecto> {

    ValoresPorDefecto vpd; //valores por defecto del sistema (IVA y codigo de administrador)

    /**
     * Permite retornar los valores por defecto que se tienen actualmente
     *
     * @return ValoresPorDefecto valores actuales del IVA y codigo de
     * administrador
     */
    public ValoresPorDefecto getVpd() {
        return vpd;
    }

    /**
     * Permite establecer valores por defecto
     *
     * @param vpd de tipo ValoresPorDefecto
     */
    public void setVpd(ValoresPorDefecto vpd) {
        this.vpd = vpd;
    }

    /**
     * Controlador que permite establecer los valores por defecto iniciales en
     * caso de que esten nulos y guardarlos en un archivo
     */
    public ControladorValoresPorDefecto() {
        super(ValoresPorDefecto.class);
        vpd = listar().getByIndex(0);

        if (vpd == null) {
            vpd = new ValoresPorDefecto(0.12, "8989");
            guardar(vpd);
        }
    }

    /**
     * Permite asignar los valoresPorDefecto requeridos por un administrador del
     * sistema En caso de ser nulos en un principio se estableceran los
     * iniciales
     *
     * @param iva Double iva por defecto que se puede cambiar
     * @param cod String codigo del administrador
     */
    public void asignarValoresPorDefecto(Double iva, String cod) {
        if (vpd == null) {
            vpd = new ValoresPorDefecto(0.12, "8989");
            guardar(vpd);
        } else {
            vpd = new ValoresPorDefecto(iva, cod);
            modificar(vpd, 0);
        }
    }
}
