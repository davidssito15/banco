package com.Banco3.rnegocios.vistas;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.rnegocios.entidades.*;
import com.Banco3.dao.impl.*;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
public class frmPedido extends JInternalFrame{
List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    List<Inspector> lstInspector;
    JComboBox<Inspector> cmbInspector;
    List<Prestamo> lstPrestamo;
    JComboBox<Prestamo> cmbPrestamo;
    JLabel resultado;
    JLabel titulo0;
    JLabel codigo;

    JLabel Cliente;
    JLabel Inspector;
    JLabel prpedidoamo;
    
    JTextField txtCodigo;
    JTextField txtResultado;    

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public frmPedido() {
        this.setSize(800, 400);
        this.setBackground(Color.CYAN);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS PEDIDO");

        codigo = new JLabel("CODIGO PEDIDO");
        Cliente  = new JLabel("CLIENTE");
        Inspector = new JLabel("INSPECTOR");
        prpedidoamo = new JLabel("PRESTAMO");
        resultado = new JLabel("RESULTADO");

        txtCodigo= new JTextField();
        CargarClientes();
        cmbCliente = new JComboBox(lstCliente.toArray());
        CargarInspectores();
        cmbInspector = new JComboBox(lstInspector.toArray());
        CargarPrestamos();
        cmbPrestamo = new JComboBox(lstPrestamo.toArray());       
        txtResultado = new JTextField();
        cmbCliente = new JComboBox(lstCliente.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(codigo);
        pnlcentral.add(txtCodigo);
         pnlcentral.add(Cliente);
        pnlcentral.add(cmbCliente);
         pnlcentral.add(Inspector);
        pnlcentral.add(cmbInspector);
         pnlcentral.add(prpedidoamo);
        pnlcentral.add(cmbPrestamo);
        pnlcentral.add(txtResultado);
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error " + ex.getMessage());
                }
            }
        });
        this.add(titulo0, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);
        this.setClosable(true);

    }

    public static void main(String[] args) {

        frmPedido frmMenu = new frmPedido();
        frmMenu.setVisible(true);

    }

    public void CargarClientes() {

        ICliente clienteDao = new ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CLIENTES", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public void CargarInspectores() {

        IInspector inspectorDao = new InspectorImpl();
        try {
            lstInspector = inspectorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR INSPECTORES", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public void CargarPrestamos() {

        IPrestamo prpedidoamoDao = new PrestamoImpl();
        try {
            lstPrestamo = prpedidoamoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR PRESTAMOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IPedido pedidoDao = new PedidoImpl();
        try {
            Pedido pedido = new Pedido();
            pedido.setCodigo(Integer.parseInt(txtCodigo.getText()));
            pedido.setCliente((Cliente) cmbCliente.getSelectedItem());
            pedido.setInspector((Inspector) cmbInspector.getSelectedItem());
            pedido.setPrestamo((Prestamo) cmbPrestamo.getSelectedItem());
            pedido.setResultado(txtResultado.getText());
                if (pedidoDao.insertar(pedido) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! "+ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}



