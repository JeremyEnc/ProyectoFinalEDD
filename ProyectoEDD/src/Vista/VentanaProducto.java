/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorKardex;
import Controlador.ControladorPersona;
import Controlador.ControladorMarca;
import Controlador.ControladorProducto;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ANDRES
 */
public class VentanaProducto extends javax.swing.JFrame {

    ControladorKardex ck = new ControladorKardex();
    ControladorPersona cp;
    ControladorMarca mc = new ControladorMarca();
    ControladorProducto pc = new ControladorProducto();

    /**
     * Creates new form VentanaProducto
     */
    public VentanaProducto() {
        initComponents();
        setLocationRelativeTo(null);
        txtfDesc.setEnabled(false);
        txtfDesc.setVisible(false);
        cbxMarcas.removeAllItems();
        lblPorcentaja.setVisible(false);
        cargarCombo();
    }

    /**
     * Constructor de la ventana del producto
     * @param pc Controlador del producto
     * @param cp Controlador de persona
     */
    public VentanaProducto(ControladorProducto pc, ControladorPersona cp) {
        initComponents();
        this.pc = pc;
        this.cp = cp;
        setLocationRelativeTo(null);
        txtfDesc.setEnabled(false);
        cbxMarcas.removeAllItems();
        txtfDesc.setVisible(false);
        lblPorcentaja.setVisible(false);
        cargarCombo();
    }

    /**
     * Carga los ComboBox de las marcas
     */
    private void cargarCombo() {
        mc.setMarcas(mc.listar());
        for (int i = 0; i < mc.getMarcas().length(); i++) {
            cbxMarcas.addItem(mc.getMarcas().getByIndex(i).getNombreMarca());
        }
    }

    /**
     * Limpia los text field de la pantalla
     */
    private void limpiar() {
        txtfDesc.setText("");
        txtfDesc.setText("");
        txtfPrecioVenta.setText("");
        lblFoto.setIcon(null);
        lblFoto.setText("IMAGEN");
        pc.setProducto(null);
    }

    /**
     * Guarda el producto en un archivo
     */
    private void guardar() {
        if (!txtfCodigo.getText().trim().isEmpty() && !txtfPrecioVenta.getText().trim().isEmpty()) {
            pc.getProducto().setCodigo(txtfDesc.getText());
            pc.getProducto().setStock(0);
            String nombre = pc.buscarPrenda(cbxPrenda.getSelectedIndex()).name() + " " + pc.buscarColor(cbxColor.getSelectedIndex()).name() + " " + mc.getMarcas().getByIndex(cbxMarcas.getSelectedIndex()).getNombreMarca();
            pc.getProducto().setNombre(nombre);
            pc.getProducto().setPrecioCompra(null);
            pc.getProducto().setPrecioVenta(Double.valueOf(txtfPrecioVenta.getText()));
            pc.getProducto().setMarca(mc.getMarcas().getByIndex(cbxMarcas.getSelectedIndex()));
            pc.getProducto().setTipoPrenda(pc.buscarTipoPrenda(cbxTipoPrenda.getSelectedIndex()));
            pc.getProducto().setTalla(pc.buscarTalla(cbxTalla.getSelectedIndex()));
            pc.getProducto().setPrenda(pc.buscarPrenda(cbxPrenda.getSelectedIndex()));
            pc.getProducto().setColor(pc.buscarColor(cbxColor.getSelectedIndex()));
            pc.getProducto().setFechaCompra(convertToDateViaInstant(LocalDate.now()));
            ck.getKardex().setCantidad(0);
            ck.getKardex().setCantidadTotal(0);
            ck.getKardex().setDetalle(nombre);
            ck.getKardex().setFecha(convertToDateViaInstant(LocalDate.now()));
            ck.getKardex().setTipoId(Long.valueOf("0"));
            ck.getKardex().setTotal(0);
            ck.getKardex().setTotalFinal(0);
            ck.getKardex().setValorUnitario(0.0);
            ck.getKardex().setPrenda(pc.buscarPrenda(cbxPrenda.getSelectedIndex()));
            if (txtfDesc.getText().trim().isEmpty()) {
                pc.getProducto().setEstadoDes(false);
                pc.getProducto().setPorcentajeDesc(0.00);
            } else {
                pc.getProducto().setEstadoDes(true);
                pc.getProducto().setPorcentajeDesc(Double.valueOf(txtfDesc.getText()));
            }
            if (pc.guardar() && ck.guardar()) {
                limpiar();
                JOptionPane.showMessageDialog(null, "Producto guardado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Agregue todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Convierte la fecha de tipo LocalDate a una fecha tipo Date;
     *
     * @param dateToConvert
     * @return Fecha en tipo date
     */
    public Date convertToDateViaInstant(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    File fichero;

    /**
     * Abre la ventana para seleccionar la foto
     */
    private void cargarFoto() {
        int resultado;
        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        ventana.jfchCargarfoto.setFileFilter(filtro);
        resultado = ventana.jfchCargarfoto.showOpenDialog(null);
        if (JFileChooser.APPROVE_OPTION == resultado) {
            fichero = ventana.jfchCargarfoto.getSelectedFile();
            try {
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setText(null);
                lblFoto.setIcon(icono);
                pc.getProducto().setIcon(icon);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + ex);
            }
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

        jPanel9 = new javax.swing.JPanel();
        butCargar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        butVerProdutos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        butAgregarMarca = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        butGuardar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        cbxMarcas = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        cbxTipoPrenda = new javax.swing.JComboBox<>();
        cbxTalla = new javax.swing.JComboBox<>();
        cbxPrenda = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        cbxColor = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        cbxDesc = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtfPrecioVenta = new javax.swing.JTextField();
        txtfDesc = new javax.swing.JTextField();
        txtfCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        lblPorcentaja = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(51, 153, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butCargar.setBackground(new java.awt.Color(51, 153, 255));
        butCargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butCargarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butCargarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butCargarMouseExited(evt);
            }
        });
        butCargar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CARGAR IMAGEN");
        butCargar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -2, 190, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoCargar.png"))); // NOI18N
        butCargar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel9.add(butCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 240, 50));

        butVerProdutos.setBackground(new java.awt.Color(51, 153, 255));
        butVerProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butVerProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butVerProdutosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butVerProdutosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butVerProdutosMouseExited(evt);
            }
        });
        butVerProdutos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("VER PRODUCTOS");
        butVerProdutos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, -4, 190, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoVerProductos.png"))); // NOI18N
        butVerProdutos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel9.add(butVerProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 240, 50));

        butAgregarMarca.setBackground(new java.awt.Color(51, 153, 255));
        butAgregarMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butAgregarMarca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAgregarMarcaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butAgregarMarcaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butAgregarMarcaMouseExited(evt);
            }
        });
        butAgregarMarca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("AGREGAR  MARCA");
        butAgregarMarca.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoMarca.png"))); // NOI18N
        butAgregarMarca.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel9.add(butAgregarMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 240, 50));

        butGuardar.setBackground(new java.awt.Color(51, 153, 255));
        butGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                butGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                butGuardarMouseExited(evt);
            }
        });
        butGuardar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoGuardar.png"))); // NOI18N
        butGuardar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("GUARDAR");
        butGuardar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -2, 190, 50));

        jPanel9.add(butGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 240, 50));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFoto.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel4.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 210));

        jPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 210));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 240, 430));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Marca");
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        cbxMarcas.setBackground(new java.awt.Color(255, 255, 255));
        cbxMarcas.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxMarcas.setForeground(new java.awt.Color(0, 0, 0));
        cbxMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin marcas registradas" }));
        cbxMarcas.setFocusable(false);
        jPanel11.add(cbxMarcas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 140, -1));

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Precio de venta");
        jPanel11.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel42.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Codigo");
        jPanel11.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel43.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Tipo de prenda");
        jPanel11.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel44.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Talla");
        jPanel11.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel45.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Prenda");
        jPanel11.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        cbxTipoPrenda.setBackground(new java.awt.Color(255, 255, 255));
        cbxTipoPrenda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxTipoPrenda.setForeground(new java.awt.Color(0, 0, 0));
        cbxTipoPrenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Unisex" }));
        jPanel11.add(cbxTipoPrenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 140, -1));

        cbxTalla.setBackground(new java.awt.Color(255, 255, 255));
        cbxTalla.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxTalla.setForeground(new java.awt.Color(0, 0, 0));
        cbxTalla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "XS", "S", "M", "L", "XL" }));
        jPanel11.add(cbxTalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 140, -1));

        cbxPrenda.setBackground(new java.awt.Color(255, 255, 255));
        cbxPrenda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxPrenda.setForeground(new java.awt.Color(0, 0, 0));
        cbxPrenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camiseta", "Pantalon", "Chompa", "Blusa", "Vestido", "Falda" }));
        jPanel11.add(cbxPrenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 140, -1));

        jLabel46.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Color");
        jPanel11.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        cbxColor.setBackground(new java.awt.Color(255, 255, 255));
        cbxColor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxColor.setForeground(new java.awt.Color(0, 0, 0));
        cbxColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rojo", "Azul", "Negro", "Blanco", "Cafe", "Amarillo", "Gris", "Verde" }));
        jPanel11.add(cbxColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 140, -1));

        jLabel47.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Descuento");
        jPanel11.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        cbxDesc.setBackground(new java.awt.Color(255, 255, 255));
        cbxDesc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxDesc.setForeground(new java.awt.Color(0, 0, 0));
        cbxDesc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));
        cbxDesc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDesc2cbxDescItemStateChanged(evt);
            }
        });
        jPanel11.add(cbxDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 140, -1));

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Valor");
        jPanel11.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setOpaque(true);
        jPanel11.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 140, 1));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setOpaque(true);
        jPanel11.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 140, 1));

        txtfPrecioVenta.setBackground(new java.awt.Color(255, 255, 255));
        txtfPrecioVenta.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfPrecioVenta.setForeground(new java.awt.Color(0, 0, 0));
        txtfPrecioVenta.setBorder(null);
        jPanel11.add(txtfPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, 30));

        txtfDesc.setBackground(new java.awt.Color(255, 255, 255));
        txtfDesc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfDesc.setForeground(new java.awt.Color(0, 0, 0));
        txtfDesc.setBorder(null);
        txtfDesc.setOpaque(false);
        jPanel11.add(txtfDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 140, 30));

        txtfCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtfCodigo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtfCodigo.setForeground(new java.awt.Color(0, 0, 0));
        txtfCodigo.setBorder(null);
        jPanel11.add(txtfCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 140, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoRegistrarProducto.png"))); // NOI18N
        jLabel1.setText("   REGISTRAR PRODUCTO");
        jPanel11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 580, 40));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setOpaque(true);
        jPanel11.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 140, 1));

        lblPorcentaja.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPorcentaja.setForeground(new java.awt.Color(255, 0, 0));
        lblPorcentaja.setText("*Agregue el valor en %");
        jPanel11.add(lblPorcentaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, -1, -1));

        jPanel1.setBackground(new java.awt.Color(238, 246, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 62, 610, 8));

        jPanel2.setBackground(new java.awt.Color(238, 246, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 422, 610, 8));

        jPanel3.setBackground(new java.awt.Color(238, 246, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel11.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 8, 430));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 580, 40));

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 610, 430));

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

        jMenu7.setText("Abastecer");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu2.setText("Productos");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Kardex");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu1.setText("Registros");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu8.setText("Sistema");
        jMenu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu8MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        // TODO add your handling code here:
        VentanaKardex ventana = new VentanaKardex(this.pc, this.cp);
        this.dispose();
        ventana.show();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        VentanaComprar vc = new VentanaComprar(cp);
        this.dispose();
        vc.setVisible(true);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        // TODO add your handling code here:
        VentanaPerfil vtPerfil = new VentanaPerfil(cp, pc);
        vtPerfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        // TODO add your handling code here:
        VentanaFacturarCompras vtFacturarCompra = new VentanaFacturarCompras(cp, pc);
        vtFacturarCompra.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        VentanaRegistro vtRegistrar = new VentanaRegistro(null, false, cp, pc);
        vtRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu8MouseClicked
        // TODO add your handling code here:
        VentanaSistema vtSistema = new VentanaSistema(cp, pc);
        vtSistema.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu8MouseClicked

    private void butCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCargarMouseClicked
        // TODO add your handling code here:
        cargarFoto();
    }//GEN-LAST:event_butCargarMouseClicked

    private void butGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGuardarMouseClicked
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_butGuardarMouseClicked

    private void butCargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCargarMouseEntered
        // TODO add your handling code here:
        Color color1 = new Color(0, 153, 204);
        butCargar.setBackground(color1);
    }//GEN-LAST:event_butCargarMouseEntered

    private void butAgregarMarcaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAgregarMarcaMouseClicked
        // TODO add your handling code here:
        VentanaMarca vm = new VentanaMarca(this.pc, this.cp);
        vm.setVisible(true);
    }//GEN-LAST:event_butAgregarMarcaMouseClicked

    private void butVerProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVerProdutosMouseClicked
        // TODO add your handling code here:
        VentanaProductosRegistrados vpr = new VentanaProductosRegistrados(this.pc, this.cp);
        vpr.setVisible(true);
    }//GEN-LAST:event_butVerProdutosMouseClicked

    private void cbxDesc2cbxDescItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDesc2cbxDescItemStateChanged
        // TODO add your handling code here:
        if (cbxDesc.getSelectedIndex() == 1) {
            txtfDesc.setEnabled(true);
            txtfDesc.setVisible(true);
            lblPorcentaja.setVisible(true);
        } else if (cbxDesc.getSelectedIndex() == 0) {
            txtfDesc.setText("");
            txtfDesc.setVisible(false);
            txtfDesc.setEnabled(false);
            lblPorcentaja.setVisible(false);
        }
    }//GEN-LAST:event_cbxDesc2cbxDescItemStateChanged

    private void butGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGuardarMouseEntered
        // TODO add your handling code here:
        Color color1 = new Color(0, 153, 204);
        butGuardar.setBackground(color1);
    }//GEN-LAST:event_butGuardarMouseEntered

    private void butCargarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butCargarMouseExited
        // TODO add your handling code here:
        Color color1 = new Color(51,153,255);
        butCargar.setBackground(color1);
    }//GEN-LAST:event_butCargarMouseExited

    private void butGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGuardarMouseExited
        // TODO add your handling code here:
        Color color1 = new Color(51,153,255);
        butGuardar.setBackground(color1);
    }//GEN-LAST:event_butGuardarMouseExited

    private void butVerProdutosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVerProdutosMouseEntered
        // TODO add your handling code here:
        Color color1 = new Color(0, 153, 204);
        butVerProdutos.setBackground(color1);
    }//GEN-LAST:event_butVerProdutosMouseEntered

    private void butVerProdutosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butVerProdutosMouseExited
        // TODO add your handling code here:
        Color color1 = new Color(51,153,255);
        butVerProdutos.setBackground(color1);
    }//GEN-LAST:event_butVerProdutosMouseExited

    private void butAgregarMarcaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAgregarMarcaMouseEntered
        // TODO add your handling code here:
        Color color1 = new Color(0, 153, 204);
        butAgregarMarca.setBackground(color1);
    }//GEN-LAST:event_butAgregarMarcaMouseEntered

    private void butAgregarMarcaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAgregarMarcaMouseExited
        // TODO add your handling code here:
        Color color1 = new Color(51,153,255);
        butAgregarMarca.setBackground(color1);
    }//GEN-LAST:event_butAgregarMarcaMouseExited

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
            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel butAgregarMarca;
    private javax.swing.JPanel butCargar;
    private javax.swing.JPanel butGuardar;
    private javax.swing.JPanel butVerProdutos;
    private javax.swing.JComboBox<String> cbxColor;
    private javax.swing.JComboBox<String> cbxDesc;
    private javax.swing.JComboBox<String> cbxMarcas;
    private javax.swing.JComboBox<String> cbxPrenda;
    private javax.swing.JComboBox<String> cbxTalla;
    private javax.swing.JComboBox<String> cbxTipoPrenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblPorcentaja;
    private javax.swing.JTextField txtfCodigo;
    private javax.swing.JTextField txtfDesc;
    private javax.swing.JTextField txtfPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
