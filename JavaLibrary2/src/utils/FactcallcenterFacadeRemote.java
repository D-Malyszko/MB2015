/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Factcallcenter;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FactcallcenterFacadeRemote {

    void create(Factcallcenter factcallcenter);

    void edit(Factcallcenter factcallcenter);

    void remove(Factcallcenter factcallcenter);

    Factcallcenter find(Object id);

    List<Factcallcenter> findAll();

    List<Factcallcenter> findRange(int[] range);

    int count();
    
}
