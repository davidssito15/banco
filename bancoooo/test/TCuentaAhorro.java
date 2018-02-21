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
public class TCuentaAhorro {
    
    public TCuentaAhorro() {
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
     public void PruebaCuentaAhorro() {
         //Ingreso
         int resultadoIngreso=0;
         try {
            Cuenta cuenta=new Cuenta();
            ICuenta cue=new CuentaImpl();
            cuenta=cue.obtener(2);
            Cliente cliente=new Cliente();
            ICliente cli=new ClienteImpl();
            cliente=cli.obtener("180492150-8");
            CuentaAhorro cuentaahorro=new CuentaAhorro(2, 10, cuenta, cliente, 300);
            ICuentaAhorro cuen=new CuentaAhorroImpl();
            resultadoIngreso=cuen.insertar(cuentaahorro);
            
        } catch (Exception e) {
            System.out.println("Error al Ingresar");
        }
         assertTrue(resultadoIngreso>0);
       
         //Modificacion
         int resultadoModificacion=0;
         try {
            Cuenta cuenta=new Cuenta();
            ICuenta cue=new CuentaImpl();
            cuenta=cue.obtener(2);
            Cliente cliente=new Cliente();
            ICliente clien=new ClienteImpl();
            cliente=clien.obtener("180492150-8");
            CuentaAhorro cuanaho=new CuentaAhorro();
            ICuentaAhorro icuenta=new CuentaAhorroImpl();
            cuanaho.setId(2);
            cuanaho.setInteres(11);
            cuanaho.setCuenta(cuenta);
            cuanaho.setCliente(cliente);
            cuanaho.setSaldo(324);
            resultadoModificacion=icuenta.modificar(cuanaho);
        } catch (Exception e) {
            System.out.println("Error al modificar");
        }
         assertTrue(resultadoModificacion>0);
         
         //Obtener
         CuentaAhorro cuena=new CuentaAhorro();
         try {
            ICuentaAhorro icuen=new CuentaAhorroImpl();
            cuena=icuen.obtener(2);
            System.out.println(cuena.getCliente().getApellido());
        } catch (Exception e) {
        }
         assertTrue(cuena!=null);
         
         //Obtener Lista
         List<CuentaAhorro> lista=new ArrayList<>();
         try {
            ICuentaAhorro cuentaa=new CuentaAhorroImpl();
            lista=cuentaa.obtener();
            for(CuentaAhorro i:lista){
                System.out.println(i.getCliente().getApellido());                
            }
            
        } catch (Exception e) {
            System.out.println("Error");
            
        }
         assertTrue(lista!=null);
         
         //Borrar
         int resultadoBorrado=0;
         try{
            CuentaAhorro cueah=new CuentaAhorro();
            ICuentaAhorro cue=new CuentaAhorroImpl();
            cueah.setId(2);
            resultadoBorrado=cue.eliminar(cueah);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
         assertTrue(resultadoBorrado>0);
     }
}
