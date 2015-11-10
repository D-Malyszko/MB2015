/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.CmCategory;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface CmCategoryFacadeRemote {

    void create(CmCategory cmCategory);

    void edit(CmCategory cmCategory);

    void remove(CmCategory cmCategory);

    CmCategory find(Object id);

    List<CmCategory> findAll();

    List<CmCategory> findRange(int[] range);

    int count();
    
}
