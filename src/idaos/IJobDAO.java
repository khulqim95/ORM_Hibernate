/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Job;

/**
 *
 * @author sofia
 */
public interface IJobDAO {
    public boolean deleteById(Job job);
    public boolean update(Job job);
    public boolean insert(Job job);
    public List<Job> getAll();
}
