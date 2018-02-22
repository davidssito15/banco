
package com.Banco3.rnegocios.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class frmNuevoCuenta extends JInternalFrame{
    
    JLabel lblcentrado;
    JLabel lblcodigo;
    JLabel lblNumCuenta;
    JLabel lblTipoCuenta;
    JLabel lblSaldo;
    JLabel lblMovimiento;
    
    
    JTextField txtcentrado;
    JTextField txtcodigo;
    JTextField txtNumCuenta;
    JTextField txtTipoCuenta;
    JTextField txtSaldo;
    JTextField txtMovimiento;
      
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    

    public frmNuevoCuenta() {
        
       this.setSize(200, 180);
       this.setLayout(new BorderLayout());
       
       pnlCentral = new JPanel();
       pnlPie = new JPanel();
       pnlCentral.setLayout(new GridLayout(2, 2, 5, 5));
       pnlPie.setLayout(new GridLayout(1, 2, 5, 5));
       
       lblcentrado = new JLabel("Cuenta");
       
       lblcodigo = new JLabel("Codigo:"); 
       lblNumCuenta = new JLabel("NumCuenta:");
       lblTipoCuenta = new JLabel("TipoCuenta:");
       lblSaldo = new JLabel("Saldo:");
       lblMovimiento = new JLabel("Movimiento:");
       
       txtcodigo  = new JTextField(2);
       txtNumCuenta= new JTextField(2);
       txtTipoCuenta= new JTextField(2);
       txtSaldo= new JTextField(2);
       txtMovimiento= new JTextField(2);
       
       
       
       btnLimpiar = new JButton("Limpiar");
       btnAceptar = new JButton("Aceptar");   
       
       pnlCentral.add(lblcodigo) ;
       pnlCentral.add(txtcodigo) ;
       pnlCentral.add(lblNumCuenta) ;
       pnlCentral.add(txtNumCuenta);
       pnlCentral.add(lblTipoCuenta) ;
       pnlCentral.add(txtTipoCuenta);
       pnlCentral.add(lblSaldo) ;
       pnlCentral.add(txtSaldo);
       pnlCentral.add(lblMovimiento) ;
       pnlCentral.add(txtMovimiento);
       
       pnlPie.add(btnLimpiar);
       pnlPie.add(btnAceptar);
        
       
       this.add(lblcentrado, BorderLayout.NORTH);
       this.add(pnlCentral, BorderLayout.CENTER);
       this.add(pnlPie, BorderLayout.SOUTH);
             
        btnAceptar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
               btnAceptarActionListener(e);
               }catch(Exception ex){
                   System.out.println("Error:"+ex.getMessage());
               }
           }

           private void btnAceptarActionListener(ActionEvent e) {
               throw new UnsupportedOperationException("Not supported yet."); }
       });    
      
    }
    
    public static void main(String[]args){
    frmNuevoCuenta frmMenu = new frmNuevoCuenta();
    frmMenu.setVisible(true);
          
    
    
}
}
