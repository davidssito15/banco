/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.pruebas;

import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.ICuenta;
import com.Banco3.dao.contrato.ICuentaAhorro;
import com.Banco3.dao.impl.ClienteImpl;
import com.Banco3.dao.impl.CuentaAhorroImpl;
import com.Banco3.dao.impl.CuentaImpl;
import com.Banco3.rnegocios.entidades.Cliente;
import com.Banco3.rnegocios.entidades.Cuenta;
import com.Banco3.rnegocios.entidades.CuentaAhorro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class PCuentaAhorro {
    public static void main(String[] args) {
//        //Ingreso
//        try {
//            Cuenta cuenta=new Cuenta();
//            ICuenta cue=new CuentaImpl();
//            cuenta=cue.obtener(1);
//            Cliente cliente=new Cliente();
//            ICliente cli=new ClienteImpl();
//            cliente=cli.obtener("172409466-8");
//            CuentaAhorro cuentaahorro=new CuentaAhorro(1, 10, cuenta, cliente, 300);
//            ICuentaAhorro cuen=new CuentaAhorroImpl();
//            int i=cuen.insertar(cuentaahorro);
//            if(i>0){
//                System.out.println("Ingresado Correctamente");
//            }else{
//                System.out.println("Nose Pudo Ingresar");
//            }
//            
//        } catch (Exception e) {
//            System.out.println("Error al Ingresar");
//        }
        
////        Modificacion
//        try {
//            Cuenta cuenta=new Cuenta();
//            ICuenta cue=new CuentaImpl();
//            cuenta=cue.obtener(1);
//            Cliente cliente=new Cliente();
//            ICliente clien=new ClienteImpl();
//            cliente=clien.obtener("172409466-8");
//            CuentaAhorro cuanaho=new CuentaAhorro();
//            ICuentaAhorro icuenta=new CuentaAhorroImpl();
//            cuanaho.setId(1);
//            cuanaho.setInteres(11);
//            cuanaho.setCuenta(cuenta);
//            cuanaho.setCliente(cliente);
//            cuanaho.setSaldo(324);
//            int u=icuenta.modificar(cuanaho);
//            if(u>0){
//                System.out.println("Modificado correctamente");
//            }else{
//                System.out.println("No se pudo Modificar");
//            }
//        } catch (Exception e) {
//            System.out.println("Error al modificar");
//        }
        
//        //Obtener
//        try {
//            CuentaAhorro cuena=new CuentaAhorro();
//            ICuentaAhorro icuen=new CuentaAhorroImpl();
//            cuena=icuen.obtener(1);
//            System.out.println(cuena.getCliente().getApellido());
//        } catch (Exception e) {
//            System.err.println("Error");
//        }
        
//        //Lista
//        try {
//            List<CuentaAhorro> lista=new ArrayList<>();
//            ICuentaAhorro cuentaa=new CuentaAhorroImpl();
//            lista=cuentaa.obtener();
//            for(CuentaAhorro i:lista){
//                System.out.println(i.getCliente().getApellido());                
//            }
//            
//        } catch (Exception e) {
//            System.out.println("Error");
//            
//        }
        
        //Borrar
        try{
            CuentaAhorro cueah=new CuentaAhorro();
            ICuentaAhorro cue=new CuentaAhorroImpl();
            cueah.setId(1);
            cue.eliminar(cueah);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
