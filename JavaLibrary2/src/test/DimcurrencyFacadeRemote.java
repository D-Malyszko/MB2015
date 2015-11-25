/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimcurrency;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimcurrencyFacadeRemote {

    void create(Dimcurrency dimcurrency);

    void edit(Dimcurrency dimcurrency);

    void remove(Dimcurrency dimcurrency);

    Dimcurrency find(Object id);

    List<Dimcurrency> findAll();

    List<Dimcurrency> findRange(int[] range);

    int count();
    
}
