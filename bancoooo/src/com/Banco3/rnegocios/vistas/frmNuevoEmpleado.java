/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.rnegocios.vistas;

import com.Banco3.dao.contrato.IEmpleado;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.EmpleadoImpl;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.Empleado;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Francisco
 */
public class frmNuevoEmpleado extends JInternalFrame{
    
    List<Sucursal> lstSucursal;
    JComboBox<Sucursal> cmbSucursal;
    JLabel lblTitulo0;
    JLabel lblcodigo;
    JLabel lblnombre;
    JLabel lblapellido;
    JLabel lbldireccion;
    JLabel lbltelefono;
    JLabel lblemail;
    
    JTextField txtcodigo;
    JTextField txtnombre;
    JTextField txtapellido;
    JTextField txtdireccion;
    JTextField txttelefono;
    JTextField txtemail;
 
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
    
     public frmNuevoEmpleado() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos del Empleado");
        
        lblcodigo= new JLabel("Código:");
        lblnombre= new JLabel("Nombre:");
        lblapellido = new JLabel("Apellido:");
        lbldireccion = new JLabel("direccion:");
        lbltelefono = new JLabel("telefono:");
        lblemail = new JLabel("email:");

        txtcodigo = new JTextField(2);
        txtnombre = new JTextField(2);
        txtapellido = new JTextField(2);
        txtdireccion = new JTextField(2);
        txttelefono = new JTextField(2);
        txtemail = new JTextField(2); 
        cargarSucursal();
        cmbSucursal = new JComboBox(lstSucursal.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblcodigo);
        pnlCentral.add(txtcodigo);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblapellido);
        pnlCentral.add(txtapellido);
        pnlCentral.add(lbldireccion);
        pnlCentral.add(txtdireccion);
        pnlCentral.add(lbltelefono);
        pnlCentral.add(txttelefono);
        pnlCentral.add(lblemail);
        pnlCentral.add(txtemail);
        pnlCentral.add(lblTitulo0);
        pnlCentral.add(cmbSucursal);
        
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
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        frmNuevoSucursal frmMenu= new frmNuevoSucursal();
        frmMenu.setVisible(true);
    } 
    public void cargarSucursal(){
        ISucursal sucursalDao = new SucursalImpl();
        try {
            lstSucursal = sucursalDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los cursos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IEmpleado empleadoDao = new EmpleadoImpl();
        Empleado empleado = new Empleado();
        empleado.setCodigoE(Integer.parseInt(txtcodigo.getText()));
        empleado.setNombre(txtnombre.getText());
        empleado.setApellido(txtapellido.getText());
        empleado.setDireccion(txtdireccion.getText());
        empleado.setTelefono(txttelefono.getText());
        empleado.setEmail(txtemail.getText());
        
        
        
        empleado.setSucursal((Sucursal) cmbSucursal.getSelectedItem());
        
        try {
            if(empleadoDao.insertar(empleado)>0){
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
