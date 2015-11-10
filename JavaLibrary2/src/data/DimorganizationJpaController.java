/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.NonexistentEntityException;
import data.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author admin
 */
public class DimorganizationJpaController implements Serializable {

    public DimorganizationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimorganization dimorganization) throws PreexistingEntityException, Exception {
        if (dimorganization.getDimorganizationCollection() == null) {
            dimorganization.setDimorganizationCollection(new ArrayList<Dimorganization>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimcurrency currencykey = dimorganization.getCurrencykey();
            if (currencykey != null) {
                currencykey = em.getReference(currencykey.getClass(), currencykey.getCurrencykey());
                dimorganization.setCurrencykey(currencykey);
            }
            Dimorganization parentorganizationkey = dimorganization.getParentorganizationkey();
            if (parentorganizationkey != null) {
                parentorganizationkey = em.getReference(parentorganizationkey.getClass(), parentorganizationkey.getOrganizationkey());
                dimorganization.setParentorganizationkey(parentorganizationkey);
            }
            Collection<Dimorganization> attachedDimorganizationCollection = new ArrayList<Dimorganization>();
            for (Dimorganization dimorganizationCollectionDimorganizationToAttach : dimorganization.getDimorganizationCollection()) {
                dimorganizationCollectionDimorganizationToAttach = em.getReference(dimorganizationCollectionDimorganizationToAttach.getClass(), dimorganizationCollectionDimorganizationToAttach.getOrganizationkey());
                attachedDimorganizationCollection.add(dimorganizationCollectionDimorganizationToAttach);
            }
            dimorganization.setDimorganizationCollection(attachedDimorganizationCollection);
            em.persist(dimorganization);
            if (currencykey != null) {
                currencykey.getDimorganizationCollection().add(dimorganization);
                currencykey = em.merge(currencykey);
            }
            if (parentorganizationkey != null) {
                parentorganizationkey.getDimorganizationCollection().add(dimorganization);
                parentorganizationkey = em.merge(parentorganizationkey);
            }
            for (Dimorganization dimorganizationCollectionDimorganization : dimorganization.getDimorganizationCollection()) {
                Dimorganization oldParentorganizationkeyOfDimorganizationCollectionDimorganization = dimorganizationCollectionDimorganization.getParentorganizationkey();
                dimorganizationCollectionDimorganization.setParentorganizationkey(dimorganization);
                dimorganizationCollectionDimorganization = em.merge(dimorganizationCollectionDimorganization);
                if (oldParentorganizationkeyOfDimorganizationCollectionDimorganization != null) {
                    oldParentorganizationkeyOfDimorganizationCollectionDimorganization.getDimorganizationCollection().remove(dimorganizationCollectionDimorganization);
                    oldParentorganizationkeyOfDimorganizationCollectionDimorganization = em.merge(oldParentorganizationkeyOfDimorganizationCollectionDimorganization);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimorganization(dimorganization.getOrganizationkey()) != null) {
                throw new PreexistingEntityException("Dimorganization " + dimorganization + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimorganization dimorganization) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimorganization persistentDimorganization = em.find(Dimorganization.class, dimorganization.getOrganizationkey());
            Dimcurrency currencykeyOld = persistentDimorganization.getCurrencykey();
            Dimcurrency currencykeyNew = dimorganization.getCurrencykey();
            Dimorganization parentorganizationkeyOld = persistentDimorganization.getParentorganizationkey();
            Dimorganization parentorganizationkeyNew = dimorganization.getParentorganizationkey();
            Collection<Dimorganization> dimorganizationCollectionOld = persistentDimorganization.getDimorganizationCollection();
            Collection<Dimorganization> dimorganizationCollectionNew = dimorganization.getDimorganizationCollection();
            if (currencykeyNew != null) {
                currencykeyNew = em.getReference(currencykeyNew.getClass(), currencykeyNew.getCurrencykey());
                dimorganization.setCurrencykey(currencykeyNew);
            }
            if (parentorganizationkeyNew != null) {
                parentorganizationkeyNew = em.getReference(parentorganizationkeyNew.getClass(), parentorganizationkeyNew.getOrganizationkey());
                dimorganization.setParentorganizationkey(parentorganizationkeyNew);
            }
            Collection<Dimorganization> attachedDimorganizationCollectionNew = new ArrayList<Dimorganization>();
            for (Dimorganization dimorganizationCollectionNewDimorganizationToAttach : dimorganizationCollectionNew) {
                dimorganizationCollectionNewDimorganizationToAttach = em.getReference(dimorganizationCollectionNewDimorganizationToAttach.getClass(), dimorganizationCollectionNewDimorganizationToAttach.getOrganizationkey());
                attachedDimorganizationCollectionNew.add(dimorganizationCollectionNewDimorganizationToAttach);
            }
            dimorganizationCollectionNew = attachedDimorganizationCollectionNew;
            dimorganization.setDimorganizationCollection(dimorganizationCollectionNew);
            dimorganization = em.merge(dimorganization);
            if (currencykeyOld != null && !currencykeyOld.equals(currencykeyNew)) {
                currencykeyOld.getDimorganizationCollection().remove(dimorganization);
                currencykeyOld = em.merge(currencykeyOld);
            }
            if (currencykeyNew != null && !currencykeyNew.equals(currencykeyOld)) {
                currencykeyNew.getDimorganizationCollection().add(dimorganization);
                currencykeyNew = em.merge(currencykeyNew);
            }
            if (parentorganizationkeyOld != null && !parentorganizationkeyOld.equals(parentorganizationkeyNew)) {
                parentorganizationkeyOld.getDimorganizationCollection().remove(dimorganization);
                parentorganizationkeyOld = em.merge(parentorganizationkeyOld);
            }
            if (parentorganizationkeyNew != null && !parentorganizationkeyNew.equals(parentorganizationkeyOld)) {
                parentorganizationkeyNew.getDimorganizationCollection().add(dimorganization);
                parentorganizationkeyNew = em.merge(parentorganizationkeyNew);
            }
            for (Dimorganization dimorganizationCollectionOldDimorganization : dimorganizationCollectionOld) {
                if (!dimorganizationCollectionNew.contains(dimorganizationCollectionOldDimorganization)) {
                    dimorganizationCollectionOldDimorganization.setParentorganizationkey(null);
                    dimorganizationCollectionOldDimorganization = em.merge(dimorganizationCollectionOldDimorganization);
                }
            }
            for (Dimorganization dimorganizationCollectionNewDimorganization : dimorganizationCollectionNew) {
                if (!dimorganizationCollectionOld.contains(dimorganizationCollectionNewDimorganization)) {
                    Dimorganization oldParentorganizationkeyOfDimorganizationCollectionNewDimorganization = dimorganizationCollectionNewDimorganization.getParentorganizationkey();
                    dimorganizationCollectionNewDimorganization.setParentorganizationkey(dimorganization);
                    dimorganizationCollectionNewDimorganization = em.merge(dimorganizationCollectionNewDimorganization);
                    if (oldParentorganizationkeyOfDimorganizationCollectionNewDimorganization != null && !oldParentorganizationkeyOfDimorganizationCollectionNewDimorganization.equals(dimorganization)) {
                        oldParentorganizationkeyOfDimorganizationCollectionNewDimorganization.getDimorganizationCollection().remove(dimorganizationCollectionNewDimorganization);
                        oldParentorganizationkeyOfDimorganizationCollectionNewDimorganization = em.merge(oldParentorganizationkeyOfDimorganizationCollectionNewDimorganization);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimorganization.getOrganizationkey();
                if (findDimorganization(id) == null) {
                    throw new NonexistentEntityException("The dimorganization with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimorganization dimorganization;
            try {
                dimorganization = em.getReference(Dimorganization.class, id);
                dimorganization.getOrganizationkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimorganization with id " + id + " no longer exists.", enfe);
            }
            Dimcurrency currencykey = dimorganization.getCurrencykey();
            if (currencykey != null) {
                currencykey.getDimorganizationCollection().remove(dimorganization);
                currencykey = em.merge(currencykey);
            }
            Dimorganization parentorganizationkey = dimorganization.getParentorganizationkey();
            if (parentorganizationkey != null) {
                parentorganizationkey.getDimorganizationCollection().remove(dimorganization);
                parentorganizationkey = em.merge(parentorganizationkey);
            }
            Collection<Dimorganization> dimorganizationCollection = dimorganization.getDimorganizationCollection();
            for (Dimorganization dimorganizationCollectionDimorganization : dimorganizationCollection) {
                dimorganizationCollectionDimorganization.setParentorganizationkey(null);
                dimorganizationCollectionDimorganization = em.merge(dimorganizationCollectionDimorganization);
            }
            em.remove(dimorganization);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimorganization> findDimorganizationEntities() {
        return findDimorganizationEntities(true, -1, -1);
    }

    public List<Dimorganization> findDimorganizationEntities(int maxResults, int firstResult) {
        return findDimorganizationEntities(false, maxResults, firstResult);
    }

    private List<Dimorganization> findDimorganizationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimorganization.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Dimorganization findDimorganization(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimorganization.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimorganizationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimorganization> rt = cq.from(Dimorganization.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
