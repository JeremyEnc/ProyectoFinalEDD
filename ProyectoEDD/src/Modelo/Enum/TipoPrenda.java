/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Enum;

/**
 *
 * @author Usuario
 */
public enum TipoPrenda {
    Hombre, Mujer, Unisex;
    
    /**
     * Retorna el tipo de prenda
     * @return El tipo de prenda
     */
    @Override
    public String toString() {
        return this.name();
    }
    
}
