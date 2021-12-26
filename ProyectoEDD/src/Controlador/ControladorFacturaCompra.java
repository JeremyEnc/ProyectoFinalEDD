/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.DetalleCompra;
import Modelo.FacturaCompra;
import Modelo.Proveedor;

/**
 *
 * @author jere_
 */
public class ControladorFacturaCompra extends AdaptadorDao<FacturaCompra> 
{
    Lista<DetalleCompra> listaDetallesCompra;
    Proveedor proveedor;

    public ControladorFacturaCompra()
    {
        super(FacturaCompra.class);
    }
}
