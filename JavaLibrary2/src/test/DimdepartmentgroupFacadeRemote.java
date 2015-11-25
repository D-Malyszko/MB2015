/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Dimdepartmentgroup;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimdepartmentgroupFacadeRemote {

    void create(Dimdepartmentgroup dimdepartmentgroup);

    void edit(Dimdepartmentgroup dimdepartmentgroup);

    void remove(Dimdepartmentgroup dimdepartmentgroup);

    Dimdepartmentgroup find(Object id);

    List<Dimdepartmentgroup> findAll();

    List<Dimdepartmentgroup> findRange(int[] range);

    int count();
    
}
