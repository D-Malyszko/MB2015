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
public class DimproductcategoryJpaController implements Serializable {

    public DimproductcategoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimproductcategory dimproductcategory) throws PreexistingEntityException, Exception {
        if (dimproductcategory.getDimproductsubcategoryCollection() == null) {
            dimproductcategory.setDimproductsubcategoryCollection(new ArrayList<Dimproductsubcategory>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Dimproductsubcategory> attachedDimproductsubcategoryCollection = new ArrayList<Dimproductsubcategory>();
            for (Dimproductsubcategory dimproductsubcategoryCollectionDimproductsubcategoryToAttach : dimproductcategory.getDimproductsubcategoryCollection()) {
                dimproductsubcategoryCollectionDimproductsubcategoryToAttach = em.getReference(dimproductsubcategoryCollectionDimproductsubcategoryToAttach.getClass(), dimproductsubcategoryCollectionDimproductsubcategoryToAttach.getProductsubcategorykey());
                attachedDimproductsubcategoryCollection.add(dimproductsubcategoryCollectionDimproductsubcategoryToAttach);
            }
            dimproductcategory.setDimproductsubcategoryCollection(attachedDimproductsubcategoryCollection);
            em.persist(dimproductcategory);
            for (Dimproductsubcategory dimproductsubcategoryCollectionDimproductsubcategory : dimproductcategory.getDimproductsubcategoryCollection()) {
                Dimproductcategory oldProductcategorykeyOfDimproductsubcategoryCollectionDimproductsubcategory = dimproductsubcategoryCollectionDimproductsubcategory.getProductcategorykey();
                dimproductsubcategoryCollectionDimproductsubcategory.setProductcategorykey(dimproductcategory);
                dimproductsubcategoryCollectionDimproductsubcategory = em.merge(dimproductsubcategoryCollectionDimproductsubcategory);
                if (oldProductcategorykeyOfDimproductsubcategoryCollectionDimproductsubcategory != null) {
                    oldProductcategorykeyOfDimproductsubcategoryCollectionDimproductsubcategory.getDimproductsubcategoryCollection().remove(dimproductsubcategoryCollectionDimproductsubcategory);
                    oldProductcategorykeyOfDimproductsubcategoryCollectionDimproductsubcategory = em.merge(oldProductcategorykeyOfDimproductsubcategoryCollectionDimproductsubcategory);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimproductcategory(dimproductcategory.getProductcategorykey()) != null) {
                throw new PreexistingEntityException("Dimproductcategory " + dimproductcategory + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimproductcategory dimproductcategory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimproductcategory persistentDimproductcategory = em.find(Dimproductcategory.class, dimproductcategory.getProductcategorykey());
            Collection<Dimproductsubcategory> dimproductsubcategoryCollectionOld = persistentDimproductcategory.getDimproductsubcategoryCollection();
            Collection<Dimproductsubcategory> dimproductsubcategoryCollectionNew = dimproductcategory.getDimproductsubcategoryCollection();
            Collection<Dimproductsubcategory> attachedDimproductsubcategoryCollectionNew = new ArrayList<Dimproductsubcategory>();
            for (Dimproductsubcategory dimproductsubcategoryCollectionNewDimproductsubcategoryToAttach : dimproductsubcategoryCollectionNew) {
                dimproductsubcategoryCollectionNewDimproductsubcategoryToAttach = em.getReference(dimproductsubcategoryCollectionNewDimproductsubcategoryToAttach.getClass(), dimproductsubcategoryCollectionNewDimproductsubcategoryToAttach.getProductsubcategorykey());
                attachedDimproductsubcategoryCollectionNew.add(dimproductsubcategoryCollectionNewDimproductsubcategoryToAttach);
            }
            dimproductsubcategoryCollectionNew = attachedDimproductsubcategoryCollectionNew;
            dimproductcategory.setDimproductsubcategoryCollection(dimproductsubcategoryCollectionNew);
            dimproductcategory = em.merge(dimproductcategory);
            for (Dimproductsubcategory dimproductsubcategoryCollectionOldDimproductsubcategory : dimproductsubcategoryCollectionOld) {
                if (!dimproductsubcategoryCollectionNew.contains(dimproductsubcategoryCollectionOldDimproductsubcategory)) {
                    dimproductsubcategoryCollectionOldDimproductsubcategory.setProductcategorykey(null);
                    dimproductsubcategoryCollectionOldDimproductsubcategory = em.merge(dimproductsubcategoryCollectionOldDimproductsubcategory);
                }
            }
            for (Dimproductsubcategory dimproductsubcategoryCollectionNewDimproductsubcategory : dimproductsubcategoryCollectionNew) {
                if (!dimproductsubcategoryCollectionOld.contains(dimproductsubcategoryCollectionNewDimproductsubcategory)) {
                    Dimproductcategory oldProductcategorykeyOfDimproductsubcategoryCollectionNewDimproductsubcategory = dimproductsubcategoryCollectionNewDimproductsubcategory.getProductcategorykey();
                    dimproductsubcategoryCollectionNewDimproductsubcategory.setProductcategorykey(dimproductcategory);
                    dimproductsubcategoryCollectionNewDimproductsubcategory = em.merge(dimproductsubcategoryCollectionNewDimproductsubcategory);
                    if (oldProductcategorykeyOfDimproductsubcategoryCollectionNewDimproductsubcategory != null && !oldProductcategorykeyOfDimproductsubcategoryCollectionNewDimproductsubcategory.equals(dimproductcategory)) {
                        oldProductcategorykeyOfDimproductsubcategoryCollectionNewDimproductsubcategory.getDimproductsubcategoryCollection().remove(dimproductsubcategoryCollectionNewDimproductsubcategory);
                        oldProductcategorykeyOfDimproductsubcategoryCollectionNewDimproductsubcategory = em.merge(oldProductcategorykeyOfDimproductsubcategoryCollectionNewDimproductsubcategory);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimproductcategory.getProductcategorykey();
                if (findDimproductcategory(id) == null) {
                    throw new NonexistentEntityException("The dimproductcategory with id " + id + " no longer exists.");
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
            Dimproductcategory dimproductcategory;
            try {
                dimproductcategory = em.getReference(Dimproductcategory.class, id);
                dimproductcategory.getProductcategorykey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimproductcategory with id " + id + " no longer exists.", enfe);
            }
            Collection<Dimproductsubcategory> dimproductsubcategoryCollection = dimproductcategory.getDimproductsubcategoryCollection();
            for (Dimproductsubcategory dimproductsubcategoryCollectionDimproductsubcategory : dimproductsubcategoryCollection) {
                dimproductsubcategoryCollectionDimproductsubcategory.setProductcategorykey(null);
                dimproductsubcategoryCollectionDimproductsubcategory = em.merge(dimproductsubcategoryCollectionDimproductsubcategory);
            }
            em.remove(dimproductcategory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimproductcategory> findDimproductcategoryEntities() {
        return findDimproductcategoryEntities(true, -1, -1);
    }

    public List<Dimproductcategory> findDimproductcategoryEntities(int maxResults, int firstResult) {
        return findDimproductcategoryEntities(false, maxResults, firstResult);
    }

    private List<Dimproductcategory> findDimproductcategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimproductcategory.class));
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

    public Dimproductcategory findDimproductcategory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimproductcategory.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimproductcategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimproductcategory> rt = cq.from(Dimproductcategory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
