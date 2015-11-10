/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimproductcategory;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimproductcategoryFacadeRemote {

    void create(Dimproductcategory dimproductcategory);

    void edit(Dimproductcategory dimproductcategory);

    void remove(Dimproductcategory dimproductcategory);

    Dimproductcategory find(Object id);

    List<Dimproductcategory> findAll();

    List<Dimproductcategory> findRange(int[] range);

    int count();
    
}
