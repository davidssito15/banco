/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.*;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface ICuentaAhorro {
    int insertar(CuentaAhorro cuentaahorro) throws Exception;
    int modificar(CuentaAhorro cuentaahorro) throws Exception;
    int eliminar(CuentaAhorro cuentaahorro) throws Exception;
    CuentaAhorro obtener(int id) throws Exception;
    List<CuentaAhorro> obtener() throws Exception;
    
}
