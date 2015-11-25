/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Factinternetsales;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FactinternetsalesFacadeRemote {

    void create(Factinternetsales factinternetsales);

    void edit(Factinternetsales factinternetsales);

    void remove(Factinternetsales factinternetsales);

    Factinternetsales find(Object id);

    List<Factinternetsales> findAll();

    List<Factinternetsales> findRange(int[] range);

    int count();
    
}
