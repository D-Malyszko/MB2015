/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Factsalesquota;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FactsalesquotaFacadeRemote {

    void create(Factsalesquota factsalesquota);

    void edit(Factsalesquota factsalesquota);

    void remove(Factsalesquota factsalesquota);

    Factsalesquota find(Object id);

    List<Factsalesquota> findAll();

    List<Factsalesquota> findRange(int[] range);

    int count();
    
}
