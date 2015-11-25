/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Attribute;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface AttributeFacadeRemote {

    void create(Attribute attribute);

    void edit(Attribute attribute);

    void remove(Attribute attribute);

    Attribute find(Object id);

    List<Attribute> findAll();

    List<Attribute> findRange(int[] range);

    int count();
    
}
