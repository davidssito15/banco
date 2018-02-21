
package com.Banco3.dao.pruebas;

import com.Banco3.dao.impl.InspectorImpl;
import com.Banco3.rnegocios.entidades.ClientePrestamo;
import com.Banco3.rnegocios.entidades.Inspector;
import java.util.List;



public class PInspector {
    public static void main(String[] args) {

        ClientePrestamo clienteprestamo = new ClientePrestamo();
        clienteprestamo.setId(1);
        Inspector rl = new Inspector(3,"Iker","Jím","Junin, Riobamba","Ingeniero",clienteprestamo);
       
       
       
      
       InspectorImpl dao = new InspectorImpl(); 
        try {
            if(dao.insertar(rl)>0){
                System.out.println("Insertado Correctamente");
            }else{
                System.out.println("NO Insertado Correctamente");
            }         
            List<Inspector> lista = dao.obtener();
            for(Inspector r : lista){
                System.out.println(r.getId());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
 
