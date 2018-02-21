/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.IClientePrestamo;
import com.Banco3.dao.contrato.IInspector;
import com.Banco3.rnegocios.entidades.Inspector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class InspectorImpl implements IInspector {

    @Override
    public int insertar(Inspector inspector) throws Exception {
          int numFilasAfectadas = 0;
        String sql = "INSERT INTO inspector VALUES (?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getId()));
        lstPar.add(new Parametro(2, inspector.getNombres()));
        lstPar.add(new Parametro(3, inspector.getApellidos()));
        lstPar.add(new Parametro(4, inspector.getDireccion()));
        lstPar.add(new Parametro(5, inspector.getTitulo()));
        lstPar.add(new Parametro(6, inspector.getClientePrestamo().getId()));
      
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
    public int modificar(Inspector inspector) throws Exception {
            int numFilasAfectadas = 0;
        String sql = "UPDATE  inspector  SET nombres=?, apelldos=?, direccion=?, titulo=?, id_clientePrestamo=?"
                + " WHERE id=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getNombres()));
        lstPar.add(new Parametro(2, inspector.getApellidos()));
        lstPar.add(new Parametro(3, inspector.getDireccion()));
        lstPar.add(new Parametro(4, inspector.getTitulo()));
        lstPar.add(new Parametro(5, inspector.getId()));
        lstPar.add(new Parametro(6, inspector.getClientePrestamo().getId()));
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
    public int eliminar(Inspector inspector) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "delete from inspector WHERE id=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, inspector.getId()));
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
    public Inspector obtener(int id) throws Exception {
        Inspector insp = null;
        String sql = "SELECT id, nombres, apellidos, direccion, tutulo, clientePrestamo"
                + "  FROM inspector where id=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        IClientePrestamo dao = new ClientePrestamoImpl();
        lstPar.add(new Parametro(1, id));
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                
                insp = new Inspector();
                insp.setId(rst.getInt(1));
                insp.setNombres(rst.getString(2));
                insp.setApellidos(rst.getString(3));
                insp.setDireccion(rst.getString(4));
                insp.setTitulo(rst.getString(5));
                insp.setClientePrestamo(dao.obtener(rst.getInt(6)));
              
            }
        } catch (Exception e) {
            throw e;
        }
        return insp; 
    }

    @Override
    public List<Inspector> obtener() throws Exception {
        ClientePrestamoImpl dao = new ClientePrestamoImpl();
        List<Inspector> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, direccion, titulo, clientePrestamo"
                + "  FROM inspector";
        Conexion con = new Conexion();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Inspector insp = new Inspector();
                insp.setId(rst.getInt(1));
                insp.setNombres(rst.getString(2));
                insp.setApellidos(rst.getString(3));
                insp.setDireccion(rst.getString(4));
                insp.setTitulo(rst.getString(5));
                insp.setClientePrestamo(dao.obtener(rst.getInt(6)));
                lista.add(insp);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
    
}
