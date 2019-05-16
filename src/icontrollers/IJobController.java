/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author ASUS
 */
public interface IJobController {

    public List<Job> getAll();

    public List <Job> getById(String id);

    public List<Job> search(Object keyword);

    public String insert(String id, String name, int min, int max);

    public String update(String id, String name, int min, int max);

    public String delete(String id);
}
