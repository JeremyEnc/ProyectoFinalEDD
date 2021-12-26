/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Modelo.DetalleCompra;

/**
 *
 * @author jere_
 */
public class ControladorDetalleCompra extends AdaptadorDao<DetalleCompra>
{

    public ControladorDetalleCompra()
    {
        super(DetalleCompra.class);
    }
    
}
