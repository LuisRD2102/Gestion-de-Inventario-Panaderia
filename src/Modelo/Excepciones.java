/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author luisr
 */
public class Excepciones {
          public void comprobarGTIN(JTextField campoTxt, JComboBox combo){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                if (combo.getSelectedItem().equals("GTIN-12")){
                    if (campoTxt.getText().length()>11){
                    e.consume();
                    }
                }
                else if (combo.getSelectedItem().equals("GTIN-13")){
                     if (campoTxt.getText().length()>12){
                    e.consume();
                    }
                }
                else if (combo.getSelectedItem().equals("GTIN-14")){
                     if (campoTxt.getText().length()>13){
                    e.consume();
                    }
                }
            }
            
        });
    }
        public boolean comprobarLongitudGTIN(JTextField campoTxt, JComboBox combo){
           
                if (combo.getSelectedItem().equals("GTIN-12")){
                    if (campoTxt.getText().length()<12){
                        return false;
                    }
                }
                else if (combo.getSelectedItem().equals("GTIN-13")){
                     if (campoTxt.getText().length()<13){
                         return false;
                    
                    }
                }
                else if (combo.getSelectedItem().equals("GTIN-14")){
                     if (campoTxt.getText().length()<14){
                         return false;
                   
                    }
                }
                return true;
            }
            
        

        public void RestringirATextoNumerico(JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                if (!Character.isDigit(caracter)){
                    e.consume();
                }
            }
            
        });
       }
        
        public void restringirContraseña (JPasswordField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                    if (campoTxt.getText().length()==20){
                        e.consume();
                    }
            }
        });
    }
        
       public void restringirPassword (JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                    if (campoTxt.getText().length()==20){
                        e.consume();
                    }
            }
        });
    }
       
    public void restringirUsuario (JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                    if (campoTxt.getText().length()==20){
                        e.consume();
                    }
            }
        });
    }
   

        public boolean verificarContraseña (JTextField campoTxt){
            return campoTxt.getText().length()>=6;
        }
        
        public boolean verificarMayorA3(JTextField campoTxt){
            return campoTxt.getText().length()>=3;
        }
        
        public boolean verificarGTINLongitud(JTextField campoTxt){
            return campoTxt.getText().length()>=1;
        }
        
        public boolean verificarLongitudCorreo(JTextField campoTxt){
            return campoTxt.getText().length()>=1;
        
        }
        
        public boolean verificarUsuario (JTextField campoTxt){
            return campoTxt.getText().length()>=4;
        }
        
        public void restringirUsuarioLongitud (JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                    if (campoTxt.getText().length()==20){
                        e.consume();
                    }
            }
        });
    }
        
       public void restringirCodigo (JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                    if (campoTxt.getText().length()==4){
                        e.consume();
                    }
            }
        });
    } 
    
      
      public boolean verificarCorreo(JTextField correo){
         Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(correo.getText());
         return mather.find();
      }
    
       public void restringirCedula(JTextField campoTxt){
           campoTxt.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                if (!Character.isDigit(caracter)||(campoTxt.getText().length()==10)){
                    e.consume();
                }
                if (((campoTxt.getText().length()==2)||(campoTxt.getText().length()==6))&&(caracter!=KeyEvent.VK_BACK_SPACE)) 
                    campoTxt.setText(campoTxt.getText()+".");
            }
            
        });  
      
      } 
     
    
    public void restringirCorreo(JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                    if (campoTxt.getText().length()==50){
                        e.consume();
                    }
            }
        });
    }
   
    public void RestringirATexto(JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                if (!(Character.isAlphabetic(caracter) ||  (caracter==KeyEvent.VK_BACK_SPACE)||  caracter==KeyEvent.VK_SPACE ))
                    e.consume();
                    
            }
            
        });
       }
          public void RestringirTextoADecimal(JTextField campoTxt){
           campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                if (((caracter<'0')||(caracter>'9'))&&(caracter!=KeyEvent.VK_BACK_SPACE)&&(caracter!='.'||campoTxt.getText().contains("."))){
                    e.consume();
                }
            }
            
        });  
      
      }    
    
       public void RestringirRIF(JTextField campoTxt){
        campoTxt.addKeyListener(new KeyAdapter(){
            
            @Override
            public void keyTyped(KeyEvent e){
                char caracter= e.getKeyChar();
                if ((campoTxt.getText().length()==1)&&(caracter!=KeyEvent.VK_BACK_SPACE)){
                    campoTxt.setText(campoTxt.getText()+"-");
                    campoTxt.setText(campoTxt.getText().toUpperCase());
                }
                if (campoTxt.getText().length()>1 &&!Character.isDigit(caracter)){
                    e.consume();
                }
                if (campoTxt.getText().length()==0 && Character.isDigit(caracter) ){
                    e.consume();
                }
                if (campoTxt.getText().length()==10){
                    e.consume();
                }
            }
            
        });
       }
}
