/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.*;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class SucursalImpl implements ISucursal{
    @Override
    public int insertar(Sucursal sucursal) {
        int numFilasAfectadas = 0;
        String sql = "insert into sucursal values(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getId()));
        lstPar.add(new Parametro(2, sucursal.getCiudad()));
        
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
    public int modificar(Sucursal sucursal) {
        
        int numFilasAfectadas = 0;
        String sql = "update sucursal set ciudad= '"+sucursal.getCiudad()
                + "' where  id = " + sucursal.getId();
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, sucursal.getCiudad()));
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
    public int eliminar(Sucursal sucursal) {
        
        int numFilasAfectadas = 0;
        String sql = "delete from sucursal WHERE id=" + sucursal.getId();
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
    public Sucursal obtener(int id) throws Exception{
        
        Sucursal sucursal = null;
        String sql = "select id, ciudad from sucursal where id=?";
        Conexion con = new Conexion();
        
        List<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                sucursal=new Sucursal();
                sucursal.setId(rst.getInt(1));
                sucursal.setCiudad(rst.getString(2));               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return sucursal;
        
    }

    @Override
    public List<Sucursal> obtener() throws Exception{
        
        
        List<Sucursal> lista = new ArrayList<>();
        
        String sql = "select id, ciudad from sucursal";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setId(rst.getInt(1));
                sucursal.setCiudad(rst.getString(2));
                lista.add(sucursal);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
        
    }
    
}
