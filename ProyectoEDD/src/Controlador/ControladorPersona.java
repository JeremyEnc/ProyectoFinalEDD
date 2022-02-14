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

/**
 *
 * @author santiago-arg
 */
public class ControladorPersona extends AdaptadorDao<Persona> {

    private Lista<Persona> personas;
    private Persona persona;
    private Factura factura;
    private Rol rol;

    /**
     * Contructor del ControladorPersona
     */
    public ControladorPersona() {
        super(Persona.class);
        listar();
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable rol
     */
    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();
        }
        return rol;
    }

    /**
     *
     * Setter
     *
     * @param rol asignado a la variable rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     *
     * @param id del rol de la persona
     * @param nombreRol de la persona
     */
    public void cargarRol(Long id, String nombreRol) {
        getRol().setId(id);
        getRol().setNombreRol(nombreRol);
    }

    /**
     *
     * Getter
     *
     * @return Devuelve una lista de tipo persona
     */
    public Lista<Persona> getPersonas() {
        return personas;
    }

    /**
     *
     * Setter
     *
     * @param personas asignado a la lista personas
     */
    public void setPersonas(Lista<Persona> personas) {
        this.personas = personas;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable perosna
     */
    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
            personas = listar();
            persona.setId(Long.valueOf(personas.length() + 1));
        }

        return persona;
    }

    /**
     *
     * Setter
     *
     * @param persona asignado a la variable persona
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     *
     * Getter
     *
     * @return Devuelve el valor de la variable factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     *
     * Setter
     *
     * @param factura asignado a la variable factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    /**
     * Contructor de persona con todas sus variables
     *
     * @param id de la persona
     * @param n nombre de la persona
     * @param a apellidos de la persona
     * @param r id del rol de la persona
     * @param d direccion de la persona
     * @param co correo de la persona
     * @param ident identificacion de la persona
     * @param ti tipo de identificacion de la persona
     * @param c cuenta de la persona
     * @param lFacturas lista de facturas asociada a la persona
     */
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

    /**
     * Sirve para guardar una factura
     *
     * @param f factura de la persona
     * @return true o false y se guarda la factura
     */
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

    /**
     * Sirve para verificar si una cedula es valida o invalida
     *
     * @param cedula a verificar
     * @return true o false si la cedula es valida o invalida
     */
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

    /**
     * Sirve para verificar si el correo o la identificacion ya han sido
     * registrados
     *
     * @param identificacion a verificar
     * @param correo a verificar
     * @return true o false si el correo o la identificacion ya han sido
     * registrados
     */
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

    /**
     * Sirve para verificar si el correo tiene la estructura correcta
     *
     * @param correo a verificar
     * @return true o false si el correo tiene la estructura correcta
     */
    public boolean verificar_Email(String correo) {
        Pattern pt = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pt.matcher(correo);
        return mat.find();
    }

    /**
     * Sirve para verificar si el pasasporte tiene la longitud correcta.
     *
     * @param pasaporte a verificar
     * @return true o false si el pasaporte tiene la longitud correcta.
     */
    public Boolean verificar_Pasaporte(String pasaporte) {
        return pasaporte.length() == 9;
    }

    /**
     * Sirve para verificar si el ruc tiene la longitud correcta.
     *
     * @param ruc a verificar
     * @return rue o false si el ruc tiene la longitud correcta.
     */
    public Boolean verificar_Ruc(String ruc) {
        String rucCedula = ruc.substring(0, 10);
        return verificarCedula(rucCedula);
    }

    /**
     * Sirve para crear una cuenta
     *
     * @param clave de la cuenta de la persona
     */
    public void crearCuenta(String clave) {
        Cuenta cuenta = new Cuenta(this.persona.getId(), this.persona.getCorreo(), clave, this.persona.getId(), true);
        this.persona.setCuenta(cuenta);
    }

    /**
     * Transforma una variable localDate a date
     *
     * @param dateToConvert fecha en tipo localDate
     * @return fecha en tipo date
     */
    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    /**
     * Crear Pdf de una factura
     *
     * @param factura a la que se creara el documento
     * @param path ruta donde se guardara el documento
     * @throws DocumentException
     */
    public void crearPDF(Factura factura, String path) throws DocumentException, BadElementException, IOException {
        FileOutputStream ficheroPdf = null;
        DecimalFormat dc = new DecimalFormat("##.##");
        try {
            Document documento = new Document();
            ficheroPdf = new FileOutputStream(path);
            PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
            documento.open();

            Image header = Image.getInstance("src/Imagenes/ENCABEZADO.png");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            documento.add(header);

            PdfPTable tablaDatos = new PdfPTable(2);
            for (int i = 0; i < 6; i++) {
                switch (i) {
                    case 0:
                        tablaDatos.addCell("NRO FACTURA: " + factura.getNroFactura());
                        break;
                    case 1:
                        tablaDatos.addCell("FECHA DE EMISION: " + factura.getFecha().getDate() + "/" + (factura.getFecha().getMonth() + 1) + "/" + (factura.getFecha().getYear() + 1900));
                        break;
                    case 2:
                        tablaDatos.addCell("IDENTIFICACIÓN: " + persona.getIdentificacion());
                        break;
                    case 3:
                        tablaDatos.addCell("CLIENTE: " + persona.getNombres() + " " + persona.getApellidos());
                        break;
                    case 4:
                        tablaDatos.addCell("DIRECCION: " + persona.getDireccion());
                        break;
                    case 5:
                        tablaDatos.addCell("E-MAIL: " + persona.getCorreo());
                        break;
                }
            }
            documento.add(new Paragraph("\n\n"));
            Paragraph q = new Paragraph("DATOS CLIENTE");
            q.setAlignment(Element.ALIGN_CENTER);
            documento.add(q);
            documento.add(new Paragraph("\n\n"));
            
            documento.add(tablaDatos);
            
            documento.add(new Paragraph("\n\n"));
            Paragraph p = new Paragraph("PRODUCTOS COMPRADOS");
            p.setAlignment(Element.ALIGN_CENTER);
            documento.add(p);
            documento.add(new Paragraph("\n\n"));
            
            PdfPTable tabla = new PdfPTable(5);
            int j = 0;
            for (int i = 0; i < (5 * (factura.getDetallesFactura().length() + 1)); i++) {
                if (i < 5) {
                    switch (i) {
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
                } else if (i % 5 == 0) {
                    tabla.addCell(factura.getDetallesFactura().getByIndex(j).getProducto().getNombre());
                    tabla.addCell(String.valueOf(factura.getDetallesFactura().getByIndex(j).getCantidad()));
                    tabla.addCell(String.valueOf(factura.getDetallesFactura().getByIndex(j).getProducto().getPorcentajeDesc()));
                    tabla.addCell(String.valueOf("$" + factura.getDetallesFactura().getByIndex(j).getPrecioUnitario()));
                    tabla.addCell(String.valueOf("$" + factura.getDetallesFactura().getByIndex(j).getPrecioTotal()));
                    j++;
                    i += 5;
                }
            }
            documento.add(tabla);
            documento.add(new Paragraph("\n\n"));
            documento.add(new Paragraph("SUBTOTAL: $" + dc.format(factura.getSubTotal())));
            documento.add(new Paragraph("VALOR IVA: $" + dc.format(factura.getIva())));
            documento.add(new Paragraph("TOTAL: $" + dc.format(factura.getTotal())));
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
