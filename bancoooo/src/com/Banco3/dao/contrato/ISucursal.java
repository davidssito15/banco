
package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.Sucursal;
import java.util.List;


public interface ISucursal {
    
    int insertar(Sucursal sucursal);
    
    int modificar(Sucursal sucursal);
    
    int eliminar(Sucursal sucursal);
    
    Sucursal obtener(int codigo) throws Exception;
    
    List<Sucursal> obtener() throws Exception;
    
}
