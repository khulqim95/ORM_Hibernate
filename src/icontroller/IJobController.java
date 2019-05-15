/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontroller;

import models.Job;

/**
 *
 * @author sofia
 */
public interface IJobController {
    public String update(String id, String name, int min, int max); 
    public String delete(Job job); 
}
