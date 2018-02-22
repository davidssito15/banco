/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.*;
import com.Banco3.rnegocios.entidades.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ClienteImpl implements ICliente{

    @Override
    public int insertar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into Cliente  values (?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getTelefono()));
        lstPar.add(new Parametro(5, cliente.getEmail()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Cliente cliente) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "UPDATE Cliente SET Cedula=?, Nombre=?, Apellido=?, Telefono=?, Email=? WHERE Cedula=?";
      
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getTelefono()));
        lstPar.add(new Parametro(5, cliente.getEmail()));        
        lstPar.add(new Parametro(6, cliente.getCedula()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Cliente cliente) throws Exception {
        
        int numFilasAfectadas = 0;
        String sql = "delete  from Cliente  where Cedula=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public Cliente obtener(String cedula) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT Cedula, Nombre, Apellido, Telefono, Email" +
                     "  FROM Cliente where Cedula=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql,null);           
            while(rst.next()){
                cliente=new Cliente();
                cliente.setCedula(rst.getString(1));
                cliente.setNombre(rst.getString(2));               
                cliente.setApellido(rst.getString(3));
                cliente.setTelefono(rst.getString(4));
                cliente.setEmail(rst.getString(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> obtener() throws Exception {
        ArrayList<Cliente> lista = new ArrayList<>();
        
        String sql = "SELECT Cedula, Nombre, Apellido, Telefono, email" +
                     "  FROM Cliente";
        Conexion con = null;
       
        con.conectar();
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutarQuery(sql);
            Cliente cliente= null;
            
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setCedula(rst.getString(1));
                cliente.setNombre(rst.getString(2));               
                cliente.setApellido(rst.getString(3));
                cliente.setTelefono(rst.getString(4));
                cliente.setEmail(rst.getString(5));
                lista.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    } 
}