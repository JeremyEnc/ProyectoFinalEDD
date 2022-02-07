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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 *
 * @author jere_
 */
public class ControladorProveedor extends AdaptadorDao<Proveedor>
{
    Lista<Proveedor> listaProveedores;
    Proveedor proveedor;

    public Lista<Proveedor> getListaProveedores()
    {
        if(listaProveedores == null) listaProveedores = new Lista<>();
        return listaProveedores;
    }

    public void setListaProveedores(Lista<Proveedor> listaProveedores) {
        this.listaProveedores = listaProveedores;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
    public ControladorProveedor()
    {
        super(Proveedor.class);
    }
    
    public void guardarFacturaCompra(FacturaCompra factura)
    {
        System.out.println("Factura(guardarFACTURACOMPRA):" + factura);
        System.out.println("proveedor(guardarFACTURACOMPRA):" + proveedor);
        System.out.println("listaFACTURAS(guardarFACTURACOMPRA):" + proveedor.getListaFacturasCompras());
        proveedor.getListaFacturasCompras().add(factura);
        modificar(proveedor, listaProveedores.getIndexOf(proveedor));
    }
    
    public void agregarProveedor(String ruc, String nombreProveedor, String apellidoProveedor, String direccionProveedor)
    {
        Long id = Integer.toUnsignedLong(listar().length() + 1);
        proveedor = new Proveedor(id, ruc, nombreProveedor, apellidoProveedor, direccionProveedor);
        listaProveedores.add(proveedor);
        guardar(proveedor);
    }
    
    public void crearPDF(FacturaCompra factura, String path, Integer i) throws DocumentException{
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
            documento.add(new Paragraph("R.U.C. de proveedor: "+ getListaProveedores().getByIndex(i).getRuc()));
            documento.add(new Paragraph("Proveedor: "+getListaProveedores().getByIndex(i).getNombreProveedor()+" "+getListaProveedores().getByIndex(i).getApellidoProveedor()));
            documento.add(new Paragraph("DIRECCION: "+getListaProveedores().getByIndex(i).getDireccionProveedor()));
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
        } finally {
            try {
                ficheroPdf.close();
            } catch (IOException ex) {
                System.out.println("error3pdf");
            }
        }
    }
}
