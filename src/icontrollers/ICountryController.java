package icontrollers;

import entities.Country;
import entities.Region;
import java.util.List;

/**
 *
 * @author RR17
 */
public interface ICountryController<T> {

    public List<T> getAll();

    public List<T> getById(String countryId);

    public String insert(String countryId, String countryName, String regionId);

    public List<T> search(String keyword);

    public String update(String countryId, String countryName, Region regionId);

    public String delete(String countryId);
}
