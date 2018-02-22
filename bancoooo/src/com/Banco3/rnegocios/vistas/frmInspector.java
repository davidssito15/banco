package com.Banco3.rnegocios.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class frmInspector extends JInternalFrame {

    
    JLabel titulo0;
    
    JLabel id;

    JLabel nombres;

    JLabel apellidos;

    JLabel direccion;
    
    JLabel titulo;

    JLabel clientePrestamo;

    JTextField txid;
    JTextField txNombre;
    JTextField txApellido;
    JTextField txDireccion;
    JTextField txtitulo;
    JTextField txClientePrestamo;

    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public frmInspector() {
        this.setSize(800, 400);
        this.setBackground(Color.CYAN);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo0 = new JLabel("DATOS INSPECTOR");

        id = new JLabel("CODIGO INSPECTOR");

        nombres = new JLabel("NOMBRE");

        apellidos = new JLabel("APELLIDO");
        
        direccion = new JLabel("DIRECCION");
         
        titulo = new JLabel("TITULO");
          
        clientePrestamo = new JLabel("CLIENTE PRESTAMO");

        txid = new JTextField();
        txNombre = new JTextField();
        txApellido = new JTextField();
        txDireccion = new JTextField();
        txtitulo = new JTextField();
        txClientePrestamo = new JTextField();
        
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo0, BorderLayout.NORTH);
        pnlcentral.add(id);
        pnlcentral.add(txid);
        pnlcentral.add(nombres);
        pnlcentral.add(txNombre);
        pnlcentral.add(apellidos);
        pnlcentral.add(txApellido);
        pnlcentral.add(direccion);
        pnlcentral.add(txDireccion);
        pnlcentral.add(titulo);
        pnlcentral.add(txtitulo);
        pnlcentral.add(clientePrestamo);
        pnlcentral.add(txClientePrestamo);

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

        frmInspector frmMenu = new frmInspector();
        frmMenu.setVisible(true);

    }

    public void btnAceptarActionListener(ActionEvent e) {
        IInspector estDao = new InspectorImpl();

        try {

            Inspector est = new Inspector();
            est.setId(Integer.parseInt(txid.getText()));
            est.setNombres(txNombre.getText());
            est.setApellidos(txApellido.getText());
            est.setDireccion(txDireccion.getText());
            est.setTitulo(txtitulo.getText());

                if (estDao.insertar(est) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR !! "+ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
