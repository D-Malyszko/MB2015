/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Fileformat;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FileformatFacadeRemote {

    void create(Fileformat fileformat);

    void edit(Fileformat fileformat);

    void remove(Fileformat fileformat);

    Fileformat find(Object id);

    List<Fileformat> findAll();

    List<Fileformat> findRange(int[] range);

    int count();
    
}
