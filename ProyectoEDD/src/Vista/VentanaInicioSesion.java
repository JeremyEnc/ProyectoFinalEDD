/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorPersona;
import Controlador.ControladorValoresPorDefecto;
import Modelo.Cuenta;
import Modelo.Persona;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago-arg
 */
public class VentanaInicioSesion extends javax.swing.JFrame {

    ControladorPersona ctrlPersona = new ControladorPersona();
    ControladorValoresPorDefecto ctrlVPD = new ControladorValoresPorDefecto();

    /**
     * Contructor de la ventana InicioSesion
     */
    public VentanaInicioSesion() {
        initComponents();
        this.setLocationRelativeTo(this);
        ctrlPersona.setPersonas(ctrlPersona.listar());
    }

    /**
     * Verifica si el correo pertenece a una persona
     *
     * @param correo verificar
     * @return la persona con el correo asignado
     * @throws StackOverflowError
     */
    private Persona comprobarCorreo(String correo) throws StackOverflowError {
        return ctrlPersona.getPersonas().uniqueSearch("correo", correo, ctrlPersona.getPersonas().length() - 1, 0);

    }

    /**
     * Verifica si la clave coincide con la de la persona
     *
     * @param contra clave a verificar
     * @param persona persona que contiene esa clave
     * @return true o false si la clave coincide con la cuenta
     * @throws StackOverflowError
     */
    private Boolean comprobarClave(String contra, Persona persona) throws StackOverflowError {
        if (contra.equals(persona.getCuenta().getClave())) {
            return true;
        } else {
            return false;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCorreoUsu = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btRegistrar = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Correo Electronico:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        txtCorreoUsu.setBackground(new java.awt.Color(255, 255, 255));
        txtCorreoUsu.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCorreoUsu.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreoUsu.setBorder(null);
        jPanel1.add(txtCorreoUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 140, 30));

        btIngresar.setBackground(new java.awt.Color(51, 153, 255));
        btIngresar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btIngresar.setForeground(new java.awt.Color(0, 0, 0));
        btIngresar.setText("INICIAR SESION");
        btIngresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 160, 40));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Si aun no tiene una cuenta ingrese a");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, 20));

        btRegistrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btRegistrar.setForeground(new java.awt.Color(51, 153, 255));
        btRegistrar.setText("REGISTRAR");
        btRegistrar.setBorderPainted(false);
        btRegistrar.setContentAreaFilled(false);
        btRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 110, 40));

        txtPass.setBackground(new java.awt.Color(255, 255, 255));
        txtPass.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPass.setBorder(null);
        jPanel1.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 140, 30));

        jSeparator1.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 140, 10));

        jSeparator2.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 140, 10));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ropaIcono.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 270, 240));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tienda ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, 50));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 270, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 270, 490));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Iniciar Sesion");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/candadoIcono.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 30, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/correoIcono.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 30, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarioIcono.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarActionPerformed
        // TODO add your handling code here:
        VentanaRegistrar ventanaR = new VentanaRegistrar(this, rootPaneCheckingEnabled, ctrlVPD.getVpd().getCodigoAdmin());
        ventanaR.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btRegistrarActionPerformed

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        // TODO add your handling code here:
        String usuario = txtCorreoUsu.getText();
        String contra = txtPass.getText();
        try {
            if (comprobarCorreo(usuario) != null) {
                if (comprobarClave(contra, comprobarCorreo(usuario))) {
                    ctrlPersona.setPersona(comprobarCorreo(usuario));
                    VentanaComprar vtCompra = new VentanaComprar(ctrlPersona);
                    vtCompra.setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario/Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario/Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Usuario/Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (StackOverflowError s) {
            JOptionPane.showMessageDialog(null, "Usuario/Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaInicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JButton btRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField txtCorreoUsu;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
