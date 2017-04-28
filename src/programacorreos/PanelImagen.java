/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacorreos;

/**
 *
 * @author Andres Chila
 */
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelImagen extends JPanel{
    private JLabel imagen;
    private VentanaPrincipal ventana;
    
    public PanelImagen(VentanaPrincipal ventana) {
         
        this.ventana = ventana;
        setSize(130, 130);
        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);
        setLayout(layout);
        
        ImageIcon icon = new ImageIcon("imagenes/imagen.png"); 
        imagen = new JLabel();
        imagen.setLocation(0,0);
        imagen.setIcon(icon);
        add(imagen);
        
    }
}
