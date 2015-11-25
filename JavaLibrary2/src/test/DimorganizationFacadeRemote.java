/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimorganization;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimorganizationFacadeRemote {

    void create(Dimorganization dimorganization);

    void edit(Dimorganization dimorganization);

    void remove(Dimorganization dimorganization);

    Dimorganization find(Object id);

    List<Dimorganization> findAll();

    List<Dimorganization> findRange(int[] range);

    int count();
    
}
