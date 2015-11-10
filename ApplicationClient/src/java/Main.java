/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ejb.EJB;
import data.Account;
import data.Customer;
import java.util.List;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.NewSessionBeanRemote;




/**
 *
 * @author admin
 */
public class Main {
    @EJB
    private static NewSessionBeanRemote newSessionBean;
   
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
                       
            Future<List<Account>> b = ((NewSessionBeanRemote)newSessionBean).GetAccounts();
            
            
            while (!b.isDone()) {
                Thread.sleep(10000);
                System.out.println("Waiting for server to respond");
            }
         
            
            Account account = new Account("53234567");
            
            Customer customer = new Customer("5322343");
            
                        
            newSessionBean.CreateAccount(account);
            
            newSessionBean.CreateCustomer(customer);
            
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
