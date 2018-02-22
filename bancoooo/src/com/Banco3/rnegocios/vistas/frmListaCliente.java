
package com.Banco3.rnegocios.vistas;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
import java.util.ArrayList;
import java.util.List;
public class frmListaCliente extends JInternalFrame{
     JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jacTabla;
    
    public frmListaCliente(){    
        this.setSize(800, 600);
        setTitle("CLIENTE....");
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Cliente.");
        tabla=new JTable();
        jacTabla=new JScrollPane(tabla);
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(jacTabla,BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
           modelo=new DefaultTableModel();
           modelo.addColumn("Cedula");
           modelo.addColumn("Nombre");
           modelo.addColumn("Apellido");
           modelo.addColumn("Telefono");
           modelo.addColumn("Email");
           
          
           List<Cliente> lista=new ArrayList<>();
           try{
               ICliente clienteDao=new ClienteImpl();
               lista=clienteDao.obtener();
           }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"Error",
                JOptionPane.ERROR_MESSAGE);
    }
            
           for(Cliente est:lista){
              modelo.addRow(new Object[]{est.getCedula(),est.getNombre(),est.getApellido(),est.getTelefono(),est.getEmail()});
      
    }
           tabla.setModel(modelo);
    }
}