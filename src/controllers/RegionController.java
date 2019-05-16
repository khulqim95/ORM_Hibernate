/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import idaos.IRegionDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Region;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;
import icontrollers.IRegionController;

/**
 *
 * @author Relion31
 */
public class RegionController implements IRegionController {

 //   private SessionFactory sessionFactory = null;
    private IRegionDAO irdao;

    public RegionController(SessionFactory factory) {
        irdao = new RegionDAO(factory);
    }

    @Override
    public List<Region> getAll() {
       return irdao.getData(new Region(), false);
    }

    @Override
    public List<Region> search(String key) {
        return irdao.search(key);
    }

}
