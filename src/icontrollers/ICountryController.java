/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Country;

/**
 *
 * @author Ode
 */
public interface ICountryController {

    public List<Country> getAll();

    public String delete(Country country);

    public List<Country> search(String keyword);
}
