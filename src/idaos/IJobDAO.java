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
 * @author Relion31
 */
public interface IJobDAO {
    public List<Job> getData(Job j, boolean isGetById);
    public List<Job> search(Object key);
    public boolean delete(Job j);
}
