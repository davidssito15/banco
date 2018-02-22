package Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.Banco3.accesoadatos.*;
import com.Banco3.dao.contrato.*;

import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
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
        ICliente clienteDao = new ClienteImpl();
        //Insercion
//        int filas = 0;
//        Cliente cliente = new Cliente("1", "Alexander","Correa","022627346","k@hotmailcom");      
//        
//        try {
//            filas = clienteDao.insertar(cliente);
//            System.out.println("filas Insertadas:" + filas);
//        } catch (Exception e) {
//        }
//        assertEquals(filas > 0, true);

//        
////TEST OBTENER POR CODIGO
//
//        Cliente client = new Cliente();
//        try {
//            cliente = clienteDao.obtener("");
//            System.out.println(client.getCedula() + "    " + client.getNombre() + "       " + client.getApellido()+"    " + client.getTelefono() + "      " + client.getEmail() + ""+ "\n\n");
//        } catch (Exception e) {
//        }
        //assertEquals(usuario != null, true);
        
////TEST LISTADO
//
          List<Cliente> clientess = new ArrayList<>();
        try {
            clientess = clienteDao.obtener();
            for (Cliente clientes : clientess) {
                System.out.println("CEDULA      " + "  NOMBRE "+ "   APELLIDO"+"DIRECCION"+"TELEFONO"+"EMAIL"+"FECHA NACIEMIENTO");
                System.out.println(clientes.getCedula() + "" + clientes.getNombre() + "" + clientes.getApellido() + "" + clientes.getTelefono() + "" +  "" + clientes.getEmail());
            }
        } catch (Exception e) {
        }
       //assertTrue(clientess.size() > 0);
    }

}
