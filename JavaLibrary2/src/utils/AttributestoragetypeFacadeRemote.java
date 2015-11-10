/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Attributestoragetype;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface AttributestoragetypeFacadeRemote {

    void create(Attributestoragetype attributestoragetype);

    void edit(Attributestoragetype attributestoragetype);

    void remove(Attributestoragetype attributestoragetype);

    Attributestoragetype find(Object id);

    List<Attributestoragetype> findAll();

    List<Attributestoragetype> findRange(int[] range);

    int count();
    
}
