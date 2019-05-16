/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDao;
import daos.RegionDAO;
import icontrollers.IJobController;
import idaos.IJobDAO;
import idaos.IRegionDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Relion31
 */
public class JobController implements IJobController {

    private IJobDAO ijdao;
    public JobController(SessionFactory factory) {
        ijdao = new JobDao(factory);
    }

    @Override
    public List<Job> getAll() {
        return ijdao.getData(new Job(""), false);
    }

    @Override
    public List<Job> search(String key) {
        return ijdao.search(key);
    }

}
