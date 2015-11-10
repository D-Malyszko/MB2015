/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Asset;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface AssetFacadeRemote {

    void create(Asset asset);

    void edit(Asset asset);

    void remove(Asset asset);

    Asset find(Object id);

    List<Asset> findAll();

    List<Asset> findRange(int[] range);

    int count();
    
}
