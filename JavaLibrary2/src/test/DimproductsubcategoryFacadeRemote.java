/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimproductsubcategory;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimproductsubcategoryFacadeRemote {

    void create(Dimproductsubcategory dimproductsubcategory);

    void edit(Dimproductsubcategory dimproductsubcategory);

    void remove(Dimproductsubcategory dimproductsubcategory);

    Dimproductsubcategory find(Object id);

    List<Dimproductsubcategory> findAll();

    List<Dimproductsubcategory> findRange(int[] range);

    int count();
    
}
