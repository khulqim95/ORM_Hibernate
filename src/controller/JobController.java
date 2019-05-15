/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.JobDAO;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author sofia
 */
public class JobController implements icontroller.IJobController{
    
    private JobDAO jdao;

    
    public JobController(SessionFactory factory) {
        jdao = new JobDAO(factory);
    }
    
    
    @Override
    public String update(String id, String name, int min, int max) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Job job = new Job(id, name, new Integer(min), new Integer(max));
        job.setJobId(id);
        if (jdao.update(job)) {
            return "update success";
        }else {
            return "update failed";
        }
    }

    @Override
    public String delete(Job job) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        String result = "";
        if (jdao.deleteById(job)) {
            result = "delete success";
        }else {
            result =  "delete failed";
        }
        return result;
    }
    
}
