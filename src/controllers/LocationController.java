package controllers;

import daos.LocationDAO;
import entities.Location;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author RR17
 */
public class LocationController implements ILocationController {
    
    private ILocationDAO ildao;
    
    public LocationController(SessionFactory factory) {
        ildao = new LocationDAO(factory);
    }
    
    @Override
    public List<Location> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Location getById(String locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Location> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String locationId, String city, String streetAddress, String postalCode, String stateProvince, String countryId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Location location = new Location(Short.MIN_VALUE, city, streetAddress, postalCode, stateProvince, countryId);
        return null;
    }

    @Override
    public String update(String locationId, String city, String streetAddress, String postalCode, String stateProvince, String countryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String locationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
