/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controller.JobController;
import controller.RegionController;
import daos.DepartmentDAO;
import daos.JobDAO;
import models.Region;
import daos.RegionDAO;
import icontroller.IJobController;
import icontroller.IRegionController;
import idaos.IRegionDAO;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import models.Country;
import models.Department;
import models.Job;
import models.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.Insert;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.jdbc.Work;
import view.MainFrame;

/**
 *
 * @author sofia
 */
public class ContohORM2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println(HibernateUtil.getSessionFactory());

// kalau ingin menggunakan line 32 file regionDAO                 
//        RegionDAO redao = new RegionDAO(sessionFactory);
//bisa menggunakan line 28 file regionDAO
//        RegionDAO rdao = new RegionDAO(); 
//        for (Region region : redao.getAll()) {
//            System.out.println(region.getRegionId() 
//                    +" - "+region.getRegionName());
//            for (Country country : region.getCountryList()) {
//                System.out.println("\t-> "+ country.getCountryId() 
//                        +" - "+country.getCountryName());
//                for (Location location : country.getLocationList()) {
//                    System.out.println("\t\t-> "+ location.getCity());
//                }
//            }
//        }
//        Location l = new Location(1611, "JLTJDR", "4533345", "DKI", "JKT", "CH");
//        System.out.println(ildao.save(l));
//          Region region = new Region(new BigDecimal(5), "Kongo");
//          System.out.println(rdao.update(region));
//          Region region = new Region(new BigDecimal(6), "kongo");
//          System.out.println(rdao.update(region));
//            
//          Job job = new Job("CEO58", "bootcamp25");
//          System.out.println(jobDAO.insert(job));
//          System.out.println(jobDAO.deleteById(new Job("CEO57", "")));
//            Job job = new Job("CEO58", "");
//            System.out.println(jobDAO.deleteById(job));
//           IRegionController irc = new RegionController(HibernateUtil.getSessionFactory());
//           Region region = new Region(new BigDecimal(0), "Bandungan");
//           System.out.println(irc.insert(region));
//            IJobController ijc = new JobController(HibernateUtil.getSessionFactory());
//            Job job = new Job("CEO58");
//            System.out.println(ijc.delete(job));
//            JobDAO jobDAO =  new JobDAO();
//            Job job = new Job("CEO58", "rahmad");
//            System.out.println(jobDAO.insert(job));
//            System.out.println(ijc.update("CEO58", "rahmad", 13000, 14000));
//          System.out.println(rdao.search("Asia")); 
//          DepartmentDAO ddao = new DepartmentDAO(sessionFactory);
//          System.out.println(ddao.search("IT"));
//          for (Department department : ddao.search("IT")) {
//              System.out.println(department.getDepartmentName() +" "+
//                      department.getDepartmentId() +" "+
//                      department.getLocationId() +" "+
//                      department.getManagerId());              
//        }
//        for (Job job : jobDAO.getAll()) {
//            System.out.println(job.getJobTitle());
////        }
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);       
//        Session session = sessionFactory.openSession();
//        Transaction tx = session.beginTransaction();
//        PreparedStatement st = session.connection().prepareStatement("{call procedureName(?, ?)}");
//        st.setString(1, formatter.format(parameter1));
//        st.setString(2, formatter.format(parameter2));
//        st.execute();
//        tx.commit();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Configuration c = new Configuration().configure();
        SessionFactory sf = c.buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        try {
            Connection connection = sessionFactory.
                    getSessionFactoryOptions().getServiceRegistry().
                    getService(ConnectionProvider.class).getConnection();
            connection.createStatement().execute("ALTER SESSION SET CURRENT_SCHEMA=HR");
//            Statement statement = connection.createStatement();
//            statement.execute("ALTER SESSION SET CURRENT_SCHEMA=HR");
//              statement.execute("{ call changesalary(?,?) }");

            CallableStatement cs = connection.prepareCall("{ call changesalary(?,?) }");
            cs.setInt(1, 100);  // first parameter index start with 1
            cs.setInt(2, 6541); // second parameter
//            cs.execute("ALTER SESSION SET CURRENT_SCHEMA=HR");  // call stored procedure          
            cs.execute();
            System.out.println("succes");
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
