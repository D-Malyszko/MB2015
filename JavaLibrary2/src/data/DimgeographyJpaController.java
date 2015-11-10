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
public class DimgeographyJpaController implements Serializable {

    public DimgeographyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimgeography dimgeography) throws PreexistingEntityException, Exception {
        if (dimgeography.getDimcustomerCollection() == null) {
            dimgeography.setDimcustomerCollection(new ArrayList<Dimcustomer>());
        }
        if (dimgeography.getDimresellerCollection() == null) {
            dimgeography.setDimresellerCollection(new ArrayList<Dimreseller>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimsalesterritory salesterritorykey = dimgeography.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey = em.getReference(salesterritorykey.getClass(), salesterritorykey.getSalesterritorykey());
                dimgeography.setSalesterritorykey(salesterritorykey);
            }
            Collection<Dimcustomer> attachedDimcustomerCollection = new ArrayList<Dimcustomer>();
            for (Dimcustomer dimcustomerCollectionDimcustomerToAttach : dimgeography.getDimcustomerCollection()) {
                dimcustomerCollectionDimcustomerToAttach = em.getReference(dimcustomerCollectionDimcustomerToAttach.getClass(), dimcustomerCollectionDimcustomerToAttach.getCustomerkey());
                attachedDimcustomerCollection.add(dimcustomerCollectionDimcustomerToAttach);
            }
            dimgeography.setDimcustomerCollection(attachedDimcustomerCollection);
            Collection<Dimreseller> attachedDimresellerCollection = new ArrayList<Dimreseller>();
            for (Dimreseller dimresellerCollectionDimresellerToAttach : dimgeography.getDimresellerCollection()) {
                dimresellerCollectionDimresellerToAttach = em.getReference(dimresellerCollectionDimresellerToAttach.getClass(), dimresellerCollectionDimresellerToAttach.getResellerkey());
                attachedDimresellerCollection.add(dimresellerCollectionDimresellerToAttach);
            }
            dimgeography.setDimresellerCollection(attachedDimresellerCollection);
            em.persist(dimgeography);
            if (salesterritorykey != null) {
                salesterritorykey.getDimgeographyCollection().add(dimgeography);
                salesterritorykey = em.merge(salesterritorykey);
            }
            for (Dimcustomer dimcustomerCollectionDimcustomer : dimgeography.getDimcustomerCollection()) {
                Dimgeography oldGeographykeyOfDimcustomerCollectionDimcustomer = dimcustomerCollectionDimcustomer.getGeographykey();
                dimcustomerCollectionDimcustomer.setGeographykey(dimgeography);
                dimcustomerCollectionDimcustomer = em.merge(dimcustomerCollectionDimcustomer);
                if (oldGeographykeyOfDimcustomerCollectionDimcustomer != null) {
                    oldGeographykeyOfDimcustomerCollectionDimcustomer.getDimcustomerCollection().remove(dimcustomerCollectionDimcustomer);
                    oldGeographykeyOfDimcustomerCollectionDimcustomer = em.merge(oldGeographykeyOfDimcustomerCollectionDimcustomer);
                }
            }
            for (Dimreseller dimresellerCollectionDimreseller : dimgeography.getDimresellerCollection()) {
                Dimgeography oldGeographykeyOfDimresellerCollectionDimreseller = dimresellerCollectionDimreseller.getGeographykey();
                dimresellerCollectionDimreseller.setGeographykey(dimgeography);
                dimresellerCollectionDimreseller = em.merge(dimresellerCollectionDimreseller);
                if (oldGeographykeyOfDimresellerCollectionDimreseller != null) {
                    oldGeographykeyOfDimresellerCollectionDimreseller.getDimresellerCollection().remove(dimresellerCollectionDimreseller);
                    oldGeographykeyOfDimresellerCollectionDimreseller = em.merge(oldGeographykeyOfDimresellerCollectionDimreseller);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimgeography(dimgeography.getGeographykey()) != null) {
                throw new PreexistingEntityException("Dimgeography " + dimgeography + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimgeography dimgeography) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimgeography persistentDimgeography = em.find(Dimgeography.class, dimgeography.getGeographykey());
            Dimsalesterritory salesterritorykeyOld = persistentDimgeography.getSalesterritorykey();
            Dimsalesterritory salesterritorykeyNew = dimgeography.getSalesterritorykey();
            Collection<Dimcustomer> dimcustomerCollectionOld = persistentDimgeography.getDimcustomerCollection();
            Collection<Dimcustomer> dimcustomerCollectionNew = dimgeography.getDimcustomerCollection();
            Collection<Dimreseller> dimresellerCollectionOld = persistentDimgeography.getDimresellerCollection();
            Collection<Dimreseller> dimresellerCollectionNew = dimgeography.getDimresellerCollection();
            if (salesterritorykeyNew != null) {
                salesterritorykeyNew = em.getReference(salesterritorykeyNew.getClass(), salesterritorykeyNew.getSalesterritorykey());
                dimgeography.setSalesterritorykey(salesterritorykeyNew);
            }
            Collection<Dimcustomer> attachedDimcustomerCollectionNew = new ArrayList<Dimcustomer>();
            for (Dimcustomer dimcustomerCollectionNewDimcustomerToAttach : dimcustomerCollectionNew) {
                dimcustomerCollectionNewDimcustomerToAttach = em.getReference(dimcustomerCollectionNewDimcustomerToAttach.getClass(), dimcustomerCollectionNewDimcustomerToAttach.getCustomerkey());
                attachedDimcustomerCollectionNew.add(dimcustomerCollectionNewDimcustomerToAttach);
            }
            dimcustomerCollectionNew = attachedDimcustomerCollectionNew;
            dimgeography.setDimcustomerCollection(dimcustomerCollectionNew);
            Collection<Dimreseller> attachedDimresellerCollectionNew = new ArrayList<Dimreseller>();
            for (Dimreseller dimresellerCollectionNewDimresellerToAttach : dimresellerCollectionNew) {
                dimresellerCollectionNewDimresellerToAttach = em.getReference(dimresellerCollectionNewDimresellerToAttach.getClass(), dimresellerCollectionNewDimresellerToAttach.getResellerkey());
                attachedDimresellerCollectionNew.add(dimresellerCollectionNewDimresellerToAttach);
            }
            dimresellerCollectionNew = attachedDimresellerCollectionNew;
            dimgeography.setDimresellerCollection(dimresellerCollectionNew);
            dimgeography = em.merge(dimgeography);
            if (salesterritorykeyOld != null && !salesterritorykeyOld.equals(salesterritorykeyNew)) {
                salesterritorykeyOld.getDimgeographyCollection().remove(dimgeography);
                salesterritorykeyOld = em.merge(salesterritorykeyOld);
            }
            if (salesterritorykeyNew != null && !salesterritorykeyNew.equals(salesterritorykeyOld)) {
                salesterritorykeyNew.getDimgeographyCollection().add(dimgeography);
                salesterritorykeyNew = em.merge(salesterritorykeyNew);
            }
            for (Dimcustomer dimcustomerCollectionOldDimcustomer : dimcustomerCollectionOld) {
                if (!dimcustomerCollectionNew.contains(dimcustomerCollectionOldDimcustomer)) {
                    dimcustomerCollectionOldDimcustomer.setGeographykey(null);
                    dimcustomerCollectionOldDimcustomer = em.merge(dimcustomerCollectionOldDimcustomer);
                }
            }
            for (Dimcustomer dimcustomerCollectionNewDimcustomer : dimcustomerCollectionNew) {
                if (!dimcustomerCollectionOld.contains(dimcustomerCollectionNewDimcustomer)) {
                    Dimgeography oldGeographykeyOfDimcustomerCollectionNewDimcustomer = dimcustomerCollectionNewDimcustomer.getGeographykey();
                    dimcustomerCollectionNewDimcustomer.setGeographykey(dimgeography);
                    dimcustomerCollectionNewDimcustomer = em.merge(dimcustomerCollectionNewDimcustomer);
                    if (oldGeographykeyOfDimcustomerCollectionNewDimcustomer != null && !oldGeographykeyOfDimcustomerCollectionNewDimcustomer.equals(dimgeography)) {
                        oldGeographykeyOfDimcustomerCollectionNewDimcustomer.getDimcustomerCollection().remove(dimcustomerCollectionNewDimcustomer);
                        oldGeographykeyOfDimcustomerCollectionNewDimcustomer = em.merge(oldGeographykeyOfDimcustomerCollectionNewDimcustomer);
                    }
                }
            }
            for (Dimreseller dimresellerCollectionOldDimreseller : dimresellerCollectionOld) {
                if (!dimresellerCollectionNew.contains(dimresellerCollectionOldDimreseller)) {
                    dimresellerCollectionOldDimreseller.setGeographykey(null);
                    dimresellerCollectionOldDimreseller = em.merge(dimresellerCollectionOldDimreseller);
                }
            }
            for (Dimreseller dimresellerCollectionNewDimreseller : dimresellerCollectionNew) {
                if (!dimresellerCollectionOld.contains(dimresellerCollectionNewDimreseller)) {
                    Dimgeography oldGeographykeyOfDimresellerCollectionNewDimreseller = dimresellerCollectionNewDimreseller.getGeographykey();
                    dimresellerCollectionNewDimreseller.setGeographykey(dimgeography);
                    dimresellerCollectionNewDimreseller = em.merge(dimresellerCollectionNewDimreseller);
                    if (oldGeographykeyOfDimresellerCollectionNewDimreseller != null && !oldGeographykeyOfDimresellerCollectionNewDimreseller.equals(dimgeography)) {
                        oldGeographykeyOfDimresellerCollectionNewDimreseller.getDimresellerCollection().remove(dimresellerCollectionNewDimreseller);
                        oldGeographykeyOfDimresellerCollectionNewDimreseller = em.merge(oldGeographykeyOfDimresellerCollectionNewDimreseller);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimgeography.getGeographykey();
                if (findDimgeography(id) == null) {
                    throw new NonexistentEntityException("The dimgeography with id " + id + " no longer exists.");
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
            Dimgeography dimgeography;
            try {
                dimgeography = em.getReference(Dimgeography.class, id);
                dimgeography.getGeographykey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimgeography with id " + id + " no longer exists.", enfe);
            }
            Dimsalesterritory salesterritorykey = dimgeography.getSalesterritorykey();
            if (salesterritorykey != null) {
                salesterritorykey.getDimgeographyCollection().remove(dimgeography);
                salesterritorykey = em.merge(salesterritorykey);
            }
            Collection<Dimcustomer> dimcustomerCollection = dimgeography.getDimcustomerCollection();
            for (Dimcustomer dimcustomerCollectionDimcustomer : dimcustomerCollection) {
                dimcustomerCollectionDimcustomer.setGeographykey(null);
                dimcustomerCollectionDimcustomer = em.merge(dimcustomerCollectionDimcustomer);
            }
            Collection<Dimreseller> dimresellerCollection = dimgeography.getDimresellerCollection();
            for (Dimreseller dimresellerCollectionDimreseller : dimresellerCollection) {
                dimresellerCollectionDimreseller.setGeographykey(null);
                dimresellerCollectionDimreseller = em.merge(dimresellerCollectionDimreseller);
            }
            em.remove(dimgeography);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimgeography> findDimgeographyEntities() {
        return findDimgeographyEntities(true, -1, -1);
    }

    public List<Dimgeography> findDimgeographyEntities(int maxResults, int firstResult) {
        return findDimgeographyEntities(false, maxResults, firstResult);
    }

    private List<Dimgeography> findDimgeographyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimgeography.class));
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

    public Dimgeography findDimgeography(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimgeography.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimgeographyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimgeography> rt = cq.from(Dimgeography.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
