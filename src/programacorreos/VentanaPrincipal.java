/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacorreos;

import programacorreos.logica.*;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import programacorreos.logica.DialogoVistaTabla;


/**
 *
 * @author Andres Chila
 */
public class VentanaPrincipal extends JFrame implements ActionListener{
    private JMenuBar menuBar;
    
    private JMenu MPrincipal;
    
    private JMenu MVer;
    
    private JMenuItem MIAyuda;
    
    private JMenuItem MINosotros;
    
    private JMenuItem MISalir;
    
    private JMenuItem MIInfo;
    
    private JDialog dialogoAyuda, dialogoNosotros;
    
    private static final String AYUDA = "AYUDA";
    
    private static final String NOSOTROS = "NOSOTROS";
    
    private static final String SALIR = "SALIR";
    
    private static final String INFO = "INFO";
    
    private JLabel LAyuda1, LAyuda2, LAyuda3;
    
    private JLabel LNosotros1, LNosotros2, LNosotros3, LNosotros4;
    
    private DialogoVistaTabla dialogTabla;
   
    
    private Panel1 panel1;
    private Panel2 panel2;
    private PanelImagen panel3;

    
    public VentanaPrincipal(){
        setSize(800, 600);
        setTitle("Titulo");
        setResizable(false);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        panel3 = new PanelImagen(this);
        panel3.setBounds(430, 80, 130, 130);
        add(panel3);
        
        panel1 = new Panel1(this);
        panel1.setBounds(10, 10, 780, 250);
        panel1.setBackground(Color.white);
        add(panel1);
        
        panel2 = new Panel2(this);
        panel2.setBounds(10, 260, 780, 280);
        add(panel2);
        
        menuBar = new JMenuBar();        
        setJMenuBar(menuBar);
        
        MPrincipal = new JMenu("Principal");
        
        MIAyuda = new JMenuItem("Ayuda");
        MIAyuda.setActionCommand(AYUDA);
        MIAyuda.addActionListener(this);
        
        MINosotros = new JMenuItem("Nosotros");
        MINosotros.setActionCommand(NOSOTROS);
        MINosotros.addActionListener(this);
        
        MISalir = new JMenuItem("Salir");
        MISalir.setActionCommand(SALIR);
        MISalir.addActionListener(this);
        
        MPrincipal.add(MIAyuda);
        MPrincipal.add(MINosotros);
        MPrincipal.add(MISalir);
        
        menuBar.add(MPrincipal);
        
        MVer = new JMenu("Ver");
        
        MIInfo = new JMenuItem("Info");
        MIInfo.setActionCommand(INFO);
        MIInfo.addActionListener(this);
        
        MVer.add(MIInfo);
        menuBar.add(MVer);
        
        LAyuda1 = new JLabel("Debe ingresar un correo, el programa lo valida");
        LAyuda2 = new JLabel("y luego lo puede visualizar en el menu ver.");
        LAyuda3 = new JLabel ("");
        
        LNosotros1 = new JLabel("Nosotros somos Andres Chila y Anderson Suarez");
        LNosotros2 = new JLabel("Estudiantes de Ingenieria de Sistemas");
        LNosotros3 = new JLabel("Universidad Cundinamarca sede Facatativa");
        LNosotros4 =  new JLabel("");
        setVisible(true);
        
        dialogTabla = new DialogoVistaTabla(this);
}
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(AYUDA)) {
            dialogoAyuda = new JDialog();
            dialogoAyuda.setSize(400, 200);
            dialogoAyuda.setLocation(500, 200);
            LAyuda1.setBounds(10, 10, 300, 20);
            LAyuda2.setBounds(10, 20, 300, 20);
            LAyuda3.setBounds(10, 30, 1, 1);
            dialogoAyuda.add(LAyuda1);
            dialogoAyuda.add(LAyuda2);
            dialogoAyuda.add(LAyuda3);
            dialogoAyuda.setVisible(true);
        } 
        else if(e.getActionCommand().equals(NOSOTROS) ){
            dialogoNosotros = new JDialog();
            dialogoNosotros.setSize(400, 200);
            dialogoNosotros.setLocation(500, 200);
            LNosotros1.setBounds(10, 10, 300, 20);
            LNosotros2.setBounds(10, 20, 300, 20);
            LNosotros3.setBounds(10, 30, 300, 20);
            LNosotros4.setBounds(10, 40, 1, 1);
            dialogoNosotros.add(LNosotros1);
            dialogoNosotros.add(LNosotros2);
            dialogoNosotros.add(LNosotros3);
            dialogoNosotros.add(LNosotros4);
            dialogoNosotros.setVisible(true);
        }
        else if(e.getActionCommand().equals(INFO)){
            
            dialogTabla.actualizarTablaCorreo();
            dialogTabla.setVisible(true);
        }
        else if(e.getActionCommand().equals(SALIR)) {
            System.exit(0);
        }
    }

    public Panel2 getPanel2() {
        return panel2;
    }
    
}