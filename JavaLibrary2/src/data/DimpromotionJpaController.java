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
public class DimpromotionJpaController implements Serializable {

    public DimpromotionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimpromotion dimpromotion) throws PreexistingEntityException, Exception {
        if (dimpromotion.getFactinternetsalesCollection() == null) {
            dimpromotion.setFactinternetsalesCollection(new ArrayList<Factinternetsales>());
        }
        if (dimpromotion.getFactresellersalesCollection() == null) {
            dimpromotion.setFactresellersalesCollection(new ArrayList<Factresellersales>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Factinternetsales> attachedFactinternetsalesCollection = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionFactinternetsalesToAttach : dimpromotion.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionFactinternetsalesToAttach.getClass(), factinternetsalesCollectionFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection.add(factinternetsalesCollectionFactinternetsalesToAttach);
            }
            dimpromotion.setFactinternetsalesCollection(attachedFactinternetsalesCollection);
            Collection<Factresellersales> attachedFactresellersalesCollection = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionFactresellersalesToAttach : dimpromotion.getFactresellersalesCollection()) {
                factresellersalesCollectionFactresellersalesToAttach = em.getReference(factresellersalesCollectionFactresellersalesToAttach.getClass(), factresellersalesCollectionFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollection.add(factresellersalesCollectionFactresellersalesToAttach);
            }
            dimpromotion.setFactresellersalesCollection(attachedFactresellersalesCollection);
            em.persist(dimpromotion);
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : dimpromotion.getFactinternetsalesCollection()) {
                Dimpromotion oldPromotionkeyOfFactinternetsalesCollectionFactinternetsales = factinternetsalesCollectionFactinternetsales.getPromotionkey();
                factinternetsalesCollectionFactinternetsales.setPromotionkey(dimpromotion);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
                if (oldPromotionkeyOfFactinternetsalesCollectionFactinternetsales != null) {
                    oldPromotionkeyOfFactinternetsalesCollectionFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionFactinternetsales);
                    oldPromotionkeyOfFactinternetsalesCollectionFactinternetsales = em.merge(oldPromotionkeyOfFactinternetsalesCollectionFactinternetsales);
                }
            }
            for (Factresellersales factresellersalesCollectionFactresellersales : dimpromotion.getFactresellersalesCollection()) {
                Dimpromotion oldPromotionkeyOfFactresellersalesCollectionFactresellersales = factresellersalesCollectionFactresellersales.getPromotionkey();
                factresellersalesCollectionFactresellersales.setPromotionkey(dimpromotion);
                factresellersalesCollectionFactresellersales = em.merge(factresellersalesCollectionFactresellersales);
                if (oldPromotionkeyOfFactresellersalesCollectionFactresellersales != null) {
                    oldPromotionkeyOfFactresellersalesCollectionFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionFactresellersales);
                    oldPromotionkeyOfFactresellersalesCollectionFactresellersales = em.merge(oldPromotionkeyOfFactresellersalesCollectionFactresellersales);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimpromotion(dimpromotion.getPromotionkey()) != null) {
                throw new PreexistingEntityException("Dimpromotion " + dimpromotion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimpromotion dimpromotion) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimpromotion persistentDimpromotion = em.find(Dimpromotion.class, dimpromotion.getPromotionkey());
            Collection<Factinternetsales> factinternetsalesCollectionOld = persistentDimpromotion.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollectionNew = dimpromotion.getFactinternetsalesCollection();
            Collection<Factresellersales> factresellersalesCollectionOld = persistentDimpromotion.getFactresellersalesCollection();
            Collection<Factresellersales> factresellersalesCollectionNew = dimpromotion.getFactresellersalesCollection();
            List<String> illegalOrphanMessages = null;
            for (Factinternetsales factinternetsalesCollectionOldFactinternetsales : factinternetsalesCollectionOld) {
                if (!factinternetsalesCollectionNew.contains(factinternetsalesCollectionOldFactinternetsales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factinternetsales " + factinternetsalesCollectionOldFactinternetsales + " since its promotionkey field is not nullable.");
                }
            }
            for (Factresellersales factresellersalesCollectionOldFactresellersales : factresellersalesCollectionOld) {
                if (!factresellersalesCollectionNew.contains(factresellersalesCollectionOldFactresellersales)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factresellersales " + factresellersalesCollectionOldFactresellersales + " since its promotionkey field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Factinternetsales> attachedFactinternetsalesCollectionNew = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsalesToAttach : factinternetsalesCollectionNew) {
                factinternetsalesCollectionNewFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionNewFactinternetsalesToAttach.getClass(), factinternetsalesCollectionNewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollectionNew.add(factinternetsalesCollectionNewFactinternetsalesToAttach);
            }
            factinternetsalesCollectionNew = attachedFactinternetsalesCollectionNew;
            dimpromotion.setFactinternetsalesCollection(factinternetsalesCollectionNew);
            Collection<Factresellersales> attachedFactresellersalesCollectionNew = new ArrayList<Factresellersales>();
            for (Factresellersales factresellersalesCollectionNewFactresellersalesToAttach : factresellersalesCollectionNew) {
                factresellersalesCollectionNewFactresellersalesToAttach = em.getReference(factresellersalesCollectionNewFactresellersalesToAttach.getClass(), factresellersalesCollectionNewFactresellersalesToAttach.getFactresellersalesPK());
                attachedFactresellersalesCollectionNew.add(factresellersalesCollectionNewFactresellersalesToAttach);
            }
            factresellersalesCollectionNew = attachedFactresellersalesCollectionNew;
            dimpromotion.setFactresellersalesCollection(factresellersalesCollectionNew);
            dimpromotion = em.merge(dimpromotion);
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsales : factinternetsalesCollectionNew) {
                if (!factinternetsalesCollectionOld.contains(factinternetsalesCollectionNewFactinternetsales)) {
                    Dimpromotion oldPromotionkeyOfFactinternetsalesCollectionNewFactinternetsales = factinternetsalesCollectionNewFactinternetsales.getPromotionkey();
                    factinternetsalesCollectionNewFactinternetsales.setPromotionkey(dimpromotion);
                    factinternetsalesCollectionNewFactinternetsales = em.merge(factinternetsalesCollectionNewFactinternetsales);
                    if (oldPromotionkeyOfFactinternetsalesCollectionNewFactinternetsales != null && !oldPromotionkeyOfFactinternetsalesCollectionNewFactinternetsales.equals(dimpromotion)) {
                        oldPromotionkeyOfFactinternetsalesCollectionNewFactinternetsales.getFactinternetsalesCollection().remove(factinternetsalesCollectionNewFactinternetsales);
                        oldPromotionkeyOfFactinternetsalesCollectionNewFactinternetsales = em.merge(oldPromotionkeyOfFactinternetsalesCollectionNewFactinternetsales);
                    }
                }
            }
            for (Factresellersales factresellersalesCollectionNewFactresellersales : factresellersalesCollectionNew) {
                if (!factresellersalesCollectionOld.contains(factresellersalesCollectionNewFactresellersales)) {
                    Dimpromotion oldPromotionkeyOfFactresellersalesCollectionNewFactresellersales = factresellersalesCollectionNewFactresellersales.getPromotionkey();
                    factresellersalesCollectionNewFactresellersales.setPromotionkey(dimpromotion);
                    factresellersalesCollectionNewFactresellersales = em.merge(factresellersalesCollectionNewFactresellersales);
                    if (oldPromotionkeyOfFactresellersalesCollectionNewFactresellersales != null && !oldPromotionkeyOfFactresellersalesCollectionNewFactresellersales.equals(dimpromotion)) {
                        oldPromotionkeyOfFactresellersalesCollectionNewFactresellersales.getFactresellersalesCollection().remove(factresellersalesCollectionNewFactresellersales);
                        oldPromotionkeyOfFactresellersalesCollectionNewFactresellersales = em.merge(oldPromotionkeyOfFactresellersalesCollectionNewFactresellersales);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimpromotion.getPromotionkey();
                if (findDimpromotion(id) == null) {
                    throw new NonexistentEntityException("The dimpromotion with id " + id + " no longer exists.");
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
            Dimpromotion dimpromotion;
            try {
                dimpromotion = em.getReference(Dimpromotion.class, id);
                dimpromotion.getPromotionkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimpromotion with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factinternetsales> factinternetsalesCollectionOrphanCheck = dimpromotion.getFactinternetsalesCollection();
            for (Factinternetsales factinternetsalesCollectionOrphanCheckFactinternetsales : factinternetsalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimpromotion (" + dimpromotion + ") cannot be destroyed since the Factinternetsales " + factinternetsalesCollectionOrphanCheckFactinternetsales + " in its factinternetsalesCollection field has a non-nullable promotionkey field.");
            }
            Collection<Factresellersales> factresellersalesCollectionOrphanCheck = dimpromotion.getFactresellersalesCollection();
            for (Factresellersales factresellersalesCollectionOrphanCheckFactresellersales : factresellersalesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dimpromotion (" + dimpromotion + ") cannot be destroyed since the Factresellersales " + factresellersalesCollectionOrphanCheckFactresellersales + " in its factresellersalesCollection field has a non-nullable promotionkey field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(dimpromotion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimpromotion> findDimpromotionEntities() {
        return findDimpromotionEntities(true, -1, -1);
    }

    public List<Dimpromotion> findDimpromotionEntities(int maxResults, int firstResult) {
        return findDimpromotionEntities(false, maxResults, firstResult);
    }

    private List<Dimpromotion> findDimpromotionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimpromotion.class));
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

    public Dimpromotion findDimpromotion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimpromotion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimpromotionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimpromotion> rt = cq.from(Dimpromotion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
