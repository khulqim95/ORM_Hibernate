/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import icontrollers.IJobController;
import idaos.IJobDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASUS
 */
public class JobController implements IJobController{
    private IJobDAO ijc;

    public JobController(SessionFactory factory) {
        ijc = new JobDAO(factory);
    }
    
    @Override
    public List<Job> getAll() {
        return ijc.getAll();
    }

    @Override
    public List<Job> getById(String id) {
        return ijc.getById(id);
    }

    @Override
    public List<Job> search(Object keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String name, int min, int max) {
        Job job = new Job(id, name, min, max);
        if (ijc.insert(job)) {
            return "Insert Success";
        } else {
            return "Insert Failed";
        }
    }

    @Override
    public String update(String id, String name, int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
