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


/**
 *
 * @author santiago-arg
 */
public class ControladorPersona extends AdaptadorDao<Persona>
{

    private Lista<Persona> personas;
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

    public Persona getPersona()
    {
        if(persona == null)
        {
            persona = new Persona();
            personas = listar();
            persona.setId(Long.valueOf(personas.length() + 1));
        }
        
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
                    modificar(persona, pos);
                    return true;
                } catch (Exception e) {
                }
            }

        }
        return false;
    }

}
