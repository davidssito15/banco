package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.IPrestamo;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.ClienteImpl;
import com.Banco3.dao.impl.PrestamoImpl;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.Cliente;
import com.Banco3.rnegocios.entidades.Prestamo;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author usuario
 */
public class TPrestamo {

    public TPrestamo() {
    }

    @Test
    public void pruebaPrestamo() throws Exception {
        ISucursal daosucursal = new SucursalImpl();
        ICliente daocliente = new ClienteImpl();
        IPrestamo daoprestamo = new PrestamoImpl();
        int codigoprueba = 156;
        Prestamo prestamo = new Prestamo(codigoprueba, 25000, daocliente.obtener("060440535-7"), daosucursal.obtener(10));
        //insertar
        int insertado = daoprestamo.insertar(prestamo);
        assertTrue(insertado > 0);

//        Listar uno
        Prestamo obtenido = null;
        try {
            obtenido=new Prestamo();
            obtenido = daoprestamo.obtener(codigoprueba);
        } catch (Exception e) {
        }
        assertTrue(obtenido != null);

        //   modificar
        int modificados = 0;
        Sucursal sucursal=new Sucursal();
        sucursal=daosucursal.obtener(10);
        Cliente cliente=new Cliente();
        cliente=daocliente.obtener("060440535-7");
        Prestamo prestamo1=new Prestamo();
        prestamo1.setId(codigoprueba);
        prestamo1.setImporte(5895);
        prestamo1.setCliente(cliente);
        prestamo1.setSucursal(sucursal);
        try {
            modificados = daoprestamo.modificar(prestamo1);
        } catch (Exception e) {
        }
        assertTrue(modificados > 0);

        //Listar Todo
        List<Prestamo> lst = new ArrayList<>();
        try {
            lst=daoprestamo.obtener();
            for(Prestamo i:lst){
                System.out.println(i.getCliente().getApellido());
            }
        } catch (Exception e) {
        }
        assertTrue(lst!=null);

        //eliminado

        int eliminado = codigoprueba;
        eliminado = daoprestamo.eliminar(prestamo);
        assertTrue(eliminado > 0);

    }

}
