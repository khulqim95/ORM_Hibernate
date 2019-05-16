/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import Daos.CountryDAO;
import Daos.LocationDAO;
import Daos.RegionDAO;
import Models.Country;
import Models.Location;
import Models.Region;
import Views.MainFrame;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import org.hibernate.Session;
import views.JICountryView;
import views.JIRegionView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import views.JILocationView;
import org.hibernate.Query;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;


/**
 *
 * @author WIN7
 */
public class ORM_Latihan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here
      //  RegionDAO regionDAO = new RegionDAO();// bisa menggunakan line 28 fileregionDAO
       // kalau ingin menggunkana line 32 file reggion dao maka di buat instansiasi sesion factory.
       
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Configuration configuration = new Configuration().configure();
        SessionFactory sf = configuration.buildSessionFactory();
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

            CallableStatement cs = connection.prepareCall("{ call changePostalcode(?,?) }");
            cs.setInt(1, 1000);  // first parameter index start with 1
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


        
//        RegionDAO redao = new RegionDAO(sessionFactory); //disarankan unutk menguNAKAN 
//        
//        regionDAO.getAll().forEach((region) -> {
//            System.out.println(region.getRegionId() + " - " 
//                    +region.getRegionName());
//            for (Country country : region.getCountryList()){
//                System.out.println("\t -> "+ country.getCountryId()
//                        + " - "+ country.getCountryName());
//                for (Location location : country.getLocationList()){
//                    System.out.println("\t\t --> "+ location.getCity());
//                    
//                

//            }
                
////            }
//            
//            Region r = new Region(new BigDecimal(6), "nasi goreng");
//            System.out.println(regionDAO.delete(r));
//            
//            System.out.println(regionDAO.getById("1").get(0).getRegionName());
//            System.out.println(regionDAO.getId("4").getRegionName());
//            System.out.println(regionDAO.search("2"));
////        });
//        for (Region region : regionDAO.search("2")) {
//            System.out.println(region.getRegionId());
//            System.out.println(region.getRegionName());
//         
//          CountryDAO countryDAO = new CountryDAO();
////          Country c = new Country("BG", "JAWA", new Region(new BigDecimal(1)));
////          System.out.println(countryDAO.update(c));
//
//            LocationDAO locationDAO = new LocationDAO();
//
//            for (Location location : locationDAO.search("1000")) {
//            System.out.println(location.getLocationId());
//            System.out.println(location.getStreetAddress());
//            System.out.println(location.getPostalCode());
//            System.out.println(location.getCity());
//            System.out.println(location.getStateProvince());
//            System.out.println(location.getCountryId());

   // }
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);
//                
////        JICountryView countryView = new JICountryView();
////        countryView.setVisible(true);
//        
//        JILocationView iLocationView = new JILocationView();
//        iLocationView.setVisible(true);
//   
       
    }
}

