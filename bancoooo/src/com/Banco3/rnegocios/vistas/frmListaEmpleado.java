/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.rnegocios.vistas;
import com.Banco3.dao.contrato.IEmpleado;
import com.Banco3.dao.impl.EmpleadoImpl;
import com.Banco3.rnegocios.entidades.Empleado;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Francisco
 */
public class frmListaEmpleado extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public frmListaEmpleado(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado de Empleados");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Id Empleado");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apelido");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("email");
        modelo.addColumn("Codigo de la Sucursal");
        
        List<Empleado> lista = new ArrayList<>();
        try {
            IEmpleado empleadoDao = new EmpleadoImpl();
            lista = empleadoDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Empleado est : lista){
            modelo.addRow(new Object[] { est.getCodigoE(), est.getNombre(), est.getApellido(), est.getDireccion(), est.getTelefono(), est.getEmail(), est.getSucursal()});
            
           tabla.setModel(modelo); 
        }
    
}
    
}
