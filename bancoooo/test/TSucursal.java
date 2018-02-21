import com.Banco3.dao.contrato.ISucursal;
import com.Banco3.dao.impl.SucursalImpl;
import com.Banco3.rnegocios.entidades.Sucursal;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class TSucursal {
    
    public TSucursal() {
    }
    
    @Test
    public void pruebaSucursal()
    {
        //INSERTAR
        
        int codigoprueba=9782;
        Sucursal sucursal = new Sucursal(codigoprueba, "Cuenca");
        ISucursal dao = new SucursalImpl();
        int resultadoInsersion =0;
        
        try {            
            resultadoInsersion=dao.insertar(sucursal);            
        } catch (Exception e) {
        }
        assertTrue(resultadoInsersion>0);
          
        //OBTENER POR CODIGO
        Sucursal obtener=null;
        try {
            obtener=dao.obtener(codigoprueba);
        } catch (Exception e) {
        }
        assertTrue(obtener!=null);
        
        //MODIFICAR
        
        obtener.setId(codigoprueba);
        int resultadoModificacion=0;
        try {
            resultadoModificacion=dao.modificar(obtener);
        } catch (Exception e) {
        }
        assertTrue(resultadoModificacion>0);
        
        //OBTENER TODOS
        
        List<Sucursal> lista = new ArrayList<>();
        
        try {
            lista=dao.obtener();
        } catch (Exception e) {
        }
        assertTrue(lista!=null);
        
        //ELIMINAR
         
        int resultadoEliminar =0;
        
        try {            
            resultadoEliminar=dao.eliminar(obtener);            
        } catch (Exception e) {
        }
        assertTrue(resultadoEliminar>0);  
       
        
        
    }
    
}
