/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimproduct;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimproductFacadeRemote {

    void create(Dimproduct dimproduct);

    void edit(Dimproduct dimproduct);

    void remove(Dimproduct dimproduct);

    Dimproduct find(Object id);

    List<Dimproduct> findAll();

    List<Dimproduct> findRange(int[] range);

    int count();
    
}
