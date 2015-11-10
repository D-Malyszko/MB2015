/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Attributetype;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface AttributetypeFacadeRemote {

    void create(Attributetype attributetype);

    void edit(Attributetype attributetype);

    void remove(Attributetype attributetype);

    Attributetype find(Object id);

    List<Attributetype> findAll();

    List<Attributetype> findRange(int[] range);

    int count();
    
}
