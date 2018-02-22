
package com.Banco3.rnegocios.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;

public class frmListaPrestamo extends JInternalFrame{
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public frmListaPrestamo() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE PRESTAMOS");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();
    }
    
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo: ");

        modelo.addColumn("Importe: ");

        modelo.addColumn("Cliente: ");

        modelo.addColumn("Sucursal: ");


        List<Prestamo> lista = new ArrayList<>();
        try {
            IPrestamo presDao = new PrestamoImpl();
            lista = presDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Prestamo pres : lista) {
            modelo.addRow(new Object[]{pres.getId(), pres.getImporte(), pres.getCliente().getCedula(), pres.getSucursal().getId()});
        }
        tabla.setModel(modelo);
    }
    
    
    
}
