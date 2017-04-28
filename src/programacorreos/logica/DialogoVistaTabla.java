/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacorreos.logica;
import programacorreos.VentanaPrincipal;

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Andres Chila
 */
public class DialogoVistaTabla extends JDialog {
    JPanel panel;
    JTable tablaCorreo;
    
    private DefaultTableModel dtm;
    private VentanaPrincipal ventana;
    public DialogoVistaTabla(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setSize(300, 300);
        setTitle("Vista Tabla");
        
        panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Correos"));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        add(panel);
        
        dtm = new DefaultTableModel();
        tablaCorreo = new JTable(dtm);
        
        Object[] columna = {"Correo"};
        for (Object columna1 : columna) {
            dtm.addColumn(columna1);
        }        
        
        
        JScrollPane scrollPane = new JScrollPane(tablaCorreo);
        scrollPane.setBounds(30, 30, 240, 200);
        panel.add(scrollPane);
    }
    
    public void actualizarTablaCorreo() {
         List<Correo> lista1 = this.ventana.getPanel2().getListaCorreo();
         for (Correo correo : lista1) {
             Object[] fila = {correo.getCorreo()};
             dtm.addRow(fila);
        }
    }

    public DefaultTableModel getDtm() {
        return dtm;
    }

    public void setDtm(DefaultTableModel dtm) {
        this.dtm = dtm;
    }
    
}

