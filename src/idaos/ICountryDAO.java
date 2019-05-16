/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Country;

/**
 *
 * @author sofia
 */
public interface ICountryDAO {
   public List<Country> getAll();
    public Country getById(String countryId);
    public boolean insert(Country country);
    
    public List<Country> search(Object keyword);
    public boolean update(Country country);
    public boolean delete(Country country);
}
