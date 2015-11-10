/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.exceptions.NonexistentEntityException;
import data.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author admin
 */
public class FactcallcenterJpaController implements Serializable {

    public FactcallcenterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factcallcenter factcallcenter) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdate datekey = factcallcenter.getDatekey();
            if (datekey != null) {
                datekey = em.getReference(datekey.getClass(), datekey.getDatekey());
                factcallcenter.setDatekey(datekey);
            }
            em.persist(factcallcenter);
            if (datekey != null) {
                datekey.getFactcallcenterCollection().add(factcallcenter);
                datekey = em.merge(datekey);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactcallcenter(factcallcenter.getFactcallcenterid()) != null) {
                throw new PreexistingEntityException("Factcallcenter " + factcallcenter + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factcallcenter factcallcenter) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factcallcenter persistentFactcallcenter = em.find(Factcallcenter.class, factcallcenter.getFactcallcenterid());
            Dimdate datekeyOld = persistentFactcallcenter.getDatekey();
            Dimdate datekeyNew = factcallcenter.getDatekey();
            if (datekeyNew != null) {
                datekeyNew = em.getReference(datekeyNew.getClass(), datekeyNew.getDatekey());
                factcallcenter.setDatekey(datekeyNew);
            }
            factcallcenter = em.merge(factcallcenter);
            if (datekeyOld != null && !datekeyOld.equals(datekeyNew)) {
                datekeyOld.getFactcallcenterCollection().remove(factcallcenter);
                datekeyOld = em.merge(datekeyOld);
            }
            if (datekeyNew != null && !datekeyNew.equals(datekeyOld)) {
                datekeyNew.getFactcallcenterCollection().add(factcallcenter);
                datekeyNew = em.merge(datekeyNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factcallcenter.getFactcallcenterid();
                if (findFactcallcenter(id) == null) {
                    throw new NonexistentEntityException("The factcallcenter with id " + id + " no longer exists.");
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
            Factcallcenter factcallcenter;
            try {
                factcallcenter = em.getReference(Factcallcenter.class, id);
                factcallcenter.getFactcallcenterid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factcallcenter with id " + id + " no longer exists.", enfe);
            }
            Dimdate datekey = factcallcenter.getDatekey();
            if (datekey != null) {
                datekey.getFactcallcenterCollection().remove(factcallcenter);
                datekey = em.merge(datekey);
            }
            em.remove(factcallcenter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factcallcenter> findFactcallcenterEntities() {
        return findFactcallcenterEntities(true, -1, -1);
    }

    public List<Factcallcenter> findFactcallcenterEntities(int maxResults, int firstResult) {
        return findFactcallcenterEntities(false, maxResults, firstResult);
    }

    private List<Factcallcenter> findFactcallcenterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factcallcenter.class));
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

    public Factcallcenter findFactcallcenter(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factcallcenter.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactcallcenterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factcallcenter> rt = cq.from(Factcallcenter.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
