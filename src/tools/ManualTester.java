/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose ManualTester | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.CountryController;
import controllers.EmployeeController;
import controllers.LocationController;
import daos.CountryDAO;
import daos.EmployeeDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import models.Country;
import models.Department;
import models.Employee;
import models.Location;
import models.Region;
import java.math.BigDecimal;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import views.MainFrame;

/**
 *
 * @author Ode
 */
public class ManualTester {

    public static void main(String[] args) {
//        Cek Session
        System.out.println(HibernateUtil.getSessionFactory());

//        RegionDAO regionDAO = new RegionDAO();
//        for (Region region : regionDAO.getAll()) {
//            System.out.println(region.getRegionId() + " - "
//                    + region.getRegionName());
//
//            for (Country country : region.getCountryList()) {
//                System.out.println("\t->" + country.getCountryId()
//                        + " - " + country.getCountryName());
//
//                for (Location location : country.getLocationList()) {
//                    System.out.println("\t\t-->" + location.getCity());
//
//                    for (Department department : location.getDepartmentList()) {
//                        System.out.println("\t--->" + department.getDepartmentName());
//
//                    }
//                }
//
//            }
//        }
//        Cek Insert
//        Region region = new Region(new BigDecimal(0), "Yogya");
//        System.out.println(regionDAO.insert(region));
//        Cek Update
//        Region region = new Region(new BigDecimal(18), "Yogya City");
//        System.out.println(regionDAO.update(region));
//        Cek Delete
//        Region region = new Region(new BigDecimal(111));
//        System.out.println(regionDAO.delete(region));
//        Cek getById
//        System.out.println(regionDAO.getById("9").get(0).getRegionName());
//        System.out.println(regionDAO.getId("18").getRegionName());
//        System.out.println(regionDAO.search(key));

//      Cek Employee getById (DAO)
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        System.out.println(employeeDAO.getById("100").get(0).getLastName());
       
//      Instansiasi Session
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
//      Cek Employee getById (Controllers)
//        EmployeeController employeeController = new EmployeeController(sessionFactory);
//        System.out.println(employeeController.getById("100").get(0).getLastName());

//      Cek Location getAll
//        LocationDAO locationDAO = new LocationDAO();
//        for (Location location : locationDAO.getAll()) {
//            System.out.println(location.getLocationId() + " - "
//                    + location.getStreetAddress());
//    }

//        LocationController locationController = new LocationController(sessionFactory);
//        for (Location location : locationController.getAll()) {
//            System.out.println(location.getLocationId()+ " - " 
//                    + location.getCity());   
//        }

//      Delete Country
//        CountryController countryController = new CountryController(sessionFactory);
//        Country country = new Country("LL");
//        System.out.println(countryController.delete(country));

//        Search Country        
//        CountryController countryController = new CountryController(sessionFactory);        
//        for(Country country : countryController.search("AR")){
//            System.out.println(country.getCountryId());
//            System.out.println(country.getCountryName());
//            System.out.println(country.getRegionId());
//        }

        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
    
