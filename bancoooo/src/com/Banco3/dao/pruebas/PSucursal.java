/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.pruebas;

import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.util.List;

/**
 *
 * @author usuario
 */
public class PSucursal {
    
    public static void main(String[] args) {
        
        Sucursal sucursal = new Sucursal(50, "Riobamba");
        
        ISucursal dao = new SucursalImpl();
        
        try {
            
            if(dao.insertar(sucursal)>0)
            {
                System.out.println("RELACION LABORAL INSERTADO");
            }
            else
            {
                System.out.println(" ERROR AL INSERTAR");
            }
            
            List<Sucursal> lista = dao.obtener();
            
            for(Sucursal per: lista)
            {
                System.out.println(per.getCiudad());
            }
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
    }
    
}
