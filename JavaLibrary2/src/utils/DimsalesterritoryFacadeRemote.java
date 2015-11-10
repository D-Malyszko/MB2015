/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimsalesterritory;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimsalesterritoryFacadeRemote {

    void create(Dimsalesterritory dimsalesterritory);

    void edit(Dimsalesterritory dimsalesterritory);

    void remove(Dimsalesterritory dimsalesterritory);

    Dimsalesterritory find(Object id);

    List<Dimsalesterritory> findAll();

    List<Dimsalesterritory> findRange(int[] range);

    int count();
    
}
