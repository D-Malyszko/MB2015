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
public class FactsalesquotaJpaController implements Serializable {

    public FactsalesquotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factsalesquota factsalesquota) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimdate datekey = factsalesquota.getDatekey();
            if (datekey != null) {
                datekey = em.getReference(datekey.getClass(), datekey.getDatekey());
                factsalesquota.setDatekey(datekey);
            }
            Dimemployee employeekey = factsalesquota.getEmployeekey();
            if (employeekey != null) {
                employeekey = em.getReference(employeekey.getClass(), employeekey.getEmployeekey());
                factsalesquota.setEmployeekey(employeekey);
            }
            em.persist(factsalesquota);
            if (datekey != null) {
                datekey.getFactsalesquotaCollection().add(factsalesquota);
                datekey = em.merge(datekey);
            }
            if (employeekey != null) {
                employeekey.getFactsalesquotaCollection().add(factsalesquota);
                employeekey = em.merge(employeekey);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactsalesquota(factsalesquota.getSalesquotakey()) != null) {
                throw new PreexistingEntityException("Factsalesquota " + factsalesquota + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factsalesquota factsalesquota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factsalesquota persistentFactsalesquota = em.find(Factsalesquota.class, factsalesquota.getSalesquotakey());
            Dimdate datekeyOld = persistentFactsalesquota.getDatekey();
            Dimdate datekeyNew = factsalesquota.getDatekey();
            Dimemployee employeekeyOld = persistentFactsalesquota.getEmployeekey();
            Dimemployee employeekeyNew = factsalesquota.getEmployeekey();
            if (datekeyNew != null) {
                datekeyNew = em.getReference(datekeyNew.getClass(), datekeyNew.getDatekey());
                factsalesquota.setDatekey(datekeyNew);
            }
            if (employeekeyNew != null) {
                employeekeyNew = em.getReference(employeekeyNew.getClass(), employeekeyNew.getEmployeekey());
                factsalesquota.setEmployeekey(employeekeyNew);
            }
            factsalesquota = em.merge(factsalesquota);
            if (datekeyOld != null && !datekeyOld.equals(datekeyNew)) {
                datekeyOld.getFactsalesquotaCollection().remove(factsalesquota);
                datekeyOld = em.merge(datekeyOld);
            }
            if (datekeyNew != null && !datekeyNew.equals(datekeyOld)) {
                datekeyNew.getFactsalesquotaCollection().add(factsalesquota);
                datekeyNew = em.merge(datekeyNew);
            }
            if (employeekeyOld != null && !employeekeyOld.equals(employeekeyNew)) {
                employeekeyOld.getFactsalesquotaCollection().remove(factsalesquota);
                employeekeyOld = em.merge(employeekeyOld);
            }
            if (employeekeyNew != null && !employeekeyNew.equals(employeekeyOld)) {
                employeekeyNew.getFactsalesquotaCollection().add(factsalesquota);
                employeekeyNew = em.merge(employeekeyNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factsalesquota.getSalesquotakey();
                if (findFactsalesquota(id) == null) {
                    throw new NonexistentEntityException("The factsalesquota with id " + id + " no longer exists.");
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
            Factsalesquota factsalesquota;
            try {
                factsalesquota = em.getReference(Factsalesquota.class, id);
                factsalesquota.getSalesquotakey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factsalesquota with id " + id + " no longer exists.", enfe);
            }
            Dimdate datekey = factsalesquota.getDatekey();
            if (datekey != null) {
                datekey.getFactsalesquotaCollection().remove(factsalesquota);
                datekey = em.merge(datekey);
            }
            Dimemployee employeekey = factsalesquota.getEmployeekey();
            if (employeekey != null) {
                employeekey.getFactsalesquotaCollection().remove(factsalesquota);
                employeekey = em.merge(employeekey);
            }
            em.remove(factsalesquota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factsalesquota> findFactsalesquotaEntities() {
        return findFactsalesquotaEntities(true, -1, -1);
    }

    public List<Factsalesquota> findFactsalesquotaEntities(int maxResults, int firstResult) {
        return findFactsalesquotaEntities(false, maxResults, firstResult);
    }

    private List<Factsalesquota> findFactsalesquotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factsalesquota.class));
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

    public Factsalesquota findFactsalesquota(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factsalesquota.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactsalesquotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factsalesquota> rt = cq.from(Factsalesquota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
