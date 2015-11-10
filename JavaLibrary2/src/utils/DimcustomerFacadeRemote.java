/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimcustomer;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimcustomerFacadeRemote {

    void create(Dimcustomer dimcustomer);

    void edit(Dimcustomer dimcustomer);

    void remove(Dimcustomer dimcustomer);

    Dimcustomer find(Object id);

    List<Dimcustomer> findAll();

    List<Dimcustomer> findRange(int[] range);

    int count();
    
}
