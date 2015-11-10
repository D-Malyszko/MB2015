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
public class DimsalesreasonJpaController implements Serializable {

    public DimsalesreasonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimsalesreason dimsalesreason) throws PreexistingEntityException, Exception {
        if (dimsalesreason.getFactinternetsalesCollection() == null) {
            dimsalesreason.setFactinternetsalesCollection(new ArrayList<Factinternetsales>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Factinternetsales> attachedFactinternetsalesCollection = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionFactinternetsalesToAttach : dimsalesreason.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionFactinternetsalesToAttach.getClass(), factinternetsalesCollectionFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollection.add(factinternetsalesCollectionFactinternetsalesToAttach);
            }
            dimsalesreason.setFactinternetsalesCollection(attachedFactinternetsalesCollection);
            em.persist(dimsalesreason);
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : dimsalesreason.getFactinternetsalesCollection()) {
                factinternetsalesCollectionFactinternetsales.getDimsalesreasonCollection().add(dimsalesreason);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimsalesreason(dimsalesreason.getSalesreasonkey()) != null) {
                throw new PreexistingEntityException("Dimsalesreason " + dimsalesreason + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimsalesreason dimsalesreason) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimsalesreason persistentDimsalesreason = em.find(Dimsalesreason.class, dimsalesreason.getSalesreasonkey());
            Collection<Factinternetsales> factinternetsalesCollectionOld = persistentDimsalesreason.getFactinternetsalesCollection();
            Collection<Factinternetsales> factinternetsalesCollectionNew = dimsalesreason.getFactinternetsalesCollection();
            Collection<Factinternetsales> attachedFactinternetsalesCollectionNew = new ArrayList<Factinternetsales>();
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsalesToAttach : factinternetsalesCollectionNew) {
                factinternetsalesCollectionNewFactinternetsalesToAttach = em.getReference(factinternetsalesCollectionNewFactinternetsalesToAttach.getClass(), factinternetsalesCollectionNewFactinternetsalesToAttach.getFactinternetsalesPK());
                attachedFactinternetsalesCollectionNew.add(factinternetsalesCollectionNewFactinternetsalesToAttach);
            }
            factinternetsalesCollectionNew = attachedFactinternetsalesCollectionNew;
            dimsalesreason.setFactinternetsalesCollection(factinternetsalesCollectionNew);
            dimsalesreason = em.merge(dimsalesreason);
            for (Factinternetsales factinternetsalesCollectionOldFactinternetsales : factinternetsalesCollectionOld) {
                if (!factinternetsalesCollectionNew.contains(factinternetsalesCollectionOldFactinternetsales)) {
                    factinternetsalesCollectionOldFactinternetsales.getDimsalesreasonCollection().remove(dimsalesreason);
                    factinternetsalesCollectionOldFactinternetsales = em.merge(factinternetsalesCollectionOldFactinternetsales);
                }
            }
            for (Factinternetsales factinternetsalesCollectionNewFactinternetsales : factinternetsalesCollectionNew) {
                if (!factinternetsalesCollectionOld.contains(factinternetsalesCollectionNewFactinternetsales)) {
                    factinternetsalesCollectionNewFactinternetsales.getDimsalesreasonCollection().add(dimsalesreason);
                    factinternetsalesCollectionNewFactinternetsales = em.merge(factinternetsalesCollectionNewFactinternetsales);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimsalesreason.getSalesreasonkey();
                if (findDimsalesreason(id) == null) {
                    throw new NonexistentEntityException("The dimsalesreason with id " + id + " no longer exists.");
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
            Dimsalesreason dimsalesreason;
            try {
                dimsalesreason = em.getReference(Dimsalesreason.class, id);
                dimsalesreason.getSalesreasonkey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimsalesreason with id " + id + " no longer exists.", enfe);
            }
            Collection<Factinternetsales> factinternetsalesCollection = dimsalesreason.getFactinternetsalesCollection();
            for (Factinternetsales factinternetsalesCollectionFactinternetsales : factinternetsalesCollection) {
                factinternetsalesCollectionFactinternetsales.getDimsalesreasonCollection().remove(dimsalesreason);
                factinternetsalesCollectionFactinternetsales = em.merge(factinternetsalesCollectionFactinternetsales);
            }
            em.remove(dimsalesreason);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimsalesreason> findDimsalesreasonEntities() {
        return findDimsalesreasonEntities(true, -1, -1);
    }

    public List<Dimsalesreason> findDimsalesreasonEntities(int maxResults, int firstResult) {
        return findDimsalesreasonEntities(false, maxResults, firstResult);
    }

    private List<Dimsalesreason> findDimsalesreasonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimsalesreason.class));
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

    public Dimsalesreason findDimsalesreason(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimsalesreason.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimsalesreasonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimsalesreason> rt = cq.from(Dimsalesreason.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
