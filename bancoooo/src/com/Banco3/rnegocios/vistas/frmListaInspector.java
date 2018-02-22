package com.Banco3.rnegocios.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;

public class frmListaInspector extends JInternalFrame{
    JLabel titulo1;
    JTable tabla1;
    DefaultTableModel modelo1;

    public frmListaInspector() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo1 = new JLabel("LISTADO DE INSPECTORES");
        tabla1 = new JTable();
        this.add(titulo1, BorderLayout.NORTH);
        this.add(tabla1, BorderLayout.CENTER);

        cargarTabla1();
    }
    
    public void cargarTabla1() {
        modelo1 = new DefaultTableModel();
        
        modelo1.addColumn("Codigo: ");

        modelo1.addColumn("Nombre: ");

        modelo1.addColumn("Apellido: ");

        modelo1.addColumn("Direccion: ");
        
        modelo1.addColumn("Titulo: ");


        List<Inspector> lista = new ArrayList<>();
        try {
            IInspector inspectorDao = new InspectorImpl();
            lista = inspectorDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Inspector inspector : lista) {
            modelo1.addRow(new Object[]{inspector.getId(), inspector.getNombres().toString(), inspector.getApellidos(), inspector.getDireccion(), inspector.getTitulo()});
        }
        tabla1.setModel(modelo1);
    }
    
}