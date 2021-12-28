/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Factura;
import Modelo.Persona;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author santiago-arg
 */
public class ControladorPersona extends AdaptadorDao<Persona>{
    
    

    private final String CARPETA = "datos" + File.separatorChar + Persona.class.getSimpleName() + ".obj";
    private Lista<Persona> personas = new Lista();
    private Persona persona;
    private Factura factura;

    public ControladorPersona() {
        super(Persona.class);
    }

    public Lista<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Lista<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public boolean guardarFactura() {
        if (getPersona().getId() != null) {
            factura.setId_Persona(persona.getId());
            persona.getFacturas().add(factura);
            Lista<Persona> aux = listar();
            int pos = -1;
            for (int i = 0; i < aux.length(); i++) {
                if (aux.getByIndex(i).getId().intValue() == getPersona().getId().intValue()) {
                    pos = i;
                    break;
                }
            }
            if (pos >= 0) {
                try {
                    aux.replace(getPersona(), pos);
                    guardarArchivo(aux);
                    return true;
                } catch (Exception e) {
                }
            }

        }
        return false;
    }

    private void guardarArchivo(Lista<Persona> aux) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
        oos.writeObject(aux);
        oos.close();
    }

    public Lista<Persona> listar() {
        Lista<Persona> lista = new Lista();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CARPETA));
            lista = (Lista<Persona>) ois.readObject();
            personas = lista;
            ois.close();
        } catch (Exception e) {
            System.out.println("Error en leer archivo");
        }
        return lista;
    }
    
    public boolean modificar() {
        Lista<Persona> aux = listar();
        try {
            for (int i = 0; i < aux.length(); i++) {
                if (aux.getByIndex(i).getId().intValue() == getPersona().getId().intValue()) {
                    aux.replace(persona, i);
                    guardarArchivo(aux);
                    break;
                }
            }

            return true;
        } catch (Exception e) {
            System.out.println("No se ha guardado");
            e.printStackTrace();
            return false;
        }
    }
    public boolean guardarPersona() {
        Lista<Persona> aux = listar();
        try {
            persona.setId(Long.valueOf((aux.length()+ 1)));
            //aux.insertarFinal(persona);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CARPETA));
            oos.writeObject(aux);
            oos.close();
            personas = aux;
            guardarArchivo(aux);
            return true;
        } catch (Exception e) {
            System.out.println("No se ha guardado");
            e.printStackTrace();
            return false;
        }
    }
}
