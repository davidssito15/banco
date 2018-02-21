/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.Cliente;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface ICliente {
    int insertar(Cliente cleinte);    
    int modificar(Cliente cliente);    
    int eliminar(Cliente cliente);    
    Cliente obtener(String cedula) throws Exception;    
    List<Cliente> obtener() throws Exception;
}
