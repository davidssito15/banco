/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Banco3.dao.contrato.*;
import com.Banco3.dao.impl.*;
import com.Banco3.rnegocios.entidades.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Angel-Pc
 */
public class TEmpleado {
    
    public TEmpleado() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void PruebaEmpleado() {
     //Ingreso 
     int resultadoInsersion=0;
        Sucursal sucursal=new Sucursal();
        ISucursal sucur=new SucursalImpl();
        try {
            sucursal= sucur.obtener(1);
            Empleado jefe=new Empleado();
            IEmpleado ob=new EmpleadoImpl();
            jefe=ob.obtener(1);
            Empleado empleado=new Empleado(100, "Angel", "Sisa", "180492159-8", "Ambato", "0968759242", jefe , sucursal);
            IEmpleado emple=new EmpleadoImpl();
            resultadoInsersion=emple.insertar(empleado);
        } catch (Exception ex) {
        }
        assertTrue(resultadoInsersion>0);
        
        //Modificacion
        int resulatdoModificacion=0;
        try {
            sucursal = sucur.obtener(1);
            Empleado jefe = new Empleado();
            IEmpleado ob = new EmpleadoImpl();
            jefe = ob.obtener(1);
            Empleado empleado = new Empleado();
            IEmpleado emple = new EmpleadoImpl();
            empleado.setId(100);
            empleado.setNombre("Isaias");
            empleado.setApellido("Caiza");
            empleado.setCedula("180492150-8");
            empleado.setDireccion("Quito");
            empleado.setTelefono("0968759242");
            empleado.setEmpleado(jefe);
            empleado.setSucursal(sucursal);
            resulatdoModificacion = emple.modificar(empleado);
        } catch (Exception ex) {
        }
        assertTrue(resulatdoModificacion>0);
        
        //Obtener
        Empleado empleado=null;
        try {
            empleado=new Empleado();
            IEmpleado obtener =new EmpleadoImpl();
            empleado=obtener.obtener(100);
            System.out.println(empleado.getNombre());
        } catch (Exception e) {
            System.out.println("No se puede Obtener");
        }
        assertTrue(empleado!=null);
        
        //Obtener Lista
        List<Empleado> lista=new ArrayList();
        try{
            IEmpleado emp=new EmpleadoImpl();
            lista=emp.obtener();
            for(Empleado est:lista){
                System.out.println(est.getApellido());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertTrue(lista!=null);
        
        //Eliminar
        int resultadoEliminar=0;
        try{
            Empleado empl=new Empleado();
            IEmpleado eli=new EmpleadoImpl();
            empl.setId(100);
            resultadoEliminar=eli.eliminar(empl);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertTrue(resultadoEliminar>0);
     }
}
