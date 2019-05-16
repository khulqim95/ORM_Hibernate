/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Views.MainFrame;
import Views.RegionView;
import controllers.DepartmentController;
import controllers.EmployeeController;
import daos.EmployeeDAO;
import daos.JobDao;
import daos.RegionDAO;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.persistence.EntityManager;
import models.Country;
import models.Department;
import models.Employee;
import models.Job;
import models.Location;
import models.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.internal.SessionImpl;

/**
 *
 * @author Relion31
 */
public class ORM_Latihan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        SessionFactory factory = null;
        Date d = new Date();
//        java.util.Date date = new java.util.Date();
//                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        // TODO code application logic 
        // System.out.println(HibernateUtil.getSessionFactory());

//        JobDao jobDao = new JobDao(HibernateUtil.getSessionFactory());
//        RegionDAO regionDAO = new RegionDAO(HibernateUtil.getSessionFactory());
//            EmployeeDAO employeeDAO = new EmployeeDAO(HibernateUtil.getSessionFactory());
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

//        for (Region region : regionDAO.getAll()) {
//            System.out.println("");
//            System.out.println(region.getRegionId() + " - " + region.getRegionName());
//            for (Country country : region.getCountryList()) {
//                System.out.println("\t->" + country.getCountryId() + " - " + country.getCountryName());
//                for (Location location : country.getLocationList()) {
//                    System.out.println("\t\t-->" + location.getCity());
//                    for (Department department : location.getDepartmentList()) {
//                        System.out.println("\t\t\t----->" + department.getDepartmentName());
//                        for (Employee employee : department.getEmployeeList()) {
//                            System.out.println("\t\t\t===>" + employee.getFirstName() + " " + employee.getLastName());
//                        }
//                    }
//                }
//            }
//        }
//          Untuk testing insert, update, delete
//        Region r = new Region(new BigDecimal(0), "Yogyakarta");
//        System.out.println(regionDAO.save(r));
//            Employee e = new Employee(220, "Bang", "Ocep", "bangocep@gmail.com", "087878765", new java.sql.Date(d.getTime()), new BigDecimal(3232), new BigDecimal(3232), new Department((short)90), new Employee(100), new Job("AD_VP"));
////            Employee e = new Employee(220, "Bang", "Ocep", "bangocep@gmail.com", "087878765", new java.sql.Date(d.getTime()), new BigDecimal(3232), new BigDecimal(3232), new Department((short)90), new Employee(100), new Job("AD_VP"));
//            System.out.println(employeeDAO.save(e));
//            EmployeeController employeeController = new EmployeeController(sessionFactory);
//            System.out.println(employeeController.save("220", "Namaku", "Saya", "saya@gmail", "09898787", "2019-04-05", "AD_VP", "1600", "0", "100", "90"));
                
//            DepartmentController departmentController = new DepartmentController(sessionFactory);
//            System.out.println(departmentController.insert("280", "MSBU", "200", "1700"));

//            for (Job job : jobDao.search("PR")) {
//                System.out.println(job.getJobId());
//                System.out.println(job.getJobTitle());
//        }
//            System.out.println(employeeDAO.save(e));
//              untuk testing get ALL
//            for (Employee employee : employeeDAO.getData(new Employee(0), false)) {
//                System.out.println(employee.getFirstName());
//        }
//              untuk testing get By Id
//            for (Job job : jobDao.getData(new Job("AD_PRES"), true)) {
//                System.out.println(job.getJobTitle());
//        }
MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
//    RegionView regionView = new RegionView();
//    regionView.setVisible(true);
//            System.out.println(regionDAO.getData(new Region(new BigDecimal(0), "asasa"), false).get(3).getRegionName());
        


    //Panggil store procedure di oracle.
//        Configuration c = new Configuration().configure();
//        SessionFactory sf = c.buildSessionFactory();
//        Session session = sf.openSession();
//        session.beginTransaction();
//        try {
//            Connection connection = sessionFactory.getSessionFactoryOptions().getServiceRegistry().getService(ConnectionProvider.class).getConnection();
////            connection.createStatement().execute("");
//            Statement statement = connection.createStatement();
//            statement.execute("ALTER SESSION SET CURRENT_SCHEMA=HR");
//            CallableStatement csmt = connection.prepareCall("{call updateSalary(?,?)}");
//            csmt.setInt(1, 100); // set parameter yang bertipe String
//            csmt.setInt(2, 12345); // jika tipenya int, maka setInteger
//            ResultSet rs = (csmt.executeQuery());
//        } catch (Exception e) {
//            System.out.println("gagal");
//            e.printStackTrace();
//        }
    }

}
