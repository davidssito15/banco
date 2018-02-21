package com.Banco3.dao.contrato;
import com.Banco3.rnegocios.entidades.Inspector;
import java.util.List;

public interface IInspector {
    int insertar(Inspector inspector) throws Exception;
    int modificar(Inspector inspector) throws Exception;
    int eliminar(Inspector inspector) throws Exception;
    Inspector obtener(int id) throws Exception;
    List<Inspector> obtener() throws Exception;
}
