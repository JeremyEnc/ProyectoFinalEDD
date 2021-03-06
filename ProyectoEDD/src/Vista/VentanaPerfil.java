/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPersona;
import Controlador.ControladorProducto;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago-arg
 */
public class VentanaPerfil extends javax.swing.JFrame {

    ControladorPersona ctrlPersona;
    ControladorProducto ctrlProducto;

    /**
     * Constructor de la ventana Perfil
     *
     * @param ctrlPersona Controlador de la persona
     * @param cp Controlador del producto
     */
    public VentanaPerfil(ControladorPersona ctrlPersona, ControladorProducto cp) {
        initComponents();
        this.ctrlPersona = ctrlPersona;
        this.ctrlProducto = cp;
        cargarDatos();
        btGuardar.setVisible(false);
        btGuardar.setEnabled(false);
        comprobarRol();
        this.setLocationRelativeTo(null);
    }

    /**
     * Comprobar el rol de la cuenta
     */
    private void comprobarRol() {
        System.out.println("ComprobarRol: " + ctrlPersona.getPersona().getId_Rol().getNombreRol());
        if (ctrlPersona.getPersona().getId_Rol().getNombreRol().equals("cliente")) {
            jmFacturarCompra.setEnabled(false);
            jmFacturarCompra.setVisible(false);
            jmKardex.setEnabled(false);
            jmKardex.setVisible(false);
            jmRegistros.setEnabled(false);
            jmRegistros.setVisible(false);
            jmAgregarProducto.setEnabled(false);
            jmAgregarProducto.setVisible(false);
            jmSistema.setEnabled(false);
            jmSistema.setVisible(false);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
        btModificar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblTipoDeIdent = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        txtfNombre = new javax.swing.JTextField();
        txtfApellido = new javax.swing.JTextField();
        txtfDireccion = new javax.swing.JTextField();
        txtfCorreo = new javax.swing.JTextField();
        txtfIdent = new javax.swing.JTextField();
        ptxtfClave = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jmFacturarCompra = new javax.swing.JMenu();
        jmAgregarProducto = new javax.swing.JMenu();
        jmKardex = new javax.swing.JMenu();
        jmRegistros = new javax.swing.JMenu();
        jmSistema = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 100, 100));

        btGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btGuardar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconGuardar.jpeg"))); // NOI18N
        btGuardar.setText("Guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, -1));

        btModificar.setBackground(new java.awt.Color(255, 255, 255));
        btModificar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btModificar.setForeground(new java.awt.Color(0, 0, 0));
        btModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconModificar.png"))); // NOI18N
        btModificar.setText("Modificar");
        btModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 140, -1));

        btCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btCancelar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btCancelar.setForeground(new java.awt.Color(0, 0, 0));
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 140, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 390));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Direcci??n: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Rol: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Correo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tipo de Identificaci??n: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Identificaci??n: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, -1));

        lblRol.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblRol.setText("jLabel8");
        jPanel1.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        lblTipoDeIdent.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTipoDeIdent.setText("jLabel8");
        jPanel1.add(lblTipoDeIdent, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, -1, -1));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Contrase??a: ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, -1, -1));

        jSeparator8.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 150, 10));

        jSeparator7.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 150, 10));

        jSeparator6.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 150, 10));

        jSeparator5.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 150, 10));

        jSeparator4.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 150, 10));

        jSeparator3.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 150, 10));

        jSeparator2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 150, 10));

        jSeparator1.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 150, 10));

        txtfNombre.setEditable(false);
        txtfNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtfNombre.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtfNombre.setBorder(null);
        jPanel1.add(txtfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 150, -1));

        txtfApellido.setEditable(false);
        txtfApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtfApellido.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtfApellido.setBorder(null);
        jPanel1.add(txtfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 150, -1));

        txtfDireccion.setEditable(false);
        txtfDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtfDireccion.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtfDireccion.setBorder(null);
        jPanel1.add(txtfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 150, -1));

        txtfCorreo.setEditable(false);
        txtfCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtfCorreo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtfCorreo.setBorder(null);
        jPanel1.add(txtfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 150, -1));

        txtfIdent.setEditable(false);
        txtfIdent.setBackground(new java.awt.Color(255, 255, 255));
        txtfIdent.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtfIdent.setBorder(null);
        jPanel1.add(txtfIdent, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 150, -1));

        ptxtfClave.setEditable(false);
        ptxtfClave.setBackground(new java.awt.Color(255, 255, 255));
        ptxtfClave.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ptxtfClave.setBorder(null);
        jPanel1.add(ptxtfClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 150, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellidos: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Datos de Usuario");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 430, 60));

        jMenu5.setText("Comprar");
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu6.setText("Perfil");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jmFacturarCompra.setText("Abastecer");
        jmFacturarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmFacturarCompraMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmFacturarCompra);

        jmAgregarProducto.setText("Productos");
        jmAgregarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmAgregarProductoMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmAgregarProducto);

        jmKardex.setText("Kardex");
        jmKardex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmKardexMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmKardex);

        jmRegistros.setText("Registros");
        jmRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmRegistrosMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmRegistros);

        jmSistema.setText("Sistema");
        jmSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSistemaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmSistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed

        Integer index = ctrlPersona.getPersonas().getIndexOf(ctrlPersona.getPersona());
        System.out.println(index);
        String n = txtfNombre.getText();
        String a = txtfApellido.getText();
        System.out.println(a);
        String d = txtfDireccion.getText();
        String co = txtfCorreo.getText();
        String ident = txtfIdent.getText();
        String ti = lblTipoDeIdent.getText();

        ctrlPersona.getPersona().getCuenta().setClave(ptxtfClave.getText());

        System.out.println("VentPerfilComprobarQueRolSePaseBien: " + ctrlPersona.getPersona().getId_Rol().getNombreRol());

        ctrlPersona.asignarNuevaPersona(ctrlPersona.getPersona().getId(), n, a, ctrlPersona.getPersona().getId_Rol(),
                d, co, ident, ti, ctrlPersona.getPersona().getCuenta(),
                ctrlPersona.getPersona().getFacturas());

        System.out.println("VentPerfilComprobarQueRolSePaseBien: " + ctrlPersona.getPersona().getId_Rol().getNombreRol());

        ctrlPersona.modificar(ctrlPersona.getPersona(), index);
        ctrlPersona.setPersonas(ctrlPersona.listar());

        activarEdicion(false);
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        VentanaComprar vc = new VentanaComprar(ctrlPersona);
        this.dispose();
        vc.setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        VentanaPerfil vtPerfil = new VentanaPerfil(ctrlPersona, ctrlProducto);
        vtPerfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jmFacturarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmFacturarCompraMouseClicked
        // TODO add your handling code here:
        VentanaFacturarCompras vtFacturarCompra = new VentanaFacturarCompras(ctrlPersona, ctrlProducto);
        vtFacturarCompra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmFacturarCompraMouseClicked

    private void jmAgregarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmAgregarProductoMouseClicked
        // TODO add your handling code here:
        VentanaProducto vp = new VentanaProducto(ctrlProducto, ctrlPersona);
        this.dispose();
        vp.setVisible(true);
    }//GEN-LAST:event_jmAgregarProductoMouseClicked

    private void jmKardexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmKardexMouseClicked
        // TODO add your handling code here:
        VentanaKardex ventana = new VentanaKardex(ctrlProducto, ctrlPersona);
        this.dispose();
        ventana.show();
    }//GEN-LAST:event_jmKardexMouseClicked

    private void jmRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmRegistrosMouseClicked
        // TODO add your handling code here:
        VentanaRegistro vtRegistrar = new VentanaRegistro(null, false, ctrlPersona, ctrlProducto);
        vtRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmRegistrosMouseClicked

    private void jmSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSistemaMouseClicked
        // TODO add your handling code here:
        VentanaSistema vtSistema = new VentanaSistema(ctrlPersona, ctrlProducto);
        vtSistema.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmSistemaMouseClicked

    private void btModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarActionPerformed

        String contra = JOptionPane.showInputDialog("Ingrese su contrase??a");

        if (contra.equals(ctrlPersona.getPersona().getCuenta().getClave())) {
            activarEdicion(true);
        } else {
            JOptionPane.showMessageDialog(null, "Contrase??a Incorrecta");
        }
    }
//GEN-LAST:event_btModificarActionPerformed
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
            java.util.logging.Logger.getLogger(VentanaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPerfil(new ControladorPersona(), new ControladorProducto()).setVisible(true);
            }
        });
    }

    /**
     * Sirve para activar la edicion
     *
     * @param b true o false si se quiere editar
     */
    private void activarEdicion(Boolean b) {
        btGuardar.setVisible(b);
        btGuardar.setEnabled(b);

        txtfNombre.setEditable(b);
        txtfApellido.setEditable(b);
        txtfDireccion.setEditable(b);
        txtfCorreo.setEditable(b);
        txtfIdent.setEditable(b);
        ptxtfClave.setEditable(b);
    }

    /**
     * Carga los datos y los muestra en pantalla
     */
    private void cargarDatos() {
        txtfNombre.setText(ctrlPersona.getPersona().getNombres());
        txtfApellido.setText(ctrlPersona.getPersona().getApellidos());
        txtfDireccion.setText(ctrlPersona.getPersona().getDireccion());
        lblRol.setText(ctrlPersona.getPersona().getId_Rol().getNombreRol());
        txtfCorreo.setText(ctrlPersona.getPersona().getCorreo());
        lblTipoDeIdent.setText(ctrlPersona.getPersona().getTipoDeIdentificacion());
        txtfIdent.setText(ctrlPersona.getPersona().getIdentificacion());
        ptxtfClave.setText(ctrlPersona.getPersona().getCuenta().getClave());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JMenu jmAgregarProducto;
    private javax.swing.JMenu jmFacturarCompra;
    private javax.swing.JMenu jmKardex;
    private javax.swing.JMenu jmRegistros;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblTipoDeIdent;
    private javax.swing.JPasswordField ptxtfClave;
    private javax.swing.JTextField txtfApellido;
    private javax.swing.JTextField txtfCorreo;
    private javax.swing.JTextField txtfDireccion;
    private javax.swing.JTextField txtfIdent;
    private javax.swing.JTextField txtfNombre;
    // End of variables declaration//GEN-END:variables
}
