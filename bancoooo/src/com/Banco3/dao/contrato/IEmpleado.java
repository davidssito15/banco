/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.Empleado;
import java.util.List;

/**
 *
 * @author Angel-Pc
 */
public interface IEmpleado {
    int insertar(Empleado empleado) throws Exception;
    int modificar(Empleado empleado) throws Exception;
    int eliminar(Empleado empleado) throws Exception;
    Empleado obtener(int id) throws Exception;
    List<Empleado> obtener() throws Exception;
    
}
