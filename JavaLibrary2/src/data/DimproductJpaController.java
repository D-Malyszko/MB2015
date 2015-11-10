/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.IllegalOrphanException;
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
public class DimproductJpaController implements Serializable {

    public DimproductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimproduct dimproduct) throws PreexistingEntityException, Exception {
        if (dimproduct.getFactinternetsalesCollection() == null) {
            dimproduct.setFactinternetsalesCollection(new ArrayList<Factinternetsales>());
        }
        if (dimproduct.getFactproductinventoryCollection() == null) {
            dimproduct.setFactproductinventoryCollection(new ArrayList<Factproductinventory>());
        }
        if (dimproduct.getFactresellersalesCollection() == null) {
            dimproduct.setFactresellersalesCollection(new ArrayList<Factresellersales>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimproductsubcategory productsubcategorykey = dimproduct.getProductsubcategorykey();
            if (productsubcategorykey != null) {
                productsubcategorykey = em.getReference(productsubcategorykey.getClass(), productsubcategorykey.getProductsubcategorykey());
                dimproduct.setProductsubcategorykey(productsubcategorykey);
            }
            Collection<Factinternetsales> attachedFactinternetsalesCollection = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionFactinternetsalesToAttach : dimproduct.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionFactinternetsalesToAttach.getClass(), factinternetsalesCollectionFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection.add(factinternetsalesCollectionFactinternetsalesToAttach);
            }
            dimproduct.setFactinternetsalesCollection(attachedFactinternetsalesCollection);
            Collection<Factproductinventory> attachedFactproductinventoryCollection = new ArrayList<Factproductinventory>();
            for (Factproductinventory factproductinventoryCollectionFactproductinventoryToAttach : dimproduct.getFactproductinventoryCollection()) {
                factproductinventoryCollectionFactproductinventoryToAttach = em.getReference(factproductinventoryCollectionFactproductinventoryToAttach.getClass(), factproductinventoryCollectionFactproductinventoryToAttach.getFactproductinventoryPK());
                attachedFactproductinventoryCollection.add(factproductinventoryCollectionFactproductinventoryToAttach);
            }
            dimproduct.setFactproductinventoryCollection(attachedFactproductinventoryCollection);
            Collection<Factresellersales> attachedFactresellersalesCollection = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionFactresellersalesToAttach : dimproduct.getFactresellersalesCollection()) {
                factresellersalesCollectionFactresellersalesToAttach = em.getReference(factresellersalesCollectionFactresellersalesToAttach.getClass(), factresellersalesCollectionFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection.add(factresellersalesCollectionFactresellersalesToAttach);
            }
            dimproduct.setFactresellersalesCollection(attachedFactresellersalesCollection);
            em.persist(dimproduct);
            if (productsubcategorykey != null) {
                productsubcategorykey.getDimproductCollection().add(dimproduct);
                productsubcategorykey = em.merge(productsubcategorykey);
            }
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : dimproduct.getFactinternetsalesCollection()) {
                Dimproduct oldProductkeyOfFactinternetsalesCollectionFactinternetsales = factinternetsalesCollectionFactinternetsales.getProductkey();
                factinternetsalesCollectionFactinternetsales.setProductkey(dimproduct);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
                if (oldProductkeyOfFactinternetsalesCollectionFactinternetsales != null) {
                    oldProductkeyOfFactinternetsalesCollectionFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionFactinternetsales);
                    oldProductkeyOfFactinternetsalesCollectionFactinternetsales = em.merge(oldProductkeyOfFactinternetsalesCollectionFactinternetsales);
                }
            }
            for (Factproductinventory factproductinventoryCollectionFactproductinventory : dimproduct.getFactproductinventoryCollection()) {
                Dimproduct oldDimproductOfFactproductinventoryCollectionFactproductinventory = factproductinventoryCollectionFactproductinventory.getDimproduct();
                factproductinventoryCollectionFactproductinventory.setDimproduct(dimproduct);
                factproductinventoryCollectionFactproductinventory = em.merge(factproductinventoryCollectionFactproductinventory);
                if (oldDimproductOfFactproductinventoryCollectionFactproductinventory != null) {
                    oldDimproductOfFactproductinventoryCollectionFactproductinventory.getFactproductinventoryCollection().remove(factproductinventoryCollectionFactproductinventory);
                    oldDimproductOfFactproductinventoryCollectionFactproductinventory = em.merge(oldDimproductOfFactproductinventoryCollectionFactproductinventory);
                }
            }
            for (Factresellersales factresellersalesCollectionFactresellersales : dimproduct.getFactresellersalesCollection()) {
                Dimproduct oldProductkeyOfFactresellersalesCollectionFactresellersales = factresellersalesCollectionFactresellersales.getProductkey();
                factresellersalesCollectionFactresellersales.setProductkey(dimproduct);
                factresellersalesCollectionFactresellersales = em.merge(factresellersalesCollectionFactresellersales);
                if (oldProductkeyOfFactresellersalesCollectionFactresellersales != null) {
                    oldProductkeyOfFactresellersalesCollectionFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionFactresellersales);
                    oldProductkeyOfFactresellersalesCollectionFactresellersales = em.merge(oldProductkeyOfFactresellersalesCollectionFactresellersales);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimproduct(dimproduct.getProductkey()) != null) {
                throw new PreexistingEntityException("Dimproduct " + dimproduct + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimproduct dimproduct) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimproduct persistentDimproduct = em.find(Dimproduct.class, dimproduct.getProductkey());
            Dimproductsubcategory productsubcategorykeyOld = persistentDimproduct.getProductsubcategorykey();
            Dimproductsubcategory productsubcategorykeyNew = dimproduct.getProductsubcategorykey();
            Collection<Factinternetsales> factinternetsalesCollectionOld = persistentDimproduct.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollectionNew = dimproduct.getFactinternetsalesCollection();
            Collection<Factproductinventory> factproductinventoryCollectionOld = persistentDimproduct.getFactproductinventoryCollection();
            Collection<Factproductinventory> factproductinventoryCollectionNew = dimproduct.getFactproductinventoryCollection();
            Collection<Factresellersales> factresellersalesCollectionOld = persistentDimproduct.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollectionNew = dimproduct.getFactresellersalesCollection();
            List<String> illegalOrphanMessages = null;
            for (Factinternetsales factinternetsalesCollectionOldFactinternetsales : factinternetsalesCollectionOld) {
                if (!factinternetsalesCollectionNew.contains(factinternetsalesCollectionOldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollectionOldFactinternetsales + " since its productkey field is not nullable.");
                }
            }
            for (Factproductinventory factproductinventoryCollectionOldFactproductinventory : factproductinventoryCollectionOld) {
                if (!factproductinventoryCollectionNew.contains(factproductinventoryCollectionOldFactproductinventory)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factproductinventory " + factproductinventoryCollectionOldFactproductinventory + " since its dimproduct field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollectionOldFactresellersales : factresellersalesCollectionOld) {
                if (!factresellersalesCollectionNew.contains(factresellersalesCollectionOldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollectionOldFactresellersales + " since its productkey field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (productsubcategorykeyNew != null) {
                productsubcategorykeyNew = em.getReference(productsubcategorykeyNew.getClass(), productsubcategorykeyNew.getProductsubcategorykey());
                dimproduct.setProductsubcategorykey(productsubcategorykeyNew);
            }
            Collection<Factinternetsales> attachedFactinternetsalesCollectionNew = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsalesToAttach : factinternetsalesCollectionNew) {
                factinternetsalesCollectionNewFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionNewFactinternetsalesToAttach.getClass(), factinternetsalesCollectionNewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollectionNew.add(factinternetsalesCollectionNewFactinternetsalesToAttach);
            }
            factinternetsalesCollectionNew = attachedFactinternetsalesCollectionNew;
            dimproduct.setFactinternetsalesCollection(factinternetsalesCollectionNew);
            Collection<Factproductinventory> attachedFactproductinventoryCollectionNew = new ArrayList<Factproductinventory>();
            for (Factproductinventory factproductinventoryCollectionNewFactproductinventoryToAttach : factproductinventoryCollectionNew) {
                factproductinventoryCollectionNewFactproductinventoryToAttach = em.getReference(factproductinventoryCollectionNewFactproductinventoryToAttach.getClass(), factproductinventoryCollectionNewFactproductinventoryToAttach.getFactproductinventoryPK());
                attachedFactproductinventoryCollectionNew.add(factproductinventoryCollectionNewFactproductinventoryToAttach);
            }
            factproductinventoryCollectionNew = attachedFactproductinventoryCollectionNew;
            dimproduct.setFactproductinventoryCollection(factproductinventoryCollectionNew);
            Collection<Factresellersales> attachedFactresellersalesCollectionNew = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionNewFactresellersalesToAttach : factresellersalesCollectionNew) {
                factresellersalesCollectionNewFactresellersalesToAttach = em.getReference(factresellersalesCollectionNewFactresellersalesToAttach.getClass(), factresellersalesCollectionNewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollectionNew.add(factresellersalesCollectionNewFactresellersalesToAttach);
            }
            factresellersalesCollectionNew = attachedFactresellersalesCollectionNew;
            dimproduct.setFactresellersalesCollection(factresellersalesCollectionNew);
            dimproduct = em.merge(dimproduct);
            if (productsubcategorykeyOld != null && !productsubcategorykeyOld.equals(productsubcategorykeyNew)) {
                productsubcategorykeyOld.getDimproductCollection().remove(dimproduct);
                productsubcategorykeyOld = em.merge(productsubcategorykeyOld);
            }
            if (productsubcategorykeyNew != null && !productsubcategorykeyNew.equals(productsubcategorykeyOld)) {
                productsubcategorykeyNew.getDimproductCollection().add(dimproduct);
                productsubcategorykeyNew = em.merge(productsubcategorykeyNew);
            }
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsales : factinternetsalesCollectionNew) {
                if (!factinternetsalesCollectionOld.contains(factinternetsalesCollectionNewFactinternetsales)) {
                    Dimproduct oldProductkeyOfFactinternetsalesCollectionNewFactinternetsales = factinternetsalesCollectionNewFactinternetsales.getProductkey();
                    factinternetsalesCollectionNewFactinternetsales.setProductkey(dimproduct);
                    factinternetsalesCollectionNewFactinternetsales = em.merge(factinternetsalesCollectionNewFactinternetsales);
                    if (oldProductkeyOfFactinternetsalesCollectionNewFactinternetsales != null && !oldProductkeyOfFactinternetsalesCollectionNewFactinternetsales.equals(dimproduct)) {
                        oldProductkeyOfFactinternetsalesCollectionNewFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionNewFactinternetsales);
                        oldProductkeyOfFactinternetsalesCollectionNewFactinternetsales = em.merge(oldProductkeyOfFactinternetsalesCollectionNewFactinternetsales);
                    }
                }
            }
            for (Factproductinventory factproductinventoryCollectionNewFactproductinventory : factproductinventoryCollectionNew) {
                if (!factproductinventoryCollectionOld.contains(factproductinventoryCollectionNewFactproductinventory)) {
                    Dimproduct oldDimproductOfFactproductinventoryCollectionNewFactproductinventory = factproductinventoryCollectionNewFactproductinventory.getDimproduct();
                    factproductinventoryCollectionNewFactproductinventory.setDimproduct(dimproduct);
                    factproductinventoryCollectionNewFactproductinventory = em.merge(factproductinventoryCollectionNewFactproductinventory);
                    if (oldDimproductOfFactproductinventoryCollectionNewFactproductinventory != null && !oldDimproductOfFactproductinventoryCollectionNewFactproductinventory.equals(dimproduct)) {
                        oldDimproductOfFactproductinventoryCollectionNewFactproductinventory.getFactproductinventoryCollection().remove(factproductinventoryCollectionNewFactproductinventory);
                        oldDimproductOfFactproductinventoryCollectionNewFactproductinventory = em.merge(oldDimproductOfFactproductinventoryCollectionNewFactproductinventory);
                    }
                }
            }
            for (Factresellersales factresellersalesCollectionNewFactresellersales : factresellersalesCollectionNew) {
                if (!factresellersalesCollectionOld.contains(factresellersalesCollectionNewFactresellersales)) {
                    Dimproduct oldProductkeyOfFactresellersalesCollectionNewFactresellersales = factresellersalesCollectionNewFactresellersales.getProductkey();
                    factresellersalesCollectionNewFactresellersales.setProductkey(dimproduct);
                    factresellersalesCollectionNewFactresellersales = em.merge(factresellersalesCollectionNewFactresellersales);
                    if (oldProductkeyOfFactresellersalesCollectionNewFactresellersales != null && !oldProductkeyOfFactresellersalesCollectionNewFactresellersales.equals(dimproduct)) {
                        oldProductkeyOfFactresellersalesCollectionNewFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionNewFactresellersales);
                        oldProductkeyOfFactresellersalesCollectionNewFactresellersales = em.merge(oldProductkeyOfFactresellersalesCollectionNewFactresellersales);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimproduct.getProductkey();
                if (findDimproduct(id) == null) {
                    throw new NonexistentEntityException("The dimproduct with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimproduct dimproduct;
            try {
                dimproduct = em.getReference(Dimproduct.class, id);
                dimproduct.getProductkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimproduct with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factinternetsales> factinternetsalesCollectionOrphanCheck = dimproduct.getFactinternetsalesCollection();
            for (Factinternetsales factinternetsalesCollectionOrphanCheckFactinternetsales : factinternetsalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimproduct (" + dimproduct + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollectionOrphanCheckFactinternetsales + " in its factinternetsalesCollection field has a non-nullable productkey field.");
            }
            Collection<Factproductinventory> factproductinventoryCollectionOrphanCheck = dimproduct.getFactproductinventoryCollection();
            for (Factproductinventory factproductinventoryCollectionOrphanCheckFactproductinventory : factproductinventoryCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimproduct (" + dimproduct + ") cannot be destroyed since the Factproductinventory " + factproductinventoryCollectionOrphanCheckFactproductinventory + " in its factproductinventoryCollection field has a non-nullable dimproduct field.");
            }
            Collection<Factresellersales> factresellersalesCollectionOrphanCheck = dimproduct.getFactresellersalesCollection();
            for (Factresellersales factresellersalesCollectionOrphanCheckFactresellersales : factresellersalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimproduct (" + dimproduct + ") cannot be destroyed since the Factresellersales " + factresellersalesCollectionOrphanCheckFactresellersales + " in its factresellersalesCollection field has a non-nullable productkey field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dimproductsubcategory productsubcategorykey = dimproduct.getProductsubcategorykey();
            if (productsubcategorykey != null) {
                productsubcategorykey.getDimproductCollection().remove(dimproduct);
                productsubcategorykey = em.merge(productsubcategorykey);
            }
            em.remove(dimproduct);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimproduct> findDimproductEntities() {
        return findDimproductEntities(true, -1, -1);
    }

    public List<Dimproduct> findDimproductEntities(int maxResults, int firstResult) {
        return findDimproductEntities(false, maxResults, firstResult);
    }

    private List<Dimproduct> findDimproductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimproduct.class));
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

    public Dimproduct findDimproduct(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimproduct.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimproductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimproduct> rt = cq.from(Dimproduct.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
