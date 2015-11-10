/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Factproductinventory;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FactproductinventoryFacadeRemote {

    void create(Factproductinventory factproductinventory);

    void edit(Factproductinventory factproductinventory);

    void remove(Factproductinventory factproductinventory);

    Factproductinventory find(Object id);

    List<Factproductinventory> findAll();

    List<Factproductinventory> findRange(int[] range);

    int count();
    
}
