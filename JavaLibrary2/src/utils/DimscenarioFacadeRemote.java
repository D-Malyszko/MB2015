/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Dimscenario;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface DimscenarioFacadeRemote {

    void create(Dimscenario dimscenario);

    void edit(Dimscenario dimscenario);

    void remove(Dimscenario dimscenario);

    Dimscenario find(Object id);

    List<Dimscenario> findAll();

    List<Dimscenario> findRange(int[] range);

    int count();
    
}
