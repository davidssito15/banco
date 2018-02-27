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
public class frmListaSucursal extends JInternalFrame{
    JLabel titulo;
    JTable tabla;
    DefaultTableModel modelo;

    public frmListaSucursal() {
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        titulo = new JLabel("LISTADO DE SUCURSALES");
        tabla = new JTable();
        this.add(titulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);

        cargarTabla();
    }
    
    public void cargarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Sucursal: ");
        modelo.addColumn("Nombre del Banco: ");
        modelo.addColumn("Ciudad: ");
        modelo.addColumn("Direccion: ");
        modelo.addColumn("Telefono: ");
        modelo.addColumn("Email: ");

        List<Sucursal> lista = new ArrayList<>();
        try {
            ISucursal sucursalDao = new SucursalImpl();
            lista = sucursalDao.obtener();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
        for (Sucursal sucursal : lista) {
            modelo.addRow(new Object[]{sucursal.getCodigoS(), sucursal.getNombreBanco().toString(), sucursal.getCiudad(), sucursal.getDireccion(), sucursal.getTelefono(),sucursal.getEmail()});
        }
        tabla.setModel(modelo);
    }
    
}
