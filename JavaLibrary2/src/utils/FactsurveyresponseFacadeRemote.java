/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import data.Factsurveyresponse;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface FactsurveyresponseFacadeRemote {

    void create(Factsurveyresponse factsurveyresponse);

    void edit(Factsurveyresponse factsurveyresponse);

    void remove(Factsurveyresponse factsurveyresponse);

    Factsurveyresponse find(Object id);

    List<Factsurveyresponse> findAll();

    List<Factsurveyresponse> findRange(int[] range);

    int count();
    
}
