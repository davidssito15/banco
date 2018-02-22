package com.Banco3.rnegocios.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
import javax.swing.JInternalFrame;

public class frmListaPedido extends JInternalFrame{
    JLabel titulo1;
    JTable tabla1;
    DefaultTableModel modelo1;

    public frmListaPedido() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo1 = new JLabel("LISTADO DE PEDIDOS");
        tabla1 = new JTable();
        this.add(titulo1, BorderLayout.NORTH);
        this.add(tabla1, BorderLayout.CENTER);

        cargarTabla1();
    }
    
    public void cargarTabla1() {
        modelo1 = new DefaultTableModel();
        
        modelo1.addColumn("Codigo: ");

        modelo1.addColumn("Cliente: ");

        modelo1.addColumn("Pedido: ");

        modelo1.addColumn("Prestamo: ");
        
        modelo1.addColumn("Resultado: ");


        List<Pedido> lista = new ArrayList<>();
        try {
            IPedido pedidorDao = new PedidoImpl();
            lista = pedidorDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Pedido pedido : lista) {
            modelo1.addRow(new Object[]{pedido.getCodigo(), pedido.getCliente().getNombre(), pedido.getInspector().getId(), pedido.getPrestamo().getId(), pedido.getResultado()});
        }
        tabla1.setModel(modelo1);
    }
    
}

