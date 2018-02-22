
package com.Banco3.rnegocios.vistas;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;


public class frmNuevoCliente extends JInternalFrame{
    JLabel titulo;
    ;
    JLabel cedula;
    JLabel nombre;
    JLabel apellido;
    JLabel telefono;
    JLabel email;
    
    
   // 
   
   
    JTextField txtcedula;
    JTextField txtnombres;
    JTextField txtapellidos;
    JTextField txttelefono;
    JTextField txtemail;
   
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlcentral;
    JPanel pnlpie;

    public frmNuevoCliente() {
        this.setSize(500, 500);
        setTitle("Cliente....");
         
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlcentral = new JPanel();
        pnlpie = new JPanel();

        pnlcentral.setLayout(new GridLayout(7, 2, 5, 5));
        pnlpie.setLayout(new GridLayout(1, 2, 5, 5));
  
       
        titulo = new JLabel("                     DATOS DEL CLIENTE..   ");
        
        cedula = new JLabel("  CEDULA: ");
        txtcedula = new JTextField(2);
        nombre = new JLabel("  NOMBRES: ");
        txtnombres = new JTextField(2);
        apellido = new JLabel("  APELLIDOS: ");
        txtapellidos = new JTextField(2);
        telefono = new JLabel("  TELEFONO: ");
        txttelefono = new JTextField(2);
        email = new JLabel("  EMAIL: ");
        txtemail= new JTextField(2);
        
        
        
//      
        btnLimpiar = new JButton("LIMPIAR");
        btnAceptar = new JButton("ACEPTAR");
        pnlcentral.setBackground(Color.green);
        this.add(titulo, BorderLayout.NORTH);
        
        pnlcentral.add(titulo);  
        pnlcentral.add(cedula);
        pnlcentral.add(txtcedula);
        pnlcentral.add(nombre); 
        pnlcentral.add(txtnombres);
        pnlcentral.add(apellido);
        pnlcentral.add(txtapellidos);
        pnlcentral.add(telefono);
        pnlcentral.add(txttelefono);
        pnlcentral.add(email);
        pnlcentral.add(txtemail);
        
    
 
        pnlpie.add(btnLimpiar);
        pnlpie.add(btnAceptar);
        
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.print("error "+ex.getMessage());
                }
            }
        });
        
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnLimpiarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });

         
        this.add(titulo, BorderLayout.NORTH);
        this.add(pnlcentral, BorderLayout.CENTER);
        this.add(pnlpie, BorderLayout.SOUTH);

    }
      public static void main(String[] args) {
        
        frmNuevoCliente frmD = new frmNuevoCliente();
        frmD.setVisible(true);   
    }
      
      public void btnLimpiarActionListener(ActionEvent e){
           
            txtcedula.setText("");
            txtnombres.setText("");
            txtapellidos.setText("");
            txtemail.setText("");
            txttelefono.setText("");
            
       }
    public void btnAceptarActionListener(ActionEvent e){
   
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente();
     
        cliente.setCedula(txtcedula.getText());
        cliente.setNombre(txtnombres.getText());
        cliente.setApellido(txtapellidos.getText());
        cliente.setTelefono(txttelefono.getText());
        cliente.setEmail(txtemail.getText());
        
        try {
            if (clienteDao.insertar(cliente) > 0) {
                JOptionPane.showMessageDialog(this, "Guardado Correctamente!!",
                        "Transacción", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error desconocido: ",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar!!: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
