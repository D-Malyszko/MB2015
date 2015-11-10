/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimsalesreason;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimsalesreasonFacadeRemote {

    void create(Dimsalesreason dimsalesreason);

    void edit(Dimsalesreason dimsalesreason);

    void remove(Dimsalesreason dimsalesreason);

    Dimsalesreason find(Object id);

    List<Dimsalesreason> findAll();

    List<Dimsalesreason> findRange(int[] range);

    int count();
    
}
