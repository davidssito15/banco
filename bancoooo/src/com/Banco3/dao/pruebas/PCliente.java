/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.pruebas;

import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.ClienteImpl;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.Cliente;
import java.util.List;

/**
 *
 * @author usuario
 */
public class PCliente {
    public static void main(String[] args) {
    Cliente cliente = new Cliente("172409466-7", "Jairo","Vera","0995811890","jairoespunk@hotmail.com");
        
        ICliente dao = new ClienteImpl();        
        try {            
            if(dao.insertar(cliente)>0)
            {
                System.out.println("CLIENTE INSERTADO CORRECTAMENTE");
            }
            else
            {
                System.out.println("ERROR AL INSERTAR");
            }
            
            List<Cliente> lista = dao.obtener();
            
            for(Cliente cli: lista)
            {
                System.out.println(cli.getNombre());
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
    }
}
    
