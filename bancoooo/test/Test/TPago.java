package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.IPago;
import com.Banco3.dao.contrato.IPrestamo;
import com.Banco3.dao.impl.ClienteImpl;
import com.Banco3.dao.impl.PagoImpl;
import com.Banco3.dao.impl.PrestamoImpl;
import com.Banco3.rnegocios.entidades.Cliente;
import com.Banco3.rnegocios.entidades.Pago;
import com.Banco3.rnegocios.entidades.Prestamo;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TPago {
    
    public TPago() {
    }
    
    @Test
    public void pruebaPago() throws Exception
    {
        //INSERTAR
        
        int codigoprueba=1055500;
        
        Cliente cliente = new Cliente("060440535-3", "Eloy", "Alfaro", "0958995049", "real@gmail.com");      
               
        IPrestamo prestamo = new PrestamoImpl();        
        
        Pago pago = new Pago(codigoprueba, new Date(), 101, 202, prestamo.obtener(1));               
        
        IPago dao = new PagoImpl();
        
        int resultadoInsersion =0;
        
        try {            
            resultadoInsersion=dao.insertar(pago);            
        } catch (Exception e) {
        }
        assertTrue(resultadoInsersion>0);
        
        //OBTENER POR CODIGO
        Pago obtener=null;
        try {
            obtener=dao.obtener(codigoprueba);
        } catch (Exception e) {
        }
        assertTrue(obtener!=null);
        
        //MODIFICAR
        
        obtener.setId(codigoprueba);
        int resultadoModificacion=0;
        try {
            resultadoModificacion=dao.modificar(obtener);
        } catch (Exception e) {
        }
        assertTrue(resultadoModificacion>0);
        
        //OBTENER TODOS
        
        List<Pago> lista = new ArrayList<>();
        
        try {
            lista=dao.obtener();
        } catch (Exception e) {
        }
        assertTrue(lista!=null);
        
        //ELIMINAR
         
        int resultadoEliminar =0;
        
        try {            
            resultadoEliminar=dao.eliminar(obtener);            
        } catch (Exception e) {
        }
        assertTrue(resultadoEliminar>0);
        
//        
        
        
    }
}
