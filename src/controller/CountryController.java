/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.CountryDAO;
import icontroller.ICountryController;
import java.util.List;
import models.Country;
import org.hibernate.SessionFactory;

/**
 *
 * @author sofia
 */
public class CountryController implements ICountryController{
    
    private CountryDAO cdao;

    
    public CountryController(SessionFactory factory) {
        cdao = new CountryDAO(factory);
    }
    
    @Override
    public List<Country> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return cdao.getAll();
    }

}
