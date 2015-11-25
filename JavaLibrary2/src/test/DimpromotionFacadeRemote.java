/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimpromotion;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimpromotionFacadeRemote {

    void create(Dimpromotion dimpromotion);

    void edit(Dimpromotion dimpromotion);

    void remove(Dimpromotion dimpromotion);

    Dimpromotion find(Object id);

    List<Dimpromotion> findAll();

    List<Dimpromotion> findRange(int[] range);

    int count();
    
}
