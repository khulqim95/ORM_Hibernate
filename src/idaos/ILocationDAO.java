/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import models.Location;

/**
 *
 * @author sofia
 */
public interface ILocationDAO {
    public Location getById(String locationId);
}
