/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author yosef
 */
public class RegionController implements IRegionController{
    
    private IRegionDAO rdao;
    
    public RegionController (SessionFactory factory){
        rdao = new RegionDAO();
    }
    
    @Override
    public List<Region> getById(String id) {
        return rdao.getById((id));
    }

    @Override
    public String delete(Region r) {
        String result = "";
        if (rdao.delete(r)) {
            result = "delete success";
        }else {
            result =  "delete failed";
        }
        return result;
    }

    @Override
    public List<Region> getAll() {
       return rdao.getAll();
    }

    @Override
    public List<Region> search(String key) {
        return rdao.search(key);
    }
}
