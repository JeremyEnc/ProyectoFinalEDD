/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Controlador.Dao.AdaptadorDao;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.FacturaCompra;
import Modelo.Proveedor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jere_
 */
public class ControladorProveedor extends AdaptadorDao<Proveedor>
{
    private Lista<Proveedor> listaProveedores;//lista de los proveedores que se van a almacenar el sistema
    private Proveedor proveedor;//Proveedor que se utiliza como auxiliar;

    /**
     * Getter para obtener la lista de los proveedores del objeto
     * @return la lista de los proveedores del objeto
     */
    public Lista<Proveedor> getListaProveedores()
    {
        if(listaProveedores == null) listaProveedores = new Lista<>();
        return listaProveedores;
    }

    /**
     * Setter para cambiar la lista de proveedores del objeto
     * @param listaProveedores la nueva lista de proveedores del objeto
     */
    public void setListaProveedores(Lista<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    /**
     * Getter para obtener el proveedor del objeto
     * @return el proveedor del objeto
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * Setter para cambiar el proveedor del objeto
     * @param proveedor el nuevo proveedor del objeto
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    /**
     * Constructor del objeto que sirve para indicar la clase con la que trabajara el AdaptadorDAO
     */
    public ControladorProveedor()
    {
        super(Proveedor.class);
    }
    
    /**
     * Metodo para guardar la factura dentro de la lista de facturas del proveedor 
     * @param factura la factura que se almacenara en la lista del proveedor
     */
    public void guardarFacturaCompra(FacturaCompra factura)
    {
        proveedor.getListaFacturasCompras().add(factura);
        modificar(proveedor, listaProveedores.getIndexOf(proveedor));
    }
    
    /**
     * Metodo para crear un nuevo proveedor, asignarlo dentro del atributo proveedor de esta clase 
     * y añadirlo en la lista de proveedores para guardar esta dentro de un archivo
     * @param ruc R.U.C del nuevo proveedor
     * @param nombreProveedor Nombre del nuevo proveedor
     * @param apellidoProveedor Apellido del Nuevo proveedor
     * @param direccionProveedor  Direccion del Nuevo proveedor
     */
    public void agregarProveedor(String ruc, String nombreProveedor, String apellidoProveedor, String direccionProveedor)
    {
        Long id = Integer.toUnsignedLong(listar().length() + 1);
        proveedor = new Proveedor(id, ruc, nombreProveedor, apellidoProveedor, direccionProveedor);
        listaProveedores.add(proveedor);
        guardar(proveedor);
    }
    
    /**
     * Metodo para transformar a pdf la factura compra realizada
     * @param factura La factura que se transformara a pdf
     * @param path La direccion en que se almacenara el pdf
     * @param i Posicion del proveedor al que se le realizo la compra
     * @throws DocumentException Se dispara cuando existe un error al crear el documento
     */
    public void crearPDF(FacturaCompra factura, String path, Integer i) throws DocumentException{
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
            for (int j = 0; j < 5; j++) 
            {
                switch (j) {
                    case 0:
                        tablaDatos.addCell("NRO FACTURA: " + factura.getNroFactura());
                        break;
                    case 1:
                        tablaDatos.addCell("FECHA DE EMISION: " + factura.getFecha().getDate()+"/"+(factura.getFecha().getMonth()+1)+"/"+(factura.getFecha().getYear()+1900));
                        break;
                    case 2:
                        tablaDatos.addCell("R.U.C. DE PROVEEDOR: " + getListaProveedores().getByIndex(i).getRuc());
                        break;
                    case 3:
                        tablaDatos.addCell("PROVEEDOR: " + getListaProveedores().getByIndex(i).getNombreProveedor()+" "+getListaProveedores().getByIndex(i).getApellidoProveedor());
                        break;
                    case 4:
                        tablaDatos.addCell("DIRECCION: " +getListaProveedores().getByIndex(i).getDireccionProveedor());
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
            
            PdfPTable tabla = new PdfPTable(4);
            int j = 0;
            for (i = 0; i < (4*(factura.getListaDetalles().length()+1)); i++) {
                if(i < 4){
                    switch(i){
                        case 0:
                            tabla.addCell("PRODUCTO");
                            break;
                        case 1:
                            tabla.addCell("CANTIDAD");
                            break;
                        case 2:
                            tabla.addCell("PRECIO UNITARIO");
                            break;
                        case 3:
                            tabla.addCell("PRECIO TOTAL");
                            break;
                    }
                }else if(i % 4 == 0){
                    tabla.addCell(factura.getListaDetalles().getByIndex(j).getIdProducto().toString());
                    tabla.addCell(String.valueOf(factura.getListaDetalles().getByIndex(j).getCantidad()));
                    tabla.addCell(String.valueOf(factura.getListaDetalles().getByIndex(j).getPrecioUnitario()));
                    tabla.addCell(String.valueOf(factura.getListaDetalles().getByIndex(j).getPrecioTotal()));
                    j++;
                    i += 4;
                }
            }
            documento.add(tabla);
            documento.add(new Paragraph("\n\n"));
            documento.add(new Paragraph("SUBTOTAL: "+ factura.getSubTotal()));
            documento.add(new Paragraph("VALOR IVA: "+dc.format(factura.getIva())));
            documento.add(new Paragraph("TOTAL: "+factura.getTotal()));
            documento.close();
         } catch (FileNotFoundException ex) {
            System.out.println("error1pdf");
        } catch (DocumentException ex) {
            System.out.println("error2pdf");
        } catch (IOException ex) {
            Logger.getLogger(ControladorProveedor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ficheroPdf.close();
            } catch (IOException ex) {
                System.out.println("error3pdf");
            }
        }
    }
    
    /**
     * Metodo para validar el ruc del proveedor
     * @param ruc R.U.C. del proveedor
     * @return Verdadero si el R.U.C. es valido y falso si no lo es
     */
    public Boolean verificar_Ruc(String ruc) {
        String rucCedula = ruc.substring(0, 10);
        return verificarCedula(rucCedula);
    }
    
    /**
     * Metodo para validar la cedula, usado en el metodo de verificarR.U.C.
     * @param cedula la cedula del proveedor, recuperada del R.U.C
     * @return Verdadero si la cedula es valida, falso si no lo es
     */
    private boolean verificarCedula(String cedula) {
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
}
