/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Assetbankuser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface AssetbankuserFacadeRemote {

    void create(Assetbankuser assetbankuser);

    void edit(Assetbankuser assetbankuser);

    void remove(Assetbankuser assetbankuser);

    Assetbankuser find(Object id);

    List<Assetbankuser> findAll();

    List<Assetbankuser> findRange(int[] range);

    int count();
    
}
