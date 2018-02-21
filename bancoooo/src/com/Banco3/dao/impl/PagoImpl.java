/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.IPago;
import com.Banco3.dao.contrato.IPrestamo;
import com.Banco3.rnegocios.entidades.Pago;
import com.Banco3.rnegocios.entidades.Pago;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class PagoImpl implements IPago{
    
     @Override
    public int insertar(Pago pago) {
        int numFilasAfectadas = 0;
        String sql = "insert into pago values(?,?,?,?,?)";        
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getId()));
        lstPar.add(new Parametro(2, pago.getFecha()));
        lstPar.add(new Parametro(3, pago.getValor()));
        lstPar.add(new Parametro(4, pago.getNumero_pago()));
        lstPar.add(new Parametro(5, pago.getPrestamo().getId()));
        
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
    public int modificar(Pago pago) {
        
        int numFilasAfectadas = 0;
        String sql = "update pago set numero_pago= "+pago.getNumero_pago()
                + " where  id = " + pago.getId();
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pago.getNumero_pago()));
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
    public int eliminar(Pago pago) {
        
        int numFilasAfectadas = 0;
        String sql = "delete from pago WHERE id=" + pago.getId();
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
    public Pago obtener(int id) throws Exception{
        
        Pago pago = null;
        String sql = "select id, fecha, valor, numero_pago, id_prestamo from pago where id=?";
        Conexion con = new Conexion();
        
        IPrestamo dao = new PrestamoImpl();
        
        List<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, id));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql,lstPar);
            while (rst.next()) {
                pago=new Pago();
                pago.setId(rst.getInt(1));
                pago.setFecha(rst.getDate(2));
                pago.setNumero_pago(rst.getInt(3));
                pago.setValor(rst.getDouble(4));
                pago.setPrestamo(dao.obtener(rst.getInt(5)));
               
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return pago;
        
    }

    @Override
    public List<Pago> obtener() throws Exception{
        
        
        List<Pago> lista = new ArrayList<>();
        
        String sql = "select id, fecha, valor, numero_pago, id_prestamo from pago ";
        IPrestamo dao = new PrestamoImpl();
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Pago pago = new Pago();
                pago.setId(rst.getInt(1));
                pago.setFecha(rst.getDate(2));
                pago.setNumero_pago(rst.getInt(3));
                pago.setValor(rst.getDouble(4));
                pago.setPrestamo(dao.obtener(rst.getInt(5)));
                lista.add(pago);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
        
    }

    private IPrestamo PrestamoImpl() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
