/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.*;
import com.Banco3.rnegocios.entidades.ClientePrestamo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ClientePrestamoImpl implements IClientePrestamo{

    @Override
    public int insertar(ClientePrestamo clienteprestamo) {
        
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO cliente_prestamo(" +
            "id, id_cliente, id_prestamo, id_sucursal)" +
            "VALUES (?, ?, ?, ?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, clienteprestamo.getId()));
        lstPar.add(new Parametro(2, clienteprestamo.getCliente().getCedula()));
        lstPar.add(new Parametro(3, clienteprestamo.getPrestamo().getId()));
        lstPar.add(new Parametro(4, clienteprestamo.getSucursal().getCodigoS()));
        
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
    public int modificar(ClientePrestamo clienteprestamo) {
  
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente_prestamo" +
        "SET id=?, id_cliente=?, id_prestamo=?, codigos=?" +
        " WHERE cedula=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, clienteprestamo.getId()));
        lstPar.add(new Parametro(2, clienteprestamo.getCliente().getCedula()));
        lstPar.add(new Parametro(3, clienteprestamo.getPrestamo().getId()));
        lstPar.add(new Parametro(4, clienteprestamo.getSucursal().getCodigoS()));
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(ClientePrestamo clienteprestamo) {
       int numFilasAfectadas = 0;
        String sql = "DELETE FROM cliente_prestamo\n" +
        " WHERE id=?" + clienteprestamo.getId();
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public ClientePrestamo obtener(int id) throws Exception {
         ClientePrestamo clienteprestamo = null;
        String sql = "SELECT id, id_cliente, id_prestamo, codigos\n" +
        "FROM cliente_prestamo where id=?";
        Conexion con = new Conexion();
        
        List<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                
                ICliente rs=new ClienteImpl();
                IPrestamo rs1=new PrestamoImpl();
                ISucursal rs2=new SucursalImpl();
                
                clienteprestamo=new ClientePrestamo();
                clienteprestamo.setId(rst.getInt(1));
                clienteprestamo.setCliente(rs.obtener(rst.getString(2)));               
                clienteprestamo.setPrestamo(rs1.obtener(rst.getInt(3)));
                clienteprestamo.setSucursal(rs2.obtener(rst.getInt(4)));  
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return clienteprestamo;
    }

    @Override
    public List<ClientePrestamo> obtener() throws Exception {
        List<ClientePrestamo> lista = new ArrayList<>();
        
        String sql = "SELECT id, id_cliente, id_prestamo, codigoS\n" +
                      "FROM cliente_prestamo";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                
                ICliente rs=new ClienteImpl();
                IPrestamo rs1=new PrestamoImpl();
                ISucursal rs2=new SucursalImpl();
                
                ClientePrestamo clienteprestamo = new ClientePrestamo();
                clienteprestamo.setId(rst.getInt(1));
                clienteprestamo.setCliente(rs.obtener(rst.getString(2)));               
                clienteprestamo.setPrestamo(rs1.obtener(rst.getInt(3)));
                clienteprestamo.setSucursal(rs2.obtener(rst.getInt(4))); 
                lista.add(clienteprestamo);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }
    
}
