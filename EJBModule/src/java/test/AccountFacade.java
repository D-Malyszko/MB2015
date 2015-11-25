/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import data.Account;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeRemote {
    @PersistenceContext(unitName = "EJBModule1PU")
    static private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        if(em == null) {
            System.out.println("EM null reference");
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModule1PU");
            em = emf.createEntityManager();
            System.out.println("EM created...");
        }
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }
    
}
