/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.CmCategorytype;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface CmCategorytypeFacadeRemote {

    void create(CmCategorytype cmCategorytype);

    void edit(CmCategorytype cmCategorytype);

    void remove(CmCategorytype cmCategorytype);

    CmCategorytype find(Object id);

    List<CmCategorytype> findAll();

    List<CmCategorytype> findRange(int[] range);

    int count();
    
}
