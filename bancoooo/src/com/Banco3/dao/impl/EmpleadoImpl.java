/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.IEmpleado;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.rnegocios.entidades.Empleado;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class EmpleadoImpl implements IEmpleado {

    @Override
    public int insertar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO empleado(\n"
                + "            idempleado, nombre, apellido, direccion, telefono, email, id)\n"
                + "    VALUES (?, ?, ?, ?, ?, ?, ?);";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getIdEmpleado()));
        lstPar.add(new Parametro(2, empleado.getNombre()));
        lstPar.add(new Parametro(3, empleado.getApellido()));
        lstPar.add(new Parametro(4, empleado.getDireccion()));
        lstPar.add(new Parametro(5, empleado.getTelefono()));
         lstPar.add(new Parametro(6,empleado.getEmail()));
        lstPar.add(new Parametro(7, empleado.getSucursal().getId()));

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
    public int modificar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE empleado\n"
                + "   SET nombre=?, apellido=?, direccion=?, telefono=?, \n"
                + "       email=?, id=?\n"
                + " WHERE idempleado=?";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getIdEmpleado()));
        lstPar.add(new Parametro(2, empleado.getNombre()));
        lstPar.add(new Parametro(3, empleado.getApellido()));
        lstPar.add(new Parametro(4, empleado.getDireccion()));
        lstPar.add(new Parametro(5, empleado.getTelefono()));
         lstPar.add(new Parametro(6,empleado.getEmail()));
        lstPar.add(new Parametro(7, empleado.getSucursal().getId()));
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
    public int eliminar(Empleado empleado) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM empleado\n"
                + " WHERE id=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, empleado.getIdEmpleado()));
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
    public Empleado obtener(int id) throws Exception {
        Empleado empleado = null;
        String sql = "SELECT idempleado, nombre, apellido, direccion, telefono, email, id\n"
                + "  FROM empleado where idempleado=?";
        Conexion con = new Conexion();

        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                IEmpleado ob = new EmpleadoImpl();
                ISucursal su = new SucursalImpl();
                empleado = new Empleado();
                empleado.setIdEmpleado(rst.getInt(1));
                empleado.setNombre(rst.getString(2));
                empleado.setApellido(rst.getString(3));
                empleado.setCedula(rst.getString(4));
                empleado.setDireccion(rst.getString(5));
                empleado.setTelefono(rst.getString(6));
           
                empleado.setSucursal(su.obtener(rst.getInt(7)));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return empleado;
    }

    @Override
    public List<Empleado> obtener() throws Exception {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT idempleado, nombre, apellido,  direccion, telefono, email, id\n"
                + "  FROM empleado";
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Empleado empleado;
                IEmpleado ob = new EmpleadoImpl();
                ISucursal su = new SucursalImpl();
                empleado = new Empleado();
                empleado.setIdEmpleado(rst.getInt(1));
                empleado.setNombre(rst.getString(2));
                empleado.setApellido(rst.getString(3));
                empleado.setCedula(rst.getString(4));
                empleado.setDireccion(rst.getString(5));
                empleado.setTelefono(rst.getString(6));
                empleado.setSucursal(su.obtener(rst.getInt(7)));
                lista.add(empleado);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
