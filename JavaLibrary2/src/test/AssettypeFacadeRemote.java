/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Assettype;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface AssettypeFacadeRemote {

    void create(Assettype assettype);

    void edit(Assettype assettype);

    void remove(Assettype assettype);

    Assettype find(Object id);

    List<Assettype> findAll();

    List<Assettype> findRange(int[] range);

    int count();
    
}
