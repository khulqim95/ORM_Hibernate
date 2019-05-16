
package Controller;

import Daos.LocationDAO;
import Icontroller.ILocationController;
import Models.Location;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN7
 */
public class LocationController implements ILocationController{
    
    private LocationDAO ldao ;
    
    public LocationController(SessionFactory factory){
        ldao = new LocationDAO();
    }
    

    @Override
    public List<Location> getAll() {
        return ldao.getAll();
    }
//
//    @Override
//    public List<Location> getById(String id) {
//        return ldao.getById(id);
//    }

    @Override
    public List<Location> search(String key) {
        return ldao.search(key);
    }

    @Override
    public String insert(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
