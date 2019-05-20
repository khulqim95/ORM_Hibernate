package controllers;

import daos.CountryDAO;
import daos.GeneralDAO;
import entities.Country;
import entities.Region;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import idaos.IGeneralDAO;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author RR17
 */
public class CountryController<T> implements ICountryController<T>{
    private IGeneralDAO igdao = null;
    
    public CountryController(SessionFactory sessionFactory){
        igdao = new GeneralDAO<>(Country.class, sessionFactory);
    }

    @Override
    public List<T> getAll() {
        return igdao.getData("", false);
    }

    @Override
    public List<T> getById(String countryId) {
        return igdao.getData("countryId", true);
    }

    @Override
    public String insert(String countryId, String countryName, String regionId) {
        Country country = new Country(countryId, countryName, new Region(new BigDecimal(regionId)));
        String result="Insert Failed";
        if (igdao.saveOrDelete(country, true)){
            result = "true";
        } 
//        else {
//            result = "Insert Failed";
//        }
        return result;
    }

    @Override
    public List<T> search(String keyword) {
        return igdao.getData(keyword, false);
    }

    @Override
    public String update(String countryId, String countryName, Region regionId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String countryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
