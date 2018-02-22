package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.IClientePrestamo;
import com.Banco3.dao.contrato.IPrestamo;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.ClienteImpl;
import com.Banco3.dao.impl.ClientePrestamoImpl;
import com.Banco3.dao.impl.PrestamoImpl;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.ClientePrestamo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TClientePrestamo {
    
    public TClientePrestamo() {
    }
    @Test
    public void pruebaClientePrestamo() throws Exception{
        //Insercion
        ICliente daocliente = new ClienteImpl();
        ISucursal daosucursal = new SucursalImpl();
        IPrestamo daoprestamo = new PrestamoImpl();
        
        IClientePrestamo daocp = new ClientePrestamoImpl();
        ClientePrestamo clientepr = new ClientePrestamo(3, daocliente.obtener("172409466-7"),daoprestamo.obtener(1), daosucursal.obtener(5));
        
        int insertado=0;
        try {
            insertado = daocp.insertar(clientepr);
        } catch (Exception e) {
        }
        assertTrue(insertado>0);
        
        
    }
}
