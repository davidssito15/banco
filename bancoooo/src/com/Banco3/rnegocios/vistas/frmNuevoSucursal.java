/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.rnegocios.vistas;

import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Francisco
 */
public class frmNuevoSucursal extends JInternalFrame{
    JLabel titulo;
    JLabel id;
    JLabel nombrebanco;
    JLabel ciudad;
    JLabel direccion;
    JLabel telefono;
    JLabel email;

    JTextField txtid;
    JTextField txtnombrebanco;
    JTextField txtciudad;
    JTextField txtdireccion;
    JTextField txttelefono;
    JTextField txtemail;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public frmNuevoSucursal() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        titulo= new JLabel("Datos de la Sucursal");
        
        id= new JLabel("Id de la Sucursal:");
        nombrebanco= new JLabel("Nombre:");
        ciudad= new JLabel("Ciudad:");
        direccion = new JLabel("Direccion:");
        telefono = new JLabel("Telefono:");
        email = new JLabel("Email:");
       

        txtid = new JTextField(2);
        txtnombrebanco = new JTextField(2);
        txtciudad= new JTextField(2);
        txtdireccion = new JTextField(2);
        txttelefono= new JTextField(2);
        txtemail= new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(id);
        pnlCentral.add(txtid);
        pnlCentral.add(nombrebanco);
        pnlCentral.add(txtnombrebanco);
        pnlCentral.add(ciudad);
        pnlCentral.add(txtciudad);
        pnlCentral.add(direccion);
        pnlCentral.add(txtdireccion);
        pnlCentral.add(telefono);
        pnlCentral.add(txttelefono);
        pnlCentral.add(email);
        pnlCentral.add(txtemail);
              
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        frmNuevoSucursal frmMenu= new frmNuevoSucursal();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        ISucursal sucursalDao = new SucursalImpl();
        Sucursal sucursal = new Sucursal();
        sucursal.setCodigoS(Integer.parseInt(txtid.getText()));
        sucursal.setNombreBanco(txtnombrebanco.getText());
        sucursal.setCiudad(txtciudad.getText());
        sucursal.setDireccion(txtdireccion.getText());
        sucursal.setTelefono(txttelefono.getText());
        sucursal.setEmail(txtemail.getText());
        
        try {
            if(sucursalDao.insertar(sucursal)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
