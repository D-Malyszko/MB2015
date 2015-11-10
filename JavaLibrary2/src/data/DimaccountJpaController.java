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
public class DimaccountJpaController implements Serializable {

    public DimaccountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimaccount dimaccount) throws PreexistingEntityException, Exception {
        if (dimaccount.getDimaccountCollection() == null) {
            dimaccount.setDimaccountCollection(new ArrayList<Dimaccount>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimaccount parentaccountkey = dimaccount.getParentaccountkey();
            if (parentaccountkey != null) {
                parentaccountkey = em.getReference(parentaccountkey.getClass(), parentaccountkey.getAccountkey());
                dimaccount.setParentaccountkey(parentaccountkey);
            }
            Collection<Dimaccount> attachedDimaccountCollection = new ArrayList<Dimaccount>();
            for (Dimaccount dimaccountCollectionDimaccountToAttach : dimaccount.getDimaccountCollection()) {
                dimaccountCollectionDimaccountToAttach = em.getReference(dimaccountCollectionDimaccountToAttach.getClass(), dimaccountCollectionDimaccountToAttach.getAccountkey());
                attachedDimaccountCollection.add(dimaccountCollectionDimaccountToAttach);
            }
            dimaccount.setDimaccountCollection(attachedDimaccountCollection);
            em.persist(dimaccount);
            if (parentaccountkey != null) {
                parentaccountkey.getDimaccountCollection().add(dimaccount);
                parentaccountkey = em.merge(parentaccountkey);
            }
            for (Dimaccount dimaccountCollectionDimaccount : dimaccount.getDimaccountCollection()) {
                Dimaccount oldParentaccountkeyOfDimaccountCollectionDimaccount = dimaccountCollectionDimaccount.getParentaccountkey();
                dimaccountCollectionDimaccount.setParentaccountkey(dimaccount);
                dimaccountCollectionDimaccount = em.merge(dimaccountCollectionDimaccount);
                if (oldParentaccountkeyOfDimaccountCollectionDimaccount != null) {
                    oldParentaccountkeyOfDimaccountCollectionDimaccount.getDimaccountCollection().remove(dimaccountCollectionDimaccount);
                    oldParentaccountkeyOfDimaccountCollectionDimaccount = em.merge(oldParentaccountkeyOfDimaccountCollectionDimaccount);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimaccount(dimaccount.getAccountkey()) != null) {
                throw new PreexistingEntityException("Dimaccount " + dimaccount + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimaccount dimaccount) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimaccount persistentDimaccount = em.find(Dimaccount.class, dimaccount.getAccountkey());
            Dimaccount parentaccountkeyOld = persistentDimaccount.getParentaccountkey();
            Dimaccount parentaccountkeyNew = dimaccount.getParentaccountkey();
            Collection<Dimaccount> dimaccountCollectionOld = persistentDimaccount.getDimaccountCollection();
            Collection<Dimaccount> dimaccountCollectionNew = dimaccount.getDimaccountCollection();
            if (parentaccountkeyNew != null) {
                parentaccountkeyNew = em.getReference(parentaccountkeyNew.getClass(), parentaccountkeyNew.getAccountkey());
                dimaccount.setParentaccountkey(parentaccountkeyNew);
            }
            Collection<Dimaccount> attachedDimaccountCollectionNew = new ArrayList<Dimaccount>();
            for (Dimaccount dimaccountCollectionNewDimaccountToAttach : dimaccountCollectionNew) {
                dimaccountCollectionNewDimaccountToAttach = em.getReference(dimaccountCollectionNewDimaccountToAttach.getClass(), dimaccountCollectionNewDimaccountToAttach.getAccountkey());
                attachedDimaccountCollectionNew.add(dimaccountCollectionNewDimaccountToAttach);
            }
            dimaccountCollectionNew = attachedDimaccountCollectionNew;
            dimaccount.setDimaccountCollection(dimaccountCollectionNew);
            dimaccount = em.merge(dimaccount);
            if (parentaccountkeyOld != null && !parentaccountkeyOld.equals(parentaccountkeyNew)) {
                parentaccountkeyOld.getDimaccountCollection().remove(dimaccount);
                parentaccountkeyOld = em.merge(parentaccountkeyOld);
            }
            if (parentaccountkeyNew != null && !parentaccountkeyNew.equals(parentaccountkeyOld)) {
                parentaccountkeyNew.getDimaccountCollection().add(dimaccount);
                parentaccountkeyNew = em.merge(parentaccountkeyNew);
            }
            for (Dimaccount dimaccountCollectionOldDimaccount : dimaccountCollectionOld) {
                if (!dimaccountCollectionNew.contains(dimaccountCollectionOldDimaccount)) {
                    dimaccountCollectionOldDimaccount.setParentaccountkey(null);
                    dimaccountCollectionOldDimaccount = em.merge(dimaccountCollectionOldDimaccount);
                }
            }
            for (Dimaccount dimaccountCollectionNewDimaccount : dimaccountCollectionNew) {
                if (!dimaccountCollectionOld.contains(dimaccountCollectionNewDimaccount)) {
                    Dimaccount oldParentaccountkeyOfDimaccountCollectionNewDimaccount = dimaccountCollectionNewDimaccount.getParentaccountkey();
                    dimaccountCollectionNewDimaccount.setParentaccountkey(dimaccount);
                    dimaccountCollectionNewDimaccount = em.merge(dimaccountCollectionNewDimaccount);
                    if (oldParentaccountkeyOfDimaccountCollectionNewDimaccount != null && !oldParentaccountkeyOfDimaccountCollectionNewDimaccount.equals(dimaccount)) {
                        oldParentaccountkeyOfDimaccountCollectionNewDimaccount.getDimaccountCollection().remove(dimaccountCollectionNewDimaccount);
                        oldParentaccountkeyOfDimaccountCollectionNewDimaccount = em.merge(oldParentaccountkeyOfDimaccountCollectionNewDimaccount);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimaccount.getAccountkey();
                if (findDimaccount(id) == null) {
                    throw new NonexistentEntityException("The dimaccount with id " + id + " no longer exists.");
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
            Dimaccount dimaccount;
            try {
                dimaccount = em.getReference(Dimaccount.class, id);
                dimaccount.getAccountkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimaccount with id " + id + " no longer exists.", enfe);
            }
            Dimaccount parentaccountkey = dimaccount.getParentaccountkey();
            if (parentaccountkey != null) {
                parentaccountkey.getDimaccountCollection().remove(dimaccount);
                parentaccountkey = em.merge(parentaccountkey);
            }
            Collection<Dimaccount> dimaccountCollection = dimaccount.getDimaccountCollection();
            for (Dimaccount dimaccountCollectionDimaccount : dimaccountCollection) {
                dimaccountCollectionDimaccount.setParentaccountkey(null);
                dimaccountCollectionDimaccount = em.merge(dimaccountCollectionDimaccount);
            }
            em.remove(dimaccount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimaccount> findDimaccountEntities() {
        return findDimaccountEntities(true, -1, -1);
    }

    public List<Dimaccount> findDimaccountEntities(int maxResults, int firstResult) {
        return findDimaccountEntities(false, maxResults, firstResult);
    }

    private List<Dimaccount> findDimaccountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimaccount.class));
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

    public Dimaccount findDimaccount(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimaccount.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimaccountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimaccount> rt = cq.from(Dimaccount.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
