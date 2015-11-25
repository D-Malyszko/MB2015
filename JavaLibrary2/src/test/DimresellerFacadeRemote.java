/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimreseller;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimresellerFacadeRemote {

    void create(Dimreseller dimreseller);

    void edit(Dimreseller dimreseller);

    void remove(Dimreseller dimreseller);

    Dimreseller find(Object id);

    List<Dimreseller> findAll();

    List<Dimreseller> findRange(int[] range);

    int count();
    
}
