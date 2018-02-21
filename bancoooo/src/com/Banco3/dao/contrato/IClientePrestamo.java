package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.ClientePrestamo;
import java.util.List;

/**
 *
 * @author jx1r0
 */
public interface IClientePrestamo {
    int insertar(ClientePrestamo clienteprestamo);    
    int modificar(ClientePrestamo clienteprestamo);    
    int eliminar(ClientePrestamo clienteprestamo);    
    ClientePrestamo obtener(int id) throws Exception;    
    List<ClientePrestamo> obtener() throws Exception;
}
