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
    private Double IVA;
    private String codigoAdmin;

    public ValoresPorDefecto(Double IVA, String codigoAdmin) {
        this.IVA = IVA;
        this.codigoAdmin = codigoAdmin;
    }

    
    
    public Double getIVA() {
        return IVA;
    }

    public void setIVA(Double IVA) {
        this.IVA = IVA;
    }

    public String getCodigoAdmin() {
        return codigoAdmin;
    }

    public void setCodigoAdmin(String codigoAdmin) {
        this.codigoAdmin = codigoAdmin;
    }
    
    
}
