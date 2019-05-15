package icontrollers;

import entities.Location;
import java.util.List;

/**
 *
 * @author RR17
 */
public interface ILocationController {
    public List<Location> getAll();
    public Location getById(String locationId);
    public List<Location> search(Object keyword);
    public String insert (String locationId, String city, String streetAddress, String postalCode, String stateProvince, String countryId);
    public String update (String locationId, String city, String streetAddress, String postalCode, String stateProvince, String countryId);
    public String delete (String locationId);
}
