/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Enum;

/**
 *
 * @author ANDRES
 */
public enum Prenda {
    Camiseta, Pantalon, Chompa, Blusa, Vestido, Falda; 
    
    /**
     * Retorna el nombre de la prenda
     * @return El nobmre de prenda
     */
    @Override
    public String toString() {
        return this.name();
    }

}
