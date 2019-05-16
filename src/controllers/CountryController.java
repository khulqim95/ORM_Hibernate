/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.CountryDAO;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import java.util.List;
import models.Country;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ode
 */
public class CountryController implements ICountryController {

    private CountryDAO countryDAO;

    public CountryController(SessionFactory sessionFactory) {
        this.countryDAO = new CountryDAO(sessionFactory);
    }

    @Override
    public List<Country> getAll() {
        return countryDAO.getAll();
    }

    @Override
    public String delete(Country country) {
        String result = "Maaf data gagal dihapus";
        if (countryDAO.delete(country)) {
            result = "Data berhasil dihapus";
        } else {
            result = "Data gagal dihapus";
        }
        return result;
    }

    @Override
    public List<Country> search(String keyword) {
        return countryDAO.search(keyword);
    }

}
