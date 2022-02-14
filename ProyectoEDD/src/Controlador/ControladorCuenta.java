/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cuenta;

/**
 *
 * @author santiago-arg
 */
public class ControladorCuenta {

    private Cuenta cuenta;

    /**
     *
     * Getter
     * @return Devuelve el valor de la variable cuenta
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     *
     * Setter 
     * @param cuenta asignado a la variable cuenta
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
