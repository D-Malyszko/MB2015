/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Account;
import data.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author admin
 */
@Remote
public interface NewSessionBeanRemote {
    
    public Future<List<Account>> GetAccounts();
    
    public Object CreateCustomer(Customer customer) throws Exception;
    
    public Object CreateAccount(Account account) throws Exception;
    
    public Object CreateEntity(Object object) throws Exception;
    
    public ArrayList entities();
    
    public List<Class> GetEntities(Class T);
}
