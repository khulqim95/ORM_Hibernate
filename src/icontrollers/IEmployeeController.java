package icontrollers;

import entities.Employee;
import java.util.List;

/**
 *
 * @author RR17
 */
public interface IEmployeeController {
    public List<Employee> getAll();
    public Employee getById(String employeeId);
    public List<Employee> search(Object keyword);
    public String insert (String employeeId, String firstName, String lastName, String email, String phoneNumber, String hireDate, String salary, String commissionPct, String departmentId, String managerId, String jobId);
//    public String update (String locationId, String city, String streetAddress, String postalCode, String stateProvince, String countryId);
    public String delete (String employeeId);
}
