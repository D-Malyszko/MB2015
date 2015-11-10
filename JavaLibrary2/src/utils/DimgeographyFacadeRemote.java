/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimgeography;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimgeographyFacadeRemote {

    void create(Dimgeography dimgeography);

    void edit(Dimgeography dimgeography);

    void remove(Dimgeography dimgeography);

    Dimgeography find(Object id);

    List<Dimgeography> findAll();

    List<Dimgeography> findRange(int[] range);

    int count();
    
}
