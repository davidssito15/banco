package com.Banco3.dao.pruebas;

import com.Banco3.dao.contrato.ICliente;
import com.Banco3.dao.contrato.IClientePrestamo;
import com.Banco3.dao.contrato.IPrestamo;
import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.ClienteImpl;
import com.Banco3.dao.impl.ClientePrestamoImpl;
import com.Banco3.dao.impl.PrestamoImpl;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.ClientePrestamo;
import java.util.List;

public class PClientePrestamo {

    public static void main(String[] args) throws Exception {
        ICliente daocliente = new ClienteImpl();
        ISucursal daosucursal = new SucursalImpl();
        IPrestamo daoprestamo = new PrestamoImpl();
        ClientePrestamo cliente = new ClientePrestamo(10, daocliente.obtener("172409466-7"),daoprestamo.obtener(1), daosucursal.obtener(1));

        IClientePrestamo dao = new ClientePrestamoImpl();
        try {
            if (dao.insertar(cliente) > 0) {
                System.out.println("CLIENTE INSERTADO CORRECTAMENTE");
            } else {
                System.out.println("ERROR AL INSERTAR");
            }

            List<ClientePrestamo> lista = dao.obtener();

            for (ClientePrestamo cli : lista) {
                System.out.println(cli.getId());
            }
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}
