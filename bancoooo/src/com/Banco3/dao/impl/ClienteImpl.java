/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.ICliente;
import com.Banco3.rnegocios.entidades.Cliente;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ClienteImpl implements ICliente{

    @Override
    public int insertar(Cliente cliente) {
         int numFilasAfectadas = 0;
        String sql = "INSERT INTO cliente(" +
        "            cedula, nombre, apellido, celular, email)" +
        "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        lstPar.add(new Parametro(2, cliente.getNombre()));
        lstPar.add(new Parametro(3, cliente.getApellido()));
        lstPar.add(new Parametro(4, cliente.getTelefono()));
        lstPar.add(new Parametro(5, cliente.getEmail()));
        
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Cliente cliente) {
         int numFilasAfectadas = 0;
        String sql = "UPDATE cliente" +
        "   SET nombre=?, apellido=?, celular=?, email=?" +
        " WHERE cedula=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
         lstPar.add(new Parametro(1, cliente.getNombre()));
        lstPar.add(new Parametro(2, cliente.getApellido()));
        lstPar.add(new Parametro(3, cliente.getTelefono()));
        lstPar.add(new Parametro(4, cliente.getEmail()));        
        lstPar.add(new Parametro(5, cliente.getCedula()));
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql,lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Cliente cliente) {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM cliente WHERE cedula=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getCedula()));
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql,lstPar);
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
        String sql = "SELECT cedula, nombre, apellido, celular, email" +
                     "  FROM cliente where cedula=?";
        Conexion con = new Conexion();
        
        List<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, cedula));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
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
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
        
        String sql = "SELECT cedula, nombre, apellido, celular, email" +
                     "  FROM cliente";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Cliente cliente = new Cliente();
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
