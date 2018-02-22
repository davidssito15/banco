
package com.Banco3.rnegocios.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;

public class frmListaPago extends JInternalFrame{
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public frmListaPago() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE PAGOS");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();
    }
    
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo: ");

        modelo.addColumn("Fecha: ");

        modelo.addColumn("Valor: ");

        modelo.addColumn("Numero de pago: ");
        
        modelo.addColumn("Prestamo: ");


        List<Pago> lista = new ArrayList<>();
        try {
            IPago pagoDao = new PagoImpl();
            lista = pagoDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Pago pago : lista) {
            modelo.addRow(new Object[]{pago.getId(), pago.getFecha().toString(), pago.getValor(), pago.getNumero_pago(), pago.getPrestamo().getId()});
        }
        tabla.setModel(modelo);
    }
    
}
