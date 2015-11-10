/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Orgunit;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface OrgunitFacadeRemote {

    void create(Orgunit orgunit);

    void edit(Orgunit orgunit);

    void remove(Orgunit orgunit);

    Orgunit find(Object id);

    List<Orgunit> findAll();

    List<Orgunit> findRange(int[] range);

    int count();
    
}
