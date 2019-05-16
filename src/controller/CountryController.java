/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Daos.CountryDAO;
import Icontroller.ICountryController;
import Idaos.ICountryDAO;
import Models.Country;
import Models.Region;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN7
 */
public class CountryController implements ICountryController{
    
    private ICountryDAO icdao;
    
    public CountryController(SessionFactory factory){
        icdao = new CountryDAO();
    }

    @Override
    public List<Country> getAll() {
        return icdao.getAll();
        
    }

    @Override
    public List<Country> getById(String id) {
        return icdao.getById(id);
    }

    @Override
    public List<Country> search(String key) {
        return icdao.search(key);
    }

    @Override
    public String insert(String id, String name, String region) {
        Country country = new Country(id, name, new Region(new BigDecimal(region)));
        if(icdao.insert(country)){
            return "insert succes";
        }else{
            return "insert failed";
        }
    }

    @Override
    public String update(String id, String name, String region) {
        Country country = new Country(id, name, new Region(new BigDecimal(region)));
        if(icdao.update(country)){
            return "update succes";
        }else{
            return "update failed";
        }
    }

    @Override
    public String delete(String id) {
        if(icdao.delete(id)){
            return "delete succes";
        }else{
            return "delete failed";
        }
    }
  
}
