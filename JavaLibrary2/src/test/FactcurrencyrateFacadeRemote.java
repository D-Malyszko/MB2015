/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Factcurrencyrate;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FactcurrencyrateFacadeRemote {

    void create(Factcurrencyrate factcurrencyrate);

    void edit(Factcurrencyrate factcurrencyrate);

    void remove(Factcurrencyrate factcurrencyrate);

    Factcurrencyrate find(Object id);

    List<Factcurrencyrate> findAll();

    List<Factcurrencyrate> findRange(int[] range);

    int count();
    
}
