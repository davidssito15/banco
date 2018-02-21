/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.pruebas;

import com.Banco3.dao.contrato.*;
import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.dao.impl.CuentaImpl;
import com.Banco3.rnegocios.entidades.*;
import com.Banco3.rnegocios.entidades.CuentaAhorro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class PCuentaCredito {
    public static void main(String[] args) {
////        Ingreso
//        try {
//            Cuenta cuenta=new Cuenta();
//            ICuenta cue=new CuentaImpl();
//            cuenta=cue.obtener(1);
//            Cliente cliente=new Cliente();
//            ICliente cli=new ClienteImpl();
//            cliente=cli.obtener("172409466-8");
//            CuentaCredito cuentacredito=new CuentaCredito(1, 10, cuenta, cliente, 300);
//            ICuentaCredito cuen=new CuentaCreditoImpl();
//            int i=cuen.insertar(cuentacredito);
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
//            CuentaCredito cuanaho=new CuentaCredito();
//            ICuentaCredito icuenta=new CuentaCreditoImpl();
//            cuanaho.setId(1);
//            cuanaho.setSobrejiro(11);
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
//            CuentaCredito cuena=new CuentaCredito();
//            ICuentaCredito icuen=new CuentaCreditoImpl();
//            cuena=icuen.obtener(1);
//            System.out.println(cuena.getCliente().getApellido());
//        } catch (Exception e) {
//            System.err.println("Error");
//        }
        
//        //Lista
//        try {
//            List<CuentaCredito> lista=new ArrayList<>();
//            ICuentaCredito cuentaa=new CuentaCreditoImpl();
//            lista=cuentaa.obtener();
//            for(CuentaCredito i:lista){
//                System.out.println(i.getCliente().getApellido());                
//            }
//            
//        } catch (Exception e) {
//            System.out.println("Error");
//            
//        }
        
        //Borrar
        try{
            CuentaCredito cueah=new CuentaCredito();
            ICuentaCredito cue=new CuentaCreditoImpl();
            cueah.setId(1);
            cue.eliminar(cueah);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
