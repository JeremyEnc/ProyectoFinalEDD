/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Modelo.Proveedor;

/**
 *
 * @author jere_
 */
public class ControladorProveedor extends AdaptadorDao<Proveedor>
{
    
    public ControladorProveedor()
    {
        super(Proveedor.class);
    }
    
}
