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
 * @author Relion31
 */
public interface IJobController {
    public List<Job> getAll();
    public List<Job> search(String key);
}
