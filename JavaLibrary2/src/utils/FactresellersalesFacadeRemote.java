/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Factresellersales;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FactresellersalesFacadeRemote {

    void create(Factresellersales factresellersales);

    void edit(Factresellersales factresellersales);

    void remove(Factresellersales factresellersales);

    Factresellersales find(Object id);

    List<Factresellersales> findAll();

    List<Factresellersales> findRange(int[] range);

    int count();
    
}
