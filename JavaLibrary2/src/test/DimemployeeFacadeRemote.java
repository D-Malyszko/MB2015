/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimemployee;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimemployeeFacadeRemote {

    void create(Dimemployee dimemployee);

    void edit(Dimemployee dimemployee);

    void remove(Dimemployee dimemployee);

    Dimemployee find(Object id);

    List<Dimemployee> findAll();

    List<Dimemployee> findRange(int[] range);

    int count();
    
}
