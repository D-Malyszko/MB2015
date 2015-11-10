/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Menuitem;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface MenuitemFacadeRemote {

    void create(Menuitem menuitem);

    void edit(Menuitem menuitem);

    void remove(Menuitem menuitem);

    Menuitem find(Object id);

    List<Menuitem> findAll();

    List<Menuitem> findRange(int[] range);

    int count();
    
}
