
package Controller;

import Interfaz.Gestion;
import Interfaz.RecuperarContraseña;
import static Interfaz.RecuperarContraseña.btnEnviarCorreo;
import Modelo.Excepciones;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author luisr
 */
public class Controlador {
    Connection conexion;
    DefaultTableModel dtm;
    Excepciones excepcion= new Excepciones();
    String correoPanaderia="panaderiahdo@gmail.com";
    String contrasenaPanaderia="panaderiahdo123$";
    JButton detalles = new JButton();
    double iva;
    

    
    public void restringirGtin(JTextField campo, JComboBox combo){
         excepcion.comprobarGTIN(campo, combo);
     
    }
    
    public void restringirRIF(JTextField campoTxt){
        excepcion.RestringirRIF(campoTxt);
    }
    
    public void restringirNumero(JTextField campoTxt){
         excepcion.RestringirATextoNumerico(campoTxt);
    }
    
    public void restringirContraseña(JPasswordField campoTxt){
        excepcion.restringirContraseña(campoTxt);    
    }
    
    public boolean comprobarLongitudGTIN(JTextField campoTxt, JComboBox combo){
         return excepcion.comprobarLongitudGTIN(campoTxt, combo);
         
    }
    
    public void restringirADecimal(JTextField campoTxt){
        excepcion.RestringirTextoADecimal(campoTxt);
    }
    
    public void restringirCedula(JTextField campoTxt){
        excepcion.restringirCedula(campoTxt);
    }
    
    public boolean verificarLongitudGTIN(JTextField campoTxt){
       return excepcion.verificarGTINLongitud(campoTxt);
    }
    
    public boolean comprobarFormatoCorreo(JTextField campoTxt){
        return excepcion.verificarCorreo(campoTxt);
    }
    
    public void restringirUsuarioLongitud(JTextField campoTxt){
        excepcion.restringirUsuarioLongitud(campoTxt);
    }
    
    public void restringirCorreo(JTextField campoTxt){
        excepcion.restringirCorreo(campoTxt);
    }
    
    public void restringirPassword(JTextField campoTxt){
        excepcion.restringirPassword(campoTxt);
    }
    
    public void restringirATexto(JTextField campoTxt){
        excepcion.RestringirATexto(campoTxt);
    }
    
    public void restringirUsuario(JTextField campoTxt){
        excepcion.restringirUsuario(campoTxt);
    }
    
    public boolean verificarContraseña(JTextField campoTxt){
        return excepcion.verificarContraseña(campoTxt);
    }
    
    public boolean verificarMayorA3(JTextField campoTxt){
        return excepcion.verificarMayorA3(campoTxt);
    }
    
    public boolean verificarLongitudCorreo(JTextField campoTxt){
        return excepcion.verificarLongitudCorreo(campoTxt);
    }
    
    
    public boolean verificarUsuarioLongitud(JTextField campoTxt){
        return excepcion.verificarUsuario(campoTxt);
    }
    
    public void restringirCodigo(JTextField campoTxt){
        excepcion.restringirCodigo(campoTxt);
    }
      
    public void mostrarVentana (JFrame ventana, JFrame ventana2){
        ventana.setVisible(true);
        ventana2.dispose();
    }
     public void iniciaVentana(JFrame ventana){
        ventana.setLocationRelativeTo(null);
        //ventana.setIconImage((new ImageIcon("src/imagenes/logoescritorio1.png").getImage()));
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getIva() {
        return iva;
    }
    
     
    public String generarCodigo(){
        String charMinusculas = "abcdefghijklmnopqrstuvwxyz";
        String charMayusculas = charMinusculas.toUpperCase();
        String NUMBER = "0123456789";

        String datos = charMinusculas + charMayusculas + NUMBER;
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(4);

            for (int i = 0; i < 4; i++) {
                int rndCharAt = random.nextInt(datos.length());
                char rndChar = datos.charAt(rndCharAt);

                sb.append(rndChar);
            }
        return sb.toString();
    }
    
     public void enviarCorreo(JTextField txtCorreo,String correoPanaderia, String contrasenaPanaderia, String codigo){
        Thread tiempoCorreo= new Thread(){
            public void run(){
                try{
                    
                    RecuperarContraseña.progressBar.setValue(20);
                    Properties propiedad= new Properties();
                    propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
                    propiedad.setProperty("mail.smtp.starttls.enable", "true");
                    propiedad.setProperty("mail.smtp.port", "587");
                    propiedad.setProperty("mail.smtp.auth", "true");
                    Session sesion= Session.getDefaultInstance(propiedad);
                    RecuperarContraseña.progressBar.setValue(40);
                    //CUERPO DEL CORREO---------------------------------------
                    String correoPanaderia="panaderiahdo@gmail.com";
                    String contrasenaPanaderia="panaderiahdo123$";
                    String correoDestino= txtCorreo.getText();
                    String asunto="Codigo de recuperacion de contraseña";
                    String mensaje="Su codigo de recuperacion es: "+codigo+"\n\nSi usted no pidio este codigo de recuperacion haga caso omiso a este correo";
                    //--------------------------------------------------------
                    MimeMessage correoMensaje= new MimeMessage(sesion);
                    RecuperarContraseña.progressBar.setValue(60);
                    try {
                        try {
                            correoMensaje.setFrom(new InternetAddress(correoPanaderia));
                            correoMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
                            correoMensaje.setSubject(asunto);
                            correoMensaje.setText(mensaje);
                            Transport transporte= sesion.getTransport("smtp");
                            RecuperarContraseña.progressBar.setValue(80);
                            transporte.connect(correoPanaderia,contrasenaPanaderia);
                            transporte.sendMessage(correoMensaje, correoMensaje.getRecipients(Message.RecipientType.TO));
                            transporte.close();
                            RecuperarContraseña.progressBar.setValue(100);
                            UIManager.put( "nimbusOrange", new Color( 113, 213, 76 ) );
                            btnEnviarCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/btnEnviado.png")));
                            JOptionPane.showMessageDialog(null, "Se ha enviado un codigo de recuperacion a su correo asociado");
                            RecuperarContraseña.btnSiguiente.setEnabled(true);
                        } catch (AddressException ex) {
                            ex.printStackTrace();
                        }
                    } catch (MessagingException ex) {
                        ex.printStackTrace();
                    }
                            }
                catch(Exception ex){
                                ex.printStackTrace();
                }
            }
        };
        tiempoCorreo.start();
    }
    public boolean verificarInicioServidor(){
        try {
            Scanner lector= new Scanner(Runtime.getRuntime().exec("tasklist").getInputStream());
            while (lector.hasNext()){
                if (lector.nextLine().startsWith("mysqld.exe")){
                    return true;
                }
            }
            return false;  
        } catch (IOException ex) {
            return false;
        }
    }
        public void iniciarServidor(){
        try {
            Runtime.getRuntime().exec("net start mysql80");
            while(!conectarBD()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
       
    public void actualizarContraseña(JTextField email, JTextField password){
        try {
            PreparedStatement ps= conexion.prepareStatement("UPDATE `bd_hdo`.`usuarios` SET `Contraseña` = '"+password.getText()+"' WHERE (`Email` = '"+email.getText()+"')");
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    } 
    
           
    public void registrarEnBdProductos(String nombre, String tipoGtin, String gtin,JDateChooser fecha,String descripcion ,int cantidad){
       try {
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO productos VALUES (?,?,?,?,?,?)");
            java.sql.Date fechaSql=new java.sql.Date(fecha.getDate().getTime());
            ps.setString(1, nombre);
            ps.setString(2, tipoGtin);
            ps.setString(3, gtin);
            ps.setDate(4,fechaSql);
            ps.setString(5, descripcion);
            ps.setInt(6, cantidad);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        public void modificarProducto(JTable tabla, String nombre, String tipoGtin, String gtin, JDateChooser fecha, String descripcion, int cantidad){
            try {
            PreparedStatement ps= conexion.prepareStatement("UPDATE `bd_hdo`.`productos` SET `Nombre` = ?, `Tipo GTIN` = ?, `GTIN` = ?, `Fecha de Caducidad` = ?, `Descripcion` = ?, `Cantidad Disponible` = ? WHERE (`GTIN` = "+tabla.getValueAt(tabla.getSelectedRow(), 2)+")");
            java.sql.Date fechaSql=new java.sql.Date(fecha.getDate().getTime());
            ps.setString(1, nombre);
            ps.setString(2, tipoGtin);
            ps.setString(3, gtin);
            ps.setDate(4, fechaSql); 
            ps.setString(5, descripcion);
            ps.setInt(6, cantidad);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();                   
        }   
    
    
    }
        public void modificarUsuario(JTable tabla, String nombre, String apellido,String cedula ,String telefono,String direccion, String correo, String usuario, String password, String tipoUsuario){
            try {
            PreparedStatement ps= conexion.prepareStatement("UPDATE `bd_hdo`.`usuarios` SET `Nombre` = ?, `Apellido` = ?,`Cedula` = ? ,`Telefono` = ?, `Direccion` = ?, `Email` = ?, `Usuario` = ?, `Contraseña` = ?, `Tipo de Usuario` = ? WHERE (`Cedula` = '"+tabla.getValueAt(tabla.getSelectedRow(), 2)+"')");
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, cedula);
            ps.setString(4, telefono);
            ps.setString(5, direccion); 
            ps.setString(6, correo);
            ps.setString(7, usuario);
            ps.setString(8, password);
            ps.setString(9, tipoUsuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();                   
        }   
    
    
    }
        public void modificarContacto(JTable tabla, String nombre, String apellido,String email ,String telefono,String direccion){
            try {
            PreparedStatement ps= conexion.prepareStatement("UPDATE `bd_hdo`.`contactos` SET `Nombre` = ?, `Apellido` = ?,`Email` = ? ,`Telefono` = ?, `Domicilio Fiscal` = ? WHERE (`Codigo de Proveedor` = '"+tabla.getValueAt(tabla.getSelectedRow(), 0)+"')");
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, email);
            ps.setString(4, telefono);
            ps.setString(5, direccion); 
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();                   
        }   
    
    
    }
        
        
        
    public void registrarEnBdNotaDebito(String factura, String destinatario, String razon,JDateChooser fecha,double montoOriginal, double montoAdicional, double total){
       try {
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO nota_debito VALUES (?,?,?,?,?,?,?)");
            java.sql.Date fechaSql=new java.sql.Date(fecha.getDate().getTime());
            ps.setString(1, factura);
            ps.setString(2, destinatario);
            ps.setString(3, razon);
            ps.setDate(4,fechaSql);
            ps.setDouble(5, montoOriginal);
            ps.setDouble(6, montoAdicional);
            ps.setDouble(7, total);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void registrarEnBdNotaCredito(String factura, String destinatario, String razon,JDateChooser fecha,double montoOriginal, double montoAdicional, double total){
       try {
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO nota_credito VALUES (?,?,?,?,?,?,?)");
            java.sql.Date fechaSql=new java.sql.Date(fecha.getDate().getTime());
            ps.setString(1, factura);
            ps.setString(2, destinatario);
            ps.setString(3, razon);
            ps.setDate(4,fechaSql);
            ps.setDouble(5, montoOriginal);
            ps.setDouble(6, montoAdicional);
            ps.setDouble(7, total);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }   
        
        
        public boolean verificarCorreoSeleccionado(JTable tabla, String email){
        try {
            conectarBD();
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM `bd_hdo`.`usuarios` WHERE (`Email` = '"+tabla.getValueAt(tabla.getSelectedRow(),5 )+"')");
                if (resultado.next()){
                    if(resultado.getString("Email").equals(email)){
                        return true;
                    } else return false;
                    
                } else return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        }
        
    public boolean verificarNombreSeleccionado(JTable tabla, String nombre){
        try {
            conectarBD();
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM `bd_hdo`.`productos` WHERE (`Nombre` = '"+tabla.getValueAt(tabla.getSelectedRow(),0 )+"')");
                if (resultado.next()){
                    if(resultado.getString("Nombre").equals(nombre)){
                        return true;
                    } else return false;
                    
                } else return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        }

            
    public boolean verificarUsuarioSeleccionado(JTable tabla, String usuario){
        try {
            conectarBD();
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM `bd_hdo`.`usuarios` WHERE (`Usuario` = '"+tabla.getValueAt(tabla.getSelectedRow(),6 )+"')");
                if (resultado.next()){
                    if(resultado.getString("Usuario").equals(usuario)){
                        return true;
                    } else return false;
                    
                } else return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        }
    
    public boolean verificarCodigoSeleccionado(JTable tabla, int codigo){
        try {
            conectarBD();
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM `bd_hdo`.`contactos` WHERE (`Codigo de Proveedor` = '"+tabla.getValueAt(tabla.getSelectedRow(),0 )+"')");
                if (resultado.next()){
                    if(resultado.getString("Codigo de Proveedor").equals(String.valueOf(codigo))){
                        return true;
                    } else return false;
                    
                } else return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
        }
        
         public void eliminarFilaVentas(JTable tabla, int fila){
            dtm.removeRow(fila);
        }
        
        public boolean minimoContaseña(JPasswordField campoTxt){
            return campoTxt.getText().length()>5;
        }

        public void eliminarDeTablaProductosBD(JTable tabla){
         try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM `bd_hdo`.`productos` WHERE (`GTIN` = "+tabla.getValueAt(tabla.getSelectedRow(),2 )+")");
             int n=ps.executeUpdate();
             if (n>=1) JOptionPane.showMessageDialog(null, "Producto eliminado","ANUNCIO",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Eliminacion Fallida","ANUNCIO",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }  
        
    public void eliminarDeTablaContactosBD(JTable tabla){
         try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM `bd_hdo`.`contactos` WHERE (`Codigo de Proveedor` = "+tabla.getValueAt(tabla.getSelectedRow(),0 )+")");
             int n=ps.executeUpdate();
             if (n>=1) JOptionPane.showMessageDialog(null, "Contacto eliminado","ANUNCIO",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Eliminacion Fallida","ANUNCIO",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }       
    
    public double montoAdicional(String factura){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.costos WHERE `No. Factura` = '"+factura+"'");
        if (resultado.next()){ 
        return Double.parseDouble(resultado.getString("Total"));
        } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return 0;
    
    }
    
    public String obtenerCodigo(JLabel label){
        String[] labelAr=label.getText().split(":",0);
        return labelAr[1].trim();
    }
    
    
     public void ordenarPorRangoFecha(JDateChooser fecha1, JDateChooser fecha2,JTable tabla, int modalidad){
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            if (modalidad==1)
             rellenarTablaProductos(tabla, "SELECT * FROM bd_hdo.productos WHERE `Fecha de Caducidad` BETWEEN "+df.format(fecha1.getDate())+" AND "+df.format(fecha2.getDate()));
             if (modalidad==2)
             rellenarTablaProductos(tabla, "SELECT * FROM bd_hdo.productos WHERE (`Fecha de Caducidad` = "+df.format(fecha1.getDate())+")");
             
             
    }
     
     public void ordenarPorRangoFechaCosto(JDateChooser fecha1, JDateChooser fecha2,JTable tabla, int modalidad){
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            if (modalidad==1)
             rellenarTablaFactura(tabla, "SELECT * FROM bd_hdo.costos WHERE `Fecha de Emision` BETWEEN "+df.format(fecha1.getDate())+" AND "+df.format(fecha2.getDate()));
             if (modalidad==2)
             rellenarTablaFactura(tabla, "SELECT * FROM bd_hdo.costos WHERE (`Fecha de Emision` = "+df.format(fecha1.getDate())+")");
             
             
    } 
     
     public void ordenarPorRangoFechaDebito(JDateChooser fecha1, JDateChooser fecha2,JTable tabla, int modalidad){
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            if (modalidad==1)
             rellenarTablaDebito(tabla, "SELECT * FROM bd_hdo.nota_debito WHERE `Fecha` BETWEEN "+df.format(fecha1.getDate())+" AND "+df.format(fecha2.getDate()));
             if (modalidad==2)
             rellenarTablaDebito(tabla, "SELECT * FROM bd_hdo.nota_debito WHERE (`Fecha` = "+df.format(fecha1.getDate())+")");
             
             
    } 
    public void ordenarPorRangoFechaCredito(JDateChooser fecha1, JDateChooser fecha2,JTable tabla, int modalidad){
            DateFormat df = new SimpleDateFormat("yyyyMMdd");
            if (modalidad==1)
             rellenarTablaCredito(tabla, "SELECT * FROM bd_hdo.nota_credito WHERE `Fecha` BETWEEN "+df.format(fecha1.getDate())+" AND "+df.format(fecha2.getDate()));
             if (modalidad==2)
             rellenarTablaCredito(tabla, "SELECT * FROM bd_hdo.nota_credito WHERE (`Fecha` = "+df.format(fecha1.getDate())+")");
             
             
    } 
    
    public void sumarInventarioTotal(JLabel sumaTotal){
        try {
            int sumatoria=0;
            conectarBD(); 
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.productos");
            while(resultado.next()){
                sumatoria+=Integer.parseInt(resultado.getString(6));
            }
            sumaTotal.setText(sumatoria+" Unidad(es)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    
    public void sumarGastoTotal(JLabel sumaTotal){
        try {
            double sumatoria=0;
            conectarBD(); 
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.costos");
            while(resultado.next()){
                sumatoria+=Double.parseDouble(resultado.getString(6));
            }
            sumaTotal.setText("$"+String.format("%.2f",sumatoria));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    public void rellenarTablaVencimiento(JTable tabla, String sql) { 
        try {
            String[] columna = { "Nombre","Fecha de Caducidad"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(4)};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
      
    }
     
    public void eliminarDeTablaUsuariosBD(JTable tabla){
         try {
            PreparedStatement ps = conexion.prepareStatement("DELETE FROM `bd_hdo`.`usuarios` WHERE (`Cedula` = '"+tabla.getValueAt(tabla.getSelectedRow(), 2)+"')");
             int n=ps.executeUpdate();
             if (n>=1) JOptionPane.showMessageDialog(null, "Usuario eliminado","ANUNCIO",JOptionPane.INFORMATION_MESSAGE);
            else JOptionPane.showMessageDialog(null, "Eliminacion Fallida","ANUNCIO",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    } 
    
     public void mayorCantidad(JLabel mayor, JLabel titulo){
        try {
            conectarBD(); 
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.productos ORDER BY `Cantidad Disponible` DESC LIMIT 1");
           if( resultado.next()){
            mayor.setText(resultado.getString(6)+" Unidad(es)");
            titulo.setText(resultado.getString(1));
           }
           else {
               mayor.setText("0 unidades");
               titulo.setText("");
           }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        
        
        }
     
        public void menorCantidad(JLabel mayor, JLabel titulo){
        try {
            conectarBD(); 
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.productos ORDER BY `Cantidad Disponible` ASC LIMIT 1");
           if( resultado.next()){
            mayor.setText(resultado.getString(6)+" Unidad(es)");
            titulo.setText(resultado.getString(1));
           }
           else {
               mayor.setText("0 unidades");
               titulo.setText("");
           }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        }
    
    public boolean compararUsuarios(String anterior, String actual){
        if (anterior.equals(actual))
            return true;
        else return false;
    }
    
    public void bloquearEnBD(String anterior){
        
        try {
            conectarBD();
            PreparedStatement ps= conexion.prepareStatement("UPDATE `bd_hdo`.`usuarios` SET `Bloqueado` = 1 WHERE (`Usuario` = "+anterior+")");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void desbloquearUsuario(JTable tabla){
        try {
           conectarBD();
           PreparedStatement ps = conexion.prepareStatement("UPDATE `bd_hdo`.`usuarios` SET `Bloqueado` = 0 WHERE (`Usuario` = '"+tabla.getValueAt(tabla.getSelectedRow(),6 )+"')");
           ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
            
    
    }
    
    public boolean estaBloqueado(JTable tabla){
            try {
           conectarBD();
           ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM `bd_hdo`.`usuarios` WHERE (`Usuario` = '"+tabla.getValueAt(tabla.getSelectedRow(),6 )+"')");
            if (resultado.next()){
                if (resultado.getString("Bloqueado").equals("0"))
                    return false;
                else return true;
            
            } return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public boolean verificarCorreoAdmin(JTextField correo){
       
        try {
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.usuarios WHERE `Email` = '"+correo.getText()+"'");
                if (resultado.next()){
                    if(resultado.getString("Tipo de Usuario").equals("Administrador"))
                        return true;
                } return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
       
    }
    
    public int verificarUsuario (JTextField usuario, JTextField contraseña){
        
        try { 
            conectarBD();
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.usuarios WHERE `Usuario` = '"+usuario.getText()+"' AND `Contraseña` = '"+contraseña.getText()+"'");
            if (resultado.next()){
                if (resultado.getString("Bloqueado").equals("0")){ 
                  
                    if (resultado.getString("Tipo de Usuario").equals("Administrador"))
                        return 1;
                    else return 2;
                    
                }else return -2;
                    
                    
                
            }else return -1;  
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
            }
        
    
    
    }
    
    public boolean comprobarCedula(JTextField cedula){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.usuarios WHERE `Cedula` = '"+cedula.getText()+"'");
        if (resultado.next()){ 
        return true;
        
        } else return false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public boolean comprobarNoFactura(JTextField factura){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.costos WHERE `No. Factura` = '"+factura.getText()+"'");
        if (resultado.next()){ 
        return true;
        
        } else return false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public boolean comprobarNoControl(JTextField control){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.costos WHERE `No. Control` = '"+control.getText()+"'");
        if (resultado.next()){ 
        return true;
        
        } else return false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public boolean comprobarCodigoContacto(JTextField codigo){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.contactos WHERE `Codigo de Proveedor` = '"+codigo.getText()+"'");
        if (resultado.next()){ 
        return true;
        
        } else return false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public boolean comprobarUsuario(JTextField usuario){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.usuarios WHERE `Usuario` = '"+usuario.getText()+"'");
        if (resultado.next()){ 
            return true;
        
        } else return false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    public boolean comprobarCorreo(JTextField correo){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.usuarios WHERE `Email` = '"+correo.getText()+"'");
        if (resultado.next()){ 
        return true;
        
        } else return false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    
    }
    
    
     
    public void registrarEnBdUsuarios(String nombre, String apellido, String cedula,String telefono,String direccion, String correo,String usuario, String password, String tipoUsuario, int bloqueado){
       try {
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO usuarios VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, cedula);
            ps.setString(4,telefono);
            ps.setString(5, direccion);
            ps.setString(6, correo);
            ps.setString(7, usuario);
            ps.setString(8, password);
            ps.setString(9, tipoUsuario);
            ps.setInt(10, bloqueado);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
    public void registrarEnBdContactos(int codigoProveedor, String nombre, String apellido,String correo,String telefono, String direccion,String cedula, String rif){
       try {
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO contactos VALUES (?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, codigoProveedor);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setString(4, correo);
            ps.setString(5,telefono);
            ps.setString(6, direccion);
            ps.setString(7, cedula);
            ps.setString(8, rif);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void registrarEnBdFacturas(int noFactura,int noControl,int codigoProveedor, JDateChooser fecha,String productos,double total){
       try {
            PreparedStatement ps= conexion.prepareStatement("INSERT INTO costos VALUES (?,?,?,?,?,?)");
            //Como quieres meter los Productos en BD?
            java.sql.Date fechaSql=new java.sql.Date(fecha.getDate().getTime());
            ps.setInt(1, noFactura);
            ps.setInt(2, noControl);
            ps.setInt(3, codigoProveedor);
            ps.setDate(4, fechaSql);
            ps.setString(5, productos);
            ps.setDouble(6, total);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     
    public boolean conectarBD(){  
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_hdo?useSSL=false","root","123456789");
            return true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos","Error de conexión con base de datos",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }
    
        public void agregarCantidadBD(int cantidad,JTable tabla){
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE `bd_hdo`.`productos` SET `Cantidad Disponible` = '"+cantidad+"' WHERE (`GTIN` = '"+tabla.getValueAt(tabla.getSelectedRow(), 2)+"') ");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public boolean comprobarNombre(JTextField nombre){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.productos WHERE `Nombre` = '"+nombre.getText()+"'");
        if (resultado.next()){ 
        return true;
        
        } else return false;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }

    
    public int comprobarCantidad(int cantidad, JTextField gtin){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.productos WHERE `GTIN` = '"+gtin.getText()+"'");
            if (resultado.next()){                
            if (cantidad>Integer.parseInt(resultado.getString(6))){
                return 0; 
                
            } else return 1;
            
            } else {
               return 3;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return -1;
        }
        
        
    }
    
    public boolean comprobarGtin(JTextField gtin){
        if (comprobarCantidad(-1, gtin)!=3) return true;
        else return false;
    }
    
    public boolean verificarGTINSeleccionado(JTable tabla, String gtin){
            try {
            conectarBD();
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM `bd_hdo`.`productos` WHERE (`GTIN` = '"+tabla.getValueAt(tabla.getSelectedRow(),2 )+"')");
                if (resultado.next()){
                    if(resultado.getString("GTIN").equals(gtin)){
                        return true;
                    } else return false;
                    
                } else return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    
    }
    
    public void iniciarCalendar(JDateChooser fecha){
            fecha.getJCalendar().setMinSelectableDate(Calendar.getInstance().getTime());
            fecha.getJCalendar().setWeekOfYearVisible(false);
            fecha.setFont(new Font("Sans Serif",Font.BOLD,12));
            fecha.getJCalendar().setSundayForeground(new java.awt.Color(111,96,219));
            fecha.getJCalendar().setTodayButtonVisible(true);
            fecha.getJCalendar().setTodayButtonText("HOY");
            
        }
    
    public void desconectarBD(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void rellenarTablaProductos(JTable tabla, String sql) {     
        try {
            String[] columna = { "Nombre", "Tipo GTIN", "GTIN","Fecha de Caducidad", "Descripcion", "Cantidad Disponible"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6)};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableRowSorter ordenador = new TableRowSorter(dtm);
            class IntComparator implements Comparator {
                
                public int compare(Object o1, Object o2) {
                    Integer int1 = (Integer) Integer.parseInt(o1.toString());
                    Integer int2 = (Integer) Integer.parseInt(o2.toString());
                    return int1.compareTo(int2);
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
            ordenador.setComparator(5, new IntComparator());
            ordenador.setComparator(2, new IntComparator());
            tabla.setRowSorter(ordenador);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
      
    }
        
    public void rellenarTablaProductosFactura(JTable tabla, String sql) {     
        try {
            String[] columna = { "Nombre", "GTIN", "Descripcion"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(3),resultado.getString(5)};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
      
    } 
    
    public void rellenarTablaFactura(JTable tabla, String sql){
                try {
            String[] columna = { "No. Factura", "No. Control", "Cod. Proveedor","Fecha de Emision"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableRowSorter ordenador = new TableRowSorter(dtm);
            class IntComparator implements Comparator {
                
                public int compare(Object o1, Object o2) {
                    Integer int1 = (Integer) Integer.parseInt(o1.toString());
                    Integer int2 = (Integer) Integer.parseInt(o2.toString());
                    return int1.compareTo(int2);
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
            ordenador.setComparator(0, new IntComparator());
            ordenador.setComparator(1, new IntComparator());
            ordenador.setComparator(2, new IntComparator());
            tabla.setRowSorter(ordenador);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
    
    public String listaProductos(String factura){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.costos WHERE `No. Factura` = '"+factura+"'");
        if (resultado.next()){ 
        return resultado.getString("Productos");
        } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return "";
    
    }
    
    public double precioTotal(String factura){
        try {
            ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.costos WHERE `No. Factura` = '"+factura+"'");
        if (resultado.next()){ 
        return Double.parseDouble(resultado.getString("Total"));
        } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
        return 0;
    
    }
    
    
    
    public void rellenarTablaVisualizarFactura(JTable tabla, String sql, String nFactura){
        
        
        String producto = listaProductos(nFactura);
        String[] listaProductos = producto.split("\n",0);
        
     
       
        try {
            String[] columna = { "Nombre", "Descripcion", "Cantidad","P. Unidad", "Total"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
               for (int i=0;i<listaProductos.length;i++){
                String[] porComas = listaProductos[i].split(",",0);
                String [] row={porComas[0],porComas[1],porComas[2],porComas[3],String.valueOf(Integer.parseInt(porComas[2])*Double.parseDouble(porComas[3]))};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableRowSorter ordenador = new TableRowSorter(dtm);
            class IntComparator implements Comparator {
                
                public int compare(Object o1, Object o2) {
                    Integer int1 = (Integer) Integer.parseInt(o1.toString());
                    Integer int2 = (Integer) Integer.parseInt(o2.toString());
                    return int1.compareTo(int2);
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
            Comparator comparatorDouble = new Comparator() {

                @Override
                    public int compare(Object t, Object t1) {
                        Double dbl1 = Double.valueOf(String.valueOf(t).replaceAll(",", ""));
                        Double dbl2 = Double.valueOf(String.valueOf(t1).replaceAll(",", ""));
                        return dbl1.compareTo(dbl2);
                        }
                    };
            TableRowSorter sorter = new TableRowSorter(dtm);
            sorter.setComparator(3, comparatorDouble);
            sorter.setComparator(4, comparatorDouble);            
            ordenador.setComparator(2, new IntComparator());
            tabla.setRowSorter(ordenador);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    
    }
       
    
    //GTIN, Cantidad, Precio por Unidad    
    public void rellenarFactura(JTable tabla) {     
        
            String[] columna = { "Nombre", "GTIN", "Descripcion","Cantidad","P. Unidad", "P. Total"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };

            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
    }
    
    public void agregarATabla(JTable tablaProductos, JTable tablaFactura, JTextField cantidad, JTextField precioUnidad, JComboBox ivaCombo){
        dtm = (DefaultTableModel)tablaFactura.getModel();
        
        if (ivaCombo.getSelectedItem().equals("No")){
        String [] row={String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0)),String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1)),String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2)),cantidad.getText(),precioUnidad.getText(),String.valueOf(Integer.parseInt(cantidad.getText())*Double.parseDouble(precioUnidad.getText()))};
        dtm.addRow(row);
        } else {
        iva +=(Integer.parseInt(cantidad.getText())*Double.parseDouble(precioUnidad.getText()))*0.16;    
        String [] row={String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 0)),String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 1)),String.valueOf(tablaProductos.getValueAt(tablaProductos.getSelectedRow(), 2)),cantidad.getText(),precioUnidad.getText(),String.valueOf(Integer.parseInt(cantidad.getText())*Double.parseDouble(precioUnidad.getText()))};
        dtm.addRow(row);
        } 
        
    }
    
    
    public void quitarDeTabla(JTable tablaFactura){
        dtm = (DefaultTableModel)tablaFactura.getModel();
        iva -=(Integer.parseInt(String.valueOf(tablaFactura.getValueAt(tablaFactura.getSelectedRow(), 3)))*Double.parseDouble(String.valueOf(tablaFactura.getValueAt(tablaFactura.getSelectedRow(), 4))))*0.16; 
        dtm.removeRow(tablaFactura.getSelectedRow());
        System.out.println(iva);
    }
    public void buscarInfoContacto(JTextField codigo, JTextField nombre, JTextField apellido, JTextField correo, JTextField telefono, JTextArea direccion, JTextField cedula, JTextField rif){
        try {
        ResultSet resultado = conexion.createStatement().executeQuery("SELECT * FROM bd_hdo.contactos WHERE `Codigo de Proveedor` = '"+codigo.getText()+"'");
        if (resultado.next()){
            codigo.setText(resultado.getString(1));
            nombre.setText(resultado.getString(2));
            apellido.setText(resultado.getString(3));
            correo.setText(resultado.getString(4));
            telefono.setText(resultado.getString(5));
            direccion.setText(resultado.getString(6));
            cedula.setText(resultado.getString(7));
            rif.setText(resultado.getString(8));
        } 
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
    
    
    }    
        
    public void rellenarTablaContactos(JTable tabla, String sql) {     
        try {
            String[] columna = { "Codigo de Proveedor", "Nombre", "Apellido","Email", "Telefono","Domicilio Fiscal"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5), resultado.getString(6)};
  
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableRowSorter ordenador = new TableRowSorter(dtm);
            class IntComparator implements Comparator {
                
                public int compare(Object o1, Object o2) {
                    Integer int1 = (Integer) Integer.parseInt(o1.toString());
                    Integer int2 = (Integer) Integer.parseInt(o2.toString());
                    return int1.compareTo(int2);
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
            ordenador.setComparator(0, new IntComparator());
            tabla.setRowSorter(ordenador);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
    public String convertirBloqueado(String bloqueado){
        if (bloqueado.equals("1"))
            return "Si";
        else return "No";
    
    } 
    
        public void rellenarTablaUsuarios(JTable tabla, String sql) {     
        try {
            String[] columna = { "Nombre", "Apellido", "Cedula", "Telefono", "Direccion", "Email", "Usuario", "Contraseña", "Tipo de Usuario", "Bloqueado"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7),resultado.getString(8),resultado.getString(9),convertirBloqueado(resultado.getString(10))};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
      
    }
    
    public void rellenarTablaDebito(JTable tabla, String sql) {     
        try {
            String[] columna = { "Factura de referencia", "Destinatario", "Razon", "Fecha", "Monto original", "Monto adicional", "Total"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7)};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableRowSorter ordenador = new TableRowSorter(dtm);
            class IntComparator implements Comparator {
                
                public int compare(Object o1, Object o2) {
                    Integer int1 = (Integer) Integer.parseInt(o1.toString());
                    Integer int2 = (Integer) Integer.parseInt(o2.toString());
                    return int1.compareTo(int2);
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
               Comparator comparatorDouble = new Comparator() {

                @Override
                    public int compare(Object t, Object t1) {
                        Double dbl1 = Double.valueOf(String.valueOf(t).replaceAll(",", ""));
                        Double dbl2 = Double.valueOf(String.valueOf(t1).replaceAll(",", ""));
                        return dbl1.compareTo(dbl2);
                        }
                    };
            TableRowSorter sorter = new TableRowSorter(dtm);
            ordenador.setComparator(0, new IntComparator());
            sorter.setComparator(4, comparatorDouble);
            sorter.setComparator(5, comparatorDouble); 
            sorter.setComparator(6, comparatorDouble);  
            tabla.setRowSorter(ordenador);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
      
    }     
    
    public void rellenarTablaCredito(JTable tabla, String sql) {     
        try {
            String[] columna = { "Factura de referencia", "Destinatario", "Razon", "Fecha", "Monto original", "Monto adicional", "Total"};
            dtm = new DefaultTableModel(null,columna){
                @Override
                public boolean isCellEditable(int i, int i1){
                    return false;
                }
            };
            conectarBD();
            
            ResultSet resultado = conexion.createStatement().executeQuery(sql); 
            while (resultado.next()){
                String [] row={resultado.getString(1),resultado.getString(2),resultado.getString(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7)};
                dtm.addRow(row);
            }
            tabla.setModel(dtm);
            tabla.setRowHeight(40);
            tabla.getTableHeader().setFont(new Font("Sans Serif", Font.BOLD, 13));
            tabla.getTableHeader().setBorder(new MatteBorder(0,0,2,0, Color.BLACK));
            tabla.getTableHeader().setReorderingAllowed(false);
            tabla.getTableHeader().setResizingAllowed(false);
            TableRowSorter ordenador = new TableRowSorter(dtm);
            class IntComparator implements Comparator {
                
                public int compare(Object o1, Object o2) {
                    Integer int1 = (Integer) Integer.parseInt(o1.toString());
                    Integer int2 = (Integer) Integer.parseInt(o2.toString());
                    return int1.compareTo(int2);
                }

                public boolean equals(Object o2) {
                    return this.equals(o2);
                }
            }
               Comparator comparatorDouble = new Comparator() {

                @Override
                    public int compare(Object t, Object t1) {
                        Double dbl1 = Double.valueOf(String.valueOf(t).replaceAll(",", ""));
                        Double dbl2 = Double.valueOf(String.valueOf(t1).replaceAll(",", ""));
                        return dbl1.compareTo(dbl2);
                        }
                    };
            TableRowSorter sorter = new TableRowSorter(dtm);
            ordenador.setComparator(0, new IntComparator());
            sorter.setComparator(4, comparatorDouble);
            sorter.setComparator(5, comparatorDouble); 
            sorter.setComparator(6, comparatorDouble);  
            tabla.setRowSorter(ordenador);
            TableCellRenderer render = tabla.getTableHeader().getDefaultRenderer();
            JLabel headerLabel = (JLabel) render;
            headerLabel.setHorizontalAlignment(JLabel.CENTER);
            tabla.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 50));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
      
    }     

}
