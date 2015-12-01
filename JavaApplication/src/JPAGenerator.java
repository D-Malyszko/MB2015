
import javax.persistence.Persistence;

import org.apache.openjpa.jdbc.schema.SchemaTool;

import org.apache.openjpa.jdbc.meta.ReverseMappingTool;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class JPAGenerator {
    
    
    public static void main(String[] args) throws Exception {
    //Persistence.generateSchema("SamplePU", null);
        
        
        String [] arg = new String[6];
        
        arg[0] = "-properties";
        arg[1] = "persistance.xml";
        arg[2] = "-action";
        arg[3] = "reflect";
        arg[4] = "-file";
        arg[5] = "schema.xml";
        
        SchemaTool.main(arg);
        
        arg = new String[11];
        
        
        arg[0] = "-properties";
        arg[1] = "persistance.xml";
        arg[2] = "-metadata";
        arg[3] = "none";
        arg[4] = "-annotations";
        arg[5] = "true";
        arg[6] = "-nullableAsObjec";
        arg[7] = "true";
        arg[8] = "-useGenericCollections";
        arg[9] = "true";
        arg[10] = "schema.xml";
        
        ReverseMappingTool.main(arg);
        
        
    
        
        
        
  }
    
}
