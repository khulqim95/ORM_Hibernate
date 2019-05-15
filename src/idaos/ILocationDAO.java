package idaos;

import entities.Location;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author RR17
 */
public interface ILocationDAO {
    public List<Location> getAll();
    public Location getById(BigDecimal locationId);
    public Location search(String keyword);
    public boolean insert(Location location);
    public boolean update(Location location);
    public boolean delete(Location location);
}
