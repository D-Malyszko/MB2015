/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Division;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DivisionFacadeRemote {

    void create(Division division);

    void edit(Division division);

    void remove(Division division);

    Division find(Object id);

    List<Division> findAll();

    List<Division> findRange(int[] range);

    int count();
    
}
