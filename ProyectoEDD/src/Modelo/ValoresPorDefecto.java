/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Alba
 */
public class ValoresPorDefecto implements Serializable
{
    private Double IVA; //valor del IVA dentro del sistema
    private String codigoAdmin; //codigo para registrar a alguien como administrador
    

    /**
     * Constructor de la clase, se inicializa con los valores por defecto que se deseen
     * @param IVA valor del iva en el sistema de tipo Double
     * @param codigoAdmin codigo para registrar a alguien como administrador de tipo String
     */
    public ValoresPorDefecto(Double IVA, String codigoAdmin) {
        this.IVA = IVA;
        this.codigoAdmin = codigoAdmin;
    }

    /**
     * Retorna el iva por defecto ingresado en el sistema
     * @return Double valor de iva
     */
    public Double getIVA() {
        return IVA;
    }

    /**
     * Permite establecer un valor de iva por defecto
     * @param IVA valor de IVA dentro del sistema de tipo Double
     */
    public void setIVA(Double IVA) {
        this.IVA = IVA;
    }

    /**
     * Retorna el codigo de administrador que se encuentra ingresado en el sistema
     * @return String codigo de administrador
     */
    public String getCodigoAdmin() {
        return codigoAdmin;
    }

    /**
     * Permite establecer un codigo de administrador
     * @param codigoAdmin codigo para registrar a alguien como administrador de tipo String
     */
    public void setCodigoAdmin(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }
    
    
}
