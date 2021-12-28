/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Controlador.Dao.AdaptadorDao;
import Modelo.Cuenta;
import Controlador.EstructurasDinamicas.Lista;
/**
 *
 * @author santiago-arg
 */
public class ControladorCuenta extends AdaptadorDao<Cuenta> {

    private Cuenta cuenta;

    public ControladorCuenta(Class clazz) {
        super(clazz);
    }

    public ControladorCuenta() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {

        if (cuenta == null) {
            cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public boolean guardar() {
        cuenta.setId(new Long(listar().length()+ 1));
        return guardar(cuenta);
    }

    public Cuenta buscarCuentaUsuario(String dato) {
        Cuenta c = null;
        Lista<Cuenta> lista = listar();
        for (int i = 0; i < listar().length(); i++) {
            if (dato.equals(lista.getByIndex(i).getNombreUsuario())) {
                c = lista.getByIndex(i);
                break;
            }
        }
        //System.out.println("CUENTA" + c.getClave() + "=" +c.getCorreo());
        return c;
    }

    public Cuenta inicioSesion(String correo, String clave) {
        Cuenta c = buscarCuentaUsuario(correo);
        System.out.println("CUENTA" + c.getClave() + "=" + c.getNombreUsuario());
        boolean respuesta = (c != null && c.getClave().equals(clave) && c.getEstado());
        System.out.println("RESPUESTA" + respuesta);
        return (c != null && c.getClave().equals(clave) && c.getEstado()) ? c : null;
    }
}
