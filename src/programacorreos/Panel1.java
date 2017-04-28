/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacorreos;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author Andres Chila
 */
public class Panel1 extends JPanel{
     private VentanaPrincipal ventana;
     private JLabel LInfo;
     private JLabel LLinea1;
     private JLabel LLinea2;
     private JLabel LLinea3;
     private JLabel LLinea4;
     private JLabel LLinea5;
     private JLabel imagen;
            
    public Panel1(VentanaPrincipal ventana) {
         this.ventana = ventana;
         //setBorder(BorderFactory.createTitledBorder("Info"));
         setLayout(null);
         
         LInfo = new JLabel("INFO:");
         LInfo.setBounds(580, 100, 150, 11);
         add(LInfo);
         
         LLinea1 = new JLabel("Este programa captura");
         LLinea1.setBounds(580, 112, 150, 11);
         add(LLinea1);
         
         LLinea2 = new JLabel("correos ingresados por");
         LLinea2.setBounds(580, 123, 150, 11);
         add(LLinea2);
         
         LLinea3 = new JLabel("el usuario, los valida");
         LLinea3.setBounds(580, 134, 150, 11);
         add(LLinea3);
         
         LLinea4 = new JLabel("y luego los visualiza en");
         LLinea4.setBounds(580, 145, 160, 11);
         add(LLinea4);
         
         LLinea5 = new JLabel("una tabla.");
         LLinea5.setBounds(580, 156, 160, 11);
         add(LLinea5);
         
        ImageIcon icon = new ImageIcon("imagenes/imagen.png");        
        imagen = new JLabel();
        imagen.setLocation(10, 10);
        imagen.setIcon(icon);
        add(imagen);
      }
}
