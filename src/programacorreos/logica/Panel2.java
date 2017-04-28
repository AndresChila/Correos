/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacorreos.logica;
import programacorreos.VentanaPrincipal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Andres Chila
 */
public class Panel2 extends JPanel implements ActionListener{
    private VentanaPrincipal ventana;
    private JLabel LCorreo, LArroba;
    private JTextField JTCorreo;
    private List<Correo> listaCorreos;
    private Correo correo;
    private JButton BGuardar;
    private DefaultTableModel dtm;
    private DialogoVistaTabla dialogTabla;
    private int tamanio=0;
    
    public Panel2(VentanaPrincipal ventana) {
         this.ventana = ventana;
         setBorder(BorderFactory.createTitledBorder("Ingreso"));
         setLayout(null);
         
         listaCorreos = new ArrayList<Correo>();
         
         LCorreo = new JLabel("Correo: ");
         LCorreo.setBounds(350,99,120,20);
         add(LCorreo);
         
         LArroba = new JLabel("El correo debe tener un '@'. ");
         LArroba.setBounds(350,150,200,20);
         
         
         JTCorreo = new JTextField();
         JTCorreo.setBounds(400, 100, 180, 20);
         add(JTCorreo);
         
         BGuardar = new JButton("Guardar");
         BGuardar.setBounds(449, 120, 130, 20);
         BGuardar.addActionListener(this);
         add(BGuardar);
         
         EscuchaTexto el_evento = new EscuchaTexto();
         Document midoc = JTCorreo.getDocument();
         midoc.addDocumentListener(el_evento);
    }
    private class EscuchaTexto implements DocumentListener{

        @Override
        public void insertUpdate(DocumentEvent e) {
            validarCorreo();
            
        }

        @Override
        public void removeUpdate(DocumentEvent e) {

        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            
        }
        
    }
    
    private boolean validarCorreo(){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(JTCorreo.getText());
        if (mather.find() == true) {
            return true;
        }
        else if(JTCorreo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe ingresar Correo.", "Mensaje", JOptionPane.ERROR_MESSAGE);
            LCorreo.setForeground(Color.red);
            return false;
        }
        else {
            return false;
        }
        /*
        else if(tamanio > 3){
            if((JTCorreo.getText().contains("@"))){
                return true;
            }
            else{
                add(LArroba);
            }
        }
        return false;*/
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(validarCorreo()){
            correo = new Correo(JTCorreo.getText());
            listaCorreos.add(correo); 
            JOptionPane.showMessageDialog(this, "Correo creado.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            vaciarDatos();            
        }
        else{
            JOptionPane.showMessageDialog(this, "Correo no valido. Recurede que el formato del correo es: (example@dominio.com)", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void vaciarDatos() {
        JTCorreo.setText("");
        LCorreo.setForeground(Color.BLACK);
    }

    public List<Correo> getListaCorreo() {
        return listaCorreos;
    }
    
}
