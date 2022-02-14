/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorFactura;
import Controlador.ControladorKardex;
import Controlador.ControladorPersona;
import Controlador.ControladorProducto;
import Vista.ModeloTablas.ModeloTablaFactura;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alba
 */
public class VentanaFactura extends javax.swing.JDialog {

    private ControladorKardex ck = new ControladorKardex(); //controlador de kardex para poder modificarlo
    private ModeloTablaFactura mtf = new ModeloTablaFactura(); //modelo de la tabla para mostrar los detalles de la factura
    private ControladorFactura cf; //controlador de factura para sacar sus respectivos atributos
    private ControladorPersona cp = new ControladorPersona(); //controlador de persona para sacar sus respectivos atributos
    private ControladorProducto ctrlProducto; //controlador de producto para sacar sus respectivos atributos

    /**
     * Crea la ventana factura, con sus respectivas caracteristicas iniciales,
     * además de recibir los controladores necesarios
     *
     * @param parent parent
     * @param modal modal
     * @param ctrlPersona controlador de persona para sacar sus respectivos
     * atributos
     * @param cf controlador de factura para sacar sus respectivos atributos
     * @param cp1 controlador de producto para sacar sus respectivos atributos
     */
    public VentanaFactura(java.awt.Frame parent, boolean modal, ControladorPersona ctrlPersona, ControladorFactura cf, ControladorProducto cp1) {
        super(parent, modal);
        initComponents();
        TableColumn columnaNro, columnaTalla;
        columnaNro = tbl_tabla.getColumnModel().getColumn(0);
        columnaNro.setWidth(10);
        cp = ctrlPersona;
        ctrlProducto = cp1;
        this.cf = cf;
        setResizable(false);
        setLocationRelativeTo(null);
        cargarTabla();
        cargarDatos();
        encabezadoColor();
        cargarImagenesLabel();
    }

    /**
     * Carga la tabla con los detalles que tiene la factura
     */
    private void cargarTabla() {
        mtf.setLista(cf.getFactura().getDetallesFactura());
        tbl_tabla.setModel(mtf);
        tbl_tabla.updateUI();
    }

    /**
     * Cambia el color de la cabecera de la tabla
     */
    private void encabezadoColor() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(51, 153, 255));
        for (int i = 0; i < 6; i++) {
            TableColumn column = tbl_tabla.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
            cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);
        }
    }

    /**
     * Carga las imagenes en los labels correspondientes
     */
    private void cargarImagenesLabel() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/regresarIcono.png"));
        Image imgEscalada = icono.getImage().getScaledInstance(label1.getWidth(),
                label1.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        label1.setIcon(iconoEscalado);
        ImageIcon icono2 = new ImageIcon(getClass().getResource("/Imagenes/facturarIcono.png"));
        Image imgEscalada2 = icono2.getImage().getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado2 = new ImageIcon(imgEscalada2);
        label.setIcon(iconoEscalado2);
    }

    /**
     * Carga los datos que se encuentran en la factura en los diferentes
     * JtextField
     */
    private void cargarDatos() {
        DecimalFormat dc = new DecimalFormat("##.##");
        txt_nombreCliente.setText(cp.getPersona().getNombres());
        txt_apellidoCliente.setText(cp.getPersona().getApellidos());
        txt_nroCedula.setText(cp.getPersona().getIdentificacion());
        txt_nroFactura.setText(cf.getFactura().getNroFactura());
        txt_fechaFac.setText(cf.getFactura().getFecha().getDate() + "/" + (cf.getFactura().getFecha().getMonth() + 1) + "/" + (cf.getFactura().getFecha().getYear() + 1900));
        txt_IVA.setText("$" + dc.format(cf.getFactura().getIva()));
        txt_subT.setText("$" + dc.format(cf.getFactura().getSubTotal()));
        txt_total.setText("$" + dc.format(cf.getFactura().getTotal()));
    }

    /**
     * Resta en el stock la cantidad de productos que se encuentra en cada uno
     * de los detalles Tambien se guarda en el kardez lñas correspondientes
     * acciones con los productos
     *
     * @return true si se lleva a cabo de manera exitosa
     */
    private boolean restarStock() {
        ck.setListaKardex(ck.listar());
        for (int i = 0; i < cf.getFactura().getDetallesFactura().length(); i++) {
            if (cf.getFactura().getDetallesFactura().getByIndex(i).getCantidad() <= ctrlProducto.getProductos().getByIndex(cf.getFactura().getDetallesFactura().getByIndex(i).getIdProdcuto().intValue() - 1).getStock()) {
                int venta = cf.getFactura().getDetallesFactura().getByIndex(i).getCantidad();
                int compra = ctrlProducto.getProductos().getByIndex(cf.getFactura().getDetallesFactura().getByIndex(i).getIdProdcuto().intValue() - 1).getStock();
                ctrlProducto.setProducto(ctrlProducto.getProductos().getByIndex(i));
                ctrlProducto.getProducto().setStock(compra - venta);
                ctrlProducto.modificar(ctrlProducto.getProducto(), i);
                ck.getKardex().setCantidad(venta);
                ck.getKardex().setCantidadTotal(compra - venta);
                ck.getKardex().setDetalle(ctrlProducto.getProductos().getByIndex(i).getNombre());
                ck.getKardex().setFecha(cf.getFactura().getFecha());
                ck.getKardex().setPrenda(ctrlProducto.getProductos().getByIndex(i).getPrenda());
                ck.getKardex().setTipoId(Long.valueOf("1"));
                ck.getKardex().setTotal(cf.getFactura().getDetallesFactura().getByIndex(i).getPrecioUnitario() * cf.getFactura().getDetallesFactura().getByIndex(i).getCantidad());
                ck.getKardex().setTotalFinal(cf.getFactura().getDetallesFactura().getByIndex(i).getPrecioTotal());
                ck.getKardex().setValorUnitario(cf.getFactura().getDetallesFactura().getByIndex(i).getPrecioUnitario());
                try {
                    ck.guardar();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error en guardar kardex");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Stock insuficiente del producto " + ctrlProducto.getProductos().getByIndex(i).getNombre());
                return false;
            }
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_subT = new javax.swing.JTextField();
        txt_IVA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txt_nroCedula = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        txt_apellidoCliente = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_nroFactura = new javax.swing.JTextField();
        txt_fechaFac = new javax.swing.JTextField();
        txt_nombreCliente = new javax.swing.JTextField();
        label = new javax.swing.JLabel();
        label1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATOS FACTURA");
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jSeparator6.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator7.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator8.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 460, 30));

        tbl_tabla.setBackground(new java.awt.Color(255, 255, 255));
        tbl_tabla.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        tbl_tabla.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tbl_tabla.setForeground(new java.awt.Color(0, 0, 0));
        tbl_tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_tabla.setGridColor(new java.awt.Color(51, 153, 255));
        tbl_tabla.setSelectionBackground(new java.awt.Color(121, 175, 227));
        tbl_tabla.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 188, 460, 200));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("PRODUCTOS COMPRADOS");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 160, 490, -1));

        txt_total.setEditable(false);
        txt_total.setBackground(new java.awt.Color(255, 255, 255));
        txt_total.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_total.setBorder(null);
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 470, 110, 20));

        txt_subT.setEditable(false);
        txt_subT.setBackground(new java.awt.Color(255, 255, 255));
        txt_subT.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_subT.setAutoscrolls(false);
        txt_subT.setBorder(null);
        jPanel1.add(txt_subT, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 110, 20));

        txt_IVA.setEditable(false);
        txt_IVA.setBackground(new java.awt.Color(255, 255, 255));
        txt_IVA.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_IVA.setBorder(null);
        jPanel1.add(txt_IVA, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, 110, 20));

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Valor De IVA");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, 20));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("SubTotal");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, 20));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Total");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, 20));

        jSeparator9.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator9.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 410, 110, 10));

        jSeparator10.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator10.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 110, 10));

        jSeparator11.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator11.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 110, 10));

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nro de Cedula");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        txt_nroCedula.setEditable(false);
        txt_nroCedula.setBackground(new java.awt.Color(255, 255, 255));
        txt_nroCedula.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nroCedula.setBorder(null);
        jPanel1.add(txt_nroCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 110, -1));

        jSeparator4.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 110, 10));

        jSeparator5.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 110, 10));

        txt_apellidoCliente.setEditable(false);
        txt_apellidoCliente.setBackground(new java.awt.Color(255, 255, 255));
        txt_apellidoCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_apellidoCliente.setBorder(null);
        jPanel1.add(txt_apellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 110, -1));

        jSeparator3.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 110, 10));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Apellido Cliente");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre Cliente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 110, 20));

        jSeparator1.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 110, 10));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nro Factura");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fecha Factura");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txt_nroFactura.setEditable(false);
        txt_nroFactura.setBackground(new java.awt.Color(255, 255, 255));
        txt_nroFactura.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nroFactura.setBorder(null);
        jPanel1.add(txt_nroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 110, -1));

        txt_fechaFac.setEditable(false);
        txt_fechaFac.setBackground(new java.awt.Color(255, 255, 255));
        txt_fechaFac.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_fechaFac.setBorder(null);
        jPanel1.add(txt_fechaFac, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 110, -1));

        txt_nombreCliente.setEditable(false);
        txt_nombreCliente.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombreCliente.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txt_nombreCliente.setBorder(null);
        jPanel1.add(txt_nombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 110, -1));

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
        });
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 450, 40, 40));

        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseClicked
        try {
            if (restarStock()) {
                if (JOptionPane.showConfirmDialog(null, "Desea guardar la factura") == 0) {
                    String CARPETA = "";
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    Component parent = null;
                    int returnVal = chooser.showSaveDialog(parent);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        String selectPath = chooser.getSelectedFile().getPath();
                        CARPETA = selectPath + File.separatorChar;
                        CARPETA += cf.getFactura().getNroFactura() + ".pdf";
                    }
                    cp.guardarFactura(cf.getFactura());
                    cp.crearPDF(cf.getFactura(), CARPETA);
                } else {
                    cp.guardarFactura(cf.getFactura());
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error en guardar la factura");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en guardar la factura");
        }

    }//GEN-LAST:event_labelMouseClicked

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        this.dispose();
    }//GEN-LAST:event_label1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaFactura dialog = new VentanaFactura(new javax.swing.JFrame(), true, new ControladorPersona(), new ControladorFactura(0.12), new ControladorProducto());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txt_IVA;
    private javax.swing.JTextField txt_apellidoCliente;
    private javax.swing.JTextField txt_fechaFac;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_nroCedula;
    private javax.swing.JTextField txt_nroFactura;
    private javax.swing.JTextField txt_subT;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
