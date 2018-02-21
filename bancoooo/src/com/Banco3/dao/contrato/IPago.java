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
 * @author usuario
 */
public interface IPago {
    
    int insertar(Pago persona);
    
    int modificar(Pago persona);
    
    int eliminar(Pago persona);
    
    Pago obtener(int codigo) throws Exception;
    
    List<Pago> obtener() throws Exception;
    
}
