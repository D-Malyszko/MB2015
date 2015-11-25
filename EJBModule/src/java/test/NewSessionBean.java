/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import data.AccountJpaController;
import data.Customer;
import data.CustomerJpaController;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.Future;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.interceptor.Interceptors;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;





/**
 *
 * @author admin
 */
@Stateless
@SampleBinding(transaction = true)
//@Interceptors(SampleInterceptor.class)
public class NewSessionBean implements NewSessionBeanRemote {
    
    
    public void test(){
        
    }
    
    
    @PersistenceContext(unitName = "EJBModule1PU")
    private EntityManager em;
    
    
    private static AccountJpaController c;

    public void persist(Object object) {
        em.persist(object);
    }

    @Asynchronous
    @Interceptors(SampleInterceptor.class)
    public Future<List<Account>> GetAccounts(){
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModule1PU");
        
        AccountJpaController c = new AccountJpaController(emf);
        
        List<Account> f = c.findAccountEntities();
        
                
        return new AsyncResult<List<Account>>(f);
        
        
    }
      
    @Interceptors(SampleInterceptor.class)
      public Object CreateAccount(Account account)throws Exception{
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModule1PU");
        
        
         
        AccountJpaController c = new AccountJpaController(emf);
        
        c.create(account);
        
         return account;
        
    }
    

      @SampleBinding(transaction=true)
       public Object CreateCustomer(Customer customer)throws Exception{
           
           
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModule1PU");
        
        
        CustomerJpaController cs = new CustomerJpaController(emf);
        
        cs.create(customer);
        
        
       
         return customer;
        
    }
     
   public ArrayList entities() {
       
 
    ArrayList cls = new ArrayList();
    
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModule1PU");
    final Metamodel mm = emf.getMetamodel();
    for (final ManagedType<?> managedType : mm.getManagedTypes()) {
      Class clazz = managedType.getJavaType(); // this returns the java class of the @Entity object
      System.out.println("ejb " + clazz.getName());
      cls.add(clazz);
    }
    return cls;
  }
   
     public AbstractFacade entities(Class T) {
       
         System.out.println(T.getName());
         
         String name = T.getName();
         
         if(name.equals("data.Account") == true)
             return new AccountFacade();
      
             return null;
             
    
    
  }
   
   
     public List<Class> GetEntities(Class T){
         
         
         AbstractFacade f = entities(T);
         
         return f.findAll();
         
         
     }
     
     
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
