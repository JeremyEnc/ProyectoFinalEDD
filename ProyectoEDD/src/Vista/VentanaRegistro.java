/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPersona;
import Controlador.ControladorProducto;
import Controlador.ControladorProveedor;
import Controlador.EstructurasDinamicas.Lista;
import Modelo.Persona;
import Modelo.Proveedor;
import Vista.ModeloTablas.ModeloTablaClienteRegistros;
import Vista.ModeloTablas.ModeloTablaProveedoresRegistro;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alba
 */
public class VentanaRegistro extends javax.swing.JDialog {

    private ControladorPersona ctrlPersona = new ControladorPersona(); //controlador de persona para sacar sus respectivos atributos
    private ControladorProveedor ctrlProveedor = new ControladorProveedor(); //controlador de proveedor para sacar sus respectivos atributos
    private ModeloTablaClienteRegistros mTClienteR; //modelo de la tabla de clientes para mostrar informacion unicamente de los clientes
    private ModeloTablaProveedoresRegistro mTProveedorR; //modelo de la tabla de clientes para mostrar informacion unicamente de los proveedores
    private ControladorProducto cp; //controlador de producto para sacar sus respectivos atributos
    
    /**
     * Crea la nueva ventana de registros donde se mostraran los clientes y
     * proveedores reegistrados dentro del sistema
     * @param parent parent
     * @param modal modal
     * @param ctrlPersona controlador de persona para sacar sus respectivos atributos
     * @param ctrlProducto controlador de producto para sacar sus respectivos atributos
     */
    public VentanaRegistro(java.awt.Frame parent, boolean modal, ControladorPersona ctrlPersona, ControladorProducto ctrlProducto) {
        super(parent, modal);
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tbl_tabla.getModel();
        this.ctrlPersona = ctrlPersona;
        modelo.setRowCount(0);
        tbl_tabla.setModel(modelo);
        this.cp = ctrlProducto;
        menuRegistros.setEnabled(false);
        menuRegistros.setBackground(Color.blue);
        ctrlProveedor.setListaProveedores(ctrlProveedor.listar());
        this.setLocationRelativeTo(null);
        cbxParametro.setEnabled(false);
        txtfContenido.setVisible(false);
        encabezadoColor();
        cargarImagenesLabel();
    }

    /**
     * Carga las imagenes en los labels correspondientes
     */
    private void cargarImagenesLabel() {
        ImageIcon icono = new ImageIcon(getClass().getResource("/Imagenes/basuraIcono.png"));
        Image imgEscalada = icono.getImage().getScaledInstance(label1.getWidth(),
                label1.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        label1.setIcon(iconoEscalado);
        ImageIcon icono2 = new ImageIcon(getClass().getResource("/Imagenes/LUPA.png"));
        Image imgEscalada2 = icono2.getImage().getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        Icon iconoEscalado2 = new ImageIcon(imgEscalada2);
        label.setIcon(iconoEscalado2);
    }

    /**
     * Carga la tabla, segun los seleccionado en el combo box se pondrá el
     * modelo de tabla de los proveedores o el modelo de tabla de los clientes
     */
    private void cargarTabla() {
        if (cbxRegistro.getSelectedItem().equals("Usuarios")) {
            mTClienteR = new ModeloTablaClienteRegistros(ctrlPersona.getPersonas());
            tbl_tabla.setModel(mTClienteR);
            tbl_tabla.updateUI();
        } else {
            mTProveedorR = new ModeloTablaProveedoresRegistro(ctrlProveedor.getListaProveedores());
            tbl_tabla.setModel(mTProveedorR);
            tbl_tabla.updateUI();
        }

        cargarCBXParametros();

    }

    /**
     * Cambia el color de la cabecera de la tabla
     */
    private void encabezadoColor() {
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(new Color(51, 153, 255));
        for (int i = 0; i < 4; i++) {
            TableColumn column = tbl_tabla.getTableHeader().getColumnModel().getColumn(i);
            column.setHeaderRenderer(cellRenderer);
            cellRenderer.setHorizontalAlignment(cellRenderer.CENTER);
        }
    }

    /**
     * Carga el combo box con los parametros a buscar segun si se eligen
     * usuarios o proveedores
     */
    private void cargarCBXParametros() {
        cbxParametro.removeAllItems();
        for (int i = 1; i < tbl_tabla.getColumnCount(); i++) {
            cbxParametro.addItem(tbl_tabla.getColumnName(i));
        }
    }

    /**
     * `Permite borrar usuarios o proveedores del sistema de acuerdo a su
     * identificacion
     *
     * @param identificacion
     */
    public void borrarUsuario(String identificacion) {

        if (cbxRegistro.getSelectedIndex() == 0) {
            Lista<Persona> listaPersonas = ctrlPersona.getPersonas();
            for (int i = 0; i < listaPersonas.length(); i++) {
                if (listaPersonas.getByIndex(i).getIdentificacion().equals(identificacion)) {
                    listaPersonas.remove(i);
                    break;
                }
            }
            ctrlPersona.setPersonas(listaPersonas);
            ctrlPersona.guardarNuevaLista(listaPersonas);

        } else {
            Lista<Proveedor> listaProveedores = ctrlProveedor.getListaProveedores();
            for (int i = 0; i < listaProveedores.length(); i++) {
                if (listaProveedores.getByIndex(i).getRuc().equals(identificacion)) {
                    listaProveedores.remove(i);
                    break;
                }
            }
            ctrlProveedor.setListaProveedores(listaProveedores);
            ctrlProveedor.guardarNuevaLista(listaProveedores);
        }

    }

    /**
     * Permite buscar segun los parametros correspondientes, se usan la busqueda
     * binaria y la multiple segun el parametro
     */
    private void buscar() {
        try {
            if (cbxParametro != null) {
                if (cbxRegistro.getSelectedIndex() == 0) {
                    switch (cbxParametro.getSelectedIndex()) {
                        case 0:
                            mTClienteR = new ModeloTablaClienteRegistros(ctrlPersona.getPersonas().multipleSearch("nombres", txtfContenido.getText().trim()));
                            tbl_tabla.setModel(mTClienteR);
                            tbl_tabla.updateUI();
                            break;
                        case 1:
                            mTClienteR = new ModeloTablaClienteRegistros(ctrlPersona.getPersonas().multipleSearch("id_Rol", ctrlPersona.getRol()));
                            tbl_tabla.setModel(mTClienteR);
                            tbl_tabla.updateUI();
                            break;
                        case 2:
                            Lista<Persona> listaPersonas = new Lista();
                            listaPersonas.add(ctrlPersona.getPersonas().uniqueSearch("identificacion", txtfContenido.getText().trim(), (ctrlPersona.getPersonas().length() - 1), 0));
                            mTClienteR = new ModeloTablaClienteRegistros(listaPersonas);
                            tbl_tabla.setModel(mTClienteR);
                            tbl_tabla.updateUI();
                            break;
                        default:
                    }
                } else {
                    switch (cbxParametro.getSelectedIndex()) {
                        case 0:
                            mTProveedorR = new ModeloTablaProveedoresRegistro(ctrlProveedor.getListaProveedores().multipleSearch("nombreProveedor", txtfContenido.getText().trim()));
                            tbl_tabla.setModel(mTProveedorR);
                            tbl_tabla.updateUI();
                            break;
                        case 1:
                            Lista<Proveedor> listaProveedor = new Lista();
                            listaProveedor.add(ctrlProveedor.getListaProveedores().uniqueSearch("ruc", txtfContenido.getText().trim(), (ctrlProveedor.getListaProveedores().length() - 1), 0));
                            mTProveedorR = new ModeloTablaProveedoresRegistro(listaProveedor);
                            tbl_tabla.setModel(mTProveedorR);
                            tbl_tabla.updateUI();
                            break;
                        case 2:
                            mTProveedorR = new ModeloTablaProveedoresRegistro(ctrlProveedor.getListaProveedores().multipleSearch("direccionProveedor", txtfContenido.getText().trim()));
                            tbl_tabla.setModel(mTProveedorR);
                            tbl_tabla.updateUI();
                            break;
                        default:
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningun elemento que cumpla con las caracteristicas");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cbxRegistro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxParametro = new javax.swing.JComboBox<>();
        txtfContenido = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        label1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCompra = new javax.swing.JMenu();
        menuPerfil = new javax.swing.JMenu();
        menuAbastecer = new javax.swing.JMenu();
        menuProductos = new javax.swing.JMenu();
        menuKardex = new javax.swing.JMenu();
        menuRegistros = new javax.swing.JMenu();
        menuSistema = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTROS DEL SISTEMA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 8, 520, -1));

        tbl_tabla.setBackground(new java.awt.Color(255, 255, 255));
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
                "Cliente", "Rol", "Identificacion", "Fecha de Compra"
            }
        ));
        tbl_tabla.setGridColor(new java.awt.Color(51, 153, 255));
        tbl_tabla.setSelectionBackground(new java.awt.Color(121, 175, 227));
        jScrollPane1.setViewportView(tbl_tabla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 159, -1, 320));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mostrar:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        cbxRegistro.setBackground(new java.awt.Color(255, 255, 255));
        cbxRegistro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxRegistro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuarios", "Proveedores", " " }));
        jPanel1.add(cbxRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 45, 112, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Buscar por:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        cbxParametro.setBackground(new java.awt.Color(255, 255, 255));
        cbxParametro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(cbxParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 95, 116, -1));

        txtfContenido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfContenido.setForeground(new java.awt.Color(0, 0, 0));
        txtfContenido.setBorder(null);
        jPanel1.add(txtfContenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 97, 106, 22));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Cargar");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 42, 60, 30));

        jSeparator1.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 100, 10));

        label1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label1MouseClicked(evt);
            }
        });
        jPanel1.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 40, 40));

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMouseClicked(evt);
            }
        });
        jPanel1.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 40, 40));

        menuCompra.setText("Compra");
        menuCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCompraMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuCompra);

        menuPerfil.setText("Perfil");
        menuPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuPerfilMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuPerfil);

        menuAbastecer.setText("Abastecer");
        menuAbastecer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAbastecerMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAbastecer);

        menuProductos.setText("Productos");
        menuProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuProductosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuProductos);

        menuKardex.setText("Kardex");
        menuKardex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuKardexMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuKardex);

        menuRegistros.setText("Registros");
        menuRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRegistrosMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuRegistros);

        menuSistema.setText("Sistema");
        menuSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSistemaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cargarTabla();
        cbxParametro.setEnabled(true);
        txtfContenido.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCompraMouseClicked
        VentanaComprar vtCompra = new VentanaComprar(ctrlPersona);
        vtCompra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuCompraMouseClicked

    private void menuAbastecerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAbastecerMouseClicked
        VentanaFacturarCompras vtFacturarCompra = new VentanaFacturarCompras(ctrlPersona, cp);
        vtFacturarCompra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuAbastecerMouseClicked

    private void menuPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuPerfilMouseClicked
        VentanaPerfil vtPerfil = new VentanaPerfil(ctrlPersona, cp);
        vtPerfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuPerfilMouseClicked

    private void menuProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuProductosMouseClicked
        VentanaProducto vp = new VentanaProducto(cp, ctrlPersona);
        this.dispose();
        vp.setVisible(true);
    }//GEN-LAST:event_menuProductosMouseClicked

    private void menuKardexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuKardexMouseClicked
        VentanaKardex ventana = new VentanaKardex(this.cp, this.ctrlPersona);
        this.dispose();
        ventana.show();
    }//GEN-LAST:event_menuKardexMouseClicked

    private void menuRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRegistrosMouseClicked
        VentanaRegistro vtRegistrar = new VentanaRegistro(null, false, ctrlPersona, cp);
        vtRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuRegistrosMouseClicked

    private void menuSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSistemaMouseClicked
        VentanaSistema vtSistema = new VentanaSistema(ctrlPersona, cp);
        vtSistema.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuSistemaMouseClicked

    private void label1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label1MouseClicked
        Integer index = tbl_tabla.getSelectedRow();
        
        if(index == -1)
        {
            JOptionPane.showMessageDialog(null, "Debe escoger una persona de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(cbxRegistro.getSelectedIndex() == 0){
                borrarUsuario(tbl_tabla.getValueAt(index, 3).toString());
                cargarTabla();
            }else{
                borrarUsuario(tbl_tabla.getValueAt(index, 2).toString());
                cargarTabla();
            }
        }
    }//GEN-LAST:event_label1MouseClicked

    private void labelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMouseClicked
        buscar();
    }//GEN-LAST:event_labelMouseClicked

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
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaRegistro dialog = new VentanaRegistro(new javax.swing.JFrame(), true, new ControladorPersona(), new ControladorProducto());
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
    private javax.swing.JComboBox<String> cbxParametro;
    private javax.swing.JComboBox<String> cbxRegistro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label1;
    private javax.swing.JMenu menuAbastecer;
    private javax.swing.JMenu menuCompra;
    private javax.swing.JMenu menuKardex;
    private javax.swing.JMenu menuPerfil;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuRegistros;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JTable tbl_tabla;
    private javax.swing.JTextField txtfContenido;
    // End of variables declaration//GEN-END:variables
}
