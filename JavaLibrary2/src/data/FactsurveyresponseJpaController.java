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
public class FactsurveyresponseJpaController implements Serializable {

    public FactsurveyresponseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factsurveyresponse factsurveyresponse) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dimcustomer customerkey = factsurveyresponse.getCustomerkey();
            if (customerkey != null) {
                customerkey = em.getReference(customerkey.getClass(), customerkey.getCustomerkey());
                factsurveyresponse.setCustomerkey(customerkey);
            }
            Dimdate datekey = factsurveyresponse.getDatekey();
            if (datekey != null) {
                datekey = em.getReference(datekey.getClass(), datekey.getDatekey());
                factsurveyresponse.setDatekey(datekey);
            }
            em.persist(factsurveyresponse);
            if (customerkey != null) {
                customerkey.getFactsurveyresponseCollection().add(factsurveyresponse);
                customerkey = em.merge(customerkey);
            }
            if (datekey != null) {
                datekey.getFactsurveyresponseCollection().add(factsurveyresponse);
                datekey = em.merge(datekey);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFactsurveyresponse(factsurveyresponse.getSurveyresponsekey()) != null) {
                throw new PreexistingEntityException("Factsurveyresponse " + factsurveyresponse + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factsurveyresponse factsurveyresponse) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factsurveyresponse persistentFactsurveyresponse = em.find(Factsurveyresponse.class, factsurveyresponse.getSurveyresponsekey());
            Dimcustomer customerkeyOld = persistentFactsurveyresponse.getCustomerkey();
            Dimcustomer customerkeyNew = factsurveyresponse.getCustomerkey();
            Dimdate datekeyOld = persistentFactsurveyresponse.getDatekey();
            Dimdate datekeyNew = factsurveyresponse.getDatekey();
            if (customerkeyNew != null) {
                customerkeyNew = em.getReference(customerkeyNew.getClass(), customerkeyNew.getCustomerkey());
                factsurveyresponse.setCustomerkey(customerkeyNew);
            }
            if (datekeyNew != null) {
                datekeyNew = em.getReference(datekeyNew.getClass(), datekeyNew.getDatekey());
                factsurveyresponse.setDatekey(datekeyNew);
            }
            factsurveyresponse = em.merge(factsurveyresponse);
            if (customerkeyOld != null && !customerkeyOld.equals(customerkeyNew)) {
                customerkeyOld.getFactsurveyresponseCollection().remove(factsurveyresponse);
                customerkeyOld = em.merge(customerkeyOld);
            }
            if (customerkeyNew != null && !customerkeyNew.equals(customerkeyOld)) {
                customerkeyNew.getFactsurveyresponseCollection().add(factsurveyresponse);
                customerkeyNew = em.merge(customerkeyNew);
            }
            if (datekeyOld != null && !datekeyOld.equals(datekeyNew)) {
                datekeyOld.getFactsurveyresponseCollection().remove(factsurveyresponse);
                datekeyOld = em.merge(datekeyOld);
            }
            if (datekeyNew != null && !datekeyNew.equals(datekeyOld)) {
                datekeyNew.getFactsurveyresponseCollection().add(factsurveyresponse);
                datekeyNew = em.merge(datekeyNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factsurveyresponse.getSurveyresponsekey();
                if (findFactsurveyresponse(id) == null) {
                    throw new NonexistentEntityException("The factsurveyresponse with id " + id + " no longer exists.");
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
            Factsurveyresponse factsurveyresponse;
            try {
                factsurveyresponse = em.getReference(Factsurveyresponse.class, id);
                factsurveyresponse.getSurveyresponsekey();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factsurveyresponse with id " + id + " no longer exists.", enfe);
            }
            Dimcustomer customerkey = factsurveyresponse.getCustomerkey();
            if (customerkey != null) {
                customerkey.getFactsurveyresponseCollection().remove(factsurveyresponse);
                customerkey = em.merge(customerkey);
            }
            Dimdate datekey = factsurveyresponse.getDatekey();
            if (datekey != null) {
                datekey.getFactsurveyresponseCollection().remove(factsurveyresponse);
                datekey = em.merge(datekey);
            }
            em.remove(factsurveyresponse);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factsurveyresponse> findFactsurveyresponseEntities() {
        return findFactsurveyresponseEntities(true, -1, -1);
    }

    public List<Factsurveyresponse> findFactsurveyresponseEntities(int maxResults, int firstResult) {
        return findFactsurveyresponseEntities(false, maxResults, firstResult);
    }

    private List<Factsurveyresponse> findFactsurveyresponseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factsurveyresponse.class));
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

    public Factsurveyresponse findFactsurveyresponse(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factsurveyresponse.class, id);
        } finally {
            em.close();
        }
    }

    public int getFactsurveyresponseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factsurveyresponse> rt = cq.from(Factsurveyresponse.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
