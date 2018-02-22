package com.Banco3.dao.contrato;

import com.Banco3.rnegocios.entidades.*;
import java.util.*;

public interface IPedido {

    public int insertar(Pedido pedido) throws Exception;
    public int modificar(Pedido pedido) throws Exception;
    public int eliminar(Pedido pedido) throws Exception;
    public Pedido obtener(int codigo) throws Exception;
    public ArrayList<Pedido> obtener() throws Exception;
}
