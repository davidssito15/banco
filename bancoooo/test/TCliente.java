/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.IClientePrestamo;
import com.Banco3.dao.impl.ClienteImpl;
import com.Banco3.rnegocios.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TCliente {
    
    public TCliente() {
    }
    @Test
    public void pruebaCliente() throws Exception{
        
        //Insercion
        ICliente daocliente = new ClienteImpl();
        Cliente cliente = new Cliente("172409466-8", "Alexander","Correa","0995811890","jairoespunk@hotmailcom");      
        int insertado=0;
        try {
            insertado = daocliente.insertar(cliente);
        } catch (Exception e) {
        }
//        assertTrue(insertado>0);
        
        //Listar
        
        Cliente clienteelim = null;           
        try {
            clienteelim = daocliente.obtener("172409466-8");
        } catch (Exception e) {
        }
//        assertTrue(clienteelim!=null);
        
        //Modificar
        clienteelim.setNombre("SD");
        clienteelim.setApellido("SD");
        clienteelim.setTelefono("SD");
        clienteelim.setEmail("SD");
        int modificado=0;
        try {
            modificado = daocliente.modificar(clienteelim);
        } catch (Exception e) {
        }
        assertTrue(modificado>0);
         
        //Listar_todo        
        List<Cliente> lst=new ArrayList<>();
                   
        try {
            lst = daocliente.obtener();
        } catch (Exception e) {
        }
   //     assertTrue(lst.size()>0);
        
        //Eliminar                
        int eliminar=0;
        try {
            eliminar = daocliente.eliminar(clienteelim);
        } catch (Exception e) {
        }
   //     assertTrue(eliminar>0);
        
 
    }
}
