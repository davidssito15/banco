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
public interface ICuenta {
    int insertar(Cuenta cuenta) throws Exception;
    int modificar(Cuenta cuenta) throws Exception;
    int eliminar(Cuenta cuenta) throws Exception;
    Cuenta obtener(int id) throws Exception;
    List<Cuenta> obtener() throws Exception;
    
}
