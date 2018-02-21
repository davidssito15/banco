/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.ICuenta;
import com.Banco3.dao.contrato.ICuentaAhorro;
import com.Banco3.dao.contrato.IEmpleado;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.rnegocios.entidades.CuentaAhorro;
import com.Banco3.rnegocios.entidades.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class CuentaAhorroImpl implements ICuentaAhorro {

    @Override
    public int insertar(CuentaAhorro cuentaahorro) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO cuenta_ahorro(\n"
                + "            id, interes, id_cuenta, id_cliente, saldo)\n"
                + "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentaahorro.getId()));
        lstPar.add(new Parametro(2, cuentaahorro.getInteres()));
        lstPar.add(new Parametro(3, cuentaahorro.getCuenta().getId()));
        lstPar.add(new Parametro(4, cuentaahorro.getCliente().getCedula()));
        lstPar.add(new Parametro(5, cuentaahorro.getSaldo()));

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
    public int modificar(CuentaAhorro cuentaahorro) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta_ahorro\n"
                + "   SET interes=?, id_cuenta=?, id_cliente=?, saldo=?\n"
                + " WHERE id=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentaahorro.getInteres()));
        lstPar.add(new Parametro(2, cuentaahorro.getCuenta().getId()));
        lstPar.add(new Parametro(3, cuentaahorro.getCliente().getCedula()));
        lstPar.add(new Parametro(4, cuentaahorro.getSaldo()));
        lstPar.add(new Parametro(5, cuentaahorro.getId()));
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
    public int eliminar(CuentaAhorro cuentaahorro) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM cuenta_ahorro\n"
                + " WHERE id=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentaahorro.getId()));
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
    public CuentaAhorro obtener(int id) throws Exception {
        CuentaAhorro cuentaahorro = null;
        String sql = "SELECT id, interes, id_cuenta, id_cliente, saldo\n"
                + "  FROM cuenta_ahorro where id=?";
        Conexion con = new Conexion();

        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                ICuenta cu = new CuentaImpl();
                ICliente cli = new ClienteImpl();
                cuentaahorro = new CuentaAhorro();
                cuentaahorro.setId(rst.getInt(1));
                cuentaahorro.setInteres(rst.getDouble(2));
                cuentaahorro.setCuenta(cu.obtener(rst.getInt(3)));
                cuentaahorro.setCliente(cli.obtener(rst.getString(4)));
                cuentaahorro.setSaldo(rst.getDouble(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cuentaahorro;
    }

    @Override
    public List<CuentaAhorro> obtener() throws Exception {
        List<CuentaAhorro> lista = new ArrayList<>();
        String sql = "SELECT id, interes, id_cuenta, id_cliente, saldo\n"
                + "  FROM cuenta_ahorro";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                ICuenta cu = new CuentaImpl();
                ICliente cli = new ClienteImpl();
                CuentaAhorro cuentaahorro = new CuentaAhorro();
                cuentaahorro.setId(rst.getInt(1));
                cuentaahorro.setInteres(rst.getDouble(2));
                cuentaahorro.setCuenta(cu.obtener(rst.getInt(3)));
                cuentaahorro.setCliente(cli.obtener(rst.getString(4)));
                cuentaahorro.setSaldo(rst.getDouble(5));
                lista.add(cuentaahorro);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
