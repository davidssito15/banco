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
public interface ICuentaCredito {
    int insertar(CuentaCredito cuentacredito) throws Exception;
    int modificar(CuentaCredito cuentacredito) throws Exception;
    int eliminar(CuentaCredito cuentacredito) throws Exception;
    CuentaCredito obtener(int id) throws Exception;
    List<CuentaCredito> obtener() throws Exception;
    
}
