/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.ICuenta;
import com.Banco3.dao.contrato.IEmpleado;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.rnegocios.entidades.Cuenta;
import com.Banco3.rnegocios.entidades.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class CuentaImpl implements ICuenta {

    @Override
    public int insertar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO cuenta(\n"
                + "            id, nombre)\n"
                + "    VALUES (?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getId()));
        lstPar.add(new Parametro(2, cuenta.getNombre()));
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
    public int modificar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta\n"
                + "   SET nombre=?\n"
                + " WHERE id=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getNombre()));
        lstPar.add(new Parametro(2, cuenta.getId()));
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
    public int eliminar(Cuenta cuenta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM cuenta\n"
                + " WHERE id=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuenta.getId()));
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
    public Cuenta obtener(int id) throws Exception {
        Cuenta cuenta = null;
        String sql = "SELECT id, nombre\n"
                + "  FROM cuenta where id=?";
        Conexion con = new Conexion();

        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                cuenta=new Cuenta();
                cuenta.setId(rst.getInt(1));
                cuenta.setNombre(rst.getString(2));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cuenta;
    }

    @Override
    public List<Cuenta> obtener() throws Exception {
        List<Cuenta> lista = new ArrayList<>();
        String sql = "SELECT id, nombre\n"
                + "  FROM cuenta";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setId(rst.getInt(1));
                cuenta.setNombre(rst.getString(2));
                lista.add(cuenta);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
