/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.Prestamo;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface IPrestamo {
    int insertar(Prestamo prestamo);
    
    int modificar(Prestamo prestamo);
    
    int eliminar(Prestamo prestamo);
    
    Prestamo obtener(int codigo) throws Exception;
    
    List<Prestamo> obtener() throws Exception;
    
    
}
