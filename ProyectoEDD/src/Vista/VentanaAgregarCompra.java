/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorFacturaCompra;
import Controlador.ControladorProducto;
import java.awt.Dimension;

/**
 *
 * @author jere_
 */
public class VentanaAgregarCompra extends javax.swing.JFrame {

    private ControladorFacturaCompra ctrlFacturaCompra;
    private ControladorProducto ctrlProducto;
    
    /**
     * Creates new form VentanaAgregarCompra
     */
    public VentanaAgregarCompra(ControladorFacturaCompra ctrlFacturaCompra, ControladorProducto ctrlProducto) {
        initComponents();
        this.setSize(new Dimension(292,335));
        this.setLocationRelativeTo(null);
        this.ctrlFacturaCompra = ctrlFacturaCompra;
        this.ctrlProducto = ctrlProducto;
        cargarComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtfCantidad = new javax.swing.JTextField();
        txtfPrecioUnitario = new javax.swing.JTextField();
        btAgregarCompra = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cbxProductos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jLabel1.setText("Producto");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 70, 49, 16);

        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 120, 48, 16);

        jLabel3.setText("Precio Unitario");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 170, 78, 16);
        getContentPane().add(txtfCantidad);
        txtfCantidad.setBounds(130, 120, 110, 22);
        getContentPane().add(txtfPrecioUnitario);
        txtfPrecioUnitario.setBounds(130, 170, 110, 22);

        btAgregarCompra.setText("Agregar");
        btAgregarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarCompraActionPerformed(evt);
            }
        });
        getContentPane().add(btAgregarCompra);
        btAgregarCompra.setBounds(160, 260, 72, 22);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btCancelar);
        btCancelar.setBounds(40, 260, 76, 22);

        getContentPane().add(cbxProductos);
        cbxProductos.setBounds(130, 70, 110, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAgregarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarCompraActionPerformed
        String producto = cbxProductos.getSelectedItem().toString();
        String precioUnitario = txtfPrecioUnitario.getText();
        String cantidad = txtfCantidad.getText();
        
        Integer index = cbxProductos.getSelectedIndex();
        
        if(cantidad.isBlank() || precioUnitario.isBlank() || producto.isBlank())
        {
            System.out.println("Debe llenar todos los datos");
        }
        else
        {
            ctrlFacturaCompra.agregarDetalleCompra(ctrlProducto.getProductos().getByIndex(index).getId(), Integer.valueOf(cantidad) , Double.valueOf(precioUnitario));
            ctrlProducto.getProductos().getByIndex(index).setStock(ctrlProducto.getProductos().getByIndex(index).getStock()+Integer.valueOf(cantidad));
            ctrlProducto.getProductos().getByIndex(index).setPrecioCompra(Double.valueOf(precioUnitario));
            ctrlProducto.modificar(ctrlProducto.getProductos().getByIndex(index), index);
            this.dispose();
        }
    }//GEN-LAST:event_btAgregarCompraActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaAgregarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregarCompra(new ControladorFacturaCompra(0.12), new ControladorProducto()).setVisible(true);
            }
        });
    }
    
    private void cargarComboBox()
    {
        for (int i = 0; i < ctrlProducto.getProductos().length(); i++) 
        {
            cbxProductos.addItem(ctrlProducto.getProductos().getByIndex(i).getNombre());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgregarCompra;
    private javax.swing.JButton btCancelar;
    private javax.swing.JComboBox<String> cbxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtfCantidad;
    private javax.swing.JTextField txtfPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
