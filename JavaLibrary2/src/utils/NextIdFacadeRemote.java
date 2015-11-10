/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.NextId;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface NextIdFacadeRemote {

    void create(NextId nextId);

    void edit(NextId nextId);

    void remove(NextId nextId);

    NextId find(Object id);

    List<NextId> findAll();

    List<NextId> findRange(int[] range);

    int count();
    
}
