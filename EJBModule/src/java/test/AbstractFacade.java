/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    private static EntityManager em;
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
            System.out.println("EM null reference");
            final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EJBModule1PU");
            em = emf.createEntityManager();
            System.out.println("EM created...");
    }

    protected abstract EntityManager getEntityManager();

    public EntityManager getEntityManagers(){
        
        return em;
    }
    
    public void create(T entity) {
        getEntityManagers().persist(entity);
    }

    public void edit(T entity) {
        getEntityManagers().merge(entity);
    }

    public void remove(T entity) {
        getEntityManagers().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManagers().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManagers().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManagers().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManagers().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManagers().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManagers().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManagers().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManagers().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
