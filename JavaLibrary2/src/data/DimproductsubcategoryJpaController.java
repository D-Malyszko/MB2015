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
public class DimproductsubcategoryJpaController implements Serializable {

    public DimproductsubcategoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimproductsubcategory dimproductsubcategory) throws PreexistingEntityException, Exception {
        if (dimproductsubcategory.getDimproductCollection() == null) {
            dimproductsubcategory.setDimproductCollection(new ArrayList<Dimproduct>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimproductcategory productcategorykey = dimproductsubcategory.getProductcategorykey();
            if (productcategorykey != null) {
                productcategorykey = em.getReference(productcategorykey.getClass(), productcategorykey.getProductcategorykey());
                dimproductsubcategory.setProductcategorykey(productcategorykey);
            }
            Collection<Dimproduct> attachedDimproductCollection = new ArrayList<Dimproduct>();
            for (Dimproduct dimproductCollectionDimproductToAttach : dimproductsubcategory.getDimproductCollection()) {
                dimproductCollectionDimproductToAttach = em.getReference(dimproductCollectionDimproductToAttach.getClass(), dimproductCollectionDimproductToAttach.getProductkey());
                attachedDimproductCollection.add(dimproductCollectionDimproductToAttach);
            }
            dimproductsubcategory.setDimproductCollection(attachedDimproductCollection);
            em.persist(dimproductsubcategory);
            if (productcategorykey != null) {
                productcategorykey.getDimproductsubcategoryCollection().add(dimproductsubcategory);
                productcategorykey = em.merge(productcategorykey);
            }
            for (Dimproduct dimproductCollectionDimproduct : dimproductsubcategory.getDimproductCollection()) {
                Dimproductsubcategory oldProductsubcategorykeyOfDimproductCollectionDimproduct = dimproductCollectionDimproduct.getProductsubcategorykey();
                dimproductCollectionDimproduct.setProductsubcategorykey(dimproductsubcategory);
                dimproductCollectionDimproduct = em.merge(dimproductCollectionDimproduct);
                if (oldProductsubcategorykeyOfDimproductCollectionDimproduct != null) {
                    oldProductsubcategorykeyOfDimproductCollectionDimproduct.getDimproductCollection().remove(dimproductCollectionDimproduct);
                    oldProductsubcategorykeyOfDimproductCollectionDimproduct = em.merge(oldProductsubcategorykeyOfDimproductCollectionDimproduct);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimproductsubcategory(dimproductsubcategory.getProductsubcategorykey()) != null) {
                throw new PreexistingEntityException("Dimproductsubcategory " + dimproductsubcategory + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimproductsubcategory dimproductsubcategory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimproductsubcategory persistentDimproductsubcategory = em.find(Dimproductsubcategory.class, dimproductsubcategory.getProductsubcategorykey());
            Dimproductcategory productcategorykeyOld = persistentDimproductsubcategory.getProductcategorykey();
            Dimproductcategory productcategorykeyNew = dimproductsubcategory.getProductcategorykey();
            Collection<Dimproduct> dimproductCollectionOld = persistentDimproductsubcategory.getDimproductCollection();
            Collection<Dimproduct> dimproductCollectionNew = dimproductsubcategory.getDimproductCollection();
            if (productcategorykeyNew != null) {
                productcategorykeyNew = em.getReference(productcategorykeyNew.getClass(), productcategorykeyNew.getProductcategorykey());
                dimproductsubcategory.setProductcategorykey(productcategorykeyNew);
            }
            Collection<Dimproduct> attachedDimproductCollectionNew = new ArrayList<Dimproduct>();
            for (Dimproduct dimproductCollectionNewDimproductToAttach : dimproductCollectionNew) {
                dimproductCollectionNewDimproductToAttach = em.getReference(dimproductCollectionNewDimproductToAttach.getClass(), dimproductCollectionNewDimproductToAttach.getProductkey());
                attachedDimproductCollectionNew.add(dimproductCollectionNewDimproductToAttach);
            }
            dimproductCollectionNew = attachedDimproductCollectionNew;
            dimproductsubcategory.setDimproductCollection(dimproductCollectionNew);
            dimproductsubcategory = em.merge(dimproductsubcategory);
            if (productcategorykeyOld != null && !productcategorykeyOld.equals(productcategorykeyNew)) {
                productcategorykeyOld.getDimproductsubcategoryCollection().remove(dimproductsubcategory);
                productcategorykeyOld = em.merge(productcategorykeyOld);
            }
            if (productcategorykeyNew != null && !productcategorykeyNew.equals(productcategorykeyOld)) {
                productcategorykeyNew.getDimproductsubcategoryCollection().add(dimproductsubcategory);
                productcategorykeyNew = em.merge(productcategorykeyNew);
            }
            for (Dimproduct dimproductCollectionOldDimproduct : dimproductCollectionOld) {
                if (!dimproductCollectionNew.contains(dimproductCollectionOldDimproduct)) {
                    dimproductCollectionOldDimproduct.setProductsubcategorykey(null);
                    dimproductCollectionOldDimproduct = em.merge(dimproductCollectionOldDimproduct);
                }
            }
            for (Dimproduct dimproductCollectionNewDimproduct : dimproductCollectionNew) {
                if (!dimproductCollectionOld.contains(dimproductCollectionNewDimproduct)) {
                    Dimproductsubcategory oldProductsubcategorykeyOfDimproductCollectionNewDimproduct = dimproductCollectionNewDimproduct.getProductsubcategorykey();
                    dimproductCollectionNewDimproduct.setProductsubcategorykey(dimproductsubcategory);
                    dimproductCollectionNewDimproduct = em.merge(dimproductCollectionNewDimproduct);
                    if (oldProductsubcategorykeyOfDimproductCollectionNewDimproduct != null && !oldProductsubcategorykeyOfDimproductCollectionNewDimproduct.equals(dimproductsubcategory)) {
                        oldProductsubcategorykeyOfDimproductCollectionNewDimproduct.getDimproductCollection().remove(dimproductCollectionNewDimproduct);
                        oldProductsubcategorykeyOfDimproductCollectionNewDimproduct = em.merge(oldProductsubcategorykeyOfDimproductCollectionNewDimproduct);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimproductsubcategory.getProductsubcategorykey();
                if (findDimproductsubcategory(id) == null) {
                    throw new NonexistentEntityException("The dimproductsubcategory with id " + id + " no longer exists.");
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
            Dimproductsubcategory dimproductsubcategory;
            try {
                dimproductsubcategory = em.getReference(Dimproductsubcategory.class, id);
                dimproductsubcategory.getProductsubcategorykey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimproductsubcategory with id " + id + " no longer exists.", enfe);
            }
            Dimproductcategory productcategorykey = dimproductsubcategory.getProductcategorykey();
            if (productcategorykey != null) {
                productcategorykey.getDimproductsubcategoryCollection().remove(dimproductsubcategory);
                productcategorykey = em.merge(productcategorykey);
            }
            Collection<Dimproduct> dimproductCollection = dimproductsubcategory.getDimproductCollection();
            for (Dimproduct dimproductCollectionDimproduct : dimproductCollection) {
                dimproductCollectionDimproduct.setProductsubcategorykey(null);
                dimproductCollectionDimproduct = em.merge(dimproductCollectionDimproduct);
            }
            em.remove(dimproductsubcategory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimproductsubcategory> findDimproductsubcategoryEntities() {
        return findDimproductsubcategoryEntities(true, -1, -1);
    }

    public List<Dimproductsubcategory> findDimproductsubcategoryEntities(int maxResults, int firstResult) {
        return findDimproductsubcategoryEntities(false, maxResults, firstResult);
    }

    private List<Dimproductsubcategory> findDimproductsubcategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimproductsubcategory.class));
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

    public Dimproductsubcategory findDimproductsubcategory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimproductsubcategory.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimproductsubcategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimproductsubcategory> rt = cq.from(Dimproductsubcategory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
