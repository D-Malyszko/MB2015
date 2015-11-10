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
public class DimresellerJpaController implements Serializable {

    public DimresellerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimreseller dimreseller) throws PreexistingEntityException, Exception {
        if (dimreseller.getFactresellersalesCollection() == null) {
            dimreseller.setFactresellersalesCollection(new ArrayList<Factresellersales>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimgeography geographykey = dimreseller.getGeographykey();
            if (geographykey != null) {
                geographykey = em.getReference(geographykey.getClass(), geographykey.getGeographykey());
                dimreseller.setGeographykey(geographykey);
            }
            Collection<Factresellersales> attachedFactresellersalesCollection = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionFactresellersalesToAttach : dimreseller.getFactresellersalesCollection()) {
                factresellersalesCollectionFactresellersalesToAttach = em.getReference(factresellersalesCollectionFactresellersalesToAttach.getClass(), factresellersalesCollectionFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection.add(factresellersalesCollectionFactresellersalesToAttach);
            }
            dimreseller.setFactresellersalesCollection(attachedFactresellersalesCollection);
            em.persist(dimreseller);
            if (geographykey != null) {
                geographykey.getDimresellerCollection().add(dimreseller);
                geographykey = em.merge(geographykey);
            }
            for (Factresellersales factresellersalesCollectionFactresellersales : dimreseller.getFactresellersalesCollection()) {
                Dimreseller oldResellerkeyOfFactresellersalesCollectionFactresellersales = factresellersalesCollectionFactresellersales.getResellerkey();
                factresellersalesCollectionFactresellersales.setResellerkey(dimreseller);
                factresellersalesCollectionFactresellersales = em.merge(factresellersalesCollectionFactresellersales);
                if (oldResellerkeyOfFactresellersalesCollectionFactresellersales != null) {
                    oldResellerkeyOfFactresellersalesCollectionFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionFactresellersales);
                    oldResellerkeyOfFactresellersalesCollectionFactresellersales = em.merge(oldResellerkeyOfFactresellersalesCollectionFactresellersales);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimreseller(dimreseller.getResellerkey()) != null) {
                throw new PreexistingEntityException("Dimreseller " + dimreseller + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimreseller dimreseller) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimreseller persistentDimreseller = em.find(Dimreseller.class, dimreseller.getResellerkey());
            Dimgeography geographykeyOld = persistentDimreseller.getGeographykey();
            Dimgeography geographykeyNew = dimreseller.getGeographykey();
            Collection<Factresellersales> factresellersalesCollectionOld = persistentDimreseller.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollectionNew = dimreseller.getFactresellersalesCollection();
            List<String> illegalOrphanMessages = null;
            for (Factresellersales factresellersalesCollectionOldFactresellersales : factresellersalesCollectionOld) {
                if (!factresellersalesCollectionNew.contains(factresellersalesCollectionOldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollectionOldFactresellersales + " since its resellerkey field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (geographykeyNew != null) {
                geographykeyNew = em.getReference(geographykeyNew.getClass(), geographykeyNew.getGeographykey());
                dimreseller.setGeographykey(geographykeyNew);
            }
            Collection<Factresellersales> attachedFactresellersalesCollectionNew = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionNewFactresellersalesToAttach : factresellersalesCollectionNew) {
                factresellersalesCollectionNewFactresellersalesToAttach = em.getReference(factresellersalesCollectionNewFactresellersalesToAttach.getClass(), factresellersalesCollectionNewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollectionNew.add(factresellersalesCollectionNewFactresellersalesToAttach);
            }
            factresellersalesCollectionNew = attachedFactresellersalesCollectionNew;
            dimreseller.setFactresellersalesCollection(factresellersalesCollectionNew);
            dimreseller = em.merge(dimreseller);
            if (geographykeyOld != null && !geographykeyOld.equals(geographykeyNew)) {
                geographykeyOld.getDimresellerCollection().remove(dimreseller);
                geographykeyOld = em.merge(geographykeyOld);
            }
            if (geographykeyNew != null && !geographykeyNew.equals(geographykeyOld)) {
                geographykeyNew.getDimresellerCollection().add(dimreseller);
                geographykeyNew = em.merge(geographykeyNew);
            }
            for (Factresellersales factresellersalesCollectionNewFactresellersales : factresellersalesCollectionNew) {
                if (!factresellersalesCollectionOld.contains(factresellersalesCollectionNewFactresellersales)) {
                    Dimreseller oldResellerkeyOfFactresellersalesCollectionNewFactresellersales = factresellersalesCollectionNewFactresellersales.getResellerkey();
                    factresellersalesCollectionNewFactresellersales.setResellerkey(dimreseller);
                    factresellersalesCollectionNewFactresellersales = em.merge(factresellersalesCollectionNewFactresellersales);
                    if (oldResellerkeyOfFactresellersalesCollectionNewFactresellersales != null && !oldResellerkeyOfFactresellersalesCollectionNewFactresellersales.equals(dimreseller)) {
                        oldResellerkeyOfFactresellersalesCollectionNewFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionNewFactresellersales);
                        oldResellerkeyOfFactresellersalesCollectionNewFactresellersales = em.merge(oldResellerkeyOfFactresellersalesCollectionNewFactresellersales);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimreseller.getResellerkey();
                if (findDimreseller(id) == null) {
                    throw new NonexistentEntityException("The dimreseller with id " + id + " no longer exists.");
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
            Dimreseller dimreseller;
            try {
                dimreseller = em.getReference(Dimreseller.class, id);
                dimreseller.getResellerkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimreseller with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factresellersales> factresellersalesCollectionOrphanCheck = dimreseller.getFactresellersalesCollection();
            for (Factresellersales factresellersalesCollectionOrphanCheckFactresellersales : factresellersalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimreseller (" + dimreseller + ") cannot be destroyed since the Factresellersales " + factresellersalesCollectionOrphanCheckFactresellersales + " in its factresellersalesCollection field has a non-nullable resellerkey field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dimgeography geographykey = dimreseller.getGeographykey();
            if (geographykey != null) {
                geographykey.getDimresellerCollection().remove(dimreseller);
                geographykey = em.merge(geographykey);
            }
            em.remove(dimreseller);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimreseller> findDimresellerEntities() {
        return findDimresellerEntities(true, -1, -1);
    }

    public List<Dimreseller> findDimresellerEntities(int maxResults, int firstResult) {
        return findDimresellerEntities(false, maxResults, firstResult);
    }

    private List<Dimreseller> findDimresellerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimreseller.class));
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

    public Dimreseller findDimreseller(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimreseller.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimresellerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimreseller> rt = cq.from(Dimreseller.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
