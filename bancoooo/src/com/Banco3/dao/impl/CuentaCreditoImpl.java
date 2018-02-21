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
import com.Banco3.dao.contrato.ICuentaCredito;
import com.Banco3.rnegocios.entidades.CuentaAhorro;
import com.Banco3.rnegocios.entidades.CuentaCredito;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class CuentaCreditoImpl implements ICuentaCredito {

    @Override
    public int insertar(CuentaCredito cuentacredito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO cuenta_credito(\n"
                + "            id, sobregiro, id_cuenta, id_cliente, saldo)\n"
                + "    VALUES (?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentacredito.getId()));
        lstPar.add(new Parametro(2, cuentacredito.getSobrejiro()));
        lstPar.add(new Parametro(3, cuentacredito.getCuenta().getId()));
        lstPar.add(new Parametro(4, cuentacredito.getCliente().getCedula()));
        lstPar.add(new Parametro(5, cuentacredito.getSaldo()));

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
    public int modificar(CuentaCredito cuentacredito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cuenta_credito\n"
                + "   SET sobregiro=?, id_cuenta=?, id_cliente=?, saldo=?\n"
                + " WHERE id=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentacredito.getSobrejiro()));
        lstPar.add(new Parametro(2, cuentacredito.getCuenta().getId()));
        lstPar.add(new Parametro(3, cuentacredito.getCliente().getCedula()));
        lstPar.add(new Parametro(4, cuentacredito.getSaldo()));
        lstPar.add(new Parametro(5, cuentacredito.getId()));
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
    public int eliminar(CuentaCredito cuentacredito) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM cuenta_credito\n"
                + " WHERE id=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cuentacredito.getId()));
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
    public CuentaCredito obtener(int id) throws Exception {
        CuentaCredito cuentacredito = null;
        String sql = "SELECT id, sobregiro, id_cuenta, id_cliente, saldo\n"
                + "  FROM cuenta_credito where id=?";
        Conexion con = new Conexion();

        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                ICuenta cu = new CuentaImpl();
                ICliente cli = new ClienteImpl();
                cuentacredito = new CuentaCredito();
                cuentacredito.setId(rst.getInt(1));
                cuentacredito.setSobrejiro(rst.getDouble(2));
                cuentacredito.setCuenta(cu.obtener(rst.getInt(3)));
                cuentacredito.setCliente(cli.obtener(rst.getString(4)));
                cuentacredito.setSaldo(rst.getDouble(5));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return cuentacredito;
    }

    @Override
    public List<CuentaCredito> obtener() throws Exception {
        List<CuentaCredito> lista = new ArrayList<>();
        String sql = "SELECT id, sobregiro, id_cuenta, id_cliente, saldo\n"
                + "  FROM cuenta_credito;";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                ICuenta cu = new CuentaImpl();
                ICliente cli = new ClienteImpl();
                CuentaCredito cuentacredito = new CuentaCredito();
                cuentacredito.setId(rst.getInt(1));
                cuentacredito.setSobrejiro(rst.getDouble(2));
                cuentacredito.setCuenta(cu.obtener(rst.getInt(3)));
                cuentacredito.setCliente(cli.obtener(rst.getString(4)));
                cuentacredito.setSaldo(rst.getDouble(5));
                lista.add(cuentacredito);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
