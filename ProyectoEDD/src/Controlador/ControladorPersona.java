/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Cuenta;
import Modelo.Factura;
import Modelo.Persona;
import Modelo.Rol;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

/**
 *
 * @author santiago-arg
 */
public class ControladorPersona extends AdaptadorDao<Persona> {

    private Lista<Persona> personas;
    private Persona persona;
    private Factura factura;
    private Rol rol;

    public ControladorPersona() {
        super(Persona.class);
        listar();
    }

    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public void cargarRol(Long id, String nombreRol) {
        getRol().setId(id);
        getRol().setNombreRol(nombreRol);
    }

    public Lista<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(Lista<Persona> personas) {
        this.personas = personas;
    }

    public Persona getPersona() {
        if (persona == null) {
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

    public void asignarNuevaPersona(Long id, String n, String a, Rol r, String d, String co, String ident, String ti, Cuenta c, Lista<Factura> lFacturas) {
        Persona p = new Persona();
        p.setId(id);
        p.setNombres(n);
        p.setApellidos(a);
        p.setId_Rol(r);
        p.setDireccion(d);
        p.setCorreo(co);
        p.setIdentificacion(ident);
        p.setTipoDeIdentificacion(ti);
        p.setCuenta(c);
        p.setFacturas(lFacturas);

        this.setPersona(p);

    }

    public boolean guardarFactura(Factura f) {
        if (getPersona().getId() != null) {
            f.setId_Persona(persona.getId());
            persona.getFacturas().add(f);
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

    public boolean verificarCedula(String cedula) {
        boolean bandera = true;
        String cedulaIngresada = cedula;
        char arregloCedula[] = cedulaIngresada.toCharArray();
        int numeroPosicionPar = 0;
        int numeroPosicionImpar = 0;
        int suma = 0;
        int numeroFinal = 0;
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0 || i == 0) {
                if (Character.getNumericValue(arregloCedula[i]) * 2 > 9) {
                    numeroPosicionImpar += (Character.getNumericValue(arregloCedula[i]) * 2) - 9;
                } else {
                    numeroPosicionImpar += Character.getNumericValue(arregloCedula[i]) * 2;
                }
            }
            if (i % 2 != 0) {
                numeroPosicionPar += Character.getNumericValue(arregloCedula[i]);
            }
        }
        numeroFinal = Character.getNumericValue(arregloCedula[9]);
        suma = numeroPosicionImpar + numeroPosicionPar;
        int verificador = 10 - (suma % 10);
        if (numeroFinal == verificador) {
            return bandera;
        } else {
            return !bandera;
        }
    }

    public Boolean repetido(String identificacion, String correo) {
        personas = listar();
        for (int i = 0; i < personas.length(); i++) {
            System.out.println("Repetido: " + personas.getByIndex(i).getIdentificacion() + personas.getByIndex(i).getCorreo());
            if (identificacion.equals(personas.getByIndex(i).getIdentificacion())) {
                return false;
            } else if (correo.equals(personas.getByIndex(i).getCorreo())) {
                return false;
            }
        }
        return true;
    }

    public boolean verificar_Email(String correo) {
        Pattern pt = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pt.matcher(correo);
        return mat.find();
    }

    public Boolean verificar_Pasaporte(String pasaporte) {
        return pasaporte.length() == 9;
    }

    public Boolean verificar_Ruc(String ruc) {
        String rucCedula = ruc.substring(0, 10);
        return verificarCedula(rucCedula);
    }

    public void crearCuenta(String clave) {
        Cuenta cuenta = new Cuenta(this.persona.getId(), this.persona.getCorreo(), clave, this.persona.getId(), true);
        this.persona.setCuenta(cuenta);
    }

    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    public void crearPDF(Factura factura, String path) throws DocumentException{
        FileOutputStream ficheroPdf = null;
        DecimalFormat dc = new DecimalFormat("##.##");
        try {
            Document documento = new Document();
            ficheroPdf = new FileOutputStream(path);
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            documento.open();
            
            documento.add(new Paragraph("TIENDA DE ROPA\n"));
            documento.add(new Paragraph("NRO FACTURA: "+factura.getNroFactura()));
            documento.add(new Paragraph("FECHA DE EMISION: "+factura.getFecha().getDate()+"/"+(factura.getFecha().getMonth()+1)+"/"+(factura.getFecha().getYear()+1900)));
            documento.add(new Paragraph("IDENTIFICACIÓN: "+persona.getIdentificacion()));
            documento.add(new Paragraph("CLIENTE: "+persona.getNombres()+" "+persona.getApellidos()));
            documento.add(new Paragraph("DIRECCION: "+persona.getDireccion()));
            documento.add(new Paragraph("E-MAIL: "+persona.getCorreo()));
            documento.add(new Paragraph("\n\n"));
            
            PdfPTable tabla = new PdfPTable(5);
            int j = 0;
            for (int i = 0; i < (5*(factura.getDetallesFactura().length()+1)); i++) {
                if(i < 5){
                    switch(i){
                        case 0:
                            tabla.addCell("NOMBRE");
                            break;
                        case 1:
                            tabla.addCell("CANTIDAD");
                            break;
                        case 2:
                            tabla.addCell("PORCENTAJE DE DESCUENTO");
                            break;
                        case 3:
                            tabla.addCell("PRECIO UNITARIO");
                            break;
                        case 4:
                            tabla.addCell("PRECIO TOTAL");
                            break;
                    }
                }else if(i % 5 == 0){
                    tabla.addCell(factura.getDetallesFactura().getByIndex(j).getProducto().getNombre());
                    tabla.addCell(String.valueOf(factura.getDetallesFactura().getByIndex(j).getCantidad()));
                    tabla.addCell(String.valueOf(factura.getDetallesFactura().getByIndex(j).getProducto().getPorcentajeDesc()));
                    tabla.addCell(String.valueOf(factura.getDetallesFactura().getByIndex(j).getPrecioUnitario()));
                    tabla.addCell(String.valueOf(factura.getDetallesFactura().getByIndex(j).getPrecioTotal()));
                    j++;
                    i += 5;
                }
            }
            documento.add(tabla);
            documento.add(new Paragraph("\n\n"));
            documento.add(new Paragraph("SUBTOTAL: "+ dc.format(factura.getSubTotal())));
            documento.add(new Paragraph("VALOR IVA: "+dc.format(factura.getIva())));
            documento.add(new Paragraph("TOTAL: "+dc.format(factura.getTotal())));
            documento.close();
         } catch (FileNotFoundException ex) {
            System.out.println("error1pdf");
        } catch (DocumentException ex) {
            System.out.println("error2pdf");
        } finally {
            try {
                ficheroPdf.close();
            } catch (IOException ex) {
                System.out.println("error3pdf");
            }
        }
    }
}
