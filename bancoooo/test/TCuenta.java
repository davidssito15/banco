/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.Banco3.dao.contrato.ICuenta;
import com.Banco3.dao.impl.CuentaImpl;
import com.Banco3.rnegocios.entidades.Cuenta;
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
public class TCuenta {

    public TCuenta() {
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
    public void PruebaCuenta() {
        //Insertar
        int resultadoInsersion = 0;
        try {
            Cuenta cuenta = new Cuenta(3, "Cuenta Ahorro");
            ICuenta insertarcuenta = new CuentaImpl();
            resultadoInsersion = insertarcuenta.insertar(cuenta);
        } catch (Exception e) {
            System.out.println("error al ingresar");
        }
        assertTrue(resultadoInsersion > 0);

        //Altualizar
        int resultadoModificaion = 0;
        try {
            Cuenta cuenta = new Cuenta();
            ICuenta modificarcuenta = new CuentaImpl();
            cuenta.setId(3);
            cuenta.setNombre("Cambiado");
            resultadoModificaion = modificarcuenta.modificar(cuenta);
        } catch (Exception e) {
            System.out.println("Error");
        }
        assertTrue(resultadoModificaion > 0);

        //Obtener
        Cuenta cuenta = null;
        try {
            cuenta = new Cuenta();
            ICuenta obtener = new CuentaImpl();
            cuenta = obtener.obtener(3);
            System.out.println(cuenta.getNombre());
        } catch (Exception e) {
            System.out.println("No se puede Obtener");
        }
        assertTrue(cuenta != null);

//        Listado
        List<Cuenta> lista = new ArrayList();
        try {
            ICuenta cue = new CuentaImpl();
            lista = cue.obtener();
            for (Cuenta cu : lista) {
                System.out.println(cu.getNombre());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(lista != null);

        //Eliminar
        int eliminado=0;
        try{
            Cuenta cuen=new Cuenta();
            ICuenta cu=new CuentaImpl();
            cuen.setId(3);
            eliminado=cu.eliminar(cuen);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        assertTrue(eliminado>0);
    }
}
