/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Controller.Controlador;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author luisr
 */
public class Gestion extends javax.swing.JFrame {
    Controlador control= new Controlador();
    JTextField cantidad = new JTextField();
    JTextField nombre = new JTextField();
    JTextField gtin = new JTextField();
    JComboBox tipoGtin = new JComboBox();
    JTextField descripcion = new JTextField();
    JDateChooser fecha = new JDateChooser("yyyy/MM/dd","####/##/##",'_');
    JTextField apellido = new JTextField();
    JTextField cedula = new JTextField();
    JFormattedTextField telefono = new JFormattedTextField();
    JTextField correo = new JTextField();
    JTextField usuario = new JTextField();
    JTextField password = new JTextField();
    JTextArea direccion = new JTextArea();
    JComboBox tipoUsuario = new JComboBox();
    JTextField codigoProveedor = new JTextField();
    JTextField rif = new JTextField();
    JComboBox comboSeleccion = new JComboBox();
    JTextField precioUnidad = new JTextField();
    DefaultTableModel dtm;
    JComboBox iva = new JComboBox();
    double totalProductosDebito;
    /**
     * Creates new form Gestion
     */
    public Gestion() {
        initComponents();
        System.out.println();
        control.iniciaVentana(this);
        btnInicio.doClick();
        fechaFactura.setCalendar(new GregorianCalendar());
        fechaFactura1.setCalendar(new GregorianCalendar());
        fechaCredito.setCalendar(new GregorianCalendar());
        fechaDebito.setCalendar(new GregorianCalendar());
        fechaCreditoTotal.setCalendar(new GregorianCalendar());
        tipoGtin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GTIN-12", "GTIN-13", "GTIN-14" }));
        comboSeleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedula", "RIF", "Ambos" }));
        iva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Si","No" }));
        control.iniciarCalendar(fecha);
        control.restringirNumero(cantidad);
        control.restringirNumero(gtin);
        tipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Empleado" }));
        control.restringirCedula(cedula);
        control.restringirCorreo(correo);
        control.restringirATexto(nombre);
        control.restringirATexto(apellido);
        control.restringirPassword(password);
        control.restringirUsuarioLongitud(usuario);
        control.restringirRIF(rif);
        control.restringirADecimal(precioUnidad);
        control.restringirADecimal(txtMontoAdicional);
        control.restringirNumero(txtFactura);
        control.restringirNumero(txtCodigo);
        control.restringirADecimal(txtMontoAdicional3);
        control.restringirNumero(txtControl);
        control.restringirNumero(codigoProveedor);
        txtFactura.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtCodigo.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtControl.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtMontoAdicional.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtDestinatario.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtRazon.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtDestinatario1.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtRazon1.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtMontoAdicional3.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtDestinatario2.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtRazon2.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtDestinatario3.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
        txtRazon3.setBorder(BorderFactory.createCompoundBorder(null,BorderFactory.createEmptyBorder(0, 10, 0, 0 )));
          class ItemChangeListenerGti implements ItemListener{

            @Override 
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange()== ItemEvent.SELECTED){
                    Object item = ie.getItem(); 
                    gtin.setText("");
                        if (item.equals("GTIN-12")){
                            control.restringirGtin(gtin, tipoGtin);
                        } else if (item.equals("GTIN-13")) {
                            control.restringirGtin(gtin, tipoGtin);
                        } else 
                            control.restringirGtin(gtin, tipoGtin);
                           
                        
                }
            }
 
            
        }  
       tipoGtin.addItemListener(new ItemChangeListenerGti());
       tipoGtin.setSelectedItem("GTIN-13");
       tipoUsuario.setSelectedItem("Administrador");
       
               class ItemChangeListener implements ItemListener{

            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange()== ItemEvent.SELECTED){
                    Object item = ie.getItem(); 
                        if (item.equals("Cedula")){
                           rif.setEnabled(false);
                           cedula.setEnabled(true);
                        } else if (item.equals("RIF")) {
                            cedula.setEnabled(false);
                            rif.setEnabled(true);
                        } else {rif.setEnabled(true);
                            cedula.setEnabled(true);}
                }
            }
 
       
        }  
       comboSeleccion.addItemListener(new ItemChangeListener());
       comboSeleccion.setSelectedItem("Ambos");
       
       
        try {
        MaskFormatter formato= new javax.swing.text.MaskFormatter("(####) ###-####");
        formato.setPlaceholderCharacter('_');
        telefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formato));
        } catch (java.text.ParseException ex) {
        ex.printStackTrace();
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
        menuBotones = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnCostos = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnContactos = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnlTop = new javax.swing.JPanel();
        lblTop = new javax.swing.JLabel();
        btnMinimizar2 = new javax.swing.JButton();
        btnCerrar2 = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        txtPermisos = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pnlInicio = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lblProductosI = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lblCostos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lblMayorCantidad = new javax.swing.JLabel();
        tituloMayor = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        tituloMenor = new javax.swing.JLabel();
        lblMenorCantidad = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tablaVencimiento = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        btnGmail = new javax.swing.JButton();
        btnCalculadora = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        pnlProductos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        btnEliminarStock = new javax.swing.JButton();
        btnCantidad = new javax.swing.JButton();
        btnAgregarProductos = new javax.swing.JButton();
        btnEliminarProductos = new javax.swing.JButton();
        btnModificarProductos = new javax.swing.JButton();
        txtBuscador = new javax.swing.JTextField();
        chooserFechas1 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        chooserFechas2 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        btnLimpiar = new javax.swing.JButton();
        btnFecha = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlUsuarios = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        btnCantidad1 = new javax.swing.JButton();
        btnAgregarUsuarios = new javax.swing.JButton();
        btnEliminarUsuarios = new javax.swing.JButton();
        btnModificarUsuarios = new javax.swing.JButton();
        txtBuscador1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pnlCostos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCostos = new javax.swing.JTable();
        btnAgregarFactura = new javax.swing.JButton();
        btnNotaCredito = new javax.swing.JButton();
        btnNotaDebito = new javax.swing.JButton();
        txtBuscador2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        fechaCosto1 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        fechaCosto2 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        btnFecha1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        btnDetallesFactura = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        pnlContactos = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaContactos = new javax.swing.JTable();
        btnAgregarContactos = new javax.swing.JButton();
        btnEliminarContacto = new javax.swing.JButton();
        btnModificarContactos = new javax.swing.JButton();
        txtBuscador3 = new javax.swing.JTextField();
        btnDetalles = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        pnlFacturas = new javax.swing.JPanel();
        btnQuitarP = new javax.swing.JButton();
        btnAgregarP = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaProductosFactura = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        txtFactura = new javax.swing.JTextField();
        txtControl = new javax.swing.JTextField();
        fechaFactura = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        btnFactura = new javax.swing.JButton();
        lblProductos = new javax.swing.JLabel();
        lblProductosAIngresar = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtBuscador4 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaAgregarFactura = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        pnlDetallesFactura = new javax.swing.JPanel();
        lblFecha = new javax.swing.JLabel();
        lblCodigoProveedor = new javax.swing.JLabel();
        lblControl = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        lblTituloFactura = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        pnlOtrosDebito = new javax.swing.JPanel();
        txtDestinatario = new javax.swing.JTextField();
        txtMontoAdicional = new javax.swing.JTextField();
        lblMontoTotal = new javax.swing.JLabel();
        lblMontoOriginal = new javax.swing.JLabel();
        btnFinalizarDebito = new javax.swing.JButton();
        fechaDebito = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        jScrollPane5 = new javax.swing.JScrollPane();
        txtRazon = new javax.swing.JTextArea();
        lblTituloFactura1 = new javax.swing.JLabel();
        lblFondo2 = new javax.swing.JLabel();
        pnlPreDebito = new javax.swing.JPanel();
        lblPreDebito = new javax.swing.JLabel();
        lblFront = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaDebito = new javax.swing.JTable();
        btnProductosDebito = new javax.swing.JButton();
        btnOtrosDebito = new javax.swing.JButton();
        txtBuscador5 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        fechaDebito1 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        fechaDebito2 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        btnFecha2 = new javax.swing.JButton();
        btnLimpiar2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        pnlProductosDebito = new javax.swing.JPanel();
        btnQuitarP1 = new javax.swing.JButton();
        btnAgregarP1 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        tablaFacturaOriginal = new javax.swing.JTable();
        txtDestinatario1 = new javax.swing.JTextField();
        fechaFactura1 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        btnFactura1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtBuscador6 = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtRazon1 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        tablaAgregarANotaDebito = new javax.swing.JTable();
        lblProductosDebito = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        pnlPreCredito = new javax.swing.JPanel();
        lblPreCredito = new javax.swing.JLabel();
        lblFront1 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablaCredito = new javax.swing.JTable();
        btnParcialCredito = new javax.swing.JButton();
        btnTotalCredito = new javax.swing.JButton();
        txtBuscador7 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        fechaCredito1 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        fechaCredito2 = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        btnFecha3 = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        pnlParcialCredito = new javax.swing.JPanel();
        btnQuitarP2 = new javax.swing.JButton();
        btnAgregarP2 = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tablaFacturaOriginal1 = new javax.swing.JTable();
        txtDestinatario2 = new javax.swing.JTextField();
        fechaCredito = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        btnFactura2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtBuscador8 = new javax.swing.JTextField();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtRazon2 = new javax.swing.JTextArea();
        jScrollPane16 = new javax.swing.JScrollPane();
        tablaAgregarANotaCredito = new javax.swing.JTable();
        lblParcialCredito = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        pnlTotalCredito = new javax.swing.JPanel();
        txtDestinatario3 = new javax.swing.JTextField();
        txtMontoAdicional3 = new javax.swing.JTextField();
        lblMontoTotal1 = new javax.swing.JLabel();
        lblMontoOriginal1 = new javax.swing.JLabel();
        btnFinalizarCredito = new javax.swing.JButton();
        fechaCreditoTotal = new com.toedter.calendar.JDateChooser("yyyy/MM/dd","####/##/##",'_');
        jScrollPane17 = new javax.swing.JScrollPane();
        txtRazon3 = new javax.swing.JTextArea();
        lblTituloFactura2 = new javax.swing.JLabel();
        lblFondo3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuBotones.setBackground(new java.awt.Color(36, 36, 36));
        menuBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo.png"))); // NOI18N
        menuBotones.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 110));

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuarios.png"))); // NOI18N
        btnUsuarios.setBorder(null);
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuariosPressed.png"))); // NOI18N
        btnUsuarios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuariosPressed.png"))); // NOI18N
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });
        menuBotones.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 50, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Separador.png"))); // NOI18N
        menuBotones.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 110, 10));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(205, 185, 130));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USUARIOS");
        menuBotones.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 70, 10));

        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHome.png"))); // NOI18N
        btnInicio.setBorder(null);
        btnInicio.setBorderPainted(false);
        btnInicio.setContentAreaFilled(false);
        btnInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHomePressed.png"))); // NOI18N
        btnInicio.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHomePressed.png"))); // NOI18N
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        menuBotones.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 50, 50));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(205, 185, 130));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIO");
        menuBotones.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 50, 10));

        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductos.png"))); // NOI18N
        btnProductos.setBorder(null);
        btnProductos.setBorderPainted(false);
        btnProductos.setContentAreaFilled(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductosPressed.png"))); // NOI18N
        btnProductos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductosPressed.png"))); // NOI18N
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        menuBotones.add(btnProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 50, 50));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(205, 185, 130));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PRODUCTOS");
        menuBotones.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 90, 10));

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrarSesion.png"))); // NOI18N
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setContentAreaFilled(false);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrarSesionPressed.png"))); // NOI18N
        btnCerrarSesion.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrarSesionPressed.png"))); // NOI18N
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        menuBotones.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 110, 30));

        btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastos.png"))); // NOI18N
        btnCostos.setBorder(null);
        btnCostos.setBorderPainted(false);
        btnCostos.setContentAreaFilled(false);
        btnCostos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCostos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastosPressed.png"))); // NOI18N
        btnCostos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastosPressed.png"))); // NOI18N
        btnCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCostosActionPerformed(evt);
            }
        });
        menuBotones.add(btnCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 50, 50));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(205, 185, 130));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("COSTOS");
        menuBotones.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 90, 10));

        btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactos.png"))); // NOI18N
        btnContactos.setBorder(null);
        btnContactos.setBorderPainted(false);
        btnContactos.setContentAreaFilled(false);
        btnContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnContactos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactosPressed.png"))); // NOI18N
        btnContactos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactosPressed.png"))); // NOI18N
        btnContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactosActionPerformed(evt);
            }
        });
        menuBotones.add(btnContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 50, 50));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(205, 185, 130));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("CONTACTOS");
        menuBotones.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 90, 10));

        jPanel1.add(menuBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 690));

        jPanel3.setBackground(new java.awt.Color(153, 0, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTop.setBackground(new java.awt.Color(36, 36, 36));
        pnlTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlTop.add(lblTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 180, 40));

        btnMinimizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnMinimizar2.png"))); // NOI18N
        btnMinimizar2.setBorder(null);
        btnMinimizar2.setBorderPainted(false);
        btnMinimizar2.setContentAreaFilled(false);
        btnMinimizar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnMinimizar2Pressed.png"))); // NOI18N
        btnMinimizar2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnMinimizar2Pressed.png"))); // NOI18N
        btnMinimizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizar2ActionPerformed(evt);
            }
        });
        pnlTop.add(btnMinimizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 40, 40));

        btnCerrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrar2.png"))); // NOI18N
        btnCerrar2.setBorder(null);
        btnCerrar2.setBorderPainted(false);
        btnCerrar2.setContentAreaFilled(false);
        btnCerrar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrar2Pressed.png"))); // NOI18N
        btnCerrar2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCerrar2Pressed.png"))); // NOI18N
        btnCerrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrar2ActionPerformed(evt);
            }
        });
        pnlTop.add(btnCerrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 40, 40));

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnVolver.png"))); // NOI18N
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnVolverPressed.png"))); // NOI18N
        btnVolver.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnVolverPressed.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlTop.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        txtPermisos.setBackground(new java.awt.Color(36, 36, 36));
        txtPermisos.setFont(new java.awt.Font("Microsoft YaHei", 1, 14)); // NOI18N
        txtPermisos.setForeground(new java.awt.Color(153, 0, 0));
        txtPermisos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPermisos.setToolTipText("");
        txtPermisos.setBorder(null);
        txtPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPermisosActionPerformed(evt);
            }
        });
        pnlTop.add(txtPermisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 160, -1));

        jPanel3.add(pnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1190, 40));

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        pnlInicio.setBackground(new java.awt.Color(32, 32, 32));
        pnlInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(43, 44, 46));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(217, 217, 217));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Cantidad total de Productos");
        jPanel2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 160, -1));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/stockProducto.png"))); // NOI18N
        jPanel2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 85, 90));

        lblProductosI.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblProductosI.setForeground(new java.awt.Color(213, 186, 128));
        lblProductosI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProductosI.setText("4564664 Unidades");
        jPanel2.add(lblProductosI, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, 50));

        pnlInicio.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 285, 120));

        jPanel4.setBackground(new java.awt.Color(43, 44, 46));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/costos.png"))); // NOI18N
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 85, 90));

        jLabel40.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(217, 217, 217));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Gastos totales");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 170, -1));

        lblCostos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCostos.setForeground(new java.awt.Color(213, 186, 128));
        lblCostos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCostos.setText("4564664 Unidades");
        jPanel4.add(lblCostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, 50));

        pnlInicio.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 10, 285, 120));

        jPanel6.setBackground(new java.awt.Color(43, 44, 46));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/masStock.png"))); // NOI18N
        jPanel6.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 85, 90));

        jLabel45.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(217, 217, 217));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Producto en mayor existencia");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 180, -1));

        lblMayorCantidad.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMayorCantidad.setForeground(new java.awt.Color(213, 186, 128));
        lblMayorCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMayorCantidad.setText("4564664 Unidades");
        jPanel6.add(lblMayorCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, 50));

        tituloMayor.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        tituloMayor.setForeground(new java.awt.Color(213, 186, 128));
        tituloMayor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloMayor.setText("Huevos");
        jPanel6.add(tituloMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 80, 160, -1));

        pnlInicio.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(895, 10, 285, 120));

        jPanel5.setBackground(new java.awt.Color(43, 44, 46));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bajoStock.png"))); // NOI18N
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 85, 90));

        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(217, 217, 217));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Producto en menor existencia");
        jPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 180, -1));

        tituloMenor.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        tituloMenor.setForeground(new java.awt.Color(213, 186, 128));
        tituloMenor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloMenor.setText("Huevos");
        jPanel5.add(tituloMenor, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 80, 160, -1));

        lblMenorCantidad.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMenorCantidad.setForeground(new java.awt.Color(213, 186, 128));
        lblMenorCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenorCantidad.setText("4564664 Unidades");
        jPanel5.add(lblMenorCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 180, 50));

        pnlInicio.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 285, 120));

        jPanel7.setBackground(new java.awt.Color(43, 44, 46));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVencimiento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane18.setViewportView(tablaVencimiento);

        jPanel7.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 62, 550, 420));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblVencimiento.png"))); // NOI18N
        jPanel7.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 530, 30));

        pnlInicio.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 580, 500));

        btnGmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGmail.png"))); // NOI18N
        btnGmail.setBorder(null);
        btnGmail.setBorderPainted(false);
        btnGmail.setContentAreaFilled(false);
        btnGmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGmail.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGmailPressed.png"))); // NOI18N
        btnGmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGmailActionPerformed(evt);
            }
        });
        pnlInicio.add(btnGmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 395, 580, 245));

        btnCalculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCalculadora.png"))); // NOI18N
        btnCalculadora.setBorder(null);
        btnCalculadora.setBorderPainted(false);
        btnCalculadora.setContentAreaFilled(false);
        btnCalculadora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalculadora.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCalculadoraPressed.png"))); // NOI18N
        btnCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculadoraActionPerformed(evt);
            }
        });
        pnlInicio.add(btnCalculadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 580, 245));

        jLabel37.setBackground(new java.awt.Color(43, 44, 46));
        pnlInicio.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, -4, 1190, 660));

        jLayeredPane1.add(pnlInicio, "card2");

        pnlProductos.setBackground(new java.awt.Color(43, 44, 46));
        pnlProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblManejoProductos.png"))); // NOI18N
        pnlProductos.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 335, 50));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProductos);

        pnlProductos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 980, 520));

        btnEliminarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarStock.png"))); // NOI18N
        btnEliminarStock.setBorder(null);
        btnEliminarStock.setBorderPainted(false);
        btnEliminarStock.setContentAreaFilled(false);
        btnEliminarStock.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarStock.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarStockPressed.png"))); // NOI18N
        btnEliminarStock.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarStockPressed.png"))); // NOI18N
        btnEliminarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarStockActionPerformed(evt);
            }
        });
        pnlProductos.add(btnEliminarStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 110, -1));

        btnCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarStock.png"))); // NOI18N
        btnCantidad.setBorder(null);
        btnCantidad.setBorderPainted(false);
        btnCantidad.setContentAreaFilled(false);
        btnCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCantidad.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarStockPressed.png"))); // NOI18N
        btnCantidad.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarStockPressed.png"))); // NOI18N
        btnCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidadActionPerformed(evt);
            }
        });
        pnlProductos.add(btnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        btnAgregarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarProducto.png"))); // NOI18N
        btnAgregarProductos.setBorder(null);
        btnAgregarProductos.setContentAreaFilled(false);
        btnAgregarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProductos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarProductoPressed.png"))); // NOI18N
        btnAgregarProductos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarProductoPressed.png"))); // NOI18N
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });
        pnlProductos.add(btnAgregarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 180, 160));

        btnEliminarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarProducto.png"))); // NOI18N
        btnEliminarProductos.setBorder(null);
        btnEliminarProductos.setBorderPainted(false);
        btnEliminarProductos.setContentAreaFilled(false);
        btnEliminarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProductos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarProductoPressed.png"))); // NOI18N
        btnEliminarProductos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarProductoPressed.png"))); // NOI18N
        btnEliminarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductosActionPerformed(evt);
            }
        });
        pnlProductos.add(btnEliminarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 480, 180, 160));

        btnModificarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnModificarProducto.png"))); // NOI18N
        btnModificarProductos.setBorder(null);
        btnModificarProductos.setBorderPainted(false);
        btnModificarProductos.setContentAreaFilled(false);
        btnModificarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarProductos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnModificarProductoPressed.png"))); // NOI18N
        btnModificarProductos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnModificarProductoPressed.png"))); // NOI18N
        btnModificarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductosActionPerformed(evt);
            }
        });
        pnlProductos.add(btnModificarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 180, 160));

        txtBuscador.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador.setText("Buscar por Nombre o GTIN..");
        txtBuscador.setBorder(null);
        txtBuscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscadorFocusLost(evt);
            }
        });
        txtBuscador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscadorMouseClicked(evt);
            }
        });
        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyReleased(evt);
            }
        });
        pnlProductos.add(txtBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 310, 40));
        pnlProductos.add(chooserFechas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 118, 30));
        pnlProductos.add(chooserFechas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, 118, 30));

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        pnlProductos.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 30, 30));
        btnLimpiar.getAccessibleContext().setAccessibleDescription("");

        btnFecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFecha.png"))); // NOI18N
        btnFecha.setBorder(null);
        btnFecha.setBorderPainted(false);
        btnFecha.setContentAreaFilled(false);
        btnFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFecha.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFechaActionPerformed(evt);
            }
        });
        pnlProductos.add(btnFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 30, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFiltrar.png"))); // NOI18N
        pnlProductos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 250, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlProductos.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 40, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPrueba.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        pnlProductos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlProductos, "card3");

        pnlUsuarios.setBackground(new java.awt.Color(43, 44, 46));
        pnlUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFrontUsuarios.png"))); // NOI18N
        pnlUsuarios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 335, 50));

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablaUsuarios);

        pnlUsuarios.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 980, 520));

        btnCantidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desbloquearUsuario.png"))); // NOI18N
        btnCantidad1.setBorder(null);
        btnCantidad1.setBorderPainted(false);
        btnCantidad1.setContentAreaFilled(false);
        btnCantidad1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCantidad1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desbloquearUsuarioPressed.png"))); // NOI18N
        btnCantidad1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/desbloquearUsuarioPressed.png"))); // NOI18N
        btnCantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCantidad1ActionPerformed(evt);
            }
        });
        pnlUsuarios.add(btnCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        btnAgregarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarUsuario.png"))); // NOI18N
        btnAgregarUsuarios.setBorder(null);
        btnAgregarUsuarios.setContentAreaFilled(false);
        btnAgregarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarUsuarioPressed.png"))); // NOI18N
        btnAgregarUsuarios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarUsuarioPressed.png"))); // NOI18N
        btnAgregarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuariosActionPerformed(evt);
            }
        });
        pnlUsuarios.add(btnAgregarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 180, 160));

        btnEliminarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarUsuario.png"))); // NOI18N
        btnEliminarUsuarios.setBorder(null);
        btnEliminarUsuarios.setBorderPainted(false);
        btnEliminarUsuarios.setContentAreaFilled(false);
        btnEliminarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarUsuarioPressed.png"))); // NOI18N
        btnEliminarUsuarios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarUsuarioPressed.png"))); // NOI18N
        btnEliminarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuariosActionPerformed(evt);
            }
        });
        pnlUsuarios.add(btnEliminarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 480, 180, 160));

        btnModificarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEditarUsuario.png"))); // NOI18N
        btnModificarUsuarios.setBorder(null);
        btnModificarUsuarios.setBorderPainted(false);
        btnModificarUsuarios.setContentAreaFilled(false);
        btnModificarUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarUsuarios.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEditarUsuarioPressed.png"))); // NOI18N
        btnModificarUsuarios.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEditarUsuarioPressed.png"))); // NOI18N
        btnModificarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuariosActionPerformed(evt);
            }
        });
        pnlUsuarios.add(btnModificarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 180, 160));

        txtBuscador1.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador1.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador1.setText("Buscar por Nombre, Apellido o Cedula...");
        txtBuscador1.setBorder(null);
        txtBuscador1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador1FocusLost(evt);
            }
        });
        txtBuscador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador1MouseClicked(evt);
            }
        });
        txtBuscador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador1ActionPerformed(evt);
            }
        });
        txtBuscador1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador1KeyReleased(evt);
            }
        });
        pnlUsuarios.add(txtBuscador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 370, 40));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlUsuarios.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 40, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPrueba.png"))); // NOI18N
        jLabel12.setText("jLabel7");
        pnlUsuarios.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlUsuarios, "card3");

        pnlCostos.setBackground(new java.awt.Color(43, 44, 46));
        pnlCostos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/controlCostos.png"))); // NOI18N
        pnlCostos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 335, 50));

        tablaCostos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaCostos);

        pnlCostos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 980, 520));

        btnAgregarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarFactura.png"))); // NOI18N
        btnAgregarFactura.setBorder(null);
        btnAgregarFactura.setContentAreaFilled(false);
        btnAgregarFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarFactura.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarFacturaPressed.png"))); // NOI18N
        btnAgregarFactura.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarFacturaPressed.png"))); // NOI18N
        btnAgregarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFacturaActionPerformed(evt);
            }
        });
        pnlCostos.add(btnAgregarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 180, 160));

        btnNotaCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCredito.png"))); // NOI18N
        btnNotaCredito.setBorder(null);
        btnNotaCredito.setBorderPainted(false);
        btnNotaCredito.setContentAreaFilled(false);
        btnNotaCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotaCredito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoPressed.png"))); // NOI18N
        btnNotaCredito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoPressed.png"))); // NOI18N
        btnNotaCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaCreditoActionPerformed(evt);
            }
        });
        pnlCostos.add(btnNotaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 480, 180, 160));

        btnNotaDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaDebito.png"))); // NOI18N
        btnNotaDebito.setBorder(null);
        btnNotaDebito.setBorderPainted(false);
        btnNotaDebito.setContentAreaFilled(false);
        btnNotaDebito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNotaDebito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaDebitoPressed.png"))); // NOI18N
        btnNotaDebito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaDebitoPressed.png"))); // NOI18N
        btnNotaDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotaDebitoActionPerformed(evt);
            }
        });
        pnlCostos.add(btnNotaDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 180, 160));

        txtBuscador2.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador2.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador2.setText("Buscar por Factura, Control o Proveedor..");
        txtBuscador2.setBorder(null);
        txtBuscador2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador2FocusLost(evt);
            }
        });
        txtBuscador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador2MouseClicked(evt);
            }
        });
        txtBuscador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador2ActionPerformed(evt);
            }
        });
        txtBuscador2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador2KeyReleased(evt);
            }
        });
        pnlCostos.add(txtBuscador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 370, 40));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFiltrar.png"))); // NOI18N
        pnlCostos.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 250, 30));
        pnlCostos.add(fechaCosto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 118, 30));
        pnlCostos.add(fechaCosto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 118, 30));

        btnFecha1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFecha.png"))); // NOI18N
        btnFecha1.setBorder(null);
        btnFecha1.setBorderPainted(false);
        btnFecha1.setContentAreaFilled(false);
        btnFecha1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFecha1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecha1ActionPerformed(evt);
            }
        });
        pnlCostos.add(btnFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 30, 30));

        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        btnLimpiar1.setBorder(null);
        btnLimpiar1.setBorderPainted(false);
        btnLimpiar1.setContentAreaFilled(false);
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        pnlCostos.add(btnLimpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 30, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblDetalles.png"))); // NOI18N
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        pnlCostos.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 120, 30));

        btnDetallesFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDetalles.png"))); // NOI18N
        btnDetallesFactura.setBorder(null);
        btnDetallesFactura.setBorderPainted(false);
        btnDetallesFactura.setContentAreaFilled(false);
        btnDetallesFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetallesFactura.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDetallesPressed.png"))); // NOI18N
        btnDetallesFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesFacturaActionPerformed(evt);
            }
        });
        pnlCostos.add(btnDetallesFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 30, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlCostos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 40, 40));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPrueba.png"))); // NOI18N
        jLabel15.setText("jLabel7");
        pnlCostos.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlCostos, "card3");

        pnlContactos.setBackground(new java.awt.Color(43, 44, 46));
        pnlContactos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblContactos.png"))); // NOI18N
        pnlContactos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 335, 50));

        tablaContactos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tablaContactos);

        pnlContactos.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 980, 520));

        btnAgregarContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarContacto.png"))); // NOI18N
        btnAgregarContactos.setBorder(null);
        btnAgregarContactos.setContentAreaFilled(false);
        btnAgregarContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarContactos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarContactoPressed.png"))); // NOI18N
        btnAgregarContactos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarContactoPressed.png"))); // NOI18N
        btnAgregarContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarContactosActionPerformed(evt);
            }
        });
        pnlContactos.add(btnAgregarContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 180, 160));

        btnEliminarContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarContacto.png"))); // NOI18N
        btnEliminarContacto.setBorder(null);
        btnEliminarContacto.setBorderPainted(false);
        btnEliminarContacto.setContentAreaFilled(false);
        btnEliminarContacto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarContacto.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarContactoPressed.png"))); // NOI18N
        btnEliminarContacto.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarContactoPressed.png"))); // NOI18N
        btnEliminarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarContactoActionPerformed(evt);
            }
        });
        pnlContactos.add(btnEliminarContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 480, 180, 160));

        btnModificarContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEditarContacto.png"))); // NOI18N
        btnModificarContactos.setBorder(null);
        btnModificarContactos.setBorderPainted(false);
        btnModificarContactos.setContentAreaFilled(false);
        btnModificarContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarContactos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEditarContactoPressed.png"))); // NOI18N
        btnModificarContactos.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEditarContactoPressed.png"))); // NOI18N
        btnModificarContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarContactosActionPerformed(evt);
            }
        });
        pnlContactos.add(btnModificarContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 300, 180, 160));

        txtBuscador3.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador3.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador3.setText("Buscar por Codigo o Nombre...");
        txtBuscador3.setBorder(null);
        txtBuscador3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador3FocusLost(evt);
            }
        });
        txtBuscador3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador3MouseClicked(evt);
            }
        });
        txtBuscador3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador3ActionPerformed(evt);
            }
        });
        txtBuscador3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador3KeyReleased(evt);
            }
        });
        pnlContactos.add(txtBuscador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 290, 40));

        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDetalles.png"))); // NOI18N
        btnDetalles.setBorder(null);
        btnDetalles.setBorderPainted(false);
        btnDetalles.setContentAreaFilled(false);
        btnDetalles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDetalles.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDetallesPressed.png"))); // NOI18N
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        pnlContactos.add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 30, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblDetalles.png"))); // NOI18N
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        pnlContactos.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 120, 30));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlContactos.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 40, 40));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPrueba.png"))); // NOI18N
        jLabel19.setText("jLabel7");
        pnlContactos.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlContactos, "card3");

        pnlFacturas.setBackground(new java.awt.Color(43, 44, 46));
        pnlFacturas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuitarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFactura.png"))); // NOI18N
        btnQuitarP.setBorder(null);
        btnQuitarP.setBorderPainted(false);
        btnQuitarP.setContentAreaFilled(false);
        btnQuitarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFacturaPressed.png"))); // NOI18N
        btnQuitarP.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFacturaPressed.png"))); // NOI18N
        btnQuitarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarPActionPerformed(evt);
            }
        });
        pnlFacturas.add(btnQuitarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 130, -1));

        btnAgregarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFactura.png"))); // NOI18N
        btnAgregarP.setBorder(null);
        btnAgregarP.setBorderPainted(false);
        btnAgregarP.setContentAreaFilled(false);
        btnAgregarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarP.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFacturaPressed.png"))); // NOI18N
        btnAgregarP.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFacturaPressed.png"))); // NOI18N
        btnAgregarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPActionPerformed(evt);
            }
        });
        pnlFacturas.add(btnAgregarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 130, 30));

        tablaProductosFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tablaProductosFactura);

        pnlFacturas.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 840, 230));

        txtCodigo.setBackground(new java.awt.Color(217, 217, 217));
        txtCodigo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtCodigo.setForeground(new java.awt.Color(43, 44, 46));
        txtCodigo.setBorder(null);
        pnlFacturas.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 205, 130, 30));

        txtFactura.setBackground(new java.awt.Color(217, 217, 217));
        txtFactura.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtFactura.setForeground(new java.awt.Color(43, 44, 46));
        txtFactura.setBorder(null);
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });
        pnlFacturas.add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 130, 30));

        txtControl.setBackground(new java.awt.Color(217, 217, 217));
        txtControl.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtControl.setForeground(new java.awt.Color(43, 44, 46));
        txtControl.setBorder(null);
        txtControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtControlActionPerformed(evt);
            }
        });
        pnlFacturas.add(txtControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1038, 205, 130, 30));
        pnlFacturas.add(fechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(1038, 130, 130, 30));

        btnFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizar.png"))); // NOI18N
        btnFactura.setBorder(null);
        btnFactura.setBorderPainted(false);
        btnFactura.setContentAreaFilled(false);
        btnFactura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFactura.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFactura.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });
        pnlFacturas.add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 130, -1));

        lblProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblTablaProductos.png"))); // NOI18N
        pnlFacturas.add(lblProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 30));

        lblProductosAIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblTablaProductosAIngresar.png"))); // NOI18N
        pnlFacturas.add(lblProductosAIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 290, 30));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlFacturas.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 40, 40));

        txtBuscador4.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador4.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador4.setText("Buscar por Nombre o GTIN...");
        txtBuscador4.setBorder(null);
        txtBuscador4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador4FocusLost(evt);
            }
        });
        txtBuscador4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador4MouseClicked(evt);
            }
        });
        txtBuscador4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador4ActionPerformed(evt);
            }
        });
        txtBuscador4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador4KeyReleased(evt);
            }
        });
        pnlFacturas.add(txtBuscador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 300, 40));

        tablaAgregarFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(tablaAgregarFactura);

        pnlFacturas.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 1170, 250));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFrontGenerarFactura.png"))); // NOI18N
        pnlFacturas.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 335, 50));

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoAgregarFactura.png"))); // NOI18N
        jLabel24.setText("jLabel7");
        pnlFacturas.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlFacturas, "card3");

        pnlDetallesFactura.setBackground(new java.awt.Color(43, 44, 46));
        pnlDetallesFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFecha.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(204, 204, 204));
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlDetallesFactura.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 560, 30));

        lblCodigoProveedor.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        lblCodigoProveedor.setForeground(new java.awt.Color(204, 204, 204));
        pnlDetallesFactura.add(lblCodigoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 500, 30));

        lblControl.setFont(new java.awt.Font("SansSerif", 1, 19)); // NOI18N
        lblControl.setForeground(new java.awt.Color(204, 204, 204));
        lblControl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        pnlDetallesFactura.add(lblControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 400, 30));

        lblTotal.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(242, 219, 152));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlDetallesFactura.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 1160, 50));

        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(tablaFactura);

        pnlDetallesFactura.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 1170, 360));

        lblTituloFactura.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloFactura.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTituloFactura.setForeground(new java.awt.Color(242, 219, 152));
        lblTituloFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlDetallesFactura.add(lblTituloFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1190, 50));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoVisualizar2.png"))); // NOI18N
        jLabel27.setText("jLabel7");
        pnlDetallesFactura.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlDetallesFactura, "card3");

        pnlOtrosDebito.setBackground(new java.awt.Color(43, 44, 46));
        pnlOtrosDebito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDestinatario.setBackground(new java.awt.Color(187, 187, 187));
        txtDestinatario.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtDestinatario.setForeground(new java.awt.Color(43, 44, 46));
        txtDestinatario.setBorder(null);
        pnlOtrosDebito.add(txtDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 220, 30));

        txtMontoAdicional.setBackground(new java.awt.Color(187, 187, 187));
        txtMontoAdicional.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtMontoAdicional.setForeground(new java.awt.Color(43, 44, 46));
        txtMontoAdicional.setText("0");
        txtMontoAdicional.setBorder(null);
        txtMontoAdicional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMontoAdicionalMouseClicked(evt);
            }
        });
        txtMontoAdicional.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoAdicionalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoAdicionalKeyReleased(evt);
            }
        });
        pnlOtrosDebito.add(txtMontoAdicional, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 220, 30));

        lblMontoTotal.setFont(new java.awt.Font("SansSerif", 1, 34)); // NOI18N
        lblMontoTotal.setForeground(new java.awt.Color(217, 217, 217));
        lblMontoTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlOtrosDebito.add(lblMontoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 460, 60));

        lblMontoOriginal.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMontoOriginal.setForeground(new java.awt.Color(217, 217, 217));
        lblMontoOriginal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlOtrosDebito.add(lblMontoOriginal, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 490, 450, 30));

        btnFinalizarDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizar.png"))); // NOI18N
        btnFinalizarDebito.setBorder(null);
        btnFinalizarDebito.setBorderPainted(false);
        btnFinalizarDebito.setContentAreaFilled(false);
        btnFinalizarDebito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizarDebito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFinalizarDebito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFinalizarDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarDebitoActionPerformed(evt);
            }
        });
        pnlOtrosDebito.add(btnFinalizarDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 90, -1));
        pnlOtrosDebito.add(fechaDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 160, 30));

        txtRazon.setBackground(new java.awt.Color(187, 187, 187));
        txtRazon.setColumns(20);
        txtRazon.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtRazon.setForeground(new java.awt.Color(43, 44, 46));
        txtRazon.setRows(5);
        txtRazon.setBorder(null);
        jScrollPane5.setViewportView(txtRazon);

        pnlOtrosDebito.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, 110));

        lblTituloFactura1.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloFactura1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTituloFactura1.setForeground(new java.awt.Color(242, 219, 152));
        lblTituloFactura1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloFactura1.setText("HOLA");
        pnlOtrosDebito.add(lblTituloFactura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1190, 50));

        lblFondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoOtroDebito.png"))); // NOI18N
        pnlOtrosDebito.add(lblFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlOtrosDebito, "card3");

        pnlPreDebito.setBackground(new java.awt.Color(43, 44, 46));
        pnlPreDebito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPreDebito.setBackground(new java.awt.Color(255, 255, 255));
        lblPreDebito.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblPreDebito.setForeground(new java.awt.Color(213, 186, 128));
        lblPreDebito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreDebito.setText("FACTURA N° 500");
        pnlPreDebito.add(lblPreDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 260, 30));

        lblFront.setBackground(new java.awt.Color(255, 255, 255));
        lblFront.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFront.setForeground(new java.awt.Color(213, 186, 128));
        lblFront.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFront.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFrontNotasDebito.png"))); // NOI18N
        pnlPreDebito.add(lblFront, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 50));

        tablaDebito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(tablaDebito);

        pnlPreDebito.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 980, 520));

        btnProductosDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDevolucion.png"))); // NOI18N
        btnProductosDebito.setBorder(null);
        btnProductosDebito.setContentAreaFilled(false);
        btnProductosDebito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductosDebito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDevolucionPressed.png"))); // NOI18N
        btnProductosDebito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnDevolucionPressed.png"))); // NOI18N
        btnProductosDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosDebitoActionPerformed(evt);
            }
        });
        pnlPreDebito.add(btnProductosDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 180, 250));

        btnOtrosDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnOtrasRazones.png"))); // NOI18N
        btnOtrosDebito.setBorder(null);
        btnOtrosDebito.setBorderPainted(false);
        btnOtrosDebito.setContentAreaFilled(false);
        btnOtrosDebito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOtrosDebito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnOtrasRazonesPressed.png"))); // NOI18N
        btnOtrosDebito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnOtrasRazonesPressed.png"))); // NOI18N
        btnOtrosDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtrosDebitoActionPerformed(evt);
            }
        });
        pnlPreDebito.add(btnOtrosDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, 180, 250));

        txtBuscador5.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador5.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador5.setText("Buscar por Destinatario..");
        txtBuscador5.setBorder(null);
        txtBuscador5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador5FocusLost(evt);
            }
        });
        txtBuscador5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador5MouseClicked(evt);
            }
        });
        txtBuscador5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador5ActionPerformed(evt);
            }
        });
        txtBuscador5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador5KeyReleased(evt);
            }
        });
        pnlPreDebito.add(txtBuscador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 280, 40));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFiltrar.png"))); // NOI18N
        pnlPreDebito.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 250, 30));
        pnlPreDebito.add(fechaDebito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 118, 30));
        pnlPreDebito.add(fechaDebito2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 118, 30));

        btnFecha2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFecha.png"))); // NOI18N
        btnFecha2.setBorder(null);
        btnFecha2.setBorderPainted(false);
        btnFecha2.setContentAreaFilled(false);
        btnFecha2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFecha2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecha2ActionPerformed(evt);
            }
        });
        pnlPreDebito.add(btnFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 30, 30));

        btnLimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        btnLimpiar2.setBorder(null);
        btnLimpiar2.setBorderPainted(false);
        btnLimpiar2.setContentAreaFilled(false);
        btnLimpiar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar2ActionPerformed(evt);
            }
        });
        pnlPreDebito.add(btnLimpiar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 30, 30));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlPreDebito.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 40, 40));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPrueba.png"))); // NOI18N
        jLabel31.setText("jLabel7");
        pnlPreDebito.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlPreDebito, "card3");

        pnlProductosDebito.setBackground(new java.awt.Color(43, 44, 46));
        pnlProductosDebito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuitarP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFactura.png"))); // NOI18N
        btnQuitarP1.setBorder(null);
        btnQuitarP1.setBorderPainted(false);
        btnQuitarP1.setContentAreaFilled(false);
        btnQuitarP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarP1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFacturaPressed.png"))); // NOI18N
        btnQuitarP1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFacturaPressed.png"))); // NOI18N
        btnQuitarP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarP1ActionPerformed(evt);
            }
        });
        pnlProductosDebito.add(btnQuitarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 130, -1));

        btnAgregarP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFactura.png"))); // NOI18N
        btnAgregarP1.setBorder(null);
        btnAgregarP1.setBorderPainted(false);
        btnAgregarP1.setContentAreaFilled(false);
        btnAgregarP1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarP1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFacturaPressed.png"))); // NOI18N
        btnAgregarP1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFacturaPressed.png"))); // NOI18N
        btnAgregarP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarP1ActionPerformed(evt);
            }
        });
        pnlProductosDebito.add(btnAgregarP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 130, 30));

        tablaFacturaOriginal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(tablaFacturaOriginal);

        pnlProductosDebito.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 840, 230));

        txtDestinatario1.setBackground(new java.awt.Color(217, 217, 217));
        txtDestinatario1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtDestinatario1.setForeground(new java.awt.Color(43, 44, 46));
        txtDestinatario1.setBorder(null);
        txtDestinatario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinatario1ActionPerformed(evt);
            }
        });
        pnlProductosDebito.add(txtDestinatario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 130, 30));
        pnlProductosDebito.add(fechaFactura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1038, 130, 130, 30));

        btnFactura1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizar.png"))); // NOI18N
        btnFactura1.setBorder(null);
        btnFactura1.setBorderPainted(false);
        btnFactura1.setContentAreaFilled(false);
        btnFactura1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFactura1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFactura1.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFactura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactura1ActionPerformed(evt);
            }
        });
        pnlProductosDebito.add(btnFactura1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 130, -1));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlProductosDebito.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 40, 40));

        txtBuscador6.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador6.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador6.setText("Buscar por Nombre...");
        txtBuscador6.setBorder(null);
        txtBuscador6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador6FocusLost(evt);
            }
        });
        txtBuscador6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador6MouseClicked(evt);
            }
        });
        txtBuscador6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador6ActionPerformed(evt);
            }
        });
        txtBuscador6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador6KeyReleased(evt);
            }
        });
        pnlProductosDebito.add(txtBuscador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 300, 40));

        txtRazon1.setBackground(new java.awt.Color(217, 217, 217));
        txtRazon1.setColumns(20);
        txtRazon1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtRazon1.setForeground(new java.awt.Color(43, 44, 46));
        txtRazon1.setRows(5);
        txtRazon1.setBorder(null);
        jScrollPane12.setViewportView(txtRazon1);

        pnlProductosDebito.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 300, 60));

        tablaAgregarANotaDebito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(tablaAgregarANotaDebito);

        pnlProductosDebito.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 1160, 250));

        lblProductosDebito.setBackground(new java.awt.Color(255, 255, 255));
        lblProductosDebito.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblProductosDebito.setForeground(new java.awt.Color(213, 186, 128));
        pnlProductosDebito.add(lblProductosDebito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 335, 50));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoProductosDebito.png"))); // NOI18N
        jLabel32.setText("jLabel7");
        pnlProductosDebito.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlProductosDebito, "card3");

        pnlPreCredito.setBackground(new java.awt.Color(43, 44, 46));
        pnlPreCredito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPreCredito.setBackground(new java.awt.Color(255, 255, 255));
        lblPreCredito.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        lblPreCredito.setForeground(new java.awt.Color(213, 186, 128));
        lblPreCredito.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPreCredito.setText("FACTURA N° 500");
        pnlPreCredito.add(lblPreCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 260, 30));

        lblFront1.setBackground(new java.awt.Color(255, 255, 255));
        lblFront1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblFront1.setForeground(new java.awt.Color(213, 186, 128));
        lblFront1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFront1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFrontNotasCredito.png"))); // NOI18N
        pnlPreCredito.add(lblFront1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 270, 50));

        tablaCredito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(tablaCredito);

        pnlPreCredito.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 980, 520));

        btnParcialCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoParcial.png"))); // NOI18N
        btnParcialCredito.setBorder(null);
        btnParcialCredito.setContentAreaFilled(false);
        btnParcialCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnParcialCredito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoParcialPressed.png"))); // NOI18N
        btnParcialCredito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoParcialPressed.png"))); // NOI18N
        btnParcialCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParcialCreditoActionPerformed(evt);
            }
        });
        pnlPreCredito.add(btnParcialCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 180, 250));

        btnTotalCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoTotal.png"))); // NOI18N
        btnTotalCredito.setBorder(null);
        btnTotalCredito.setBorderPainted(false);
        btnTotalCredito.setContentAreaFilled(false);
        btnTotalCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTotalCredito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoTotalPressed.png"))); // NOI18N
        btnTotalCredito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnNotaCreditoTotalPressed.png"))); // NOI18N
        btnTotalCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCreditoActionPerformed(evt);
            }
        });
        pnlPreCredito.add(btnTotalCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, 180, 250));

        txtBuscador7.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador7.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador7.setText("Buscar por Destinatario..");
        txtBuscador7.setBorder(null);
        txtBuscador7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador7FocusLost(evt);
            }
        });
        txtBuscador7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador7MouseClicked(evt);
            }
        });
        txtBuscador7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador7ActionPerformed(evt);
            }
        });
        txtBuscador7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador7KeyReleased(evt);
            }
        });
        pnlPreCredito.add(txtBuscador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 280, 40));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblFiltrar.png"))); // NOI18N
        pnlPreCredito.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 250, 30));
        pnlPreCredito.add(fechaCredito1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 118, 30));
        pnlPreCredito.add(fechaCredito2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 118, 30));

        btnFecha3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFecha.png"))); // NOI18N
        btnFecha3.setBorder(null);
        btnFecha3.setBorderPainted(false);
        btnFecha3.setContentAreaFilled(false);
        btnFecha3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFecha3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aceptarFechaPressed.png"))); // NOI18N
        btnFecha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecha3ActionPerformed(evt);
            }
        });
        pnlPreCredito.add(btnFecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, 30, 30));

        btnLimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelar.png"))); // NOI18N
        btnLimpiar3.setBorder(null);
        btnLimpiar3.setBorderPainted(false);
        btnLimpiar3.setContentAreaFilled(false);
        btnLimpiar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar3.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnCancelarPressed.png"))); // NOI18N
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });
        pnlPreCredito.add(btnLimpiar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 30, 30));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlPreCredito.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 40, 40));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoPrueba.png"))); // NOI18N
        jLabel34.setText("jLabel7");
        pnlPreCredito.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlPreCredito, "card3");

        pnlParcialCredito.setBackground(new java.awt.Color(43, 44, 46));
        pnlParcialCredito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnQuitarP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFactura.png"))); // NOI18N
        btnQuitarP2.setBorder(null);
        btnQuitarP2.setBorderPainted(false);
        btnQuitarP2.setContentAreaFilled(false);
        btnQuitarP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitarP2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFacturaPressed.png"))); // NOI18N
        btnQuitarP2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEliminarPFacturaPressed.png"))); // NOI18N
        btnQuitarP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarP2ActionPerformed(evt);
            }
        });
        pnlParcialCredito.add(btnQuitarP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 310, 130, -1));

        btnAgregarP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFactura.png"))); // NOI18N
        btnAgregarP2.setBorder(null);
        btnAgregarP2.setBorderPainted(false);
        btnAgregarP2.setContentAreaFilled(false);
        btnAgregarP2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarP2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFacturaPressed.png"))); // NOI18N
        btnAgregarP2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnAgregarPFacturaPressed.png"))); // NOI18N
        btnAgregarP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarP2ActionPerformed(evt);
            }
        });
        pnlParcialCredito.add(btnAgregarP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, 130, 30));

        tablaFacturaOriginal1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(tablaFacturaOriginal1);

        pnlParcialCredito.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 840, 230));

        txtDestinatario2.setBackground(new java.awt.Color(217, 217, 217));
        txtDestinatario2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtDestinatario2.setForeground(new java.awt.Color(43, 44, 46));
        txtDestinatario2.setBorder(null);
        txtDestinatario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinatario2ActionPerformed(evt);
            }
        });
        pnlParcialCredito.add(txtDestinatario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 130, 130, 30));
        pnlParcialCredito.add(fechaCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(1038, 130, 130, 30));

        btnFactura2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizar.png"))); // NOI18N
        btnFactura2.setBorder(null);
        btnFactura2.setBorderPainted(false);
        btnFactura2.setContentAreaFilled(false);
        btnFactura2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFactura2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFactura2.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFactura2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFactura2ActionPerformed(evt);
            }
        });
        pnlParcialCredito.add(btnFactura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 310, 130, -1));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Lupa.png"))); // NOI18N
        pnlParcialCredito.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 40, 40));

        txtBuscador8.setBackground(new java.awt.Color(43, 47, 58));
        txtBuscador8.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        txtBuscador8.setForeground(new java.awt.Color(204, 204, 204));
        txtBuscador8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscador8.setText("Buscar por Nombre...");
        txtBuscador8.setBorder(null);
        txtBuscador8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscador8FocusLost(evt);
            }
        });
        txtBuscador8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscador8MouseClicked(evt);
            }
        });
        txtBuscador8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscador8ActionPerformed(evt);
            }
        });
        txtBuscador8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscador8KeyReleased(evt);
            }
        });
        pnlParcialCredito.add(txtBuscador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 300, 40));

        txtRazon2.setBackground(new java.awt.Color(217, 217, 217));
        txtRazon2.setColumns(20);
        txtRazon2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        txtRazon2.setForeground(new java.awt.Color(43, 44, 46));
        txtRazon2.setRows(5);
        txtRazon2.setBorder(null);
        jScrollPane15.setViewportView(txtRazon2);

        pnlParcialCredito.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 190, 300, 60));

        tablaAgregarANotaCredito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(tablaAgregarANotaCredito);

        pnlParcialCredito.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 1160, 250));

        lblParcialCredito.setBackground(new java.awt.Color(255, 255, 255));
        lblParcialCredito.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblParcialCredito.setForeground(new java.awt.Color(213, 186, 128));
        pnlParcialCredito.add(lblParcialCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 335, 50));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoParcialCredito.png"))); // NOI18N
        jLabel36.setText("jLabel7");
        pnlParcialCredito.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlParcialCredito, "card3");

        pnlTotalCredito.setBackground(new java.awt.Color(43, 44, 46));
        pnlTotalCredito.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtDestinatario3.setBackground(new java.awt.Color(187, 187, 187));
        txtDestinatario3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtDestinatario3.setForeground(new java.awt.Color(43, 44, 46));
        txtDestinatario3.setBorder(null);
        pnlTotalCredito.add(txtDestinatario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, 220, 30));

        txtMontoAdicional3.setBackground(new java.awt.Color(187, 187, 187));
        txtMontoAdicional3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtMontoAdicional3.setForeground(new java.awt.Color(43, 44, 46));
        txtMontoAdicional3.setText("0");
        txtMontoAdicional3.setBorder(null);
        txtMontoAdicional3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMontoAdicional3MouseClicked(evt);
            }
        });
        txtMontoAdicional3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMontoAdicional3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoAdicional3KeyReleased(evt);
            }
        });
        pnlTotalCredito.add(txtMontoAdicional3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 220, 30));

        lblMontoTotal1.setFont(new java.awt.Font("SansSerif", 1, 34)); // NOI18N
        lblMontoTotal1.setForeground(new java.awt.Color(217, 217, 217));
        lblMontoTotal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlTotalCredito.add(lblMontoTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, 460, 60));

        lblMontoOriginal1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblMontoOriginal1.setForeground(new java.awt.Color(217, 217, 217));
        lblMontoOriginal1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlTotalCredito.add(lblMontoOriginal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 490, 450, 30));

        btnFinalizarCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizar.png"))); // NOI18N
        btnFinalizarCredito.setBorder(null);
        btnFinalizarCredito.setBorderPainted(false);
        btnFinalizarCredito.setContentAreaFilled(false);
        btnFinalizarCredito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFinalizarCredito.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFinalizarCredito.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnFinalizarPressed.png"))); // NOI18N
        btnFinalizarCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCreditoActionPerformed(evt);
            }
        });
        pnlTotalCredito.add(btnFinalizarCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 90, -1));
        pnlTotalCredito.add(fechaCreditoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 160, 30));

        txtRazon3.setBackground(new java.awt.Color(187, 187, 187));
        txtRazon3.setColumns(20);
        txtRazon3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        txtRazon3.setForeground(new java.awt.Color(43, 44, 46));
        txtRazon3.setRows(5);
        txtRazon3.setBorder(null);
        jScrollPane17.setViewportView(txtRazon3);

        pnlTotalCredito.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, 110));

        lblTituloFactura2.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloFactura2.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTituloFactura2.setForeground(new java.awt.Color(242, 219, 152));
        lblTituloFactura2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloFactura2.setText("HOLA");
        pnlTotalCredito.add(lblTituloFactura2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1190, 50));

        lblFondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoOtroDebito.png"))); // NOI18N
        pnlTotalCredito.add(lblFondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 1190, 650));

        jLayeredPane1.add(pnlTotalCredito, "card3");

        jPanel3.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1190, 650));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1190, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        pnlInicio.setVisible(false);
        pnlProductos.setVisible(false);
        pnlCostos.setVisible(false);
        pnlUsuarios.setVisible(true); 
        pnlContactos.setVisible(false);
        pnlFacturas.setVisible(false);
        pnlDetallesFactura.setVisible(false);
        pnlPreDebito.setVisible(false);
        pnlOtrosDebito.setVisible(false);
        pnlProductosDebito.setVisible(false);
        pnlPreCredito.setVisible(false);
        pnlParcialCredito.setVisible(false);
        pnlTotalCredito.setVisible(false);
        lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblUsuarios.png")));
        if (pnlUsuarios.isEnabled()){
           btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHome.png")));
           btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductos.png"))); 
           btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuariosPressed.png"))); 
           btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastos.png")));
           btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactos.png")));
    
         }
        control.rellenarTablaUsuarios(tablaUsuarios,"SELECT * FROM usuarios");
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnMinimizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizar2ActionPerformed
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_btnMinimizar2ActionPerformed

    private void btnCerrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrar2ActionPerformed
     
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null,"¿Desea salir de la aplicacion?","Exit",dialog);
        if (result == 0){
            System.exit(0);
            control.desconectarBD();
        }
    }//GEN-LAST:event_btnCerrar2ActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        pnlInicio.setVisible(true);
        pnlProductos.setVisible(false);
        pnlUsuarios.setVisible(false);
        pnlCostos.setVisible(false);
        pnlContactos.setVisible(false);
        pnlFacturas.setVisible(false);
        pnlDetallesFactura.setVisible(false);
        pnlPreDebito.setVisible(false);
        pnlOtrosDebito.setVisible(false);
        pnlProductosDebito.setVisible(false);
        pnlPreCredito.setVisible(false);
        pnlParcialCredito.setVisible(false);
        pnlTotalCredito.setVisible(false);
        lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblInicio.png")));
        if (pnlInicio.isEnabled()){
           btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHomePressed.png")));
           btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductos.png"))); 
           btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuarios.png")));
           btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastos.png"))); 
           btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactos.png")));
           control.sumarInventarioTotal(lblProductosI);
           control.sumarGastoTotal(lblCostos);
           control.mayorCantidad(lblMayorCantidad,tituloMayor);
           control.menorCantidad(lblMenorCantidad,tituloMenor);
           control.rellenarTablaVencimiento(tablaVencimiento,"SELECT *FROM productos WHERE YEARWEEK(`Fecha de Caducidad`,1) = YEARWEEK(NOW(),6) ORDER BY `Fecha de Caducidad` ASC;");
         }
        
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        chooserFechas1.setDate(null);
        chooserFechas2.setDate(null);
        pnlInicio.setVisible(false);
        pnlCostos.setVisible(false);
        pnlProductos.setVisible(true);
        pnlUsuarios.setVisible(false);
        pnlContactos.setVisible(false);
        pnlFacturas.setVisible(false);
        pnlDetallesFactura.setVisible(false);
        pnlPreDebito.setVisible(false);
        pnlOtrosDebito.setVisible(false);
        pnlProductosDebito.setVisible(false);
        pnlPreCredito.setVisible(false);
        pnlParcialCredito.setVisible(false);
        pnlTotalCredito.setVisible(false);
        lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblProductos.png")));
        if (pnlProductos.isEnabled()){
           btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHome.png")));
           btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductosPressed.png"))); 
           btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuarios.png")));  
           btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastos.png"))); 
           btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactos.png")));
    
         }
        control.rellenarTablaProductos(tablaProductos,"SELECT * FROM productos");
    }//GEN-LAST:event_btnProductosActionPerformed

    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorActionPerformed

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        nombre.setText("");
        descripcion.setText("");
        gtin.setText("");
        fecha.setDate(null);
        tipoGtin.setSelectedItem("GTIN-13");
        Object [] campos ={
        "Nombre",nombre,    
        "Tipo GTIN",tipoGtin,    
        "GTIN",gtin,
        "Fecha de Caducidad",fecha,
        "Descripcion",descripcion,
        
                               
    };
    Object [] opciones={"AGREGAR","CANCELAR"};    
    int respuesta=0;
        while (respuesta == 0 && (nombre.getText().equals("")||fecha.getDate()==null || !control.comprobarLongitudGTIN(gtin, tipoGtin) ||gtin.getText().equals("") || control.comprobarCantidad(-1, gtin)!=3) || control.comprobarNombre(nombre)){
            respuesta=JOptionPane.showOptionDialog(null, campos, "Agregar Producto", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
            if (respuesta == 0 && !nombre.getText().equals("") && fecha.getDate()!=null && control.comprobarLongitudGTIN(gtin, tipoGtin) &&!gtin.getText().equals("") && control.comprobarCantidad(-1, gtin)==3 && !control.comprobarNombre(nombre)){
                control.registrarEnBdProductos(nombre.getText(),tipoGtin.getSelectedItem().toString(),gtin.getText(),fecha,descripcion.getText(), 0); 
                break;
            }
            else if (respuesta == 0 && nombre.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un nombre");
            else if (respuesta == 0 && control.comprobarNombre(nombre))  JOptionPane.showMessageDialog(null,"El nombre del producto ya existe"); 
            else if (respuesta == 0 && gtin.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un GTIN");
            else if (respuesta == 0 && !control.comprobarLongitudGTIN(gtin, tipoGtin)) JOptionPane.showMessageDialog(null,"Debe cumplir la longitud del GTIN");
            else if (respuesta == 0 && fecha.getDate()==null) JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha de caducidad");
            else if (respuesta == 0 && control.comprobarCantidad(-1, gtin)!=3) JOptionPane.showMessageDialog(null,"Debe colocar un GTIN no existente");
        }
       control.rellenarTablaProductos(tablaProductos,"SELECT * FROM productos"); 
    }//GEN-LAST:event_btnAgregarProductosActionPerformed

    private void btnModificarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductosActionPerformed
        tablaProductos.setEnabled(true);
        tablaProductos.setRowSelectionAllowed(true);  
       if (tablaProductos.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar una fila para Modificar"); 
       else {
           nombre.setText(String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0)));
           tipoGtin.setSelectedItem(String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1)));
           gtin.setText(String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2)));
           fecha.setDate(Date.valueOf(String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 3))));
           descripcion.setText(String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 4)));
           cantidad.setText(String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5)));
                   
       
             
        Object [] campos ={
        "Nombre",nombre,    
        "Tipo GTIN",tipoGtin,    
        "GTIN",gtin,
        "Fecha de Caducidad",fecha,
        "Descripcion",descripcion,
        };
    Object [] opciones={"ACEPTAR","CANCELAR"};    
    int respuesta=0;
    
          while (respuesta == 0 && (control.verificarLongitudGTIN(gtin)||control.verificarMayorA3(nombre)||(control.verificarNombreSeleccionado(tablaProductos,nombre.getText())==false && control.comprobarNombre(nombre))||(control.verificarGTINSeleccionado(tablaProductos,gtin.getText())==false && control.comprobarGtin(gtin)))){ 
            respuesta=JOptionPane.showOptionDialog(null, campos, "Modificar Productos", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
              if (respuesta==0 && !nombre.getText().equals("") && fecha.getDate()!=null &&(!control.comprobarGtin(gtin) || control.verificarGTINSeleccionado(tablaProductos,gtin.getText())==true ) &&(!control.comprobarNombre(nombre) || control.verificarNombreSeleccionado(tablaProductos,nombre.getText())==true ) &&!gtin.getText().equals("") ){
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                control.modificarProducto(tablaProductos, nombre.getText(), tipoGtin.getSelectedItem().toString(), gtin.getText(), fecha, descripcion.getText(), Integer.parseInt(cantidad.getText()));
                tablaProductos.setValueAt(nombre.getText(), tablaProductos.getSelectedRow(), 0);
                tablaProductos.setValueAt(tipoGtin.getSelectedItem().toString(), tablaProductos.getSelectedRow(), 1);
                tablaProductos.setValueAt(gtin.getText(), tablaProductos.getSelectedRow(), 2);
                tablaProductos.setValueAt(df.format(fecha.getDate()), tablaProductos.getSelectedRow(), 3);
                tablaProductos.setValueAt(descripcion.getText(), tablaProductos.getSelectedRow(), 4);
                tablaProductos.setValueAt(cantidad.getText(), tablaProductos.getSelectedRow(), 5);
                break;
            } 
            else if (respuesta == 0 && nombre.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un nombre");
            else if (respuesta == 0 && !control.verificarMayorA3(nombre)) JOptionPane.showMessageDialog(null,"El nombre del producto debe ser mayor a 3 caracteres"); 
            else if (respuesta == 0 && (control.verificarNombreSeleccionado(tablaProductos,nombre.getText())==false&&control.comprobarNombre(nombre))) JOptionPane.showMessageDialog(null,"El nombre del producto ya existe"); 
            else if (respuesta == 0 && gtin.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un GTIN");
            else if (respuesta == 0 && (control.verificarGTINSeleccionado(tablaProductos,gtin.getText())==false&&control.comprobarGtin(gtin))) JOptionPane.showMessageDialog(null,"El GTIN introducido ya existe"); 
            else if (respuesta == 0 && fecha.getDate()==null) JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha");
           
              
              
          }
        }
    }//GEN-LAST:event_btnModificarProductosActionPerformed

    private void btnEliminarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductosActionPerformed
        int fila = tablaProductos.getSelectedRow();
        
            if (fila>=0){
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el Producto?","Eliminar Producto",dialog); 
            if (result == 0){
            control.eliminarDeTablaProductosBD(tablaProductos);
            control.eliminarFilaVentas(tablaProductos, fila);
            }
            
        }else JOptionPane.showMessageDialog(null, "Debe seleccionar la fila que desea eliminar");
        
           
    }//GEN-LAST:event_btnEliminarProductosActionPerformed

    private void txtBuscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscadorFocusLost
        txtBuscador.setText("Buscar por Nombre o GTIN..");
    }//GEN-LAST:event_txtBuscadorFocusLost

    private void txtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyReleased
        control.rellenarTablaProductos(tablaProductos, "SELECT * FROM productos WHERE `Nombre` LIKE '"+txtBuscador.getText()+"%'OR `GTIN` LIKE '"+txtBuscador.getText()+"%'" );
    }//GEN-LAST:event_txtBuscadorKeyReleased

    private void txtBuscadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscadorMouseClicked
        txtBuscador.setText("");
    }//GEN-LAST:event_txtBuscadorMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        chooserFechas1.setDate(null);
        chooserFechas2.setDate(null);
        control.rellenarTablaProductos(tablaProductos,"SELECT * FROM productos" );
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFechaActionPerformed
        if (chooserFechas1.getDate()==null && chooserFechas2.getDate()!=null)
            control.ordenarPorRangoFecha(chooserFechas2, chooserFechas1, tablaProductos, 2);
        else if (chooserFechas2.getDate()==null && chooserFechas1.getDate()!=null)
            control.ordenarPorRangoFecha(chooserFechas1, chooserFechas2, tablaProductos, 2);
        else
        control.ordenarPorRangoFecha(chooserFechas1, chooserFechas2, tablaProductos, 1);
    }//GEN-LAST:event_btnFechaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (pnlFacturas.isShowing())
                btnCostos.doClick();
        else if (pnlOtrosDebito.isShowing())
                btnNotaDebito.doClick();
        else if (pnlProductosDebito.isShowing())
                btnNotaDebito.doClick();
        else if (pnlPreDebito.isShowing())
                btnCostos.doClick();
        else if (pnlPreCredito.isShowing())
                btnCostos.doClick();
        else if (pnlTotalCredito.isShowing())
                btnNotaCredito.doClick();
        else if (pnlParcialCredito.isShowing())
                btnNotaCredito.doClick();    
        
        else btnInicio.doClick();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidadActionPerformed
        cantidad.setText("");
        int fila = tablaProductos.getSelectedRow();
            if (fila>=0){  
                Object [] campos ={
            "Cantidad",cantidad,    
        
        };
    Object [] opciones={"ACEPTAR","CANCELAR"};    
    int respuesta;
            respuesta=JOptionPane.showOptionDialog(null, campos, "Agregar Stock", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
              if (respuesta == 0){
                   tablaProductos.setValueAt(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString())+Integer.parseInt(cantidad.getText()), tablaProductos.getSelectedRow(), 5);
                   control.agregarCantidadBD(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString()), tablaProductos);
                   
              }
           }
            else JOptionPane.showMessageDialog(null, "Debe seleccionar el producto al que le desea agregar stock");
    }//GEN-LAST:event_btnCantidadActionPerformed

    private void btnEliminarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarStockActionPerformed
               cantidad.setText("");
        int fila = tablaProductos.getSelectedRow();
            if (fila>=0){  
                Object [] campos ={
            "Cantidad",cantidad,    
        
                };
                Object [] opciones={"ACEPTAR","CANCELAR"};    
                int respuesta=-2;
                    while(respuesta!=1 && respuesta!=-1 && respuesta!=0){
                        respuesta=JOptionPane.showOptionDialog(null, campos, "Eliminar Stock", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
                          if (respuesta == 0 && Integer.parseInt(cantidad.getText())<=Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString())){
                               tablaProductos.setValueAt(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString())-Integer.parseInt(cantidad.getText()), tablaProductos.getSelectedRow(), 5);
                               control.agregarCantidadBD(Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString()), tablaProductos);
                    
                          }
                          else if (Integer.parseInt(cantidad.getText())>Integer.parseInt(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 5).toString()))JOptionPane.showMessageDialog(null, "No puede introducir una cantidad mayor a la del stock");
                    }
            }
       else JOptionPane.showMessageDialog(null, "Debe seleccionar el producto al que le desea restar stock"); 
    }//GEN-LAST:event_btnEliminarStockActionPerformed

    private void txtPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPermisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPermisosActionPerformed

    private void txtBuscador1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador1KeyReleased
         control.rellenarTablaUsuarios(tablaUsuarios, "SELECT * FROM usuarios WHERE `Nombre` LIKE '"+txtBuscador1.getText()+"%' OR `Apellido` LIKE '"+txtBuscador1.getText()+"%' OR `Cedula` LIKE '"+txtBuscador1.getText()+"%'" );
    }//GEN-LAST:event_txtBuscador1KeyReleased

    private void txtBuscador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador1ActionPerformed
        
    }//GEN-LAST:event_txtBuscador1ActionPerformed

    private void txtBuscador1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador1MouseClicked
        txtBuscador1.setText("");
    }//GEN-LAST:event_txtBuscador1MouseClicked

    private void txtBuscador1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador1FocusLost
       txtBuscador1.setText("Buscar por Nombre, Apellido o Cedula...");
    }//GEN-LAST:event_txtBuscador1FocusLost

    private void btnModificarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuariosActionPerformed
        tablaUsuarios.setEnabled(true);
        tablaUsuarios.setRowSelectionAllowed(true);  
       if (tablaUsuarios.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar una fila para Modificar"); 
       else {
           nombre.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 0)));
           apellido.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1)));
           cedula.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2)));
           telefono.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3)));
           direccion.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 4)));
           correo.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 5)));
           usuario.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 6)));
           password.setText(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 7)));
           tipoUsuario.setSelectedItem(String.valueOf(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 8)));

        Object [] campos ={
        "Nombre",nombre,
        "Apellido",apellido,
        "Teléfono",telefono,
        "Direccion",direccion,
        "Correo electronico",correo,
        "Usuario",usuario,
        "Contraseña",password,
        "Tipo de usuario",tipoUsuario
        }; 
    Object [] opciones={"ACEPTAR","CANCELAR"};          
    int respuesta=0;

         
         while (respuesta == 0 && (control.verificarUsuarioLongitud(usuario) || control.verificarContraseña(password) || control.verificarMayorA3(nombre) || control.verificarMayorA3(apellido) || control.verificarLongitudCorreo(correo) || (control.verificarUsuarioSeleccionado(tablaUsuarios,usuario.getText())==false && control.comprobarUsuario(usuario)) || (control.verificarCorreoSeleccionado(tablaUsuarios,correo.getText())==false && control.comprobarCorreo(correo)))){    
            respuesta=JOptionPane.showOptionDialog(null, campos, "Editar Usuarios", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
              if (respuesta==0&& !nombre.getText().equals("") && !apellido.getText().equals("") && !correo.getText().equals("") && (!control.comprobarCorreo(correo) ||control.verificarCorreoSeleccionado(tablaUsuarios,correo.getText())==true ) &&(!control.comprobarUsuario(usuario) ||control.verificarUsuarioSeleccionado(tablaUsuarios,usuario.getText())==true )&&control.verificarUsuarioLongitud(usuario)&&control.comprobarFormatoCorreo(correo)&&control.verificarContraseña(password)){
                control.modificarUsuario(tablaUsuarios, nombre.getText(), apellido.getText(),cedula.getText() ,telefono.getText() ,direccion.getText(), correo.getText(), usuario.getText(), password.getText(), tipoUsuario.getSelectedItem().toString());
                tablaUsuarios.setValueAt(nombre.getText(), tablaUsuarios.getSelectedRow(), 0);
                tablaUsuarios.setValueAt(apellido.getText(), tablaUsuarios.getSelectedRow(), 1);
                tablaUsuarios.setValueAt(cedula.getText(), tablaUsuarios.getSelectedRow(), 2);
                tablaUsuarios.setValueAt(telefono.getText(), tablaUsuarios.getSelectedRow(), 3);
                tablaUsuarios.setValueAt(direccion.getText(), tablaUsuarios.getSelectedRow(), 4);
                tablaUsuarios.setValueAt(correo.getText(), tablaUsuarios.getSelectedRow(), 5);
                tablaUsuarios.setValueAt(usuario.getText(), tablaUsuarios.getSelectedRow(), 6);
                tablaUsuarios.setValueAt(password.getText(), tablaUsuarios.getSelectedRow(), 7);
                tablaUsuarios.setValueAt(tipoUsuario.getSelectedItem().toString(), tablaUsuarios.getSelectedRow(), 8);
                break;
            } 
            else if (respuesta == 0 && nombre.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un nombre");
            else if (respuesta == 0 && apellido.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un apellido");
            else if (respuesta == 0 && correo.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe introducir un correo");
            else if (respuesta == 0 && !control.verificarUsuarioLongitud(usuario)) JOptionPane.showMessageDialog(null,"El usuario debe ser mayor a 4 caracteres");
            else if (respuesta == 0 && (control.verificarUsuarioSeleccionado(tablaUsuarios,usuario.getText())==false&&control.comprobarUsuario(usuario))) JOptionPane.showMessageDialog(null, "El usuario introducido ya existe, verifique e ingrese uno nuevo");
            else if (respuesta == 0 && password.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe introducir una contraseña");
            else if (respuesta == 0 && !control.verificarContraseña(password)) JOptionPane.showMessageDialog(null,"Debe introducir una contraseña mayor a 6 caracteres");
            else if (respuesta == 0 && (control.verificarCorreoSeleccionado(tablaUsuarios,correo.getText())==false&&control.comprobarCorreo(correo))) JOptionPane.showMessageDialog(null, "El correo introducido ya existe, verifique e ingrese uno nuevo");
            else if (respuesta == 0 && !control.comprobarFormatoCorreo(correo)) JOptionPane.showMessageDialog(null,"Debe introducir un correo valido");
            else if (telefono.getText().equals("(____) ___-____") && respuesta==0)JOptionPane.showMessageDialog(null, "Debe ingresar un numero de telefono valido");
            
        }    
            
        }
    }//GEN-LAST:event_btnModificarUsuariosActionPerformed

    private void btnEliminarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuariosActionPerformed
        int fila = tablaUsuarios.getSelectedRow();
        
            if (fila>=0){
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el Usuario?","Eliminar Usuario",dialog); 
            if (result == 0){
            control.eliminarDeTablaUsuariosBD(tablaUsuarios);
            control.eliminarFilaVentas(tablaUsuarios, fila);
            }
            
        }else JOptionPane.showMessageDialog(null, "Debe seleccionar la fila que desea eliminar");
        
    
    }//GEN-LAST:event_btnEliminarUsuariosActionPerformed

    private void btnAgregarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuariosActionPerformed
        nombre.setText("");
        apellido.setText("");
        cedula.setText("");
        telefono.setText("");
        direccion.setText("");
        usuario.setText("");
        password.setText("");
        correo.setText("");
        tipoUsuario.setSelectedItem("Administrador");
        Object [] campos ={
        "Nombre",nombre,
        "Apellido",apellido,
        "Cédula",cedula,    
        "Teléfono",telefono,
        "Direccion",direccion,
        "Correo electronico",correo,
        "Usuario",usuario,
        "Contraseña",password,
        "Tipo de usuario",tipoUsuario
        
                               
    };
    Object [] opciones={"AGREGAR","CANCELAR"};    
    int respuesta=0;
        while (respuesta == 0 && (nombre.getText().equals("")|| apellido.getText().equals("") || cedula.getText().equals("") || correo.getText().equals("") ||control.comprobarCorreo(correo)||!control.verificarUsuarioLongitud(usuario)||control.comprobarCedula(cedula) || control.comprobarUsuario(usuario) || !control.comprobarFormatoCorreo(correo) || !control.verificarContraseña(password))){
            respuesta=JOptionPane.showOptionDialog(null, campos, "Agregar Usuario", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
            if (respuesta == 0 && !nombre.getText().equals("") && !apellido.getText().equals("") && !cedula.getText().equals("") && !correo.getText().equals("") && !control.comprobarCedula(cedula)&&!control.comprobarCorreo(correo)&&control.verificarUsuarioLongitud(usuario)&&!control.comprobarUsuario(usuario)&&control.comprobarFormatoCorreo(correo)&&control.verificarContraseña(password)){
                control.registrarEnBdUsuarios(nombre.getText(), apellido.getText(), cedula.getText(), telefono.getText(), direccion.getText(), correo.getText(), usuario.getText(), password.getText(), tipoUsuario.getSelectedItem().toString(), 0);
                break;
            }
            else if (respuesta == 0 && nombre.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un nombre");
            else if (respuesta == 0 && apellido.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un apellido");
            else if (respuesta == 0 && cedula.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe introducir la cédula");
            else if (respuesta == 0 && correo.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe introducir un correo");
            else if (respuesta == 0 && control.comprobarUsuario(usuario)) JOptionPane.showMessageDialog(null,"El usuario introducido ya existe");
            else if (respuesta == 0 && !control.verificarUsuarioLongitud(usuario)) JOptionPane.showMessageDialog(null,"El usuario debe ser mayor a 4 caracteres");
            else if (respuesta == 0 && password.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe introducir una contraseña");
            else if (respuesta == 0 && !control.verificarContraseña(password)) JOptionPane.showMessageDialog(null,"Debe introducir una contraseña mayor a 6 caracteres");
            else if (respuesta == 0 && control.comprobarCorreo(correo)) JOptionPane.showMessageDialog(null, "El correo introducido ya existe, verifique e ingrese uno nuevo");
            else if (respuesta == 0 && control.comprobarCedula(cedula)) JOptionPane.showMessageDialog(null,"La cedula introducida ya existe");
            else if (respuesta == 0 && !control.comprobarFormatoCorreo(correo)) JOptionPane.showMessageDialog(null,"Debe introducir un correo valido");
            else if (telefono.getText().equals("(____) ___-____") && respuesta==0)JOptionPane.showMessageDialog(null, "Debe ingresar un numero de telefono valido");
            
            
            
        }
       control.rellenarTablaUsuarios(tablaUsuarios,"SELECT * FROM usuarios"); 
    }//GEN-LAST:event_btnAgregarUsuariosActionPerformed

    private void btnCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCantidad1ActionPerformed
        int fila = tablaUsuarios.getSelectedRow();
            if (fila>=0){
                if (control.estaBloqueado(tablaUsuarios)){
                    control.desbloquearUsuario(tablaUsuarios);
                    control.rellenarTablaUsuarios(tablaUsuarios,"SELECT * FROM usuarios" );
                    JOptionPane.showMessageDialog(null,"Usuario desbloqueado con exito");
                } else JOptionPane.showMessageDialog(null,"El usuario seleccionado no se encuentra bloqueado"); 
                
            } else JOptionPane.showMessageDialog(null,"Debe seleccionar la fila del usuario a desbloquear");
    }//GEN-LAST:event_btnCantidad1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        int dialog = JOptionPane.YES_NO_OPTION;
        
        
        int result = JOptionPane.showConfirmDialog(null,"¿Esta seguro de que desea Cerrar Sesion?","Cerrar Sesion",dialog);
        if (result == 0){
            Login login = new Login();
            control.mostrarVentana(login, this);
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCostosActionPerformed
        fechaCosto1.setDate(null);
        fechaCosto2.setDate(null);
        pnlInicio.setVisible(false);
        pnlProductos.setVisible(false);
        pnlUsuarios.setVisible(false);
        pnlCostos.setVisible(true);
        pnlContactos.setVisible(false);
        pnlFacturas.setVisible(false);
        pnlDetallesFactura.setVisible(false);
        pnlPreDebito.setVisible(false);
        pnlOtrosDebito.setVisible(false);
        pnlProductosDebito.setVisible(false);
        pnlPreCredito.setVisible(false);
        pnlParcialCredito.setVisible(false);
        pnlTotalCredito.setVisible(false);
        lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblTopCostos.png")));
        if (pnlCostos.isEnabled()){
           btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHome.png")));
           btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductos.png"))); 
           btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuarios.png"))); 
           btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastosPressed.png"))); 
           btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactos.png")));
    
         }
       control.rellenarTablaFactura(tablaCostos,"SELECT * FROM costos");
    }//GEN-LAST:event_btnCostosActionPerformed

    private void btnAgregarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFacturaActionPerformed
        control.setIva(0);
        pnlCostos.setVisible(false);
        pnlFacturas.setVisible(true);
        pnlDetallesFactura.setVisible(false);
        control.rellenarTablaProductosFactura(tablaProductosFactura,"SELECT * FROM productos" );
        control.rellenarFactura(tablaAgregarFactura);
        lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblTopCostos.png")));
        if (pnlFacturas.isEnabled()){
           btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHome.png")));
           btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductos.png"))); 
           btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuarios.png"))); 
           btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastosPressed.png"))); 
           btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactos.png")));
        }
    }//GEN-LAST:event_btnAgregarFacturaActionPerformed

    private void btnNotaCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaCreditoActionPerformed
        fechaCredito1.setDate(null);
        fechaCredito2.setDate(null);
        if (tablaCostos.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar una factura a la que le desea agregar una nota de débito");
        else{
            lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblTopCredito.png")));
            pnlCostos.setVisible(false);
            pnlOtrosDebito.setVisible(false);
            pnlPreDebito.setVisible(false);
            pnlPreCredito.setVisible(true);
            pnlParcialCredito.setVisible(false);
            pnlTotalCredito.setVisible(false);
            pnlProductosDebito.setVisible(false);
            lblPreCredito.setText("Factura N°: "+String.valueOf(tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 0)));
            control.rellenarTablaCredito(tablaCredito, "SELECT * FROM nota_credito WHERE `Factura de referencia` LIKE '"+control.obtenerCodigo(lblPreCredito)+"%'");
            
        
        }
    }//GEN-LAST:event_btnNotaCreditoActionPerformed

    private void txtBuscador2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador2FocusLost
       txtBuscador2.setText("Buscar por Factura, Control o Proveedor..");
    }//GEN-LAST:event_txtBuscador2FocusLost

    private void txtBuscador2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador2MouseClicked
        txtBuscador2.setText("");
    }//GEN-LAST:event_txtBuscador2MouseClicked

    private void txtBuscador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador2ActionPerformed

    private void txtBuscador2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador2KeyReleased
        control.rellenarTablaFactura(tablaCostos, "SELECT * FROM costos WHERE `No. Factura` LIKE '"+txtBuscador2.getText()+"%'OR `No. Control` LIKE '"+txtBuscador2.getText()+"%' OR `Codigo de Proveedor` LIKE '"+txtBuscador2.getText()+"%'" );
    }//GEN-LAST:event_txtBuscador2KeyReleased

    private void btnContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactosActionPerformed
        pnlInicio.setVisible(false);
        pnlProductos.setVisible(false);
        pnlUsuarios.setVisible(false);
        pnlCostos.setVisible(false);
        pnlContactos.setVisible(true);
        pnlFacturas.setVisible(false);
        pnlDetallesFactura.setVisible(false);
        pnlPreDebito.setVisible(false);
        pnlOtrosDebito.setVisible(false);
        pnlProductosDebito.setVisible(false);
        pnlPreCredito.setVisible(false);
        pnlParcialCredito.setVisible(false);
        pnlTotalCredito.setVisible(false);
        lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblTopContactos.png")));
        if (pnlContactos.isEnabled()){
           btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnHome.png")));
           btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnProductos.png"))); 
           btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnUsuarios.png"))); 
           btnCostos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnGastos.png")));
           btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnContactosPressed.png")));
        }
        control.rellenarTablaContactos(tablaContactos,"SELECT * FROM contactos");
    }//GEN-LAST:event_btnContactosActionPerformed

    private void btnAgregarContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarContactosActionPerformed
        codigoProveedor.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.setText("");
        telefono.setText("");
        direccion.setText("");
        correo.setText("");
        rif.setText("");
       Object [] campos ={
        "Codigo de Proveedor",codigoProveedor,   
        "Nombre",nombre,
        "Apellido",apellido,
        "Correo electronico",correo,
        "Teléfono",telefono,
        "Tipo de identificacion",comboSeleccion,
        "Cédula",cedula,
        "RIF",rif,
        "Direccion",direccion,
    };
    Object [] opciones={"AGREGAR","CANCELAR"};    
    int respuesta=0;
        while (respuesta == 0 && (nombre.getText().equals("")||codigoProveedor.getText().equals("")||!control.verificarMayorA3(nombre)||!telefono.isEditValid()||control.comprobarCodigoContacto(codigoProveedor)||(!correo.getText().equals("") && control.comprobarFormatoCorreo(correo)==false))){
            respuesta=JOptionPane.showOptionDialog(null, campos, "Agregar Contacto", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
            if (respuesta == 0 && !nombre.getText().equals("") && !codigoProveedor.getText().equals("") && telefono.isEditValid() &&control.verificarMayorA3(nombre)&& control.comprobarCodigoContacto(codigoProveedor)==false && (!correo.getText().equals("") && control.comprobarFormatoCorreo(correo))){
                control.registrarEnBdContactos(Integer.parseInt(codigoProveedor.getText()), nombre.getText(), apellido.getText(), correo.getText(), telefono.getText(), direccion.getText(), cedula.getText(), rif.getText());
                break;
            }
            else if (respuesta == 0 && codigoProveedor.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un Codigo de Proveedor");
            else if (respuesta == 0 && control.comprobarCodigoContacto(codigoProveedor)) JOptionPane.showMessageDialog(null, "El Codigo de Proveedor ingresado ya existe");
            else if (respuesta == 0 && nombre.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un nombre");
            else if (respuesta == 0 && !control.verificarMayorA3(nombre)) JOptionPane.showMessageDialog(null, "El nombre debe ser mayor a 3 caracteres");            
            else if (!telefono.isEditValid() && respuesta==0)JOptionPane.showMessageDialog(null, "Debe ingresar un numero de telefono valido");
            else if (respuesta == 0 && !correo.getText().equals("") && control.comprobarFormatoCorreo(correo)==false) JOptionPane.showMessageDialog(null, "Debe ingresar un correo electronico valido");
            
            
            
        }
       control.rellenarTablaContactos(tablaContactos,"SELECT * FROM contactos"); 
    }//GEN-LAST:event_btnAgregarContactosActionPerformed

    private void btnEliminarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarContactoActionPerformed
        int fila = tablaContactos.getSelectedRow();
        
            if (fila>=0){
            int dialog = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null,"¿Seguro que desea eliminar el Contacto?","Eliminar Contacto",dialog); 
            if (result == 0){
            control.eliminarDeTablaContactosBD(tablaContactos);
            control.eliminarFilaVentas(tablaContactos, fila);
            }
            
        }else JOptionPane.showMessageDialog(null, "Debe seleccionar la fila que desea eliminar");
    }//GEN-LAST:event_btnEliminarContactoActionPerformed

    private void btnModificarContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarContactosActionPerformed
        tablaContactos.setEnabled(true);
        tablaContactos.setRowSelectionAllowed(true);  
       if (tablaContactos.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar una fila para Modificar"); 
       else {
           
           nombre.setText(String.valueOf(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 1)));
           apellido.setText(String.valueOf(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 2)));
           correo.setText(String.valueOf(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 3)));
           telefono.setText(String.valueOf(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 4)));
           direccion.setText(String.valueOf(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 5)));
         

        Object [] campos ={
        
        "Nombre",nombre,
        "Apellido",apellido,
        "Correo electronico",correo,
        "Teléfono",telefono,
        "Direccion",direccion,
        }; 
    Object [] opciones={"ACEPTAR","CANCELAR"};          
    int respuesta=0;

         
         do {    
            respuesta=JOptionPane.showOptionDialog(null, campos, "Editar Contacto", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
              if (respuesta==0 && !nombre.getText().equals("")&&telefono.isEditValid() &&(correo.getText().equals("")||(!correo.getText().equals("") && control.comprobarFormatoCorreo(correo)))){
                control.modificarContacto(tablaContactos,nombre.getText(), apellido.getText(),correo.getText(), telefono.getText(), direccion.getText());
                tablaContactos.setValueAt(nombre.getText(), tablaContactos.getSelectedRow(), 1);
                tablaContactos.setValueAt(apellido.getText(), tablaContactos.getSelectedRow(), 2);
                tablaContactos.setValueAt(correo.getText(), tablaContactos.getSelectedRow(), 3);
                tablaContactos.setValueAt(telefono.getText(), tablaContactos.getSelectedRow(), 4);
                tablaContactos.setValueAt(direccion.getText(), tablaContactos.getSelectedRow(), 5);
                break;
            } 
            else if (respuesta == 0 && nombre.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe colocar un nombre");
            else if (respuesta == 0 && !correo.getText().equals("") && control.comprobarFormatoCorreo(correo)==false) JOptionPane.showMessageDialog(null,"Debe introducir un correo valido");
            else if (!telefono.isEditValid() && respuesta==0)JOptionPane.showMessageDialog(null, "Debe ingresar un numero de telefono valido");
            
        } while (respuesta == 0 && (nombre.getText().equals("")||!telefono.isEditValid()||(!correo.getText().equals("") && control.comprobarFormatoCorreo(correo)==false) ));    
            
        }
    }//GEN-LAST:event_btnModificarContactosActionPerformed

    private void txtBuscador3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador3FocusLost
        txtBuscador3.setText("Buscar por Codigo o Nombre...");
    }//GEN-LAST:event_txtBuscador3FocusLost

    private void txtBuscador3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador3MouseClicked
        txtBuscador3.setText("");
    }//GEN-LAST:event_txtBuscador3MouseClicked

    private void txtBuscador3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador3ActionPerformed
      
    }//GEN-LAST:event_txtBuscador3ActionPerformed

    private void txtBuscador3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador3KeyReleased
         control.rellenarTablaContactos(tablaContactos, "SELECT * FROM contactos WHERE `Nombre` LIKE '"+txtBuscador3.getText()+"%' OR `Codigo de Proveedor` LIKE '"+txtBuscador3.getText()+"%'" );
    }//GEN-LAST:event_txtBuscador3KeyReleased

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        codigoProveedor.setEditable(false);
        nombre.setEditable(false);
        apellido.setEditable(false);
        correo.setEditable(false);
        telefono.setEditable(false);
        direccion.setEditable(false);
        cedula.setEditable(false);
        rif.setEditable(false);
        tablaContactos.setEnabled(true);
        tablaContactos.setRowSelectionAllowed(true);  
       if (tablaContactos.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar el contacto del que desea ver sus detalles"); 
       else {
           codigoProveedor.setText(String.valueOf(tablaContactos.getValueAt(tablaContactos.getSelectedRow(), 0)));
           control.buscarInfoContacto(codigoProveedor, nombre, apellido, correo, telefono, direccion, cedula, rif);           
                Object [] campos ={
                "Codigo Proveedor",codigoProveedor,   
                "Nombre",nombre,
                "Apellido",apellido,
                "Correo electronico",correo,
                "Teléfono",telefono,
                "Direccion",direccion,
                "Cedula",cedula,
                "RIF",rif               
                }; 
            Object [] opciones={"Ok"};     
           JOptionPane.showOptionDialog(null, campos, "Detalles Contacto", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);  
        
       }
            codigoProveedor.setEditable(true);
            nombre.setEditable(true);
            apellido.setEditable(true);
            correo.setEditable(true);
            telefono.setEditable(true);
            direccion.setEditable(true);
            cedula.setEditable(true);
            rif.setEditable(true);
    
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
       btnDetalles.doClick();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void btnNotaDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotaDebitoActionPerformed
        fechaDebito1.setDate(null);
        fechaDebito2.setDate(null);
        if (tablaCostos.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar una factura a la que le desea agregar una nota de débito");
        else{
            lblTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lblTopNotasDebito.png")));
            pnlCostos.setVisible(false);
            pnlOtrosDebito.setVisible(false);
            pnlPreDebito.setVisible(true);
            pnlProductosDebito.setVisible(false);
            lblPreDebito.setText("Factura N°: "+String.valueOf(tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 0)));
            control.rellenarTablaDebito(tablaDebito, "SELECT * FROM nota_debito WHERE `Factura de referencia` LIKE '"+control.obtenerCodigo(lblPreDebito)+"%'");
            
        
        }
    }//GEN-LAST:event_btnNotaDebitoActionPerformed

    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFacturaActionPerformed

    private void btnAgregarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPActionPerformed
       if (tablaProductosFactura.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar un producto a agregar"); 
     else{
        cantidad.setText("0");
        precioUnidad.setText("0");
        Object [] campos ={
        "Cantidad",cantidad,    
        "Precio por Unidad", precioUnidad,
        "Aplicar IVA",iva
      
                               
    };
    Object [] opciones={"AGREGAR","CANCELAR"};    
    int respuesta=0;
        while (respuesta == 0 && (Integer.parseInt(cantidad.getText())<=0 || Double.parseDouble(precioUnidad.getText())<=0)){
            respuesta=JOptionPane.showOptionDialog(null, campos,"INFORMACION PRODUCTO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
            if (respuesta == 0 && cantidad.getText().equals("")) cantidad.setText("0");
            if (respuesta == 0 && precioUnidad.getText().equals("")) precioUnidad.setText("0");
            if (respuesta == 0 && Integer.parseInt(cantidad.getText())>0 && Double.parseDouble(precioUnidad.getText())>0){
                control.agregarATabla(tablaProductosFactura, tablaAgregarFactura, cantidad, precioUnidad, iva);
                break;
            }

            else if (respuesta == 0 && Integer.parseInt(cantidad.getText())<=0) JOptionPane.showMessageDialog(null,"Debe ingresar una cantidad mayor a 0");
            else if (respuesta == 0 && Double.parseDouble(precioUnidad.getText())<=0)  JOptionPane.showMessageDialog(null,"Debe ingresar un precio por Unidad mayor a 0"); 
          
        }
       }
       tablaProductosFactura.getSelectionModel().clearSelection();
        
       
    }//GEN-LAST:event_btnAgregarPActionPerformed

    private void btnQuitarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarPActionPerformed
        if (tablaAgregarFactura.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar un producto a eliminar de la factura"); 
        else control.quitarDeTabla(tablaAgregarFactura);
        
    }//GEN-LAST:event_btnQuitarPActionPerformed

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        if (txtFactura.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el No. de Factura");
        else if (txtCodigo.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el No. de Codigo de Proveedor");
        else if (txtControl.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el No. de Control");
        else if (fechaFactura.getDate()==null) JOptionPane.showMessageDialog(null,"Debe indicar una fecha");
        else if (control.comprobarNoFactura(txtFactura)) JOptionPane.showMessageDialog(null,"El No. Factura ya existe");
        else if (control.comprobarNoControl(txtControl)) JOptionPane.showMessageDialog(null,"El No. Control ya existe");
        else if (tablaAgregarFactura.getModel().getRowCount()==0) JOptionPane.showMessageDialog(null,"Debe ingresar al menos un producto en la Factura");
        else { 
            String productosString="";
            double totalFactura=0.0;
            
            for (int i = 0; i < tablaAgregarFactura.getRowCount(); i++) {  
               productosString += tablaAgregarFactura.getValueAt(i,0 )+",";
               productosString += tablaAgregarFactura.getValueAt(i,2 )+",";
               productosString += tablaAgregarFactura.getValueAt(i,3 )+",";
               productosString += tablaAgregarFactura.getValueAt(i,4 )+"\n";
               
               totalFactura += Double.parseDouble(String.valueOf(tablaAgregarFactura.getValueAt(i,5 )));
               
     }
            totalFactura += control.getIva();            
            control.registrarEnBdFacturas(Integer.parseInt(txtFactura.getText()), Integer.parseInt(txtControl.getText()), Integer.parseInt(txtCodigo.getText()), fechaFactura, productosString, totalFactura);
            JOptionPane.showMessageDialog(null,"Factura agregada con exito!");
            btnCostos.doClick();
 
        
        
        
        }
    }//GEN-LAST:event_btnFacturaActionPerformed

    private void txtControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtControlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtControlActionPerformed

    private void txtBuscador4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador4FocusLost
        txtBuscador4.setText("Buscar por Nombre o GTIN..");
    }//GEN-LAST:event_txtBuscador4FocusLost

    private void txtBuscador4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador4MouseClicked
        txtBuscador4.setText("");
    }//GEN-LAST:event_txtBuscador4MouseClicked

    private void txtBuscador4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador4ActionPerformed

    private void txtBuscador4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador4KeyReleased
       control.rellenarTablaProductos(tablaProductosFactura, "SELECT * FROM productos WHERE `Nombre` LIKE '"+txtBuscador4.getText()+"%'OR `GTIN` LIKE '"+txtBuscador4.getText()+"%'" );
    }//GEN-LAST:event_txtBuscador4KeyReleased

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseClicked

    private void btnDetallesFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesFacturaActionPerformed
        if (tablaCostos.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar una fila a Visualizar"); 
        else {
            lblTotal.setText("TOTAL: "+"$"+control.precioTotal(String.valueOf(tablaCostos.getValueAt(tablaCostos.getSelectedRow(),0))));
            lblTituloFactura.setText("FACTURA N° "+tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 0));
            lblControl.setText("N° Control: "+tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 1));
            lblCodigoProveedor.setText("Codigo de Proveedor: "+tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 2));
            lblFecha.setText("Fecha de emision: "+tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 3));
            pnlCostos.setVisible(false);
            pnlDetallesFactura.setVisible(true);
            control.rellenarTablaVisualizarFactura(tablaFactura, "SELECT * FROM costos", String.valueOf(tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 0)));
            
            
        
        }
    }//GEN-LAST:event_btnDetallesFacturaActionPerformed

    private void btnFecha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecha1ActionPerformed
        if (fechaCosto1.getDate()==null && fechaCosto2.getDate()!=null)
            control.ordenarPorRangoFechaCosto(fechaCosto2, fechaCosto1, tablaCostos, 2);
        else if (fechaCosto2.getDate()==null && fechaCosto1.getDate()!=null)
            control.ordenarPorRangoFechaCosto(fechaCosto1, fechaCosto2, tablaCostos, 2);
        else
        control.ordenarPorRangoFechaCosto(fechaCosto1, fechaCosto2, tablaCostos, 1);
    }//GEN-LAST:event_btnFecha1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        fechaCosto1.setDate(null);
        fechaCosto2.setDate(null);
        control.rellenarTablaFactura(tablaCostos,"SELECT * FROM costos" );
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnFinalizarDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarDebitoActionPerformed
        if (txtDestinatario.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el destinatario");
        else if (fechaDebito.getDate()==null) JOptionPane.showMessageDialog(null,"Debe indicar una fecha"); 
        else if (txtMontoAdicional.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el monto adicional");
        else {
            control.registrarEnBdNotaDebito(control.obtenerCodigo(lblTituloFactura1), txtDestinatario.getText(), txtRazon.getText(), fechaDebito, Double.parseDouble(lblMontoOriginal.getText().substring(17).trim()), Double.parseDouble(txtMontoAdicional.getText()), Double.parseDouble(lblMontoTotal.getText().substring(14).trim()));
            JOptionPane.showMessageDialog(null,"Nota de debito agregada con exito!");
            btnNotaDebito.doClick();
        
        }
        
    }//GEN-LAST:event_btnFinalizarDebitoActionPerformed

    private void txtMontoAdicionalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoAdicionalKeyReleased
       if (!txtMontoAdicional.getText().equals("")){
                lblMontoTotal.setText("Monto total: $"+String.valueOf(String.format("%.2f", Double.parseDouble(lblMontoOriginal.getText().substring(17).trim())-Double.parseDouble(txtMontoAdicional.getText()))).replace(",", "."));
            }
        else lblMontoTotal.setText("Monto total: $");

    }//GEN-LAST:event_txtMontoAdicionalKeyReleased

    private void txtMontoAdicionalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoAdicionalKeyPressed
       
    }//GEN-LAST:event_txtMontoAdicionalKeyPressed

    private void txtMontoAdicionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMontoAdicionalMouseClicked
        txtMontoAdicional.setText("");
    }//GEN-LAST:event_txtMontoAdicionalMouseClicked

    private void btnProductosDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosDebitoActionPerformed
       lblProductosDebito.setText(lblPreDebito.getText());
       pnlPreDebito.setVisible(false);
       pnlProductosDebito.setVisible(true);
       txtRazon1.setText("");
       txtDestinatario1.setText("");
       control.rellenarFactura(tablaAgregarANotaDebito);
       control.rellenarTablaVisualizarFactura(tablaFacturaOriginal, "SELECT * FROM costos", String.valueOf(tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 0)));
    }//GEN-LAST:event_btnProductosDebitoActionPerformed

    private void btnOtrosDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtrosDebitoActionPerformed
        
        pnlPreDebito.setVisible(false);
        txtDestinatario.setText("");
        txtMontoAdicional.setText("$0");
        txtRazon.setText("");
        pnlOtrosDebito.setVisible(true);
        lblTituloFactura1.setText(lblPreDebito.getText());
        lblMontoOriginal.setText("Monto original: "+"$"+control.montoAdicional(control.obtenerCodigo(lblTituloFactura1)));
        lblMontoTotal.setText("Monto Total: $");
    }//GEN-LAST:event_btnOtrosDebitoActionPerformed

    private void txtBuscador5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador5FocusLost
        txtBuscador5.setText("Buscar por Destinatario..");
    }//GEN-LAST:event_txtBuscador5FocusLost

    private void txtBuscador5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador5MouseClicked
       txtBuscador5.setText("");
    }//GEN-LAST:event_txtBuscador5MouseClicked

    private void txtBuscador5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador5ActionPerformed

    private void txtBuscador5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador5KeyReleased
         control.rellenarTablaDebito(tablaDebito, "SELECT * FROM nota_debito WHERE `Destinatario` LIKE '"+txtBuscador5.getText()+"%'" );
    }//GEN-LAST:event_txtBuscador5KeyReleased

    private void btnFecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecha2ActionPerformed
         if (fechaDebito1.getDate()==null && fechaDebito2.getDate()!=null)
            control.ordenarPorRangoFechaDebito(fechaDebito2, fechaDebito1, tablaDebito, 2);
        else if (fechaDebito2.getDate()==null && fechaDebito1.getDate()!=null)
            control.ordenarPorRangoFechaDebito(fechaDebito1, fechaDebito2, tablaDebito, 2);
        else
        control.ordenarPorRangoFechaDebito(fechaDebito1, fechaDebito2, tablaDebito, 1);
    }//GEN-LAST:event_btnFecha2ActionPerformed

    private void btnLimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar2ActionPerformed
        fechaDebito1.setDate(null);
        fechaDebito2.setDate(null);
        control.rellenarTablaDebito(tablaDebito,"SELECT * FROM nota_debito" );
    }//GEN-LAST:event_btnLimpiar2ActionPerformed

    private void btnQuitarP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarP1ActionPerformed
        if (tablaAgregarANotaDebito.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar un producto a eliminar de la nota de debito"); 
        else control.quitarDeTabla(tablaAgregarANotaDebito);
    }//GEN-LAST:event_btnQuitarP1ActionPerformed

    private void btnAgregarP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarP1ActionPerformed
    if (tablaFacturaOriginal.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar un producto de la factura original"); 
     else{
        cantidad.setText("0");
        precioUnidad.setText("0");
        Object [] campos ={
        "Cantidad",cantidad,    
        "Precio por Unidad", precioUnidad,
        "Aplicar IVA",iva
      
                               
    };
    Object [] opciones={"AGREGAR","CANCELAR"};    
    int respuesta=0;
    
        while (respuesta == 0 && (Integer.parseInt(cantidad.getText())<=0 || Double.parseDouble(precioUnidad.getText())<=0)){
            respuesta=JOptionPane.showOptionDialog(null, campos,"INFORMACION PRODUCTO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
            if (respuesta == 0 && cantidad.getText().equals("")) cantidad.setText("0");
            if (respuesta == 0 && precioUnidad.getText().equals("")) precioUnidad.setText("0");
            if (respuesta == 0 && Integer.parseInt(cantidad.getText())>0 && Double.parseDouble(precioUnidad.getText())>0){
                control.agregarATabla(tablaFacturaOriginal, tablaAgregarANotaDebito, cantidad, precioUnidad, iva);
                break;
            }

            else if (respuesta == 0 && Integer.parseInt(cantidad.getText())<=0) JOptionPane.showMessageDialog(null,"Debe ingresar una cantidad mayor a 0");
            else if (respuesta == 0 && Double.parseDouble(precioUnidad.getText())<=0)  JOptionPane.showMessageDialog(null,"Debe ingresar un precio por Unidad mayor a 0"); 
          
        }
       }
       tablaFacturaOriginal.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnAgregarP1ActionPerformed

    private void txtDestinatario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinatario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinatario1ActionPerformed

    private void btnFactura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactura1ActionPerformed
        if (txtDestinatario1.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el destinatario");
        else if (fechaFactura1.getDate()==null) JOptionPane.showMessageDialog(null,"Debe indicar una fecha");
        else if (tablaAgregarANotaDebito.getModel().getRowCount()==0) JOptionPane.showMessageDialog(null,"Debe ingresar al menos un producto a la Nota de debito");
        else { 
            String productosString="";
            double totalFactura=0.0;
            
            for (int i = 0; i < tablaAgregarANotaDebito.getRowCount(); i++) {  
               productosString += tablaAgregarANotaDebito.getValueAt(i,0 )+",";
               productosString += tablaAgregarANotaDebito.getValueAt(i,2 )+",";
               productosString += tablaAgregarANotaDebito.getValueAt(i,3 )+",";
               productosString += tablaAgregarANotaDebito.getValueAt(i,4 )+"\n";
               totalFactura += Double.parseDouble(String.valueOf(tablaAgregarANotaDebito.getValueAt(i,5 )));
               
     }
            totalFactura += control.getIva();            
            control.registrarEnBdNotaDebito(control.obtenerCodigo(lblProductosDebito), txtDestinatario1.getText(), txtRazon1.getText(), fechaFactura1, control.precioTotal(control.obtenerCodigo(lblProductosDebito)), totalFactura, control.precioTotal(control.obtenerCodigo(lblProductosDebito))-totalFactura);
            JOptionPane.showMessageDialog(null,"Nota de debito agregada con exito!");
            btnNotaDebito.doClick();
 
        
        
        
        }
    }//GEN-LAST:event_btnFactura1ActionPerformed

    private void txtBuscador6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador6FocusLost
        txtBuscador6.setText("Buscar por Nombre...");
    }//GEN-LAST:event_txtBuscador6FocusLost

    private void txtBuscador6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador6MouseClicked
        txtBuscador6.setText("");
    }//GEN-LAST:event_txtBuscador6MouseClicked

    private void txtBuscador6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador6ActionPerformed

    private void txtBuscador6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador6KeyReleased
         control.rellenarTablaVisualizarFactura(tablaFacturaOriginal, "SELECT * FROM productos WHERE `Nombre` LIKE '"+txtBuscador6.getText()+"%'",control.obtenerCodigo(lblProductosDebito) );
    }//GEN-LAST:event_txtBuscador6KeyReleased

    private void btnParcialCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParcialCreditoActionPerformed
       lblParcialCredito.setText(lblPreCredito.getText());
       pnlPreCredito.setVisible(false);
       pnlParcialCredito.setVisible(true);
       txtRazon2.setText("");
       txtDestinatario2.setText("");
       control.rellenarFactura(tablaAgregarANotaCredito);
       control.rellenarTablaVisualizarFactura(tablaFacturaOriginal1, "SELECT * FROM costos", String.valueOf(tablaCostos.getValueAt(tablaCostos.getSelectedRow(), 0)));
    }//GEN-LAST:event_btnParcialCreditoActionPerformed

    private void btnTotalCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCreditoActionPerformed
        pnlPreCredito.setVisible(false);
        txtDestinatario3.setText("");
        txtMontoAdicional3.setText("$0");
        txtRazon3.setText("");
        pnlTotalCredito.setVisible(true);
        lblTituloFactura2.setText(lblPreCredito.getText());
        lblMontoOriginal1.setText("Monto original: "+"$"+control.montoAdicional(control.obtenerCodigo(lblTituloFactura2)));
        lblMontoTotal1.setText("Monto Total: $");
    }//GEN-LAST:event_btnTotalCreditoActionPerformed

    private void txtBuscador7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador7FocusLost
       txtBuscador7.setText("Buscar por Destinatario..");
    }//GEN-LAST:event_txtBuscador7FocusLost

    private void txtBuscador7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador7MouseClicked
        txtBuscador7.setText("");
    }//GEN-LAST:event_txtBuscador7MouseClicked

    private void txtBuscador7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador7ActionPerformed

    private void txtBuscador7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador7KeyReleased
       control.rellenarTablaCredito(tablaCredito, "SELECT * FROM nota_credito WHERE `Destinatario` LIKE '"+txtBuscador7.getText()+"%'" );
    }//GEN-LAST:event_txtBuscador7KeyReleased

    private void btnFecha3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecha3ActionPerformed
        if (fechaCredito1.getDate()==null && fechaCredito2.getDate()!=null)
            control.ordenarPorRangoFechaCredito(fechaCredito2, fechaCredito1, tablaCredito, 2);
        else if (fechaCredito2.getDate()==null && fechaCredito1.getDate()!=null)
            control.ordenarPorRangoFechaCredito(fechaCredito1, fechaCredito2, tablaCredito, 2);
        else
        control.ordenarPorRangoFechaCredito(fechaCredito1, fechaCredito2, tablaCredito, 1);
    }//GEN-LAST:event_btnFecha3ActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        fechaCredito1.setDate(null);
        fechaCredito2.setDate(null);
        control.rellenarTablaCredito(tablaCredito,"SELECT * FROM nota_credito" );
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void btnQuitarP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarP2ActionPerformed
       if (tablaAgregarANotaCredito.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar un producto a eliminar de la nota de credito"); 
        else control.quitarDeTabla(tablaAgregarANotaCredito);
    }//GEN-LAST:event_btnQuitarP2ActionPerformed

    private void btnAgregarP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarP2ActionPerformed
        if (tablaFacturaOriginal1.getSelectedRow()<0)  JOptionPane.showMessageDialog(null,"Debe seleccionar un producto de la factura original"); 
     else{
        cantidad.setText("0");
        precioUnidad.setText("0");
        Object [] campos ={
        "Cantidad",cantidad,    
        "Precio por Unidad", precioUnidad,
        "Aplicar IVA",iva
      
                               
    };
    Object [] opciones={"AGREGAR","CANCELAR"};    
    int respuesta=0;
    
        while (respuesta == 0 && (Integer.parseInt(cantidad.getText())<=0 || Double.parseDouble(precioUnidad.getText())<=0)){
            respuesta=JOptionPane.showOptionDialog(null, campos,"INFORMACION PRODUCTO", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, null);
            if (respuesta == 0 && cantidad.getText().equals("")) cantidad.setText("0");
            if (respuesta == 0 && precioUnidad.getText().equals("")) precioUnidad.setText("0");
            if (respuesta == 0 && Integer.parseInt(cantidad.getText())>0 && Double.parseDouble(precioUnidad.getText())>0){
                control.agregarATabla(tablaFacturaOriginal1, tablaAgregarANotaCredito, cantidad, precioUnidad, iva);
                break;
            }

            else if (respuesta == 0 && Integer.parseInt(cantidad.getText())<=0) JOptionPane.showMessageDialog(null,"Debe ingresar una cantidad mayor a 0");
            else if (respuesta == 0 && Double.parseDouble(precioUnidad.getText())<=0)  JOptionPane.showMessageDialog(null,"Debe ingresar un precio por Unidad mayor a 0"); 
          
        }
       }
       tablaFacturaOriginal.getSelectionModel().clearSelection();
    }//GEN-LAST:event_btnAgregarP2ActionPerformed

    private void txtDestinatario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinatario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinatario2ActionPerformed

    private void btnFactura2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFactura2ActionPerformed
        if (txtDestinatario2.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el destinatario");
        else if (fechaCredito.getDate()==null) JOptionPane.showMessageDialog(null,"Debe indicar una fecha");
        else if (tablaAgregarANotaCredito.getModel().getRowCount()==0) JOptionPane.showMessageDialog(null,"Debe ingresar al menos un producto a la Nota de credito");
        else { 
            String productosString="";
            double totalFactura=0.0;
            
            for (int i = 0; i < tablaAgregarANotaCredito.getRowCount(); i++) {  
               productosString += tablaAgregarANotaCredito.getValueAt(i,0 )+",";
               productosString += tablaAgregarANotaCredito.getValueAt(i,2 )+",";
               productosString += tablaAgregarANotaCredito.getValueAt(i,3 )+",";
               productosString += tablaAgregarANotaCredito.getValueAt(i,4 )+"\n";
               totalFactura += Double.parseDouble(String.valueOf(tablaAgregarANotaCredito.getValueAt(i,5 )));
               
     }
            totalFactura += control.getIva();            
            control.registrarEnBdNotaCredito(control.obtenerCodigo(lblParcialCredito), txtDestinatario2.getText(), txtRazon2.getText(), fechaCredito, control.precioTotal(control.obtenerCodigo(lblParcialCredito)), totalFactura, control.precioTotal(control.obtenerCodigo(lblParcialCredito))+totalFactura);
            JOptionPane.showMessageDialog(null,"Nota de credito agregada con exito!");
            btnNotaCredito.doClick();
 
        
        
        
        }
    }//GEN-LAST:event_btnFactura2ActionPerformed

    private void txtBuscador8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscador8FocusLost
        txtBuscador8.setText("Buscar por Nombre...");
    }//GEN-LAST:event_txtBuscador8FocusLost

    private void txtBuscador8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscador8MouseClicked
        txtBuscador8.setText("");
    }//GEN-LAST:event_txtBuscador8MouseClicked

    private void txtBuscador8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscador8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscador8ActionPerformed

    private void txtBuscador8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscador8KeyReleased
         control.rellenarTablaVisualizarFactura(tablaFacturaOriginal1, "SELECT * FROM productos WHERE `Nombre` LIKE '"+txtBuscador8.getText()+"%'",control.obtenerCodigo(lblParcialCredito) );
    }//GEN-LAST:event_txtBuscador8KeyReleased

    private void txtMontoAdicional3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMontoAdicional3MouseClicked
        txtMontoAdicional3.setText("");
    }//GEN-LAST:event_txtMontoAdicional3MouseClicked

    private void txtMontoAdicional3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoAdicional3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoAdicional3KeyPressed

    private void txtMontoAdicional3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoAdicional3KeyReleased
         if (!txtMontoAdicional3.getText().equals("")){
                lblMontoTotal1.setText("Monto total: $"+String.valueOf(String.format("%.2f", Double.parseDouble(lblMontoOriginal1.getText().substring(17).trim())+Double.parseDouble(txtMontoAdicional3.getText()))).replace(",", "."));
            }
        else lblMontoTotal1.setText("Monto total: $");
    }//GEN-LAST:event_txtMontoAdicional3KeyReleased

    private void btnFinalizarCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCreditoActionPerformed
        if (txtDestinatario3.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el destinatario");
        else if (fechaCreditoTotal.getDate()==null) JOptionPane.showMessageDialog(null,"Debe indicar una fecha"); 
        else if (txtMontoAdicional3.getText().equals("")) JOptionPane.showMessageDialog(null,"Debe indicar el monto adicional");
        else {
            control.registrarEnBdNotaCredito(control.obtenerCodigo(lblTituloFactura2), txtDestinatario3.getText(), txtRazon3.getText(), fechaCreditoTotal, Double.parseDouble(lblMontoOriginal1.getText().substring(17).trim()), Double.parseDouble(txtMontoAdicional3.getText()), Double.parseDouble(lblMontoTotal1.getText().substring(14).trim()));
            JOptionPane.showMessageDialog(null,"Nota de credito agregada con exito!");
            btnNotaCredito.doClick();
        
        }
    }//GEN-LAST:event_btnFinalizarCreditoActionPerformed

    private void btnGmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGmailActionPerformed
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler https://www.google.com/gmail/");
        } catch (IOException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGmailActionPerformed

    private void btnCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculadoraActionPerformed
        try {
            Runtime.getRuntime().exec("calc");
        } catch (IOException ex) {
            Logger.getLogger(Gestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCalculadoraActionPerformed

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
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JButton btnAgregarContactos;
    private javax.swing.JButton btnAgregarFactura;
    private javax.swing.JButton btnAgregarP;
    private javax.swing.JButton btnAgregarP1;
    private javax.swing.JButton btnAgregarP2;
    private javax.swing.JButton btnAgregarProductos;
    private javax.swing.JButton btnAgregarUsuarios;
    private javax.swing.JButton btnCalculadora;
    private javax.swing.JButton btnCantidad;
    private javax.swing.JButton btnCantidad1;
    private javax.swing.JButton btnCerrar2;
    private javax.swing.JButton btnCerrarSesion;
    public static javax.swing.JButton btnContactos;
    public static javax.swing.JButton btnCostos;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnDetallesFactura;
    private javax.swing.JButton btnEliminarContacto;
    private javax.swing.JButton btnEliminarProductos;
    private javax.swing.JButton btnEliminarStock;
    private javax.swing.JButton btnEliminarUsuarios;
    private javax.swing.JButton btnFactura;
    private javax.swing.JButton btnFactura1;
    private javax.swing.JButton btnFactura2;
    private javax.swing.JButton btnFecha;
    private javax.swing.JButton btnFecha1;
    private javax.swing.JButton btnFecha2;
    private javax.swing.JButton btnFecha3;
    private javax.swing.JButton btnFinalizarCredito;
    private javax.swing.JButton btnFinalizarDebito;
    private javax.swing.JButton btnGmail;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnLimpiar2;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnMinimizar2;
    private javax.swing.JButton btnModificarContactos;
    private javax.swing.JButton btnModificarProductos;
    private javax.swing.JButton btnModificarUsuarios;
    private javax.swing.JButton btnNotaCredito;
    private javax.swing.JButton btnNotaDebito;
    private javax.swing.JButton btnOtrosDebito;
    private javax.swing.JButton btnParcialCredito;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProductosDebito;
    private javax.swing.JButton btnQuitarP;
    private javax.swing.JButton btnQuitarP1;
    private javax.swing.JButton btnQuitarP2;
    private javax.swing.JButton btnTotalCredito;
    public static javax.swing.JButton btnUsuarios;
    private javax.swing.JButton btnVolver;
    private com.toedter.calendar.JDateChooser chooserFechas1;
    private com.toedter.calendar.JDateChooser chooserFechas2;
    private com.toedter.calendar.JDateChooser fechaCosto1;
    private com.toedter.calendar.JDateChooser fechaCosto2;
    private com.toedter.calendar.JDateChooser fechaCredito;
    private com.toedter.calendar.JDateChooser fechaCredito1;
    private com.toedter.calendar.JDateChooser fechaCredito2;
    private com.toedter.calendar.JDateChooser fechaCreditoTotal;
    private com.toedter.calendar.JDateChooser fechaDebito;
    private com.toedter.calendar.JDateChooser fechaDebito1;
    private com.toedter.calendar.JDateChooser fechaDebito2;
    private com.toedter.calendar.JDateChooser fechaFactura;
    private com.toedter.calendar.JDateChooser fechaFactura1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblCodigoProveedor;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblCostos;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFondo2;
    private javax.swing.JLabel lblFondo3;
    private javax.swing.JLabel lblFront;
    private javax.swing.JLabel lblFront1;
    private javax.swing.JLabel lblMayorCantidad;
    private javax.swing.JLabel lblMenorCantidad;
    private javax.swing.JLabel lblMontoOriginal;
    private javax.swing.JLabel lblMontoOriginal1;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblMontoTotal1;
    private javax.swing.JLabel lblParcialCredito;
    private javax.swing.JLabel lblPreCredito;
    private javax.swing.JLabel lblPreDebito;
    private javax.swing.JLabel lblProductos;
    private javax.swing.JLabel lblProductosAIngresar;
    private javax.swing.JLabel lblProductosDebito;
    private javax.swing.JLabel lblProductosI;
    private javax.swing.JLabel lblTituloFactura;
    private javax.swing.JLabel lblTituloFactura1;
    private javax.swing.JLabel lblTituloFactura2;
    private javax.swing.JLabel lblTop;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel menuBotones;
    private javax.swing.JPanel pnlContactos;
    private javax.swing.JPanel pnlCostos;
    private javax.swing.JPanel pnlDetallesFactura;
    private javax.swing.JPanel pnlFacturas;
    private javax.swing.JPanel pnlInicio;
    private javax.swing.JPanel pnlOtrosDebito;
    private javax.swing.JPanel pnlParcialCredito;
    private javax.swing.JPanel pnlPreCredito;
    private javax.swing.JPanel pnlPreDebito;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JPanel pnlProductosDebito;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlTotalCredito;
    private javax.swing.JPanel pnlUsuarios;
    private javax.swing.JTable tablaAgregarANotaCredito;
    private javax.swing.JTable tablaAgregarANotaDebito;
    private javax.swing.JTable tablaAgregarFactura;
    private javax.swing.JTable tablaContactos;
    private javax.swing.JTable tablaCostos;
    private javax.swing.JTable tablaCredito;
    private javax.swing.JTable tablaDebito;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JTable tablaFacturaOriginal;
    private javax.swing.JTable tablaFacturaOriginal1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTable tablaProductosFactura;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTable tablaVencimiento;
    private javax.swing.JLabel tituloMayor;
    private javax.swing.JLabel tituloMenor;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtBuscador1;
    private javax.swing.JTextField txtBuscador2;
    private javax.swing.JTextField txtBuscador3;
    private javax.swing.JTextField txtBuscador4;
    private javax.swing.JTextField txtBuscador5;
    private javax.swing.JTextField txtBuscador6;
    private javax.swing.JTextField txtBuscador7;
    private javax.swing.JTextField txtBuscador8;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtControl;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextField txtDestinatario1;
    private javax.swing.JTextField txtDestinatario2;
    private javax.swing.JTextField txtDestinatario3;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtMontoAdicional;
    private javax.swing.JTextField txtMontoAdicional3;
    public static javax.swing.JTextField txtPermisos;
    private javax.swing.JTextArea txtRazon;
    private javax.swing.JTextArea txtRazon1;
    private javax.swing.JTextArea txtRazon2;
    private javax.swing.JTextArea txtRazon3;
    // End of variables declaration//GEN-END:variables
}
