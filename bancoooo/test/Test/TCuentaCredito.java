package Test;


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

public class TCuentaCredito {

    public TCuentaCredito() {
    }

    @Test
    public void PruebaCuentaCredito() {
        //Ingresar
        int resultadoIngreso = 0;
        try {
            Cuenta cuenta = new Cuenta();
            ICuenta cue = new CuentaImpl();
            cuenta = cue.obtener(2);
            Cliente cliente = new Cliente();
            ICliente cli = new ClienteImpl();
            cliente = cli.obtener("180492150-8");
            CuentaCredito cuentacredito = new CuentaCredito(1, 10, cuenta, cliente, 300);
            ICuentaCredito cuen = new CuentaCreditoImpl();
            resultadoIngreso = cuen.insertar(cuentacredito);

        } catch (Exception e) {
            System.out.println("Error al Ingresar");
        }
        assertTrue(resultadoIngreso > 0);

        //Modificar
        int resultadoModifiacion = 0;
        try {
            Cuenta cuenta = new Cuenta();
            ICuenta cue = new CuentaImpl();
            cuenta = cue.obtener(2);
            Cliente cliente = new Cliente();
            ICliente clien = new ClienteImpl();
            cliente = clien.obtener("180492150-8");
            CuentaCredito cuanaho = new CuentaCredito();
            ICuentaCredito icuenta = new CuentaCreditoImpl();
            cuanaho.setId(1);
            cuanaho.setSobrejiro(11);
            cuanaho.setCuenta(cuenta);
            cuanaho.setCliente(cliente);
            cuanaho.setSaldo(324);
            resultadoModifiacion = icuenta.modificar(cuanaho);
        } catch (Exception e) {
            System.out.println("Error al modificar");
        }
        assertTrue(resultadoModifiacion > 0);

        //Obtener
        CuentaCredito cuena = new CuentaCredito();
        try {
            ICuentaCredito icuen = new CuentaCreditoImpl();
            cuena = icuen.obtener(1);
            System.out.println(cuena.getCliente().getApellido());
        } catch (Exception e) {
            System.err.println("Error");
        }
        assertTrue(cuena != null);

        //Obtener Lista
        List<CuentaCredito> lista = new ArrayList<>();
        try {
            ICuentaCredito cuentaa = new CuentaCreditoImpl();
            lista = cuentaa.obtener();
            for (CuentaCredito i : lista) {
                System.out.println(i.getCliente().getApellido());
            }

        } catch (Exception e) {
            System.out.println("Error");

        }
        assertTrue(lista != null);

        //Borrar
        int resuladoBorrar = 0;
        try {
            CuentaCredito cueah = new CuentaCredito();
            ICuentaCredito cue = new CuentaCreditoImpl();
            cueah.setId(1);
            resuladoBorrar = cue.eliminar(cueah);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        assertTrue(resuladoBorrar > 0);
    }
}
