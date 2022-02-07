/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPersona;
import Modelo.Enum.TipoIdentif;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago-arg
 */
public class VentanaRegistrar extends javax.swing.JDialog {

    ControladorPersona ctrlPersona = new ControladorPersona();
    private String codigo;

    /**
     * Creates new form VentanaRegistrar
     */
    public VentanaRegistrar(java.awt.Frame parent, boolean modal, String codigo) {
        super(parent, modal);
        initComponents();
        this.setSize(new Dimension(770, 280));
        setLocationRelativeTo(null);
        lblAviso.setVisible(false);
        btRegistrar.setEnabled(false);
        this.codigo = codigo;
    }

    

    public Boolean validar() {
        if (!txtPassword.getText().trim().isEmpty() && !txtfApellido.getText().trim().isEmpty() && !txtfCorreo.getText().trim().isEmpty() && !txtfDireccion.getText().trim().isEmpty() && !txtfIdentificacion.getText().trim().isEmpty() && !txtfNombre.getText().trim().isEmpty() && !lblAviso.isVisible()) {
            try {
                if (ctrlPersona.repetido(txtfIdentificacion.getText(), txtfCorreo.getText())) {
                    switch (cbxTipoDeIdent.getSelectedIndex()) {
                        case 0:
                            if (txtfIdentificacion.getText().length() == 10 && ctrlPersona.verificarCedula(txtfIdentificacion.getText())) {
                                btRegistrar.setEnabled(true);
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Cedula Invalida", "Error", JOptionPane.ERROR_MESSAGE);
                                return false;
                            }
                        case 1:
                            if (ctrlPersona.verificar_Pasaporte(txtfIdentificacion.getText())) {
                                btRegistrar.setEnabled(true);
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Pasaporte Invalida", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                        case 2:
                            if (ctrlPersona.verificar_Ruc(txtfIdentificacion.getText())) {
                                btRegistrar.setEnabled(true);
                                return true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Ruc Invalida", "Error", JOptionPane.ERROR_MESSAGE);
                                break;
                            }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Identificacion/Correo ya registrado", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "(*)campos obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }

    public void limpiar() {
        txtCodigo.setText("");
        txtPassword.setText("");
        txtfApellido.setText("");
        txtfCorreo.setText("");
        txtfDireccion.setText("");
        txtfIdentificacion.setText("");
        txtfNombre.setText("");
    }

    public Boolean codigoUnico() {
        try {
            if (txtCodigo.getText().equalsIgnoreCase(codigo)) {
//                ctrlPersona.getPersona().getId_Rol().setNombreRol("administrador");
//                ctrlPersona.getPersona().getId_Rol().setId(Long.valueOf(1));
                JOptionPane.showMessageDialog(null, "Su registro se realizara como Administrador", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
//                ctrlPersona.getPersona().getId_Rol().setNombreRol("cliente");
//                ctrlPersona.getPersona().getId_Rol().setId(Long.valueOf(2));       
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean registrar() {
        btRegistrar.setEnabled(false);
        ctrlPersona.getPersona().setNombres(txtfNombre.getText());
        ctrlPersona.getPersona().setApellidos(txtfApellido.getText());
        ctrlPersona.getPersona().setDireccion(txtfDireccion.getText());
        ctrlPersona.getPersona().setCorreo(txtfCorreo.getText());
        ctrlPersona.getPersona().setTipoDeIdentificacion(TipoIdentif.valueOf(cbxTipoDeIdent.getSelectedItem().toString()).toString());
        ctrlPersona.getPersona().setIdentificacion(txtfIdentificacion.getText());
        //ctrlPersona.getPersona().getCuenta().setClave(txtPassword.getText());
        ctrlPersona.crearCuenta(txtPassword.getText());
        if(validar() && codigoUnico()){
            ctrlPersona.getPersona().getId_Rol().setNombreRol("administrador");
            ctrlPersona.getPersona().getId_Rol().setId(Long.valueOf(1));
        } else {
            ctrlPersona.getPersona().getId_Rol().setNombreRol("cliente");
            ctrlPersona.getPersona().getId_Rol().setId(Long.valueOf(2)); 
        }
        ctrlPersona.guardar(ctrlPersona.getPersona());
        
        limpiar();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        btRegistrar = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        btValidar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtfNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtfApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtfDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxTipoDeIdent = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtfIdentificacion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        asterisco = new javax.swing.JLabel();
        asterisco1 = new javax.swing.JLabel();
        asterisco2 = new javax.swing.JLabel();
        asterisco3 = new javax.swing.JLabel();
        asterisco4 = new javax.swing.JLabel();
        asterisco5 = new javax.swing.JLabel();
        asterisco6 = new javax.swing.JLabel();
        btMenu = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblAviso = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btRegistrar.setBackground(new java.awt.Color(255, 255, 255));
        btRegistrar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btRegistrar.setForeground(new java.awt.Color(0, 0, 0));
        btRegistrar.setText("Registrar");
        btRegistrar.setBorderPainted(false);
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/registrarseIcono.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 170));

        btValidar.setBackground(new java.awt.Color(255, 255, 255));
        btValidar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btValidar.setForeground(new java.awt.Color(0, 0, 0));
        btValidar.setText("Validar");
        btValidar.setBorderPainted(false);
        btValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btValidarActionPerformed(evt);
            }
        });
        jPanel1.add(btValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 280));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        txtfNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtfNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfNombre.setBorder(null);
        jPanel2.add(txtfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 120, 20));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellido:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, -1, -1));

        txtfApellido.setBackground(new java.awt.Color(255, 255, 255));
        txtfApellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfApellido.setBorder(null);
        jPanel2.add(txtfApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 120, 20));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Dirección:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        txtfDireccion.setBackground(new java.awt.Color(255, 255, 255));
        txtfDireccion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfDireccion.setBorder(null);
        jPanel2.add(txtfDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 120, 20));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Correo:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, -1, -1));

        txtfCorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtfCorreo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfCorreo.setBorder(null);
        txtfCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfCorreoKeyReleased(evt);
            }
        });
        jPanel2.add(txtfCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 120, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Tipo de identificación:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        cbxTipoDeIdent.setBackground(new java.awt.Color(255, 255, 255));
        cbxTipoDeIdent.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxTipoDeIdent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CEDULA", "PASAPORTE", "RUC" }));
        cbxTipoDeIdent.setBorder(null);
        jPanel2.add(cbxTipoDeIdent, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 120, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Identificación:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, -1, -1));

        txtfIdentificacion.setBackground(new java.awt.Color(255, 255, 255));
        txtfIdentificacion.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfIdentificacion.setBorder(null);
        jPanel2.add(txtfIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, 20));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Codigo:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, -1, -1));

        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCodigo.setBorder(null);
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 120, 20));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Contraseña:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPassword.setBorder(null);
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, 120, 20));

        asterisco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        asterisco.setForeground(new java.awt.Color(255, 255, 255));
        asterisco.setText("*");
        jPanel2.add(asterisco, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 20, 20));

        asterisco1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        asterisco1.setForeground(new java.awt.Color(255, 255, 255));
        asterisco1.setText("*");
        jPanel2.add(asterisco1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 10, 20));

        asterisco2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        asterisco2.setForeground(new java.awt.Color(255, 255, 255));
        asterisco2.setText("*");
        jPanel2.add(asterisco2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 10, 20));

        asterisco3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        asterisco3.setForeground(new java.awt.Color(255, 255, 255));
        asterisco3.setText("*");
        jPanel2.add(asterisco3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 10, 20));

        asterisco4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        asterisco4.setForeground(new java.awt.Color(255, 255, 255));
        asterisco4.setText("*");
        jPanel2.add(asterisco4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 10, 20));

        asterisco5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        asterisco5.setForeground(new java.awt.Color(255, 255, 255));
        asterisco5.setText("*");
        jPanel2.add(asterisco5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 20, 20));

        asterisco6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        asterisco6.setForeground(new java.awt.Color(255, 255, 255));
        asterisco6.setText("*");
        jPanel2.add(asterisco6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 20, 20));

        btMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/casaIcono.png"))); // NOI18N
        btMenu.setBorderPainted(false);
        btMenu.setContentAreaFilled(false);
        btMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenuActionPerformed(evt);
            }
        });
        jPanel2.add(btMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("REGISTRO DE USUARIO");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        lblAviso.setFont(new java.awt.Font("Verdana", 3, 8)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(0, 0, 0));
        lblAviso.setText("correo invalido");
        jPanel2.add(lblAviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 110, 20));

        jSeparator2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 120, 10));

        jSeparator3.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 120, 10));

        jSeparator4.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 120, 10));

        jSeparator5.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 120, 10));

        jSeparator6.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 120, 10));

        jSeparator7.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, 120, 10));

        jSeparator8.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 120, 10));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/datosPersonalesIcono.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 50, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        registrar();
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btValidarActionPerformed
        // TODO add your handling code here:
        if (!txtCodigo.getText().trim().isEmpty()) {
            if (codigoUnico()) {
                validar();
            } else {
                JOptionPane.showMessageDialog(null, "Codigo Invalido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            if (validar()) {
//                ctrlPersona.getPersona().getId_Rol().setNombreRol("0");
//                ctrlPersona.getPersona().getId_Rol().setId(Long.valueOf(2));
                    
                JOptionPane.showMessageDialog(null, "Su registro se realizara como Cliente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btValidarActionPerformed

    private void btMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenuActionPerformed
        // TODO add your handling code here:
        dispose();
        VentanaInicioSesion menu = new VentanaInicioSesion();
        menu.setVisible(true);
    }//GEN-LAST:event_btMenuActionPerformed

    private void txtfCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfCorreoKeyReleased
        // TODO add your handling code here:
        if (ctrlPersona.verificar_Email(txtfCorreo.getText())) {
            lblAviso.setVisible(false);
        } else {
            lblAviso.setVisible(true);
        }
    }//GEN-LAST:event_txtfCorreoKeyReleased

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
            java.util.logging.Logger.getLogger(VentanaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaRegistrar dialog = new VentanaRegistrar(new javax.swing.JFrame(), true, "8989");
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
    private javax.swing.JLabel asterisco;
    private javax.swing.JLabel asterisco1;
    private javax.swing.JLabel asterisco2;
    private javax.swing.JLabel asterisco3;
    private javax.swing.JLabel asterisco4;
    private javax.swing.JLabel asterisco5;
    private javax.swing.JLabel asterisco6;
    private javax.swing.JButton btMenu;
    private javax.swing.JToggleButton btRegistrar;
    private javax.swing.JButton btValidar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxTipoDeIdent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtfApellido;
    private javax.swing.JTextField txtfCorreo;
    private javax.swing.JTextField txtfDireccion;
    private javax.swing.JTextField txtfIdentificacion;
    private javax.swing.JTextField txtfNombre;
    // End of variables declaration//GEN-END:variables
}
