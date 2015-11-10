/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimdate;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimdateFacadeRemote {

    void create(Dimdate dimdate);

    void edit(Dimdate dimdate);

    void remove(Dimdate dimdate);

    Dimdate find(Object id);

    List<Dimdate> findAll();

    List<Dimdate> findRange(int[] range);

    int count();
    
}
