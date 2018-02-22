/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.Cliente;
import java.util.*;

/**
 *
 * @Davidssito Campos
 */
public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    public Cliente obtener(String cedula) throws Exception;
    public List<Cliente> obtener() throws Exception; 
}