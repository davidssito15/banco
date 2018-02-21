/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.pruebas;

import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public class PCuenta {

    public static void main(String[] args) {
        //Insertar
        try {
            Cuenta cuenta = new Cuenta(1, "Cuenta Ahorro");
            ICuenta insertarcuenta = new CuentaImpl();
            int i = insertarcuenta.insertar(cuenta);
            if (i > 0) {
                System.out.println("Ingreso de datos correctamente");
            } else {
                System.out.println("Ingreso de datos no realizado");
            }
        } catch (Exception e) {
            System.out.println("error al ingresar");
        }

//        //Altualizar
//        try{
//        Cuenta cuenta = new Cuenta();
//        ICuenta modificarcuenta = new CuentaImpl();
//        cuenta.setId(1);
//        cuenta.setNombre("Cambiado");
//        int i=modificarcuenta.modificar(cuenta);
//        if(i>0){
//            System.out.println("Modificado Correctamente");
//        }else{
//            System.out.println("No se pudo Modificar");
//        }
//        }catch(Exception e){
//            System.out.println("Error");
//        }

//        //Obtener
//        try {
//            Cuenta cuenta=new Cuenta();
//            ICuenta obtener =new CuentaImpl();
//            cuenta=obtener.obtener(2);
//            System.out.println(cuenta.getNombre());
//        } catch (Exception e) {
//            System.out.println("No se puede Obtener");
//        }
        
////        Listado
//        try{
//            List<Cuenta> lista=new ArrayList();
//            ICuenta cue=new CuentaImpl();
//            lista=cue.obtener();
//            for(Cuenta cu:lista){
//                System.out.println(cu.getNombre());
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
        
//        //Eliminar
//        try{
//            Cuenta cuen=new Cuenta();
//            ICuenta cu=new CuentaImpl();
//            cuen.setId(1);
//            cu.eliminar(cuen);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }

    }

}
