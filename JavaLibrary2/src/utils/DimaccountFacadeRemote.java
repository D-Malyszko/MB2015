/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimaccount;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimaccountFacadeRemote {

    void create(Dimaccount dimaccount);

    void edit(Dimaccount dimaccount);

    void remove(Dimaccount dimaccount);

    Dimaccount find(Object id);

    List<Dimaccount> findAll();

    List<Dimaccount> findRange(int[] range);

    int count();
    
}
