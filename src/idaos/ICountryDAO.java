/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idaos;

import models.Country;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface ICountryDAO {
    
    public List<Country> getAll();
    
    public boolean insert(Country c);
    
    public boolean update(Country c);

    public Country getId(String id);
    
    public List<Country> getById(String id);
    
    public List<Country> search (String key);

    public boolean delete(String id);
    
}
