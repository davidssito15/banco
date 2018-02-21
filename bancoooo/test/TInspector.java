import com.Banco3.dao.contrato.IClientePrestamo;
import com.Banco3.dao.contrato.IInspector;
import com.Banco3.dao.impl.ClientePrestamoImpl;
import com.Banco3.dao.impl.InspectorImpl;
import com.Banco3.rnegocios.entidades.ClientePrestamo;
import com.Banco3.rnegocios.entidades.Inspector;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TInspector {
    public TInspector() {
    }
    @Test
    public void pruebaInspector() throws Exception{
        IInspector daoinsInspector = new InspectorImpl();
        ClientePrestamo clipre = new ClientePrestamo();
        clipre.setId(5);
        
        Inspector inspector = new Inspector(585, "Juan", "Alatamirano", "La salle", "Doctor",clipre);
        int insertado = 0;
        try {
            insertado = daoinsInspector.insertar(inspector);
        } catch (Exception e) {
        }
        assertTrue(insertado>0);
        
//        IInspector daoinspector = new InspectorImpl();
//
//        IClientePrestamo daoclienteprestamo = new ClientePrestamoImpl();
//        ClientePrestamo clipre = new ClientePrestamo();
//        clipre.setId(5);
//        
//        Inspector inspector = new Inspector(5858, "Juan", "Alatamirano", "La salle", "Doctor",clipre);
//        int insertado=0;
//        try {
//            insertado = daoinspector.insertar(inspector);
//        } catch (Exception e) {
//        }
//        assertTrue(insertado>0);
//        ///////////////
//        Inspector inspectorelim = null;           
//        try {
//            inspectorelim = daoinspector.obtener(1);
//        } catch (Exception e) {
//        }
//        assertTrue(inspectorelim!=null);
//        
//        //Modificar
//        inspectorelim.setId(1);
//        inspectorelim.setNombres("SD");
//        inspectorelim.setApellidos("SD");
//        inspectorelim.setDireccion("SD");
//        inspectorelim.setTitulo("SD");
//        int modificado=0;
//        try {
//            modificado = daoinspector.modificar(inspectorelim);
//        } catch (Exception e) {
//        }
//        assertTrue(modificado>0);
//         
//        //Listar_todo        
//        List<Inspector> lst=new ArrayList<>();
//                   
//        try {
//            lst = daoinspector.obtener();
//        } catch (Exception e) {
//        }
//        assertTrue(lst.size()>0);
//        
//        //Eliminar                
//        int eliminar=0;
//        try {
//            eliminar = daoinspector.eliminar(inspectorelim);
//        } catch (Exception e) {
//        }
//        assertTrue(eliminar>0);
//        
 
    }
}

