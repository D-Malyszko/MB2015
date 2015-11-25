/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Assetentity;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface AssetentityFacadeRemote {

    void create(Assetentity assetentity);

    void edit(Assetentity assetentity);

    void remove(Assetentity assetentity);

    Assetentity find(Object id);

    List<Assetentity> findAll();

    List<Assetentity> findRange(int[] range);

    int count();
    
}
