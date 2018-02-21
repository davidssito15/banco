/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.pruebas;

import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class PEmpleado {

    public static void main(String[] args) {
//        //Insertar
//        Sucursal sucursal=new Sucursal();
//        ISucursal sucur=new SucursalImpl();
//        try {
//            sucursal= sucur.obtener(1);
//            Empleado jefe=new Empleado();
//            IEmpleado ob=new EmpleadoImpl();
//            jefe=ob.obtener(1);
//            Empleado empleado=new Empleado(2, "Angel", "Sisa", "180492150-8", "Ambato", "0968759242", jefe , sucursal);
//            IEmpleado emple=new EmpleadoImpl();
//            int i=emple.insertar(empleado);
//            if(i<1){
//                System.out.println("Empleado Ingresado Correctamente");
//            }else{
//                System.out.println("Empleado Nose pudo Ingresar ");
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
////        Obtener
//        try {
//            Empleado empleado=new Empleado();
//            IEmpleado obtener =new EmpleadoImpl();
//            empleado=obtener.obtener(2);
//            System.out.println(empleado.getNombre());
//        } catch (Exception e) {
//            System.out.println("No se puede Obtener");
//        }

////        Modificar
//        
//        Sucursal sucursal = new Sucursal();
//        ISucursal sucur = new SucursalImpl();
//        try {
//            sucursal = sucur.obtener(1);
//            Empleado jefe = new Empleado();
//            IEmpleado ob = new EmpleadoImpl();
//            jefe = ob.obtener(1);
//            Empleado empleado = new Empleado();
//            IEmpleado emple = new EmpleadoImpl();
//            empleado.setId(2);
//            empleado.setNombre("Isaias");
//            empleado.setApellido("Caiza");
//            empleado.setCedula("180492150-8");
//            empleado.setDireccion("Quito");
//            empleado.setTelefono("0968759242");
//            empleado.setEmpleado(jefe);
//            empleado.setSucursal(sucursal);
//            int u = emple.modificar(empleado);
//            if (u > 1) {
//                System.out.println("Empleado Modificado Correctamente");
//            } else {
//                System.out.println("Empleado Nose pudo Modificar ");
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(PEmpleado.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
//            //Listado
//        try{
//            List<Empleado> lista=new ArrayList();
//            IEmpleado emp=new EmpleadoImpl();
//            lista=emp.obtener();
//            for(Empleado est:lista){
//                System.out.println(est.getApellido());
//            }
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }

//    Eliminar
        try{
            Empleado empl=new Empleado();
            IEmpleado eli=new EmpleadoImpl();
            empl.setId(3);
            eli.eliminar(empl);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
