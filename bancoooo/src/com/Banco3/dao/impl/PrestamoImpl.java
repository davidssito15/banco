
package com.Banco3.dao.impl;

import com.Banco3.accesoadatos.Conexion;
import com.Banco3.accesoadatos.Parametro;
import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.IPrestamo;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.rnegocios.entidades.Prestamo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getInt;
import static javax.swing.UIManager.*;

public class PrestamoImpl implements IPrestamo {
    @Override
    public int insertar(Prestamo prestamo) {
        int numFilasAfectadas = 0;
        String sql = "INSERT INTO prestamo(\n" +
"            id, importe, id_cliente, CodigoS)\n" +
"            VALUES (?, ?, ?, ?);";
        
        List<Parametro> lstp = new ArrayList<>();
        lstp.add(new Parametro(1, prestamo.getId()));
        lstp.add(new Parametro(2, prestamo.getImporte()));
        lstp.add(new Parametro(3, prestamo.getCliente().getCedula()));
        lstp.add(new Parametro(4, prestamo.getSucursal().getCodigoS()));
        
        
        Conexion con = new Conexion();
        con.conectar();
        try {
            numFilasAfectadas = con.ejecutaComando(sql, lstp);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;    }

    @Override
    public int modificar(Prestamo prestamo) {
        int numFilasAfectadas = 0;
        String sql = "UPDATE prestamo\n" +
        "   SET  importe=?, id_cliente=?, CodigoS=?\n" +
        " WHERE id=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getImporte()));
        lstPar.add(new Parametro(2, prestamo.getCliente().getCedula()));
        lstPar.add(new Parametro(3, prestamo.getSucursal().getCodigoS()));
        lstPar.add(new Parametro(4, prestamo.getId()));
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
    public int eliminar(Prestamo prestamo) {
         int numFilasAfectadas = 0;
        String sql = "DELETE FROM prestamo\n"
                + " WHERE id=?;";
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, prestamo.getId()));
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
    public Prestamo obtener(int codigo) throws Exception {
        Prestamo pres = null;
        String sql = "SELECT id, importe, id_cliente, CodigoS\n" +
          "  FROM prestamo where id=?";
        ISucursal dao = new SucursalImpl();
        ICliente dao1 = new ClienteImpl();
        Conexion con = new Conexion();
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,1));
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql, lstPar);
            while (rst.next()) {
                pres = new Prestamo();
                pres.setId(rst.getInt(1));
                pres.setImporte(rst.getDouble(2));
                pres.setCliente(dao1.obtener(rst.getString(3)));
                pres.setSucursal(dao.obtener(rst.getInt(4)));
            }
        } catch (Exception e) {
                throw e;
        } finally {
            con.desconectar();
        }
        return pres;
    }

    @Override
    public List<Prestamo> obtener() throws Exception {
        List<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT id, importe, id_cliente, CodigoS\n" +
         "  FROM prestamo;";
        
        ISucursal dao = new SucursalImpl();
        ICliente dao1 = new ClienteImpl();
        
        Conexion con = new Conexion();
        con.conectar();
        try {
            ResultSet rst = con.ejecutarQuery(sql);
            while (rst.next()) {
                Prestamo prestamo = new Prestamo();
                prestamo.setId(rst.getInt(1));
                prestamo.setImporte(rst.getDouble(2));
                prestamo.setCliente(dao1.obtener(rst.getString(3)));
                prestamo.setSucursal(dao.obtener(rst.getInt(4)));
                
               
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }
    
    }
    
    
