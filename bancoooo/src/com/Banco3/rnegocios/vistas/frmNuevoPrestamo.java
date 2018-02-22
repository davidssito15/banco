
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
import java.util.*;


public class frmNuevoPrestamo extends JInternalFrame{
    JLabel titulo;
    JLabel id;
    JLabel importe;
    JLabel cliente;
    JLabel sucursal;

    JTextField txtTitulo1;
    JTextField txtTitulo2;

    JComboBox<Cliente> cmbCliente;
    List<Cliente> lstCliente;
    JComboBox<Sucursal> cmbSucursal;
    List<Sucursal> lstSucursal;
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public frmNuevoPrestamo() {
        this.setSize(400, 200);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(4, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo = new JLabel("DATOS PRESTAMO");

        id = new JLabel("CODIGO PRESTAMO: ");

        importe = new JLabel("IMPORTE: ");
        txtTitulo1 = new JTextField();
        txtTitulo2 = new JTextField();
        CargarClientes();
        cmbCliente=new JComboBox(lstCliente.toArray());
        CargarSucursales();
        cmbSucursal=new JComboBox(lstSucursal.toArray());
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo, BorderLayout.NORTH);
        pnlcentral.add(id);
        pnlcentral.add(txtTitulo1);
        pnlcentral.add(importe);
        pnlcentral.add(txtTitulo2);
        pnlcentral.add(cliente);
        pnlcentral.add(cmbCliente);
        pnlcentral.add(sucursal);
        pnlcentral.add(cmbSucursal);

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
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);
        this.setClosable(true);
    }

    public static void main(String[] args) {

        frmNuevoPrestamo frmMenu = new frmNuevoPrestamo();
        frmMenu.setVisible(true);
    }
    
    public void CargarClientes() {

        ICliente clienteDao = new ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS CLIENTES", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    public void CargarSucursales() {

        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS SUCURSALES", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IPrestamo presDao = new PrestamoImpl();
        try {
            Prestamo pres = new Prestamo();
            pres.setId(Integer.parseInt(txtTitulo1.getText()));
            pres.setImporte(Integer.parseInt(txtTitulo2.getText()));
            pres.setCliente((Cliente) cmbCliente.getSelectedItem());
                if (presDao.insertar(pres) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            pres.setSucursal((Sucursal) cmbSucursal.getSelectedItem());
                if (presDao.insertar(pres) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    }
    
    
    

