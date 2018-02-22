
package com.Banco3.dao.impl;


import com.Banco3.accesoadatos.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.rnegocios.entidades.*;
import java.sql.*;
import java.util.*;

public class PedidoImpl implements IPedido{
    @Override
    public int insertar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "Insert into pedido VALUES (?,?,?,?,?,)";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, pedido.getCodigo()));
        listParametro.add(new Parametro(2, pedido.getCliente().getNombre()));
        listParametro.add(new Parametro(3, pedido.getInspector().getId()));
        listParametro.add(new Parametro(4, pedido.getPrestamo().getId()));
        listParametro.add(new Parametro(5, pedido.getResultado()));
        
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Pedido pedido) throws Exception {
        int numFilasAfectadas= 0;
        String sql = "UPDATE Pedido SET CodigoP=?, CodigoC=?, CodigoI=?, CodigoPr=?, Resultado WHERE codigo=?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, pedido.getCodigo()));
        listParametro.add(new Parametro(2, pedido.getCliente().getNombre()));
        listParametro.add(new Parametro(3, pedido.getInspector().getId()));
        listParametro.add(new Parametro(4, pedido.getPrestamo().getId()));
        listParametro.add(new Parametro(5, pedido.getResultado()));
        Conexion conec=null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas=conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec !=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Pedido pedido) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "DELETE FROM Pedido WHERE codigo?";
        ArrayList<Parametro> listParametro = new ArrayList<>();
        listParametro.add(new Parametro(1, pedido.getCodigo()));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            numFilasAfectadas = conec.ejecutaComando(sql, listParametro);
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return numFilasAfectadas;
    }

    @Override
    public Pedido obtener(int codigo) throws Exception {
        Pedido pedido = null;
        String sql = "SELECT CodigoP, CodigoC, CodigoI, CodigoPr, Resultado FROM Pedido where codigo = ?";
        ArrayList<Parametro> listadoParametros = new ArrayList<>();
        listadoParametros.add(new Parametro(1, codigo));
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, listadoParametros);
            while (resultado.next()) {
                pedido = new Pedido();
                pedido.setCodigo(resultado.getInt(1));
                ICliente clientedao=new ClienteImpl();
                Cliente cliente=clientedao.obtener(resultado.getString(2));
                pedido.setCliente(cliente);
                IInspector inspectordao=new InspectorImpl();
                Inspector inspector=inspectordao.obtener(resultado.getInt(3));
                pedido.setInspector(inspector);
                IPrestamo prestamodao=new PrestamoImpl();
                Prestamo prestamo=prestamodao.obtener(resultado.getInt(4));
                pedido.setPrestamo(prestamo);
                pedido.setResultado(resultado.getString(5));
                
                //pedido.setDireccion(resultado.getObject(9)!=null? resultado.getString(9):null);
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return pedido;
    }

    @Override
    public ArrayList<Pedido> obtener() throws Exception {
        ArrayList<Pedido> lista = new ArrayList<>();
        String sql = "SELECT Cod_pedido, Cedula, Nombre, Apellido, Fecha_nacimiento, Fecha_ingreso, Telefono, Sexo, Direccion, cod_c FROM Pedido";
        Conexion conec = null;
        try {
            conec = new Conexion();
            conec.conectar();
            ResultSet resultado = conec.ejecutarQuery(sql, null);
            Pedido pedido=null;
            while (resultado.next()) {
                pedido = new Pedido();
                pedido.setCodigo(resultado.getInt(1));
                ICliente clientedao=new ClienteImpl();
                Cliente cliente=clientedao.obtener(resultado.getString(2));
                pedido.setCliente(cliente);
                IInspector inspectordao=new InspectorImpl();
                Inspector inspector=inspectordao.obtener(resultado.getInt(3));
                pedido.setInspector(inspector);
                IPrestamo prestamodao=new PrestamoImpl();
                Prestamo prestamo=prestamodao.obtener(resultado.getInt(4));
                pedido.setPrestamo(prestamo);
                pedido.setResultado(resultado.getString(5));
                lista.add(pedido);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(conec!=null){
            conec.desconectar();}
        }
        return lista;
    }

    
}
