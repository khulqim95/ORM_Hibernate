/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.EmployeeDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import models.Country;
import models.Department;
import models.Employee;
import models.Location;
import models.Region;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import views.MainFrame;

/**
 *
 * @author yosef
 */
public class ORM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        System.out.println(HibernateUtil.getSessionFactory());

        LocationDAO locationDAO = new LocationDAO(HibernateUtil.getSessionFactory());
        EmployeeDAO employeeDAO = new EmployeeDAO();
        RegionDAO regionDAO = new RegionDAO();
        

//        SessionFactory sessionFactory = Hibernate.getSessionFactory;
//        regionDAO.getAll().forEach((region) -> {
//            System.out.println("");
//            System.out.println(region.getRegionId() 
//                    +" - "+region.getRegionName());
//        for (Country country : region.getCountryList()){
//            System.out.println("\t-> "+ country.getCountryId()+" - "
//                    + country.getCountryName());
//            for (Location location : country.getLocationList()){
//                System.out.println("\t\t-->"+location.getCity());
//            } 
//        }
//        });
//        Location l = new Location(Short.1000);
//        System.out.println(locationDAO.update(l)); 
        //search Location
//        for (Location location : locationDAO.search("1100")) {
//            System.out.println(location.getLocationId());
//            System.out.println(location.getStreetAddress());
//            System.out.println(location.getPostalCode());
//            System.out.println(location.getCity());
//            System.out.println(location.getStateProvince());
//            System.out.println(location.getCountryId().getCountryName());
//        }
        //search Employee
//        for (Employee employee : employeeDAO.search("100")) {
//            System.out.println(employee.getEmployeeId());
//            System.out.println(employee.getFirstName());
//            System.out.println(employee.getLastName());
//            System.out.println(employee.getEmail());
//            System.out.println(employee.getPhoneNumber());
//            System.out.println(employee.getHireDate());
//            System.out.println(employee.getSalary());
//            System.out.println(employee.getCommissionPct());
//            System.out.println(employee.getDepartmentId());
//        }
        //Delete
//        Region r = new Region(new BigDecimal(5));
//        System.out.println(regionDAO.deleteById(r));   
        
         //Update
//          Location location = new Location(1000), "ssssss", "sssss", "sssswdwd", "wdwqewqewq", "IT");
//          System.out.println(locationDAO.update(location));


//          System.out.println(rdao.search("Asia"));
//        System.out.println(regionDAO.getById("10").get(0).getRegionName());
//        System.out.println(regionDAO.getId("10").getRegionName());
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);

        
//        System.out.println(irc.delete(r));

       
    }

}
