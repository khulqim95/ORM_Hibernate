/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Daos.RegionDAO;
import Icontroller.IRegionController;
import Idaos.IRegionDAO;
import Models.Region;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author WIN7
 */
public class RegionController implements IRegionController {
    
    private IRegionDAO irdao;
    
    public RegionController(SessionFactory factory){
        irdao = new RegionDAO();
    }

    @Override
    public List<Region> getAll() {
        return irdao.getAll();
    }
//
//    @Override
//    public List<Region> getById(String id) {
//        return irdao.getById(new BigDecimal(id));
//    }

    @Override
    public List<Region> search(String key) {
        return irdao.search(key);
    }

    @Override
    public String insert(String id, String name) {
        Region region = new Region(new BigDecimal(id), name);
        if (irdao.insert(region)) {
            return "insert succes";
            
        }else{
            return "insert failed";
        }
    }

    @Override
    public String update(String id, String name) {
        Region region = new Region(new BigDecimal(id), name);
        if (irdao.update(region)) {
            return "update succes";
            
        }else{
            return "update failed";
        }
    }
//
//    @Override
//    public String delete(String id) {
//        if (irdao.delete(new BigDecimal(id))){
//            return "delete succes";      
//        }else{
//            return "delete failed";
//        }

//}

    @Override
    public List<Region> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}