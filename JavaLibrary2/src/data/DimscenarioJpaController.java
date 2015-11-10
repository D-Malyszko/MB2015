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
public class DimscenarioJpaController implements Serializable {

    public DimscenarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dimscenario dimscenario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dimscenario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDimscenario(dimscenario.getScenariokey()) != null) {
                throw new PreexistingEntityException("Dimscenario " + dimscenario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dimscenario dimscenario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dimscenario = em.merge(dimscenario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dimscenario.getScenariokey();
                if (findDimscenario(id) == null) {
                    throw new NonexistentEntityException("The dimscenario with id " + id + " no longer exists.");
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
            Dimscenario dimscenario;
            try {
                dimscenario = em.getReference(Dimscenario.class, id);
                dimscenario.getScenariokey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dimscenario with id " + id + " no longer exists.", enfe);
            }
            em.remove(dimscenario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dimscenario> findDimscenarioEntities() {
        return findDimscenarioEntities(true, -1, -1);
    }

    public List<Dimscenario> findDimscenarioEntities(int maxResults, int firstResult) {
        return findDimscenarioEntities(false, maxResults, firstResult);
    }

    private List<Dimscenario> findDimscenarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dimscenario.class));
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

    public Dimscenario findDimscenario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dimscenario.class, id);
        } finally {
            em.close();
        }
    }

    public int getDimscenarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dimscenario> rt = cq.from(Dimscenario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
