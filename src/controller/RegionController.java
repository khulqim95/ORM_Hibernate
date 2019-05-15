/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.RegionDAO;
import icontroller.IRegionController;
import java.math.BigDecimal;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author sofia
 */
public class RegionController implements IRegionController{
    private RegionDAO rdao;

    public RegionController(SessionFactory factory) {
        rdao = new RegionDAO(factory);
    }

    @Override
    public String insert(Region region) {
        //throw new UnsupportedOperationException("Not supported yet."re); //To change body of generated methods, choose Tools | Templates.
        String result = "";         
        if (rdao.insertRegion(region)) {
            result = "insert success";
        }else {
            result =  "insert failed";
        }
        return result;
    }
    
}
