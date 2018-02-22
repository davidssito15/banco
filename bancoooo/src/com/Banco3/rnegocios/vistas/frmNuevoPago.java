
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class frmNuevoPago extends JInternalFrame{
    JLabel titulo;
    JLabel id;
    JLabel fecha;
    JLabel valor;
    JLabel numeropago;
    JLabel prestamo;

    JTextField txtTitulo1;
    JTextField txtTitulo2;
    JTextField txtTitulo3;
    JTextField txtTitulo4;

    JComboBox<Prestamo> cmbPrestamo;
    List<Prestamo> lstPrestamo;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlcentral;
    JPanel pnlpie;

    public frmNuevoPago() {
        this.setSize(400, 200);
        this.setLayout(new BorderLayout());
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(5, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
        titulo = new JLabel("DATOS PAGO");

        id = new JLabel("CODIGO PAGO: ");

        fecha = new JLabel("Fecha de pago: ");
        valor=new JLabel("Valor de pago: ");
        numeropago=new JLabel("Numero de pago: ");
        txtTitulo1 = new JTextField();
        txtTitulo2 = new JTextField();
        txtTitulo3 = new JTextField();
        txtTitulo4 = new JTextField();
        CargarPrestamos();
        cmbPrestamo=new JComboBox(lstPrestamo.toArray());
        
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        this.add(titulo, BorderLayout.NORTH);
        pnlcentral.add(id);
        pnlcentral.add(txtTitulo1);
        pnlcentral.add(fecha);
        pnlcentral.add(txtTitulo2);
        pnlcentral.add(valor);
        pnlcentral.add(txtTitulo3);
        pnlcentral.add(numeropago);
        pnlcentral.add(txtTitulo4);
        pnlcentral.add(prestamo);
        pnlcentral.add(cmbPrestamo);
        
        

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

        frmNuevoPago frmMenu = new frmNuevoPago();
        frmMenu.setVisible(true);
    }
    
    public void CargarPrestamos() {

        IPrestamo presDao = new PrestamoImpl();
        try {
            lstPrestamo = presDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR LOS PRESTAMOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }

    }
    

    public void btnAceptarActionListener(ActionEvent e) {
        IPago pagoDao = new PagoImpl();
        try {
            Pago pago = new Pago();
            pago.setId(Integer.parseInt(txtTitulo1.getText()));
            DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pago.setFecha(formatoFecha.parse(txtTitulo2.getText()));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "FECHA INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            pago.setValor(Integer.parseInt(txtTitulo3.getText()));
            pago.setNumero_pago(Integer.parseInt(txtTitulo4.getText()));
            pago.setPrestamo((Prestamo) cmbPrestamo.getSelectedItem());
                if (pagoDao.insertar(pago) > 0) {
                    JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(this, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "PROCESO CORRECTO!!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
        }

    
    }
    
    
}
