/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.util.ArrayList;
 
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.NamingManager;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import java.util.*;
import javax.naming.*;
import data.Account;
import java.util.concurrent.Future;

/**
 *
 * @author admin
 */
public class JavaApplication {

    
        private static InitialContext context;
    
        
        public static List entities = null;
        
        public static List GetEntities(Class T) throws Exception {
                                   
                if(bean == null)
                    bean = GetBeans();
                
                entities = bean.GetEntities(T);
                                
	        System.out.println("List of accounts :"+ entities.toString()); 	        
		
                return entities;
                
	}
        
    
        static ArrayList ens;
        
        public static List<Account> GetAccounts() throws Exception {
                                   
                if(bean == null)
                    bean = GetBeans();
                
                ArrayList ens = bean.entities();
                
                Future<List<Account>> acc = bean.GetAccounts();
                
                List<Account> b = acc.get();
                
	        System.out.println("List of accounts :"+b.toString()); 	        
		
                return b;
                
	}

           public static ArrayList GetEntities() throws Exception {
                                   
                if(bean == null)
                    bean = GetBeans();
                
                ens = bean.entities();
                     
		
                return ens;
                
	}
        
        public static void CreateAccount(String id) throws Exception {
                    
                InitialContext context = null;
                   
                if(bean == null)
                    bean = GetBeans();
	        
                Account account = new data.Account(id);
                
                                
                bean.CreateAccount(account);
                                
	        System.out.println("Account created : "+id.toString()); 	        
               
	}
         
        
        public static void CreateEntity(Object object) throws Exception {
                    
                InitialContext context = null;
                   
                if(bean == null)
                    bean = GetBeans();
	        
               bean.CreateEntity(object);
                                
	        System.out.println("Entity created..."); 	        
               
	}
        
        public static test.NewSessionBeanRemote bean = null;
                
    	public static test.NewSessionBeanRemote GetBean() {
                    
		try{
 
		//System.out.println("J2EE from Desktop Java");
                //Properties props = new Properties();
               
                InitialContext context = new InitialContext(); 
	        	                        
	        String name = "java:global/EJBModule/NewSessionBean";
                
                System.out.println(name);
                
	        bean = (test.NewSessionBeanRemote)context.lookup(name);
	        
		
                return bean;
                
                }catch(Exception e){
			e.printStackTrace();
		}
                
                return null;
                
	}

           public static test.NewSessionBeanRemote GetBeans() {
 
        try {
 
//            Properties props = new Properties();
//            props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost"); // default!
//            props.setProperty("org.omg.CORBA.ORBInitialPort", "3700"); // default!
//            context = new InitialContext(props);
             
            
            context = new InitialContext();
            test.NewSessionBeanRemote etr = (test.NewSessionBeanRemote) context.lookup("test.NewSessionBeanRemote");
            
            
            return etr;
 
        } catch (NamingException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }       
    
public static Object toObject( Class clazz, String value ) {
    if( Boolean.class == clazz ) return Boolean.parseBoolean( value );
    if( Byte.class == clazz ) return Byte.parseByte( value );
    if( Short.class == clazz ) return Short.parseShort( value );
    if( Integer.class == clazz ) return Integer.parseInt( value );
    if( Long.class == clazz ) return Long.parseLong( value );
    if( Float.class == clazz ) return Float.parseFloat( value );
    if( Double.class == clazz ) return Double.parseDouble( value );
    return value;
}
}
    

